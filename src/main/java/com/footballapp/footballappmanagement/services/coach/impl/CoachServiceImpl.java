package com.footballapp.footballappmanagement.services.coach.impl;

import com.footballapp.footballappmanagement.domain.Club;
import com.footballapp.footballappmanagement.domain.Coach;
import com.footballapp.footballappmanagement.mapper.coach.CoachMapper;
import com.footballapp.footballappmanagement.model.dto.coach.CoachDTO;
import com.footballapp.footballappmanagement.repository.coach.CoachRepository;
import com.footballapp.footballappmanagement.services.coach.CoachService;
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
public class CoachServiceImpl implements CoachService {

    private CoachRepository coachRepository;

    private CoachMapper coachMapper;

    @Override
    public Coach createCoach(CoachDTO coachDTO) {
        Coach coach = coachMapper.coachDTOtoCoach(coachDTO);
        return coachRepository.save(coach);
    }

    @Override
    public Optional<CoachDTO> getCoachById(UUID idCoach) {
        Optional<Coach> club = coachRepository.findById(idCoach);
        if (club.isPresent()){
            return Optional.of(coachMapper.coachToCoachDTO(club.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<CoachDTO> getCoaches() {
        List<CoachDTO> coachDTOList = new ArrayList<>();
        for (Coach coach: coachRepository.findAll()){
            coachDTOList.add(coachMapper.coachToCoachDTO(coach));
        }
        return coachDTOList;
    }

    @Override
    public List<CoachDTO> getCoachByNameOrSurname(String coachNameOrSurname) {
        List<CoachDTO> coachDTOList = new ArrayList<>();
        for (Coach coach: coachRepository.findAll()){
            if (coach.getName().toLowerCase().contains(coachNameOrSurname.toLowerCase()) ||
            coach.getSurName().toLowerCase().contains(coachNameOrSurname.toLowerCase())){
                coachDTOList.add(coachMapper.coachToCoachDTO(coach));
            }
        }
        return coachDTOList;
    }

    @Override
    public Optional<Coach> updateCoach(UUID uuidCoach, Coach coachUpdated) {
        return Optional.empty();
    }

    @Override
    public boolean deleteCoach(UUID uuidCoach) {
        return false;
    }
}
