package com.footballapp.footballappmanagement.domain;

import com.footballapp.footballappmanagement.bootstrapdata.enums.Position;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Player {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy="org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID uuid;
    private String name;
    private String surName;
    private LocalDateTime dateOfBirth;
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
