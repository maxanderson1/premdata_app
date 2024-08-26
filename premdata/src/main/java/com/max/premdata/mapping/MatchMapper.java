package com.max.premdata.mapping;

import com.max.premdata.dto.MatchDTO;
import com.max.premdata.dto.MatchResponseDTO;
import com.max.premdata.dto.TeamDTO;
import com.max.premdata.entity.*;
import com.max.premdata.fbData.CompareSavedAndPulledData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MatchMapper {

    private static final Logger logger = LoggerFactory.getLogger(MatchMapper.class);


    public static List<Match> toMatchEntityListFromMatchResponseDTO(MatchResponseDTO matchResponseDTO) {
        if (matchResponseDTO == null) {
            return null;
        }

        List<Match> matchList = new ArrayList<>();

            for(MatchDTO matchDTO : matchResponseDTO.getMatches()){
                Match match = toMatchEntity(matchDTO);
                matchList.add(match);
            }

        return  matchList;
    }


    public static Match toMatchEntity(MatchDTO matchDTO){

        Match match = new Match();

        match.setId(matchDTO.getId());
        match.setAreaId(matchDTO.getArea().getId().intValue());
        match.setMatchday(matchDTO.getMatchday());

        match.setCompetitionId(matchDTO.getCompetition().getId().intValue());
        match.setSeasonId(matchDTO.getSeason().getId().intValue());

        List<Referee> refereeList = matchDTO.getReferees().stream().map(RefereesMapping::toRefereeEntity).toList();

        match.setReferees(refereeList);

        match.setScore(ScoreMapping.toScoreEntity(matchDTO.getScore()));
        match.setStage(matchDTO.getStage());
        match.setStatus(matchDTO.getStatus());
        match.setUtcDate(matchDTO.getUtcDate());
        match.setLastUpdated(matchDTO.getLastUpdated());

        match.setHomeTeamId(matchDTO.getHomeTeam().getId());
        match.setHomeTeamName(matchDTO.getHomeTeam().getName());

        match.setAwayTeamId(matchDTO.getAwayTeam().getId());
        match.setAwayTeamName(matchDTO.getAwayTeam().getName());

        return match;
    }

}
