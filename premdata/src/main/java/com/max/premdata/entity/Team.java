package com.max.premdata.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TEAMS")
public class Team {

    @Id
    //@GeneratedValue(strategy= GenerationType.AUTO)
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

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Competition> runningCompetitions;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coach_id")
    private Coach coach;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Player> squad;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "area_id")
    private Area area;

    private String lastUpdated;
    private String[] staff;


    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
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

    public List<Competition> getRunningCompetitions() {
        return runningCompetitions;
    }

    public void setRunningCompetitions(List<Competition> runningCompetitions) {
        this.runningCompetitions = runningCompetitions;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public List<Player> getSquad() {
        return squad;
    }

    public void setSquad(List<Player> squad) {
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
