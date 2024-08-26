package com.max.premdata.controller;

import com.max.premdata.entity.Scorer;
import com.max.premdata.service.ScorerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScorerController {

    public static final String BASE_URL = "/topScorers";

    @Autowired
    ScorerService scorerService;

    @GetMapping(BASE_URL + "/getTopScorers")
    public List<Scorer> getAllTopScorers(){
        return scorerService.getTopScorers();
    }

}
