package com.max.premdata.dto;

public class ScoreDTO {
    private String winner;
    private String duration;
    private ScoreDetailDTO fullTime;
    private ScoreDetailDTO halfTime;

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

    public ScoreDetailDTO getFullTime() {
        return fullTime;
    }

    public void setFullTime(ScoreDetailDTO fullTime) {
        this.fullTime = fullTime;
    }

    public ScoreDetailDTO getHalfTime() {
        return halfTime;
    }

    public void setHalfTime(ScoreDetailDTO halfTime) {
        this.halfTime = halfTime;
    }

}
