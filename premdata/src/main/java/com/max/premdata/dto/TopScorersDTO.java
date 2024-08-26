package com.max.premdata.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TopScorersDTO {

    private CompetitionDTO competition;
    private SeasonDTO season;
    private List<ScorerDTO> scorers;

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

    public List<ScorerDTO> getScorers() {
        return scorers;
    }

    public void setScorers(List<ScorerDTO> scorers) {
        this.scorers = scorers;
    }
}
