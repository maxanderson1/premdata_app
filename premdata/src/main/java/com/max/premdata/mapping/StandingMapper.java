package com.max.premdata.mapping;

import com.max.premdata.dto.PlayerDTO;
import com.max.premdata.dto.StandingDTO;
import com.max.premdata.entity.Player;
import com.max.premdata.entity.Standing;
import com.max.premdata.entity.TableEntry;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StandingMapper {

    public static Standing toStandingEntity(StandingDTO standingDTO) {
        if (standingDTO == null) {
            return null;
        }


        Standing standing = new Standing();

        standing.setGroupName(standingDTO.getGroup());
        standing.setStage(standingDTO.getStage());
        standing.setType(standingDTO.getType());

        

        List<TableEntry> tableEntryList = standingDTO.getTable().stream()
                .map(TableEntryMapper::toTableEntryEntity)
                .toList();

        standing.setTable(tableEntryList);



        return standing;
    }
}
