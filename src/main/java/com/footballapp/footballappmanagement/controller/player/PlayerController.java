package com.footballapp.footballappmanagement.controller.player;

import com.footballapp.footballappmanagement.domain.Coach;
import com.footballapp.footballappmanagement.domain.Player;
import com.footballapp.footballappmanagement.exceptions.IllegalArgumentException;
import com.footballapp.footballappmanagement.exceptions.NotFoundException;
import com.footballapp.footballappmanagement.services.player.PlayerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/player")
@RequiredArgsConstructor
@Slf4j
public class PlayerController {

    private PlayerService playerService;

    //GET
    @GetMapping("/{idPlayer}")
    public Optional<Player> playerById(@PathVariable(value = "idPlayer")UUID idPlayer) throws NotFoundException {
        Optional<Player> player = playerService.getPlayerById(idPlayer);
        if (player.isEmpty()){
            log.info("Club Not Found");
            throw new NotFoundException();
        } else {
            return player;
        }
    }

    @GetMapping("/")
    public List<Player> getPlayer(@RequestParam(name = "name", required = false) String playerName){
        log.info("Show all players or find by name");
        if (playerName == null || playerName.isBlank()){
            return playerService.allPlayers();
        } else {
            if (playerService.playerByName(playerName).isEmpty()){
                log.info("There are no players with this name");
            }
        }
        return playerService.playerByName(playerName);
    }

    @GetMapping("/club/")
    public List<Player> getPlayersByClub(@RequestParam(name = "clubName", required = false) String clubName) throws IllegalArgumentException {
        log.info("Find the club by the name of its city. If its empty will show an error message");
        if (clubName==null || clubName.isBlank() || clubName.isEmpty()){
            throw new IllegalArgumentException();
        } else {
            return playerService.playerByClubName(clubName);
        }
    }

    //POST
    @PostMapping()
    public ResponseEntity<Void> createPlayer(@RequestBody Player player){
        log.info("Creation of a new player");
        Player playerCreated = playerService.createPlayer(player);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/player/"+playerCreated.getUuid());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{idPlayer}")
    public ResponseEntity<Void> updatePlayer(@PathVariable(value = "idPlayer") UUID idPlayer, @RequestBody Player playerUpdated) throws NotFoundException {
        Optional<Player> player = playerService.updatePlayer(idPlayer, playerUpdated);
        if (player.isEmpty()){
            log.info("Player Not Found");
            throw new NotFoundException();
        } else {
            log.info("Player updated");
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    //DELETE
    
}
