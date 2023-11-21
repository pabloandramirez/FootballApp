package com.footballapp.footballappmanagement.domain;

import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public class Coach {

    private UUID uuid;
    private String name;
    private String surName;
    private Date dateOfBirth;
    private Club club;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", club=" + club.getName() +
                '}';
    }
}
