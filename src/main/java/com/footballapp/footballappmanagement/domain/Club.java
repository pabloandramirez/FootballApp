package com.footballapp.footballappmanagement.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.boot.autoconfigure.mail.MailProperties;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

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
    private String name;
    private LocalDateTime dateOfFoundation;
    private String city;
    private Coach coach;
    private Map<UUID, Player> players = new HashMap<>();

    @Override
    public String toString() {
        return "Club{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", dateOfFoundation=" + dateOfFoundation +
                ", city='" + city + '\'' +
                ", coach=" + coach.getName() + " " + coach.getSurName() +
                ", players=" + players.values().stream().toList() +
                '}';
    }
}