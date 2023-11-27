package com.footballapp.footballappmanagement.mapper.coach.impl;

import com.footballapp.footballappmanagement.domain.Coach;
import com.footballapp.footballappmanagement.mapper.coach.CoachMapper;
import com.footballapp.footballappmanagement.model.dto.coach.CoachDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

@Component
public class CoachMapperImpl implements CoachMapper {
    @Override
    public Coach coachDTOtoCoach(CoachDTO coachDTO) {
        return Coach.builder()
                .uuid(UUID.randomUUID())
                .name(coachDTO.getName())
                .surName(coachDTO.getSurName())
                .dateOfBirth(getLocalDate(coachDTO.getDateOfBirth()))
                .build();
    }

    @Override
    public CoachDTO coachToCoachDTO(Coach coach) {
        return CoachDTO
                .builder()
                .name(coach.getName())
                .surName(coach.getSurName())
                .age(getAge(coach.getDateOfBirth()))
                .clubName(coach.getClub().getName())
                .build();
    }

    private LocalDate getLocalDate(String date){
        if (!date.isBlank()){
            String[] parts = date.split("/");
            return LocalDate.of(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));
        }
        return null;
    }

    private String getAge(LocalDate localDate){
        LocalDate actualDate = LocalDate.now();

        Period period = Period.between(localDate, actualDate);

        int years = period.getYears();
        int months = period.getMonths();

        return "Years: " + years + ". Months:" + months;
    }
}
