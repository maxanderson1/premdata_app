package com.max.premdata.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchResponseDTO {
    private FiltersDTO filters;
    private ResultSetDTO resultSet;
    private CompetitionDTO competition;
    private List<MatchDTO> matches;

    public FiltersDTO getFilters() {
        return filters;
    }

    public void setFilters(FiltersDTO filters) {
        this.filters = filters;
    }

    public ResultSetDTO getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSetDTO resultSet) {
        this.resultSet = resultSet;
    }

    public CompetitionDTO getCompetition() {
        return competition;
    }

    public void setCompetition(CompetitionDTO competition) {
        this.competition = competition;
    }

    public List<MatchDTO> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchDTO> matches) {
        this.matches = matches;
    }
}
