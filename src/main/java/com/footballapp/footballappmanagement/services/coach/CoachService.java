package com.footballapp.footballappmanagement.services.coach;

import com.footballapp.footballappmanagement.domain.Coach;
import com.footballapp.footballappmanagement.model.dto.coach.CoachDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CoachService {

    //POST
    Coach createCoach(@RequestBody CoachDTO coachDTO);

    //GET
    Optional<CoachDTO> getCoachById(UUID idCoach);
    List<CoachDTO> getCoaches();
    List<CoachDTO> getCoachByNameOrSurname(String coachNameOrSurname);

    //PUT
    Optional<Coach> updateCoach(UUID uuidCoach, Coach coachUpdated);

    //DELETE
    boolean deleteCoach(UUID uuidCoach);
}
