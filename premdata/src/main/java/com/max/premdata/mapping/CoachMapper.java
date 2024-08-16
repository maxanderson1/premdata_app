package com.max.premdata.mapping;

import com.max.premdata.dto.CoachDTO;
import com.max.premdata.entity.Coach;
import com.max.premdata.entity.Contract;
import org.springframework.stereotype.Component;

@Component
public class CoachMapper {

    public static Coach toCoachEntity(CoachDTO coachDTO) {
        if (coachDTO == null) {
            return null;
        }

        Coach coach = new Coach();

        coach.setId(coachDTO.getId());
        coach.setFirstName(coachDTO.getFirstName());
        coach.setName(coachDTO.getName());
        coach.setNationality(coachDTO.getNationality());
        coach.setLastName(coachDTO.getLastName());
        coach.setDateOfBirth(coachDTO.getDateOfBirth());

        String start = coachDTO.getContract().getStart();
        String end = coachDTO.getContract().getUntil();

        Contract contract = new Contract();
        contract.setStart(start);
        contract.setUntil(end);

        coach.setContract(contract);

        return coach;
    }
}

