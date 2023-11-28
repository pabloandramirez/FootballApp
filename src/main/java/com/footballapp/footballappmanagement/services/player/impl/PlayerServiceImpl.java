package com.footballapp.footballappmanagement.services.player.impl;

import com.footballapp.footballappmanagement.domain.Player;
import com.footballapp.footballappmanagement.mapper.player.PlayerMapper;
import com.footballapp.footballappmanagement.model.dto.player.PlayerDTO;
import com.footballapp.footballappmanagement.repository.player.PlayerRepository;
import com.footballapp.footballappmanagement.services.player.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    private final PlayerMapper playerMapper;


    @Override
    public Player createPlayer(PlayerDTO playerDTO) {
        Player player = playerMapper.playerDTOtoPlayer(playerDTO);
        return playerRepository.save(player);
    }

    @Override
    public Optional<PlayerDTO> getPlayerById(UUID idPlayer) {
        Optional<Player> playerOptional = playerRepository.findById(idPlayer);
        if (playerOptional.isPresent()){
            return Optional.of(playerMapper.playerToPlayerDTO(playerOptional.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<PlayerDTO> allPlayers() {
        List<PlayerDTO> playerDTOS = new ArrayList<>();
        for (Player player: playerRepository.findAll()){
            playerDTOS.add(playerMapper.playerToPlayerDTO(player));
        }
        return playerDTOS;
    }

    @Override
    public List<PlayerDTO> playerByName(String nameOrSurname) {
        List<PlayerDTO> playerDTOS = new ArrayList<>();
        for (Player player: playerRepository.findAll()){
            if (player.getName().toLowerCase().contains(nameOrSurname.toLowerCase())||
            player.getSurName().toLowerCase().contains(nameOrSurname.toLowerCase())){
                playerDTOS.add(playerMapper.playerToPlayerDTO(player));
            }
        }
        return playerDTOS;
    }

    @Override
    public List<PlayerDTO> playerByClubName(String name) {
        List<PlayerDTO> playerDTOS = new ArrayList<>();
        for (Player player: playerRepository.findAll()){
            if (player.getClub().getName().toLowerCase().contains(name.toLowerCase())){
                playerDTOS.add(playerMapper.playerToPlayerDTO(player));
            }
        }
        return playerDTOS;
    }

    @Override
    public Optional<Player> updatePlayer(UUID uuid, Player playerUpdated) {
        Optional<Player> playerOptional = playerRepository.findById(uuid);

        if (playerOptional.isPresent()){
            updating(playerOptional.get(), playerUpdated);
            return Optional.of(playerRepository.saveAndFlush(playerOptional.get()));
        }

        return Optional.empty();
    }

    private void updating(Player player, Player playerUpdated){

        if (playerUpdated.getName() != null){
            player.setName(playerUpdated.getName());
        }

        if (playerUpdated.getSurName() != null){
            player.setSurName(playerUpdated.getSurName());
        }

        if (playerUpdated.getDateOfBirth() != null){
            player.setDateOfBirth(playerUpdated.getDateOfBirth());
        }

        if (playerUpdated.getPosition() != null){
            player.setPosition(playerUpdated.getPosition());
        }

        if (playerUpdated.getMatches() != null){
            player.setMatches(playerUpdated.getMatches());
        }

        if (playerUpdated.getAssists() != null){
            player.setAssists(playerUpdated.getAssists());
        }

        if (playerUpdated.getGoals() != null){
            player.setGoals(playerUpdated.getGoals());
        }

        if (playerUpdated.getClub() != null){
            player.setClub(playerUpdated.getClub());
        }

        if (playerUpdated.getCaptain() != null){
            player.setCaptain(playerUpdated.getCaptain());
        }

    }

    @Override
    public boolean deletePlayer(UUID uuidPlayer) {
        if(playerRepository.existsById(uuidPlayer)){
            playerRepository.deleteById(uuidPlayer);
            return true;
        }
        return false;
    }
}
