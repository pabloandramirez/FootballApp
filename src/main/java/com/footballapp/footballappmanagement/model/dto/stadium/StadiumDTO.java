package com.footballapp.footballappmanagement.model.dto.stadium;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Builder
public class StadiumDTO {

    private String name;
    private String city;
    private String constructionDate;
    private int capacity;
    private String clubName;
    private String idCLub;
}
