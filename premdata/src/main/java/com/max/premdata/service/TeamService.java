package com.max.premdata.service;

import com.max.premdata.dto.TeamDTO;
import com.max.premdata.entity.Player;
import com.max.premdata.entity.Team;
import com.max.premdata.fbData.FootballDataAPIService;
import com.max.premdata.repository.TeamDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    TeamDAO teamDAO;

    @Autowired
    AreaService areaService;

    @Autowired
    CoachService coachService;

    @Autowired
    CompetitionService competitionService;

    @Autowired
    PlayerService playerService;

    @Autowired
    FootballDataAPIService footballDataAPIService;

    public Mono<TeamDTO> getTeamDataFromExternalAPI(String teamId) {
        Mono<TeamDTO> teamDataResponse = footballDataAPIService.getTeamExternalData(teamId);
        return teamDataResponse;
    }

    public Team getTeamById(String teamId){
        Optional<Team> optionalTeam = teamDAO.findById(Long.parseLong(teamId));

        return optionalTeam.orElse(null);
    }

    public List<Player> getSquad(Long teamId){

        List<Player> squad = new ArrayList<>();

        Optional<Team> optionalTeam = teamDAO.findById(teamId);

        if(optionalTeam.isPresent()){
            Team team = optionalTeam.get();
            squad = team.getSquad();
        }
        return squad;
    }


}
