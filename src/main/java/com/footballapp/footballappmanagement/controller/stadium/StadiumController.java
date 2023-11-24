package com.footballapp.footballappmanagement.controller.stadium;

import com.footballapp.footballappmanagement.domain.Stadium;
import com.footballapp.footballappmanagement.exceptions.NotFoundException;
import com.footballapp.footballappmanagement.services.stadium.StadiumService;
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
@RequestMapping("/api/v1/stadium")
@RequiredArgsConstructor
@Slf4j
public class StadiumController {

    private final StadiumService stadiumService;

    //GET
    @GetMapping("/{idStadium}")
    public Optional<Stadium> getStadiumById(@PathVariable(value = "idStadium")UUID idStadium)
            throws NotFoundException {
        Optional<Stadium> stadium = stadiumService.getStadiumById(idStadium);
        if (stadium.isEmpty()){
            log.info(("Stadium Not Found"));
            throw new NotFoundException();
        } else {
            return stadium;
        }
    }

    @GetMapping("/")
    public List<Stadium> getStadium(@RequestParam(name = "name", required = false) String stadiumName){
        log.info("Shows all stadiums if the name is blank, or find by name");
        if (stadiumName == null || stadiumName.isBlank()){
            return stadiumService.allStadiums();
        } else {
            if (stadiumService.stadiumByName(stadiumName).isEmpty()){
                log.info("There are no stadiums with this name");
            }
        }
        return stadiumService.stadiumByName(stadiumName);
    }

    @GetMapping("/city/")
    public List<Stadium> getStadiumByName(@RequestParam(name = "name", required = false) String cityName){
        log.info("Shows all stadiums if the city name is blank, or find by city name");
        if (cityName == null || cityName.isBlank()){
            return stadiumService.allStadiums();
        } else {
            if (stadiumService.stadiumByCityName(cityName).isEmpty()){
                log.info("There are no stadiums in this city");
            }
        }
        return stadiumService.stadiumByCityName(cityName);
    }

    //POST
    @PostMapping()
    public ResponseEntity<Void> createStadium(@RequestBody Stadium stadium){
        log.info("Creation of a new stadium");
        Stadium stadiumCreated = stadiumService.createStadium(stadium);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/stadium/"+stadiumCreated.getUuid());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{idStadium}")
    public ResponseEntity<Void> updateStadium(@PathVariable(value = "idStadium") UUID idStadium,
                                              @RequestBody Stadium stadiumUpdated) throws NotFoundException {
        Optional<Stadium> stadium = stadiumService.updateStadium(idStadium, stadiumUpdated);
        if (stadium.isEmpty()){
            log.info("Stadium Not Found");
            throw new NotFoundException();
        } else{
            log.info("Stadium updated");
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    //DELETE
    @DeleteMapping("/{idStadium}")
    public ResponseEntity<Void> deleteStadium(@PathVariable(value = "idStadium") UUID idStadium)
            throws NotFoundException {
        boolean stadiumDeleted = stadiumService.deleteStadium(idStadium);
        if (stadiumDeleted){
            log.info("Stadium Deleted");
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            log.info("Stadium Not Found");
            throw new NotFoundException();
        }
    }
}
