package com.max.premdata.controller;

import com.max.premdata.dto.TeamDTO;
import com.max.premdata.entity.Player;
import com.max.premdata.entity.Team;
import com.max.premdata.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class TeamController {

    public static final String BASE_URL = "/team";

    private static final Logger logger = LoggerFactory.getLogger(TeamController.class);


    @Autowired
    TeamService teamService;

//    @GetMapping(BASE_URL + "/getTeam/{teamId}")
//    public Mono<TeamDTO> getTeam(@PathVariable String teamId){
//
//        logger.info("Getting data for team id: " + teamId);
//
//        //currently team id not used and just passing fixed
//        //id for lfc to external api but this will be updated in
//        //future
//        //store api key / urls / constants in database and dont push to github
//
//        return teamService.getTeamData(teamId);
//    }

    @GetMapping(BASE_URL + "/getTeam/{teamId}")
    public Team getTeam(@PathVariable String teamId){

        logger.info("Getting data for team id: " + teamId);

        return teamService.getTeamById(teamId);
    }

    @GetMapping(BASE_URL + "/getSquad/{teamId}")
    public List<Player> getSquad(@PathVariable(value = "teamId") Long teamId){

        logger.info("getting squad");

        //List<Player> squad =
        return teamService.getSquad(teamId);

        //return ResponseEntity.ok(squad);
    }
}
