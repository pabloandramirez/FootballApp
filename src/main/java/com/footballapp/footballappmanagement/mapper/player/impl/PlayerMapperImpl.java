package com.footballapp.footballappmanagement.mapper.player.impl;

import com.footballapp.footballappmanagement.bootstrapdata.enums.Position;
import com.footballapp.footballappmanagement.domain.Player;
import com.footballapp.footballappmanagement.mapper.player.PlayerMapper;
import com.footballapp.footballappmanagement.model.dto.player.PlayerDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class PlayerMapperImpl implements PlayerMapper {
    @Override
    public Player playerDTOtoPlayer(PlayerDTO playerDTO) {
        return Player.builder()
                .name(playerDTO.getName())
                .surName(playerDTO.getSurName())
                .dateOfBirth(getLocalDate(playerDTO.getDateOfBirth()))
                .position(Position.valueOf(playerDTO.getPosition()))
                .matches(playerDTO.getMatches())
                .assists(playerDTO.getAssists())
                .goals(playerDTO.getGoals())
                .captain(playerDTO.isCaptain())
                .build();
    }

    @Override
    public PlayerDTO playerToPlayerDTO(Player player) {
        return PlayerDTO.builder()
                .name(player.getName())
                .surName(player.getSurName())
                .age(getAge(player.getDateOfBirth()))
                .position(player.getPosition().toString())
                .matches(player.getMatches())
                .assists(player.getAssists())
                .goals(player.getGoals())
                .captain(player.isCaptain())
                .clubName(player.getClub().getName())
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
