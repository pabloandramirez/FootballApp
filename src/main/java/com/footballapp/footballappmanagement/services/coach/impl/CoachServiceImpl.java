package com.footballapp.footballappmanagement.services.coach.impl;

import com.footballapp.footballappmanagement.domain.Coach;
import com.footballapp.footballappmanagement.services.coach.CoachService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CoachServiceImpl implements CoachService {
    @Override
    public Coach createCoach(Coach coach) {
        coach.setUuid(UUID.randomUUID());
        return coach;
    }

    @Override
    public Optional<Coach> getCoachById(UUID idCoach) {
        return Optional.empty();
    }

    @Override
    public List<Coach> getCoaches() {
        return null;
    }

    @Override
    public List<Coach> getCoachByName(String coachName) {
        return null;
    }

    @Override
    public Optional<Coach> updateCoach(UUID uuidCoach, Coach coachUpdated) {
        return Optional.empty();
    }

    @Override
    public boolean deleteCoach(UUID uuidCoach) {
        return false;
    }
}
