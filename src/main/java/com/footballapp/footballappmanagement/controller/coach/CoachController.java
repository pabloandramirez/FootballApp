package com.footballapp.footballappmanagement.controller.coach;

import com.footballapp.footballappmanagement.domain.Club;
import com.footballapp.footballappmanagement.domain.Coach;
import com.footballapp.footballappmanagement.exceptions.NotFoundException;
import com.footballapp.footballappmanagement.model.dto.coach.CoachDTO;
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
@RequestMapping("/api/v1/coach")
@RequiredArgsConstructor
@Slf4j
public class CoachController {

    private final CoachService coachService;

    //GET
    @GetMapping("/{idCoach}")
    public CoachDTO getCoachById(@PathVariable(value = "idCoach") UUID idCoach)
            throws NotFoundException {
        return coachService.getCoachById(idCoach).orElseThrow(NotFoundException::new);
    }

    @GetMapping("/")
    public List<CoachDTO> getCoaches(@RequestParam(name="name", required = false)String coachNameOrSurname){
        log.info("Shows all coaches or find by name");
        if (coachNameOrSurname == null || coachNameOrSurname.isBlank()){
            return coachService.getCoaches();
        } else {
            if (coachService.getCoachByNameOrSurname(coachNameOrSurname).isEmpty()){
                log.info("There are no coaches with this name");
            }
        }
        return coachService.getCoachByNameOrSurname(coachNameOrSurname);
    }

    //POST
    @PostMapping()
    public ResponseEntity<Void> createCoach(@RequestBody CoachDTO coachDTO){
        log.info("Creation of a new coach");
        Coach coachCreated = coachService.createCoach(coachDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/coach/"+coachCreated.getUuid());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{idCoach}")
    public ResponseEntity<Void> updateCoach(@PathVariable(value = "idCoach") UUID idCoach, @RequestBody Coach coachUpdated) throws NotFoundException {
        Optional<Coach> coach = coachService.updateCoach(idCoach, coachUpdated);
        if (coach.isEmpty()){
            log.info("Coach Not Found");
            throw new NotFoundException();
        } else{
            log.info("Coach Updated");
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    //DELETE
    @DeleteMapping("/{idCoach}")
    public ResponseEntity<Void> deleteCoach(@PathVariable(value = "idCoach") UUID idCoach) throws NotFoundException {
        boolean isCoachDeleted = coachService.deleteCoach(idCoach);
        if(isCoachDeleted){
            log.info("Coach deleted");
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            log.info("Coach Not Found");
            throw new NotFoundException();
        }
    }
}
