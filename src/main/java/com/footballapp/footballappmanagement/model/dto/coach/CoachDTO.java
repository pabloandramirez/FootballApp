package com.footballapp.footballappmanagement.model.dto.coach;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoachDTO {
    private String name;
    private String surName;
    private String dateOfBirth;
    private String age;
    private String clubName;
    private String idCLub;
}
