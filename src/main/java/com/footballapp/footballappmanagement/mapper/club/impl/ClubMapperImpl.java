package com.footballapp.footballappmanagement.mapper.club.impl;

import com.footballapp.footballappmanagement.domain.Club;
import com.footballapp.footballappmanagement.domain.Player;
import com.footballapp.footballappmanagement.mapper.club.ClubMapper;
import com.footballapp.footballappmanagement.model.dto.club.ClubDTO;
import com.footballapp.footballappmanagement.repository.player.PlayerRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
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
                .dateOfFoundation(getLocalDateTime(clubDTO.getDateOfFoundation()))
                .city(clubDTO.getCity())
                .players(playerRepository.findAll().stream().collect(Collectors.toMap(Player::getUuid, Player::)));
    }

    @Override
    public ClubDTO clubToClubDTO(Club club) {
        return null;
    }


    private LocalDateTime getLocalDateTime(String date){
        if (!date.isBlank()){
            String[] parts = date.split("/");
            return LocalDateTime.of(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),0,0);
        }
        return null;
    }

    private String getLocalDateTime(LocalDateTime localDateTime){
        StringBuffer stringBuffer = new StringBuffer();
        return stringBuffer.append(localDateTime.getYear())
                .append("/")
                .append(localDateTime.getMonthValue())
                .append("/")
                .append(localDateTime.getDayOfYear())
                .toString();
    }
}
