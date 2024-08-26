package com.max.premdata.mapping;

import com.max.premdata.dto.ScorerDTO;
import com.max.premdata.dto.TopScorersDTO;
import com.max.premdata.entity.Scorer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScorerMapping {

    private static final Logger logger = LoggerFactory.getLogger(ScorerMapping.class);

    public static List<Scorer> toScorerEntityListFromResponseDTO(TopScorersDTO topScorersDTO) {
        if (topScorersDTO == null) {
            return null;
        }

        List<Scorer> scorerList = new ArrayList<>();

        for(ScorerDTO scorerDTO : topScorersDTO.getScorers()){
            Scorer scorer = toScorerEntity(scorerDTO);
            scorer.setSeason(SeasonMapper.toSeasonEntity(topScorersDTO.getSeason()));
            scorer.setCompetition(CompetitionMapper.toCompetitionEntity(topScorersDTO.getCompetition()));
            scorerList.add(scorer);
        }

        return scorerList;
    }

    public static Scorer toScorerEntity(ScorerDTO scorerDTO) {
        if (scorerDTO == null) {
            return null;
        }

        Scorer scorer = new Scorer();

        scorer.setGoals(scorerDTO.getGoals());
        scorer.setAssists(scorerDTO.getAssists());
        scorer.setPenalties(scorerDTO.getPenalties());
        scorer.setPlayedMatches(scorerDTO.getPlayedMatches());
        scorer.setPlayer(PlayerMapper.toPlayerEntity(scorerDTO.getPlayer()));
        scorer.setPlayerName(scorerDTO.getPlayer().getName());
        scorer.setTeamName(scorerDTO.getTeam().getName());

        scorer.setTeamId(scorerDTO.getTeam().getId());

        return scorer;
    }

}
