package com.footballapp.footballappmanagement.model.dto.club;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClubDTO {
    private String name;
    private String dateOfFoundation;
    private String city;
    private String coachName;
}
