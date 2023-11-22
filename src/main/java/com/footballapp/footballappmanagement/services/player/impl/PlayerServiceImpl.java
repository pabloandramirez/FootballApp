package com.footballapp.footballappmanagement.services.player.impl;

import com.footballapp.footballappmanagement.domain.Player;
import com.footballapp.footballappmanagement.services.player.PlayerService;

import java.util.UUID;

public class PlayerServiceImpl implements PlayerService {


    @Override
    public Player createPlayer(Player player) {
        player.setUuid(UUID.randomUUID());
        return player;
    }
}
