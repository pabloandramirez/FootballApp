package com.footballapp.footballappmanagement.services.club;

import com.footballapp.footballappmanagement.domain.Club;
import org.springframework.web.bind.annotation.RequestBody;

public interface ClubService {

    Club createClub(@RequestBody Club club);
}
