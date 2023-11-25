package com.footballapp.footballappmanagement.mapper.coach;

import com.footballapp.footballappmanagement.domain.Coach;
import com.footballapp.footballappmanagement.model.dto.coach.CoachDTO;

public interface CoachMapper {

    Coach coachDTOtoCoach(CoachDTO coachDTO);

    CoachDTO coachToCoachDTO(Coach coach);
}
