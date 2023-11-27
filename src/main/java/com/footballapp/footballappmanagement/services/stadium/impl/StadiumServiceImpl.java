package com.footballapp.footballappmanagement.services.stadium.impl;

import com.footballapp.footballappmanagement.domain.Stadium;
import com.footballapp.footballappmanagement.services.stadium.StadiumService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service
@AllArgsConstructor
public class StadiumServiceImpl implements StadiumService {
    @Override
    public Stadium createStadium(Stadium stadium) {
        stadium.setUuid(UUID.randomUUID());
        return stadium;
    }

    @Override
    public Optional<Stadium> getStadiumById(UUID idStadium) {
        return Optional.empty();
    }

    @Override
    public List<Stadium> allStadiums() {
        return null;
    }

    @Override
    public List<Stadium> stadiumByName(String name) {
        return null;
    }

    @Override
    public List<Stadium> stadiumByCityName(String cityName) {
        return null;
    }

    @Override
    public Optional<Stadium> updateStadium(UUID uuidStadium, Stadium stadiumUpdated) {
        return Optional.empty();
    }

    @Override
    public boolean deleteStadium(UUID uuidStadium) {
        return false;
    }


}
