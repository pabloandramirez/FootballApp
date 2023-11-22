package com.footballapp.footballappmanagement.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter
public class Stadium {
    private UUID uuid;
    private String name;
    private Date constructionDate;
    private int capacity;
    private Club club;

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
