package com.footballapp.footballappmanagement.services.stadium;

import com.footballapp.footballappmanagement.domain.Stadium;
import org.springframework.web.bind.annotation.RequestBody;

public interface StadiumService {

    Stadium createStadium(@RequestBody Stadium stadium);
}
