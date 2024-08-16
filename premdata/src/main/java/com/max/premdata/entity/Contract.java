package com.max.premdata.entity;


import jakarta.persistence.*;

@Entity
@Table(name="CONTRACTS")
public class Contract {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String start;
    private String until;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getUntil() {
        return until;
    }

    public void setUntil(String until) {
        this.until = until;
    }
}
