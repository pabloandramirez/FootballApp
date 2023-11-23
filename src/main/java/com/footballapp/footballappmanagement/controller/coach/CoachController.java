package com.footballapp.footballappmanagement.controller.coach;

import com.footballapp.footballappmanagement.domain.Coach;
import com.footballapp.footballappmanagement.services.coach.CoachService;
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
@RequestMapping("api/v1/coach")
@RequiredArgsConstructor
@Slf4j
public class CoachController {

    private final CoachService coachService;

    //GET
    @GetMapping("/{idCoach}")
    public Optional<Coach> getCoachById(@PathVariable(value = "idCoach") UUID idCoach){
        return coachService.getCoachById(idCoach);
    }

    @GetMapping("/")
    public List<Coach> getCoachs(@RequestParam(name="name", required = false)String coachName){
        log.info("Shows all coaches or find by name");
        if (coachName == null || coachName.trim().isBlank()){
            return coachService.getCoachs();
        } else {
            if (coachService.getCoachByName(coachName).isEmpty()){
                log.info("There are no coaches with this name");
            }
        }
        return coachService.getCoachByName(coachName);
    }

    //POST
    @PostMapping()
    public ResponseEntity<Void> createCoach(@RequestBody Coach coach){
        log.info("Creation of a new coach");
        Coach coachCreated = coachService.createCoach(coach);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/coach/"+coachCreated.getUuid());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    
}
