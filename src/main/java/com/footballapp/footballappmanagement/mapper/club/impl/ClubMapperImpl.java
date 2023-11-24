package com.footballapp.footballappmanagement.mapper.club.impl;

import com.footballapp.footballappmanagement.domain.Club;
import com.footballapp.footballappmanagement.mapper.club.ClubMapper;
import com.footballapp.footballappmanagement.model.dto.club.ClubDTO;
import org.springframework.stereotype.Component;

@Component
public class ClubMapperImpl implements ClubMapper {
    @Override
    public Club clubDTOtoClub(ClubDTO clubDTO) {
        return Club;
    }

    @Override
    public ClubDTO clubToClubDTO(Club club) {
        return null;
    }
}
