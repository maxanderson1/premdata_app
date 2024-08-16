package com.max.premdata.mapping;

import com.max.premdata.dto.PlayerDTO;
import com.max.premdata.dto.StandingsResponseDTO;
import com.max.premdata.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StandingsResponseMapper {


//    public static StandingsResponse toStandingsResponseEntity(StandingsResponseDTO standingsResponseDTO) {
//        if (standingsResponseDTO == null) {
//            return null;
//        }
//
//        StandingsResponse standingsResponse = new StandingsResponse();
//
//
//        Filter filter = FilterMapper.toFilterEntity(standingsResponseDTO.getFilters());
//        Area area = AreaMapper.toAreaEntity(standingsResponseDTO.getArea());
//        Competition competition = CompetitionMapper.toCompetitionEntity(standingsResponseDTO.getCompetition());
//        Season season = SeasonMapper.toSeasonEntity(standingsResponseDTO.getSeason());
//
//        List<Standing> standings = standingsResponseDTO.getStandings().stream()
//                .map(StandingMapper::toStandingEntity)
//                .toList();
//
//        standingsResponse.setFilters(filter);
//        standingsResponse.setArea(area);
//        standingsResponse.setCompetition(competition);
//        standingsResponse.setSeason(season);
//        standingsResponse.setStandings(standings);
//
//        return standingsResponse;
//    }

}
