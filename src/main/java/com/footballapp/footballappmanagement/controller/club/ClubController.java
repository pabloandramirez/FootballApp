package com.footballapp.footballappmanagement.controller.club;

import com.footballapp.footballappmanagement.domain.Club;
import com.footballapp.footballappmanagement.exceptions.IllegalArgumentException;
import com.footballapp.footballappmanagement.exceptions.NotFoundException;
import com.footballapp.footballappmanagement.model.dto.club.ClubDTO;
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
    @GetMapping("/{idClub}")
    public ClubDTO getClubById(@PathVariable(value = "idClub")UUID idClub)
            throws NotFoundException {
        return clubService.getClubById(idClub).orElseThrow(NotFoundException::new);
    }

    @GetMapping("/")
    public List<ClubDTO> getClubs(@RequestParam(name="name", required = false) String name){
        log.info("Trying to find clubs by name. In case name is empty it shows the full list");
        if (name == null || name.isBlank()){
            return clubService.getClubs();
        } else{
            if(clubService.getClubByName(name).isEmpty()){
                log.info("There are no clubs with this name");
            }
        }
        return clubService.getClubByName(name);
    }

    @GetMapping("/city/")
    public List<ClubDTO> getClubByCityName(@RequestParam(name="name", required = false) String cityName)
            throws IllegalArgumentException {
        log.info("Find the club/s by the name of its city. If its empty will show all clubs");
        if(cityName == null || cityName.isBlank()){
            return clubService.getClubs();
        } else {
            if (clubService.getClubByCity(cityName).isEmpty()){
                log.info("There are no clubs in this city");
            }
        }
        return clubService.getClubByCity(cityName);
    }

    //POST
    @PostMapping
    public ResponseEntity<Void> createClub(@RequestBody ClubDTO clubDTO){
        log.info("Creating a new club");
        Club clubCreated = clubService.createClub(clubDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/club/"+clubCreated.getUuid());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    //PUT
    @PutMapping("/{idClub}")
    public ResponseEntity<Void> updateClub(@PathVariable(value = "idClub") UUID idClub,
                                           @RequestBody Club clubUpdated) throws NotFoundException {
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
    public ResponseEntity<Void> deleteClub(@PathVariable(value = "idClub") UUID idClub)
            throws NotFoundException {
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
