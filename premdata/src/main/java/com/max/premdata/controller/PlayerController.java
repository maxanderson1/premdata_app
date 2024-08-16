package com.max.premdata.controller;

import com.max.premdata.entity.Player;
import com.max.premdata.service.PlayerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    public static final String BASE_URL = "/player";

    @Autowired
    PlayerService playerService;

//    @GetMapping(BASE_URL + "/squad/{teamId}")
//    public List<Player> getSquad(@PathVariable(value = "teamId") Long teamId){
//
//        //List<Player> squad =
//                return playerService.getSquad(teamId);
//
//        //return ResponseEntity.ok(squad);
//    }

}
