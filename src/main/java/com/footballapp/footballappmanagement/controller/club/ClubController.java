package com.footballapp.footballappmanagement.controller.club;

import com.footballapp.footballappmanagement.domain.Club;
import com.footballapp.footballappmanagement.exceptions.IllegalArgumentException;
import com.footballapp.footballappmanagement.services.club.ClubService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/author")
@RequiredArgsConstructor
@Slf4j
public class ClubController {

    private final ClubService clubService;

    //GET
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

    //PUT

    //DELETE

}
