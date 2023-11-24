package com.footballapp.footballappmanagement.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Stadium {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy="org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
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
