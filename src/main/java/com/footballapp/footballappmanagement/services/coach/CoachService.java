package com.footballapp.footballappmanagement.services.coach;

import com.footballapp.footballappmanagement.domain.Coach;
import org.springframework.web.bind.annotation.RequestBody;

public interface CoachService {

    Coach createCoach(@RequestBody Coach coach);
}
