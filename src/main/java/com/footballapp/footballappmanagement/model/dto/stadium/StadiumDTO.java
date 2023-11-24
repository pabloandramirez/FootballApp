package com.footballapp.footballappmanagement.model.dto.stadium;

import com.footballapp.footballappmanagement.domain.Club;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class StadiumDTO {

    private String name;
    private String constructionDate;
    private int capacity;
    private String clubName;
}
