package com.max.premdata.mapping;

import com.max.premdata.dto.CompetitionDTO;
import com.max.premdata.entity.Competition;
import org.springframework.stereotype.Component;

@Component
public class CompetitionMapper {

    public static Competition toCompetitionEntity(CompetitionDTO competitionDTO) {
        if (competitionDTO == null) {
            return null;
        }

        Competition competition = new Competition();
        competition.setId(competitionDTO.getId());
        competition.setCode(competitionDTO.getCode());
        competition.setEmblem(competitionDTO.getEmblem());
        competition.setName(competitionDTO.getName());
        competition.setType(competitionDTO.getType());

        return competition;
    }
}
