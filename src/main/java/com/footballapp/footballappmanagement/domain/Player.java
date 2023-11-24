package com.footballapp.footballappmanagement.domain;

import com.footballapp.footballappmanagement.bootstrapdata.enums.Position;
import jakarta.persistence.*;
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

    @Column(length = 50, columnDefinition = "varchar(50)", updatable = true, nullable = false)
    private String name;

    @Column(length = 50, columnDefinition = "varchar(50)", updatable = true, nullable = false)
    private String surName;

    private LocalDateTime dateOfBirth;

    private Position position;

    @Column(length = 5, columnDefinition = "Integer", updatable = true, nullable = false)
    private int matches;

    @Column(length = 5, columnDefinition = "Integer", updatable = true, nullable = false)
    private int assists;

    @Column(length = 5, columnDefinition = "Integer", updatable = true, nullable = false)
    private int goals;

    private boolean captain;

    @ManyToOne
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
