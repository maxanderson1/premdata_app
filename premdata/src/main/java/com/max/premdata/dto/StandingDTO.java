package com.max.premdata.dto;

import java.util.List;

public class StandingDTO {

    private String stage;
    private String type;
    private String group;
    private List<TableEntryDTO> table;

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<TableEntryDTO> getTable() {
        return table;
    }

    public void setTable(List<TableEntryDTO> table) {
        this.table = table;
    }
}
