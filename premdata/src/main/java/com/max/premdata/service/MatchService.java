package com.max.premdata.service;

import com.max.premdata.entity.Match;
import com.max.premdata.repository.MatchDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    @Autowired
    MatchDAO matchDAO;

    public List<Match> getAllMatches(){
        return matchDAO.findAll();
    }

    public List<Match> getAllByMatchday(int matchday){
        return matchDAO.getAllByMatchday(matchday);
    }
}
