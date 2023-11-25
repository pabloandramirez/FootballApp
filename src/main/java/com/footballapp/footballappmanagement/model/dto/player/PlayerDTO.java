package com.footballapp.footballappmanagement.model.dto.player;

import com.footballapp.footballappmanagement.bootstrapdata.enums.Position;
import com.footballapp.footballappmanagement.domain.Club;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
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
}
