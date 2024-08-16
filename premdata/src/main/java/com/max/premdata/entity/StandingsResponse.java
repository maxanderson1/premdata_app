//package com.max.premdata.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import jakarta.persistence.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
////@Table(name = "standings")
//public class StandingsResponse {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "filter_id")
//    private Filter filters;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "area_id")
//    private Area area;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "competition_id")
//    private Competition competition;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "season_id")
//    private Season season;
//
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Standing> standings = new ArrayList<>();
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Filter getFilters() {
//        return filters;
//    }
//
//    public void setFilters(Filter filters) {
//        this.filters = filters;
//    }
//
//    public Area getArea() {
//        return area;
//    }
//
//    public void setArea(Area area) {
//        this.area = area;
//    }
//
//    public Competition getCompetition() {
//        return competition;
//    }
//
//    public void setCompetition(Competition competition) {
//        this.competition = competition;
//    }
//
//    public Season getSeason() {
//        return season;
//    }
//
//    public void setSeason(Season season) {
//        this.season = season;
//    }
//
//    public List<Standing> getStandings() {
//        return standings;
//    }
//
//    public void setStandings(List<Standing> standings) {
//        this.standings = standings;
//    }
//}
//
