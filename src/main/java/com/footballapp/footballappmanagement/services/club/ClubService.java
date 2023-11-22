package com.footballapp.footballappmanagement.services.club;

import com.footballapp.footballappmanagement.domain.Club;
import com.footballapp.footballappmanagement.domain.Stadium;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClubService {

    //POSTs
    Club createClub(@RequestBody Club club);

    //GETs
    List<Club> getClubs();
    List<Club> getClubByName(String name);
    List<Club> getClubByCity(String city);

    //PUTs
    Optional<Club> updateClub(UUID uuidClub, Club clubUpdated);
}
