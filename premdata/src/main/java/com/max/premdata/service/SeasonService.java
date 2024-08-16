package com.max.premdata.service;

import com.max.premdata.entity.Season;
import com.max.premdata.entity.TableEntry;
import com.max.premdata.repository.SeasonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonService {

    @Autowired
    SeasonDAO seasonDAO;

    public List<TableEntry> getAllTableEntries(String seasonYear){
        //Optional<Season> optionalSeason = seasonDAO.findById(Long.valueOf(seasonYear));

        Season season = seasonDAO.findByYear(seasonYear);

        return season.getStandings().get(0).getTable();
    }

    public List<TableEntry> getAllTableEntriesHome(String seasonYear){
        Season season = seasonDAO.findByYear(seasonYear);

        return season.getStandings().get(1).getTable();
    }

    public List<TableEntry> getAllTableEntriesAway(String seasonYear){
        Season season = seasonDAO.findByYear(seasonYear);

        return season.getStandings().get(2).getTable();
    }
}
