package com.max.premdata.controller;

import com.max.premdata.service.FootballDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FootballDataController {

    @Autowired
    FootballDataService footballDataService;



}
