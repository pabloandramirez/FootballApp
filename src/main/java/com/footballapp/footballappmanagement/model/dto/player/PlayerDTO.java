package com.footballapp.footballappmanagement.model.dto.player;


import lombok.*;
import lombok.extern.slf4j.Slf4j;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Builder
public class PlayerDTO {

    private String name;
    private String surName;
    private String dateOfBirth;
    private String age;
    private String position;
    private int matches;
    private int assists;
    private int goals;
    private boolean captain;
    private String clubName;
    private String idClub;
}
