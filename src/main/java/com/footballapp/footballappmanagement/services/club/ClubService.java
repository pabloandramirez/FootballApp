package com.footballapp.footballappmanagement.services.club;

import com.footballapp.footballappmanagement.domain.Club;
import com.footballapp.footballappmanagement.domain.Stadium;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClubService {

    //POST
    Club createClub(@RequestBody Club club);

    //GET
    List<Club> getClubs();
    List<Club> getClubByName(String name);
    List<Club> getClubByCity(String city);

    //PUT
    Optional<Club> updateClub(UUID uuidClub, Club clubUpdated);

    //DELETE
    boolean deleteClub(UUID uuidClub);
}
