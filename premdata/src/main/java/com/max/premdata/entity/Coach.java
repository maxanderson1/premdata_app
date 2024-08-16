package com.max.premdata.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "COACHES")
public class Coach {

    @Id
    private Long id;
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String name;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    private String nationality;
    @OneToOne(cascade = CascadeType.ALL)
    private Contract contract;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
