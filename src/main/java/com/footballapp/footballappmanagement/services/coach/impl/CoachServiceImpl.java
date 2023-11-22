package com.footballapp.footballappmanagement.services.coach.impl;

import com.footballapp.footballappmanagement.domain.Coach;
import com.footballapp.footballappmanagement.services.coach.CoachService;

import java.util.UUID;

public class CoachServiceImpl implements CoachService {
    @Override
    public Coach createCoach(Coach coach) {
        coach.setUuid(UUID.randomUUID());
        return coach;
    }
}
