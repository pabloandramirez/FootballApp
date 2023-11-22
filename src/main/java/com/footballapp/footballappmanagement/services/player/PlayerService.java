package com.footballapp.footballappmanagement.services.player;

import com.footballapp.footballappmanagement.domain.Player;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlayerService {

    //POST
    Player createPlayer(@RequestBody Player player);

    //GET
    List<Player> allPlayers();
    List<Player> playerByName(String name);
    List<Player> playerByClubName(String name);

    //PUT
    Optional<Player> updatePlayer(UUID uuid, Player playerUpdated);

    //DELETE
    boolean deletePlayer(UUID uuidPlayer);
}
