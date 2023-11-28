package com.footballapp.footballappmanagement.services.player;

import com.footballapp.footballappmanagement.domain.Player;
import com.footballapp.footballappmanagement.model.dto.player.PlayerDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlayerService {

    //POST
    Player createPlayer(@RequestBody PlayerDTO playerDTO);

    //GET
    Optional<PlayerDTO> getPlayerById(UUID idPlayer);
    List<PlayerDTO> allPlayers();
    List<PlayerDTO> playerByName(String nameOrSurname);
    List<PlayerDTO> playerByClubName(String name);

    //PUT
    Optional<Player> updatePlayer(UUID uuid, Player playerUpdated);

    //DELETE
    boolean deletePlayer(UUID uuidPlayer);
}
