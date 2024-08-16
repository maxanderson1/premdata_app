package com.max.premdata.service;

import com.max.premdata.entity.Competition;
import com.max.premdata.repository.CompetitionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompetitionService {

    @Autowired
    CompetitionDAO competitionDAO;

}
