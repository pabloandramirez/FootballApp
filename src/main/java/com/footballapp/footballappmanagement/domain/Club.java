package com.footballapp.footballappmanagement.domain;

import lombok.Getter;
import org.springframework.boot.autoconfigure.mail.MailProperties;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
public class Club {
    private UUID uuid;
    private String name;
    private Date dateOfFoundation;
    private String city;
    private Coach coach;
    private Map<UUID, Player> players = new HashMap<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfFoundation(Date dateOfFoundation) {
        this.dateOfFoundation = dateOfFoundation;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public void setPlayers(Map<UUID, Player> players) {
        this.players = players;
    }

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