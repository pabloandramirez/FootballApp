package com.footballapp.footballappmanagement.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Coach {

    private UUID uuid;
    private String name;
    private String surName;
    private LocalDateTime dateOfBirth;
    private Club club;


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
