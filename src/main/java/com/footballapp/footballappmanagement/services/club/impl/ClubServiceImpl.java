package com.footballapp.footballappmanagement.services.club.impl;

import com.footballapp.footballappmanagement.domain.Club;
import com.footballapp.footballappmanagement.domain.Stadium;
import com.footballapp.footballappmanagement.services.club.ClubService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service
@AllArgsConstructor
public class ClubServiceImpl implements ClubService {

    @Override
    public Club createClub(Club club) {
        club.setUuid(UUID.randomUUID());
        return club;
    }

    @Override
    public Optional<Club> getClubById(UUID uuidClub) {
        return Optional.empty();
    }

    @Override
    public List<Club> getClubs() {
        return null;
    }

    @Override
    public List<Club> getClubByName(String name) {
        return null;
    }

    @Override
    public List<Club> getClubByCity(String city) {
        return null;
    }

    @Override
    public Optional<Club> updateClub(UUID uuidClub, Club clubUpdated) {
        return Optional.empty();
    }

    @Override
    public boolean deleteClub(UUID uuidClub) {
        return false;
    }

}
