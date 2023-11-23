package com.footballapp.footballappmanagement.services.coach;

import com.footballapp.footballappmanagement.domain.Coach;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CoachService {

    //POST
    Coach createCoach(@RequestBody Coach coach);

    //GET
    Optional<Coach> getCoachById(UUID idCoach);
    List<Coach> getCoaches();
    List<Coach> getCoachByName(String coachName);

    //PUT
    Optional<Coach> updateCoach(UUID uuidCoach, Coach coachUpdated);

    //DELETE
    boolean deleteCoach(UUID uuidCoach);
}
