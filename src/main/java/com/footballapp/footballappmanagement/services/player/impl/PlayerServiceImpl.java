package com.footballapp.footballappmanagement.services.player.impl;

import com.footballapp.footballappmanagement.domain.Player;
import com.footballapp.footballappmanagement.services.player.PlayerService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PlayerServiceImpl implements PlayerService {


    @Override
    public Player createPlayer(Player player) {
        player.setUuid(UUID.randomUUID());
        return player;
    }

    @Override
    public Optional<Player> getPlayerById(UUID idPlayer) {
        return Optional.empty();
    }

    @Override
    public List<Player> allPlayers() {
        return null;
    }

    @Override
    public List<Player> playerByName(String name) {
        return null;
    }

    @Override
    public List<Player> playerByClubName(String name) {
        return null;
    }

    @Override
    public Optional<Player> updatePlayer(UUID uuid, Player playerUpdated) {
        return Optional.empty();
    }

    @Override
    public boolean deletePlayer(UUID uuidPlayer) {
        return false;
    }
}
