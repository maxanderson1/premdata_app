package com.max.premdata.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamDTO {

    private AreaDTO area;
    private Long id;
    private String name;
    private String shortName;
    private String tla;
    private String crest;
    private String address;
    private String website;
    private int founded;
    private String clubColors;
    private String venue;
    private List<CompetitionDTO> runningCompetitions;
    private CoachDTO coach;
    private List<PlayerDTO> squad;
    private String lastUpdated;
    private String[] staff;


    public AreaDTO getArea() {
        return area;
    }

    public void setArea(AreaDTO area) {
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getTla() {
        return tla;
    }

    public void setTla(String tla) {
        this.tla = tla;
    }

    public String getCrest() {
        return crest;
    }

    public void setCrest(String crest) {
        this.crest = crest;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getFounded() {
        return founded;
    }

    public void setFounded(int founded) {
        this.founded = founded;
    }

    public String getClubColors() {
        return clubColors;
    }

    public void setClubColors(String clubColors) {
        this.clubColors = clubColors;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public List<CompetitionDTO> getRunningCompetitions() {
        return runningCompetitions;
    }

    public void setRunningCompetitions(List<CompetitionDTO> runningCompetitions) {
        this.runningCompetitions = runningCompetitions;
    }

    public CoachDTO getCoach() {
        return coach;
    }

    public void setCoach(CoachDTO coach) {
        this.coach = coach;
    }

    public List<PlayerDTO> getSquad() {
        return squad;
    }

    public void setSquad(List<PlayerDTO> squad) {
        this.squad = squad;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String[] getStaff() {
        return staff;
    }

    public void setStaff(String[] staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Team{" +
                "area=" + area +
                ", id=" + id +
                ", shortName='" + shortName + '\'' +
                ", tla='" + tla + '\'' +
                ", crest='" + crest + '\'' +
                ", address='" + address + '\'' +
                ", website='" + website + '\'' +
                ", founded=" + founded +
                ", clubColors='" + clubColors + '\'' +
                ", venue='" + venue + '\'' +
                ", runningCompetitions=" + runningCompetitions +
                ", coach=" + coach +
                ", squad=" + squad +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }
}
