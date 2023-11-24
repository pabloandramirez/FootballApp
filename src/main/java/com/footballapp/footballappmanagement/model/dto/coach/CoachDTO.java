package com.footballapp.footballappmanagement.model.dto.coach;

import com.footballapp.footballappmanagement.domain.Club;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoachDTO {
    private String name;
    private String surName;
    private int yearsOld;
    private int months;
    private String clubName;
}
