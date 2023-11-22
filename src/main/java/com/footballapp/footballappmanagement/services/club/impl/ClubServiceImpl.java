package com.footballapp.footballappmanagement.services.club.impl;

import com.footballapp.footballappmanagement.domain.Club;
import com.footballapp.footballappmanagement.domain.Stadium;
import com.footballapp.footballappmanagement.services.club.ClubService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ClubServiceImpl implements ClubService {

    @Override
    public Club createClub(Club club) {
        club.setUuid(UUID.randomUUID());
        return club;
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

}
