package com.footballapp.footballappmanagement.services.stadium;

import com.footballapp.footballappmanagement.domain.Stadium;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StadiumService {

    //POST
    Stadium createStadium(@RequestBody Stadium stadium);

    //GET
    List<Stadium> allStadiums();
    List<Stadium> stadiumByName(String name);
    List<Stadium> stadiumByCityName(String cityName);

    //PUT
    Optional<Stadium> updateStadium(UUID uuidStadium, Stadium stadiumUpdated);

    //DELETE
    boolean deletePlayer(UUID uuidPlayer);
}
