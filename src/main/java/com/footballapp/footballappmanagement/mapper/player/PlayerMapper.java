package com.footballapp.footballappmanagement.mapper.player;

import com.footballapp.footballappmanagement.domain.Player;
import com.footballapp.footballappmanagement.model.dto.player.PlayerDTO;

public interface PlayerMapper {

    Player playerDTOtoPlayer(PlayerDTO playerDTO);

    PlayerDTO playerToPlayerDTO(Player player);
}
