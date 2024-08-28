package com.max.premdata.service;

import com.max.premdata.entity.Scorer;
import com.max.premdata.repository.ScorerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ScorerService {

    @Autowired
    ScorerDAO scorerDAO;

    public void persistScorer(Scorer scorer){
        scorerDAO.save(scorer);
    }

    public List<Scorer> getTopScorers(){

        return scorerDAO.findAll().stream()
                                    .sorted(Comparator.comparingInt(Scorer::getGoals)
                                    .reversed())
                                    .toList();
    }
}
