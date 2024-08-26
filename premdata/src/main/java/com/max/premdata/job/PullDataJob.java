package com.max.premdata.job;

import com.max.premdata.dto.MatchResponseDTO;
import com.max.premdata.dto.StandingsResponseDTO;
import com.max.premdata.dto.TeamDTO;
import com.max.premdata.dto.TopScorersDTO;
import com.max.premdata.entity.*;
import com.max.premdata.fbData.CompareSavedAndPulledData;
import com.max.premdata.fbData.FootballDataAPIService;
import com.max.premdata.mapping.*;
import com.max.premdata.repository.MatchDAO;
import com.max.premdata.repository.TeamDAO;
import com.max.premdata.service.ScorerService;
import com.max.premdata.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class PullDataJob {

    private static final List<String> seasons = List.of(
            "2020",
            "2021",
            "2022",
            "2023",
            "2024"
    );

    @Autowired
    TeamService teamService;

    @Autowired
    FootballDataAPIService footballDataAPIService;

    @Autowired
    CompareSavedAndPulledData compareService;

    @Autowired
    TeamDAO teamDAO;

    @Autowired
    MatchDAO matchDAO;

    @Autowired
    ScorerService scorerService;


    private static final Logger logger = LoggerFactory.getLogger(PullDataJob.class);


    @Scheduled(cron = "@daily")
    public void pullPLTableData(){

        System.out.println("in start of cron job 2");

        Set<String> set = new HashSet<>();


        for (String year : seasons){

            Mono<StandingsResponseDTO> standingsResponseDTOMono = footballDataAPIService.getStandingsExternalData(year);

            standingsResponseDTOMono.subscribe(standingsResponseDTO -> {


                Season season = SeasonMapper.toSeasonEntityFromResponseDTO(standingsResponseDTO);

                logger.info("standings size: " + season.getStandings().get(0).getTable().size());


                compareService.saveNewOrExistingSeason(season);

                Set<String> teamIds = season.getStandings().get(0)
                        .getTable()
                        .stream()
                        .map(team -> String.valueOf(team.getTeamId()))
                        .collect(Collectors.toSet());


                logger.info("season: {}", year);

                for(String teamId : teamIds){
                    logger.info("team id: " + teamId);

                    try{
                        Long parsedString = Long.parseLong(teamId);

                        Optional<Team> teamOptional = teamDAO.findById(parsedString);


                        set.add(teamId);
                        if(teamOptional.isEmpty()){
                            logger.info("id {} doesnt exist, will pull from api", teamId);
                            pullPLTeamData(teamId);
                        }

                    } catch (NumberFormatException e){
                        logger.info("Failed to parse team id, error: {}", e.getMessage());
                    }


                }

            });
        }

        pullTopScorerData();

        System.out.println("after save");
    }


    public void pullPLTeamData(String teamId){

        Mono<TeamDTO> teamMono = teamService.getTeamDataFromExternalAPI(teamId);

        teamMono.subscribe(team -> {
            Team teamEntity = TeamMapper.toTeamEntity(team);
            compareService.saveNewOrExistingTeam(teamEntity);
        });
    }


    @Scheduled(cron = "@daily")
    public void pullMatchData(){

        int totalMatchweeks = 38;

        System.out.println("in start of match data job");

        for (int i = 1; i <= totalMatchweeks ; i++) {

            logger.info("matchweek: " + i);

            Mono<MatchResponseDTO> matchResponseDTOMono = footballDataAPIService.getMatchExternalData(i);

            matchResponseDTOMono.subscribe(matchResponseDTO -> {

                Competition competition = compareService.checkSingleCompetitionExists(CompetitionMapper.toCompetitionEntity(matchResponseDTO.getCompetition()));
                Season season = compareService.checkSeasonExists(SeasonMapper.toSeasonEntity(matchResponseDTO.getMatches().get(0).getSeason()));

                List<Match> matchEntityList = MatchMapper.toMatchEntityListFromMatchResponseDTO(matchResponseDTO);

                for (Match match : matchEntityList) {

                    logger.info("area here : " + match.getAreaId());
                    compareService.checkMatchExists(match);
                }
            });
        }

        logger.info("finished match job");
    }


    //@Scheduled(cron = "0 24 11 * * *")
    public void pullTopScorerData(){
        Mono<TopScorersDTO> topScorersDTOMono = footballDataAPIService.getPLTopScorers();

        topScorersDTOMono.subscribe(topScorersDTO -> {
            List<Scorer> scorerList = ScorerMapping.toScorerEntityListFromResponseDTO(topScorersDTO);

            scorerList.forEach(scorer -> {
                compareService.checkAndPersistTopScorer(scorer);
            });
        });
    }

}
