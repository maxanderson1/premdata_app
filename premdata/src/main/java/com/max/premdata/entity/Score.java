package com.max.premdata.entity;

import jakarta.persistence.*;

@Entity
@Table(name="SCORES")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String winner;
    private String duration;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fullTime_id")
    private ScoreDetails fullTime;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "halfTime_id")
    private ScoreDetails halfTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public ScoreDetails getFullTime() {
        return fullTime;
    }

    public void setFullTime(ScoreDetails fullTime) {
        this.fullTime = fullTime;
    }

    public ScoreDetails getHalfTime() {
        return halfTime;
    }

    public void setHalfTime(ScoreDetails halfTime) {
        this.halfTime = halfTime;
    }
}
