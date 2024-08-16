package com.max.premdata.job;

import com.max.premdata.dto.StandingsResponseDTO;
import com.max.premdata.dto.TeamDTO;
import com.max.premdata.entity.Season;
import com.max.premdata.entity.TableEntry;
import com.max.premdata.entity.Team;
import com.max.premdata.fbData.CompareSavedAndPulledData;
import com.max.premdata.fbData.FootballDataAPIService;
import com.max.premdata.mapping.SeasonMapper;
import com.max.premdata.mapping.StandingsResponseMapper;
import com.max.premdata.mapping.TeamMapper;
import com.max.premdata.repository.TeamDAO;
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

//    @Autowired
//    StandingsResponseDAO standingsResponseDAO;

    private static final Logger logger = LoggerFactory.getLogger(PullDataJob.class);


    //@Scheduled(cron = "0 * * * * *")
//    public void pullPLTeamData(){
//
//        System.out.println("in start of cron job");
//
//        Mono<TeamDTO> teamMono = teamService.getTeamDataFromExternalAPI("64");
//
//        teamMono.subscribe(team -> {
//            Team teamEntity = TeamMapper.toTeamEntity(team);
//            compareService.checkTeamExists(teamEntity);
//        });
//
//        pullPLTableData();
//
//    }


    @Scheduled(cron = "0 13 22 * * *")
    public void pullPLTableData(){

        System.out.println("in start of cron job 2");

        Set<String> set = new HashSet<>();


        for (String year : seasons){

            Mono<StandingsResponseDTO> standingsResponseDTOMono = footballDataAPIService.getStandingsExternalData(year);

            standingsResponseDTOMono.subscribe(standingsResponseDTO -> {


                Season season = SeasonMapper.toSeasonEntityFromResponseDTO(standingsResponseDTO);

                logger.info("standings size: " + season.getStandings().get(0).getTable().size());


                compareService.checkSeasonExists(season);

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



        System.out.println("after save");
    }


    public void pullPLTeamData(String teamId){


        Mono<TeamDTO> teamMono = teamService.getTeamDataFromExternalAPI(teamId);

        teamMono.subscribe(team -> {
            Team teamEntity = TeamMapper.toTeamEntity(team);
            compareService.checkTeamExists(teamEntity);
        });


    }

}
