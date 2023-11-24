package com.footballapp.footballappmanagement.domain;

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
public class Stadium {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy="org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID uuid;

    @Column(length = 50, columnDefinition = "varchar(50)", updatable = true, nullable = false)
    private String name;

    @Column(length = 50, columnDefinition = "varchar(50)", updatable = true, nullable = false)
    private String city;

    private LocalDateTime constructionDate;

    @Column(length = 6, columnDefinition = "int", updatable = true, nullable = false)
    private int capacity;

    @OneToOne
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
