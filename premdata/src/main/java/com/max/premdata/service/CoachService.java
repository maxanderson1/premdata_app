package com.max.premdata.service;

import com.max.premdata.entity.Coach;
import com.max.premdata.fbData.FootballDataAPIService;
import com.max.premdata.repository.CoachDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoachService {

    @Autowired
    CoachDAO coachDAO;

    @Autowired
    FootballDataAPIService footballDataAPIService;

}
