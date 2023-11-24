package com.footballapp.footballappmanagement.mapper.club;

import com.footballapp.footballappmanagement.domain.Club;
import com.footballapp.footballappmanagement.model.dto.club.ClubDTO;

public interface ClubMapper {

    Club clubDTOtoClub(ClubDTO clubDTO);

    ClubDTO clubToClubDTO(Club club);
}
