package com.max.premdata.mapping;

import com.max.premdata.dto.SeasonDTO;
import com.max.premdata.dto.TableEntryDTO;
import com.max.premdata.entity.Season;
import com.max.premdata.entity.TableEntry;
import com.max.premdata.fbData.FootballDataAPIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TableEntryMapper {

    private static final Logger logger = LoggerFactory.getLogger(TableEntryMapper.class);


    public static TableEntry toTableEntryEntity(TableEntryDTO tableEntryDTO) {
        if (tableEntryDTO == null) {
            return null;
        }

        TableEntry tableEntry = new TableEntry();

        tableEntry.setPosition(tableEntryDTO.getPosition());
        tableEntry.setPlayedGames(tableEntryDTO.getPlayedGames());
        tableEntry.setForm(tableEntryDTO.getForm());
        tableEntry.setWon(tableEntryDTO.getWon());
        tableEntry.setDraw(tableEntryDTO.getDraw());
        tableEntry.setLost(tableEntryDTO.getLost());
        tableEntry.setPoints(tableEntryDTO.getPoints());
        tableEntry.setGoalsFor(tableEntryDTO.getGoalsFor());
        tableEntry.setGoalsAgainst(tableEntryDTO.getGoalsAgainst());
        tableEntry.setGoalDifference(tableEntryDTO.getGoalDifference());

        tableEntry.setTeamId(tableEntryDTO.getTeam().getId());
        tableEntry.setTeamName(tableEntryDTO.getTeam().getName());

        return tableEntry;
    }

}
