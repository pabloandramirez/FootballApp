package com.footballapp.footballappmanagement.services.stadium;

import com.footballapp.footballappmanagement.domain.Stadium;
import com.footballapp.footballappmanagement.model.dto.stadium.StadiumDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StadiumService {

    //POST
    Stadium createStadium(@RequestBody StadiumDTO stadiumDTO);

    //GET
    Optional<StadiumDTO> getStadiumById(UUID idStadium);
    List<StadiumDTO> allStadiums();
    List<StadiumDTO> stadiumByName(String name);
    List<StadiumDTO> stadiumByCityName(String cityName);

    //PUT
    Optional<Stadium> updateStadium(UUID uuidStadium, Stadium stadiumUpdated);

    //DELETE
    boolean deleteStadium(UUID uuidStadium);
}
