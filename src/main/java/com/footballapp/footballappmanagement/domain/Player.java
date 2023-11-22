package com.footballapp.footballappmanagement.domain;

import com.footballapp.footballappmanagement.bootstrapdata.enums.Position;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Player {

    private UUID uuid;
    private String name;
    private String surName;
    private Date dateOfBirth;
    private Position position;
    private int matches;
    private int assists;
    private int goals;
    private boolean captain;
    private Club club;

    @Override
    public String toString() {
        return "Player{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", position=" + position.toString() +
                ", matches=" + matches +
                ", assists=" + assists +
                ", goals=" + goals +
                ", captain=" + captain +
                ", club=" + club.getName() +
                '}';
    }
}
