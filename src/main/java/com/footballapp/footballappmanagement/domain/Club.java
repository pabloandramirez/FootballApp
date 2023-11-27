package com.footballapp.footballappmanagement.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Club {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy="org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID uuid;

    @Column(length = 50, columnDefinition = "varchar(50)", updatable = true, nullable = false)
    private String name;

    private LocalDate dateOfFoundation;

    @Column(length = 50, columnDefinition = "varchar(50)", updatable = true, nullable = false)
    private String city;

    @OneToOne(mappedBy = "club")
    private Coach coach;

    @OneToMany(mappedBy = "club")
    private List<Player> players = new ArrayList<>();

    @OneToOne(mappedBy = "club")
    private Stadium stadium;

    @Override
    public String toString() {
        return "Club{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", dateOfFoundation=" + dateOfFoundation +
                ", city='" + city + '\'' +
                ", coach=" + coach.getName() + " " + coach.getSurName() +
                ", players=" + players.stream().toString() +
                '}';
    }
}