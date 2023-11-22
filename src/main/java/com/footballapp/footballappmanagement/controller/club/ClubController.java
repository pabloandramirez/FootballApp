package com.footballapp.footballappmanagement.controller.club;

import com.footballapp.footballappmanagement.domain.Club;
import com.footballapp.footballappmanagement.exceptions.IllegalArgumentException;
import com.footballapp.footballappmanagement.exceptions.NotFoundException;
import com.footballapp.footballappmanagement.services.club.ClubService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/club")
@RequiredArgsConstructor
@Slf4j
public class ClubController {

    private final ClubService clubService;

    //GET
    @GetMapping("/{idCLub}")
    public Optional<Club> getClubById(@PathVariable(value = "idClub")UUID idClub){
        return clubService.getClubById(idClub);
    }

    @GetMapping("/")
    public List<Club> getClubs(@RequestParam(name="name", required = false) String name){
        log.info("Trying to find clubs by name. In case name is empty it shows the full list");
        if (name == null || name.trim().isBlank()){
            return clubService.getClubs();
        } else{
            if(clubService.getClubByName(name).isEmpty()){
                log.info("There are no clubs with this name");
            }
        }
        return clubService.getClubByName(name);
    }

    @GetMapping("/city/")
    public List<Club> getClubByCityName(@RequestParam(name="name", required = false) String cityName) throws IllegalArgumentException {
        log.info("Find the club by the name of its city. If its empty will show an advertising message");
        if(cityName == null || cityName.trim().isBlank() || cityName.isEmpty()){
            log.info("Must be a city name to search");
            throw new IllegalArgumentException();
        } else {
            return clubService.getClubByCity(cityName);
        }
    }

    //POST
    @PostMapping
    public ResponseEntity<Void> createClub(@RequestBody Club club){
        log.info("Creating a new club");
        Club clubCreated = clubService.createClub(club);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/club/"+clubCreated.getUuid());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    //PUT
    @PutMapping("/{idClub}")
    public ResponseEntity<Void> updateClub(@PathVariable(value = "idClub") UUID idClub, @RequestBody Club clubUpdated) throws NotFoundException {
        Optional<Club> club = clubService.updateClub(idClub, clubUpdated);
        if(club.isEmpty()){
            log.info("Club Not Found");
            throw new NotFoundException();
        } else{
            log.info("Club Updated");
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    //DELETE
    @DeleteMapping("/{idClub}")
    public ResponseEntity<Void> deleteClub(@PathVariable(value = "idClub") UUID idClub) throws NotFoundException {
        boolean isClubDeleted = clubService.deleteClub(idClub);
        if(isClubDeleted){
            log.info("Club deleted");
            return new ResponseEntity<>(HttpStatus.OK);
        } else{
            log.info("Club Not Found");
            throw new NotFoundException();
        }
    }
}
