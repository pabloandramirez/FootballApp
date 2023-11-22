package com.footballapp.footballappmanagement.services.stadium.impl;

import com.footballapp.footballappmanagement.domain.Stadium;
import com.footballapp.footballappmanagement.services.stadium.StadiumService;

import java.util.UUID;

public class StadiumServiceImpl implements StadiumService {
    @Override
    public Stadium createStadium(Stadium stadium) {
        stadium.setUuid(UUID.randomUUID());
        return stadium;
    }
}
