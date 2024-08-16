package com.max.premdata.service;
import com.max.premdata.entity.Area;
import com.max.premdata.fbData.FootballDataAPIService;
import com.max.premdata.repository.AreaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AreaService {


    @Autowired
    AreaDAO areaDAO;

    @Autowired
    FootballDataAPIService footballDataAPIService;




}
