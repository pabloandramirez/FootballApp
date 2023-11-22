package com.footballapp.footballappmanagement.services.player;

import com.footballapp.footballappmanagement.domain.Player;
import org.springframework.web.bind.annotation.RequestBody;

public interface PlayerService {

    Player createPlayer(@RequestBody Player player);
}
