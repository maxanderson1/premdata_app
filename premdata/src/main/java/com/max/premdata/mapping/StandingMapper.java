package com.max.premdata.mapping;

import com.max.premdata.dto.StandingDTO;
import com.max.premdata.entity.Standing;
import com.max.premdata.entity.TableEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StandingMapper {

    private static final Logger logger = LoggerFactory.getLogger(StandingMapper.class);


    public static Standing toStandingEntity(StandingDTO standingDTO) {
        if (standingDTO == null) {
            return null;
        }


        Standing standing = new Standing();

        standing.setGroupName(standingDTO.getGroup());
        standing.setStage(standingDTO.getStage());
        standing.setType(standingDTO.getType());

        List<TableEntry> tableEntryList = standingDTO.getTable().stream()
                .map(t -> {
                    logger.info("table mapper dto info, " + t.getPlayedGames());
                    return TableEntryMapper.toTableEntryEntity(t);
                })
                .toList();

        standing.setTable(tableEntryList);

        return standing;
    }
}
