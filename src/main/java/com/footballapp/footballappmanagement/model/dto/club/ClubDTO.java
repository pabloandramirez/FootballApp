package com.footballapp.footballappmanagement.model.dto.club;

import com.footballapp.footballappmanagement.domain.Coach;
import lombok.*;

import java.time.LocalDateTime;

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
