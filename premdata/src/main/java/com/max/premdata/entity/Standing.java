package com.max.premdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "STANDINGS")
public class Standing {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String stage;
    private String type;
    private String groupName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    @OneToMany(mappedBy = "standing", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TableEntry> table;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<TableEntry> getTable() {
        return table;
    }

    public void setTable(List<TableEntry> table) {
        this.table = table;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
