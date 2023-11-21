package com.footballapp.footballappmanagement.bootstrapdata.enums;

import lombok.Getter;

@Getter
public enum Position {
    GOALKEEPER("Goalkeeper"),
    DEFENDER("Defender"),
    MIDFIELDER("Midfielder"),
    FORWARD("Forward");

    private final String position;

    Position(String position) {
        this.position = position;
    }
}
