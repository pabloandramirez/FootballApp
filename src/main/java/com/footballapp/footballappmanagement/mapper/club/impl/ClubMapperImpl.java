package com.footballapp.footballappmanagement.mapper.club.impl;

import com.footballapp.footballappmanagement.domain.Club;
import com.footballapp.footballappmanagement.domain.Player;
import com.footballapp.footballappmanagement.mapper.club.ClubMapper;
import com.footballapp.footballappmanagement.model.dto.club.ClubDTO;
import com.footballapp.footballappmanagement.repository.player.PlayerRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ClubMapperImpl implements ClubMapper {

    private final PlayerRepository playerRepository;

    public ClubMapperImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Club clubDTOtoClub(ClubDTO clubDTO) {
        return Club
                .builder()
                .uuid(UUID.randomUUID())
                .name(clubDTO.getName())
                .dateOfFoundation(getLocalDate(clubDTO.getDateOfFoundation()))
                .city(clubDTO.getCity())
                .players(playerRepository.findAll().stream().toList())
                .build();
    }

    @Override
    public ClubDTO clubToClubDTO(Club club) {
        return ClubDTO
                .builder()
                .name(club.getName())
                .dateOfFoundation(getLocalDate(club.getDateOfFoundation()))
                .city(club.getCity())
                .coachName(club.getCoach().getName() + " " + club.getCoach().getSurName())
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
