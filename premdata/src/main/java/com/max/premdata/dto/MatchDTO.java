package com.max.premdata.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchDTO {

    private AreaDTO area;
    private CompetitionDTO competition;
    private SeasonDTO season;
    private Long id;
    private String utcDate;
    private String status;
    private int matchday;
    private String stage;
    private String group;
    private String lastUpdated;
    private TeamBasicDTO homeTeam;
    private TeamBasicDTO awayTeam;
    private ScoreDTO score;
    private List<RefereeDTO> referees;


    public AreaDTO getArea() {
        return area;
    }

    public void setArea(AreaDTO area) {
        this.area = area;
    }

    public CompetitionDTO getCompetition() {
        return competition;
    }

    public void setCompetition(CompetitionDTO competition) {
        this.competition = competition;
    }

    public SeasonDTO getSeason() {
        return season;
    }

    public void setSeason(SeasonDTO season) {
        this.season = season;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUtcDate() {
        return utcDate;
    }

    public void setUtcDate(String utcDate) {
        this.utcDate = utcDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMatchday() {
        return matchday;
    }

    public void setMatchday(int matchday) {
        this.matchday = matchday;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public TeamBasicDTO getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(TeamBasicDTO homeTeam) {
        this.homeTeam = homeTeam;
    }

    public TeamBasicDTO getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(TeamBasicDTO awayTeam) {
        this.awayTeam = awayTeam;
    }

    public ScoreDTO getScore() {
        return score;
    }

    public void setScore(ScoreDTO score) {
        this.score = score;
    }

    public List<RefereeDTO> getReferees() {
        return referees;
    }

    public void setReferees(List<RefereeDTO> referees) {
        this.referees = referees;
    }
}
