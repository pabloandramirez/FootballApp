package com.footballapp.footballappmanagement.domain;

import lombok.Getter;

import java.util.Date;
import java.util.UUID;
@Getter
public class Stadium {
    private UUID uuid;
    private String name;
    private Date constructionDate;
    private int capacity;
    private Club club;

    public void setName(String name) {
        this.name = name;
    }

    public void setConstructionDate(Date constructionDate) {
        this.constructionDate = constructionDate;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    @Override
    public String toString() {
        return "Stadium{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", constructionDate=" + constructionDate +
                ", capacity=" + capacity +
                ", club=" + club.getName() +
                '}';
    }
}
