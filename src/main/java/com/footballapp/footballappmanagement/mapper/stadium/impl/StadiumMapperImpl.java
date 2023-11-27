package com.footballapp.footballappmanagement.mapper.stadium.impl;

import com.footballapp.footballappmanagement.domain.Stadium;
import com.footballapp.footballappmanagement.mapper.stadium.StadiumMapper;
import com.footballapp.footballappmanagement.model.dto.stadium.StadiumDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class StadiumMapperImpl implements StadiumMapper {
    @Override
    public Stadium stadiumDTOtoStadium(StadiumDTO stadiumDTO) {
        return Stadium.builder()
                .uuid(UUID.randomUUID())
                .name(stadiumDTO.getName())
                .constructionDate(getLocalDate(stadiumDTO.getConstructionDate()))
                .city(stadiumDTO.getCity())
                .capacity(stadiumDTO.getCapacity())
                .build();
    }

    @Override
    public StadiumDTO stadiumToStadiumDTO(Stadium stadium) {
        return StadiumDTO.builder()
                .name(stadium.getName())
                .constructionDate(getLocalDate(stadium.getConstructionDate()))
                .city(stadium.getCity())
                .capacity(stadium.getCapacity())
                .clubName(stadium.getClub().getName())
                .build();
    }

    private LocalDate getLocalDate(String date){
        if (!date.isBlank()){
            String[] parts = date.split("/");
            return LocalDate.of(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));
        }
        return null;
    }

    private String getLocalDate(LocalDate localDate){
        return localDate.getYear() +
                "/" +
                localDate.getMonthValue() +
                "/" +
                localDate.getDayOfYear();
    }
}
