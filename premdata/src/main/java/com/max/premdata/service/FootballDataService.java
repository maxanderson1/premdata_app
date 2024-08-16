package com.max.premdata.service;

import com.max.premdata.dto.StandingsResponseDTO;
import com.max.premdata.dto.TeamDTO;

import com.max.premdata.fbData.FootballDataAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FootballDataService {

    @Autowired
    FootballDataAPIService footballDataAPIService;





//    public Mono<StandingsResponseDTO> getPLStandings(){
//        return footballDataAPIService.getStandingsExternalData();
//    }


    public void saveTeamData(){
        //save team data
    }

    public void saveArea(String teamId){
        Mono<TeamDTO> teamDataResponse = footballDataAPIService.getTeamExternalData(teamId);

        //footballDataRepository.save();

    }
}
