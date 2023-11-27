package com.footballapp.footballappmanagement.services.club;

import com.footballapp.footballappmanagement.domain.Club;
import com.footballapp.footballappmanagement.domain.Stadium;
import com.footballapp.footballappmanagement.model.dto.club.ClubDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClubService {

    //POST
    Club createClub(@RequestBody ClubDTO clubDTO);

    //GET
    Optional<ClubDTO> getClubById(UUID idClub);
    List<ClubDTO> getClubs();
    List<ClubDTO> getClubByName(String name);
    List<ClubDTO> getClubByCity(String city);

    //PUT
    Optional<Club> updateClub(UUID uuidClub, Club clubUpdated);

    //DELETE
    boolean deleteClub(UUID uuidClub);
}
