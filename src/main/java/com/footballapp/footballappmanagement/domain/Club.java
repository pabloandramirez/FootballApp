package com.footballapp.footballappmanagement.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.mail.MailProperties;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
public class Club {
    private UUID uuid;
    private String name;
    private Date dateOfFoundation;
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