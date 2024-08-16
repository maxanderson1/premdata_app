package com.max.premdata.controller;

import com.max.premdata.entity.Player;
import com.max.premdata.entity.TableEntry;
import com.max.premdata.service.SeasonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeasonController {

    public static final String BASE_URL = "/season";

    private static final Logger logger = LoggerFactory.getLogger(SeasonController.class);

    @Autowired
    SeasonService seasonService;

    @GetMapping(BASE_URL + "/TableEntries/{season}")
    public List<TableEntry> getAllTableEntries(@PathVariable String season){

        logger.info("getting all table entries, season: " + season);

        if(seasonService.getAllTableEntries(season) == null){
            logger.info("returned null");
        }

        return seasonService.getAllTableEntries(season);
    }

    @GetMapping(BASE_URL + "/TableEntriesHome/{season}")
    public List<TableEntry> getAllTableEntriesHome(@PathVariable String season){

        logger.info("getting all table entries HOME");

        return seasonService.getAllTableEntriesHome(season);
    }

    @GetMapping(BASE_URL + "/TableEntriesAway/{season}")
    public List<TableEntry> getAllTableEntriesAway(@PathVariable String season){

        logger.info("getting all table entries AWAY");

        return seasonService.getAllTableEntriesAway(season);
    }

}
