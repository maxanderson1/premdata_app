package com.max.premdata.mapping;

import com.max.premdata.dto.PlayerDTO;
import com.max.premdata.dto.SeasonDTO;
import com.max.premdata.dto.StandingsResponseDTO;
import com.max.premdata.entity.Player;
import com.max.premdata.entity.Season;
import com.max.premdata.entity.Standing;
import com.max.premdata.entity.TableEntry;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class SeasonMapper {

    public static Season toSeasonEntity(SeasonDTO seasonDTO) {
        if (seasonDTO == null) {
            return null;
        }

        Season season = new Season();

//        season.setId(seasonDTO.getId());
//        season.setCurrentMatchday(seasonDTO.getCurrentMatchday());
//        season.setStartDate(seasonDTO.getStartDate());
//        season.setEndDate(seasonDTO.getEndDate());
//        season.setWinner(seasonDTO.getWinner());

        return season;
    }


    public static Season toSeasonEntityFromResponseDTO(StandingsResponseDTO standingsResponseDTO){

        if (standingsResponseDTO == null) {
            return null;
        }

        Season season = new Season();

        season.setId(standingsResponseDTO.getSeason().getId());
        season.setCurrentMatchday(standingsResponseDTO.getSeason().getCurrentMatchday());
        season.setStartDate(standingsResponseDTO.getSeason().getStartDate());
        season.setEndDate(standingsResponseDTO.getSeason().getEndDate());
        season.setWinner(standingsResponseDTO.getSeason().getWinner());
        season.setYear(standingsResponseDTO.getFilters().getSeason());

        season.setCompetition(CompetitionMapper.toCompetitionEntity(standingsResponseDTO.getCompetition()));

        List<Standing> standingList = standingsResponseDTO.getStandings().stream()
                        .map(StandingMapper::toStandingEntity)
                                .toList();

        season.setStandings(standingList);


        return season;
    }
}
