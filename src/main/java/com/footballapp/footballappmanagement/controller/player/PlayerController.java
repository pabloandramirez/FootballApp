package com.footballapp.footballappmanagement.controller.player;

import com.footballapp.footballappmanagement.domain.Player;
import com.footballapp.footballappmanagement.exceptions.IllegalArgumentException;
import com.footballapp.footballappmanagement.exceptions.NotFoundException;
import com.footballapp.footballappmanagement.model.dto.player.PlayerDTO;
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
    public PlayerDTO playerById(@PathVariable(value = "idPlayer")UUID idPlayer)
            throws NotFoundException {
        return playerService.getPlayerById(idPlayer).orElseThrow(NotFoundException::new);
    }

    @GetMapping("/")
    public List<PlayerDTO> getPlayer(@RequestParam(name = "name", required = false) String playerNameOrSurname){
        log.info("Show all players or find by name");
        if (playerNameOrSurname == null || playerNameOrSurname.isBlank()){
            return playerService.allPlayers();
        } else {
            if (playerService.playerByName(playerNameOrSurname).isEmpty()){
                log.info("There are no players with this name");
            }
        }
        return playerService.playerByName(playerNameOrSurname);
    }

    @GetMapping("/club/")
    public List<PlayerDTO> getPlayersByClub(@RequestParam(name = "clubName", required = false) String clubName) {
        log.info("Find the club by the name of its city. If its empty will show all players");
        if (clubName==null || clubName.isBlank()){
            return playerService.allPlayers();
        } else {
            if (playerService.playerByClubName(clubName).isEmpty()){
                log.info("There are no player with this club name");
            }
        }
        return playerService.playerByClubName(clubName);
    }

    //POST
    @PostMapping()
    public ResponseEntity<Void> createPlayer(@RequestBody PlayerDTO playerDTO){
        log.info("Creation of a new player");
        Player playerCreated = playerService.createPlayer(playerDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/player/"+playerCreated.getUuid());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{idPlayer}")
    public ResponseEntity<Void> updatePlayer(@PathVariable(value = "idPlayer") UUID idPlayer,
                                             @RequestBody Player playerUpdated) throws NotFoundException {
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
    @DeleteMapping("/{idPlayer}")
    public ResponseEntity<Void> deletePlayer(@PathVariable(value = "idPlayer") UUID idPlayer)
            throws NotFoundException {
        boolean playerDeleted = playerService.deletePlayer(idPlayer);
        if (playerDeleted){
            log.info("Player deleted");
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            log.info("Player Not Found");
            throw new NotFoundException();
        }
    }
}
