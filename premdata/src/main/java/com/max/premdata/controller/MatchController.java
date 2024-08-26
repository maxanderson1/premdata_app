package com.max.premdata.controller;

import com.max.premdata.entity.Match;
import com.max.premdata.service.MatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchController {

    public static final String BASE_URL = "/fixtures";

    private static final Logger logger = LoggerFactory.getLogger(MatchController.class);

    @Autowired
    MatchService matchService;

    @GetMapping(BASE_URL + "/getAllMatches")
    public List<Match> getMatches(){

        logger.info("getting all matches");

        List<Match> matchList = matchService.getAllMatches();

        return matchList;
    }

    @GetMapping(BASE_URL + "/getAllMatches/{matchday}")
    public List<Match> getMatchByMatchday(@PathVariable int matchday){

        logger.info("getting all matches for matchday {}", matchday);

        return matchService.getAllByMatchday(matchday);
    }
}
