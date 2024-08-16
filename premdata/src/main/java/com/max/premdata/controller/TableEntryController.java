package com.max.premdata.controller;

import com.max.premdata.entity.TableEntry;
import com.max.premdata.service.TableEntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TableEntryController {

    public static final String BASE_URL = "/table";

    private static final Logger logger = LoggerFactory.getLogger(TeamController.class);

    @Autowired
    TableEntryService tableEntryService;

    @GetMapping(BASE_URL + "/TableEntries2")
    public List<TableEntry> getAllTableEntries(){

        logger.info("getting all table entries");

        return tableEntryService.getAll();
    }

}
