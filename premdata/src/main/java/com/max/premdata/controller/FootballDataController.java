package com.max.premdata.controller;

import com.max.premdata.dto.StandingsResponseDTO;
import com.max.premdata.service.FootballDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FootballDataController {

    @Autowired
    FootballDataService footballDataService;



//    @GetMapping("/getPLStandings")
//    public Mono<StandingsResponseDTO> getPLStandings(){
//
//
//        return footballDataService.getPLStandings();
//    }


}
