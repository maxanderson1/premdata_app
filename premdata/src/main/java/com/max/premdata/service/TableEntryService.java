package com.max.premdata.service;

import com.max.premdata.entity.TableEntry;
import com.max.premdata.repository.TableEntryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableEntryService {

    @Autowired
    TableEntryDAO tableEntryDAO;

    public List<TableEntry> getAll(){
        return tableEntryDAO.findAll();
    }
}
