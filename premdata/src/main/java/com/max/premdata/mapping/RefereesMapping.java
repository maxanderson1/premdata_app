package com.max.premdata.mapping;

import com.max.premdata.dto.AreaDTO;
import com.max.premdata.dto.RefereeDTO;
import com.max.premdata.entity.Area;
import com.max.premdata.entity.Referee;
import org.springframework.stereotype.Component;

@Component
public class RefereesMapping {

    public static Referee toRefereeEntity(RefereeDTO refereeDTO) {
        if (refereeDTO == null) {
            return null;
        }

        Referee referee = new Referee();

        referee.setId(refereeDTO.getId());
        referee.setName(refereeDTO.getName());
        referee.setType(refereeDTO.getType());
        referee.setNationality(refereeDTO.getNationality());

        return referee;
    }
}
