package com.footballapp.footballappmanagement.domain;

import com.footballapp.footballappmanagement.bootstrapdata.enums.Position;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public class Player {

    private UUID uuid;
    private String name;
    private String surName;
    private Date dateOfBirth;
    private Position position;
    private int matches;
    private int goals;
    private boolean captain;
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

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setCaptain(boolean captain) {
        this.captain = captain;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    @Override
    public String toString() {
        return "Player{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", position=" + position.toString() +
                ", matches=" + matches +
                ", goals=" + goals +
                ", captain=" + captain +
                ", club=" + club.getName() +
                '}';
    }
}
