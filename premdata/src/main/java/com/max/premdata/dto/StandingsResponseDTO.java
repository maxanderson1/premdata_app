package com.max.premdata.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingsResponseDTO {

    private FiltersDTO filters;
    private AreaDTO area;
    private CompetitionDTO competition;
    private SeasonDTO season;
    private List<StandingDTO> standings;

    public FiltersDTO getFilters() {
        return filters;
    }

    public void setFilters(FiltersDTO filters) {
        this.filters = filters;
    }

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

    public List<StandingDTO> getStandings() {
        return standings;
    }

    public void setStandings(List<StandingDTO> standings) {
        this.standings = standings;
    }
}
