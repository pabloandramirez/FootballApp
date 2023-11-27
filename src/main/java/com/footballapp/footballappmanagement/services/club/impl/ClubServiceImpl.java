package com.footballapp.footballappmanagement.services.club.impl;

import com.footballapp.footballappmanagement.domain.Club;
import com.footballapp.footballappmanagement.domain.Stadium;
import com.footballapp.footballappmanagement.mapper.club.ClubMapper;
import com.footballapp.footballappmanagement.model.dto.club.ClubDTO;
import com.footballapp.footballappmanagement.repository.club.ClubRepository;
import com.footballapp.footballappmanagement.services.club.ClubService;
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
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;

    private final ClubMapper clubMapper;

    @Override
    public Club createClub(ClubDTO clubDTO) {
        Club club = clubMapper.clubDTOtoClub(clubDTO);
        return clubRepository.save(club);
    }

    @Override
    public Optional<ClubDTO> getClubById(UUID idClub) {
        Optional<Club> club = clubRepository.findById(idClub);
        if (club.isPresent()){
            return Optional.of(clubMapper.clubToClubDTO(club.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<ClubDTO> getClubs() {
        List<ClubDTO> clubList = new ArrayList<>();
        for (Club club: clubRepository.findAll()){
            clubList.add(clubMapper.clubToClubDTO(club));
        }
        return clubList;
    }

    @Override
    public List<ClubDTO> getClubByName(String name) {
        List<ClubDTO> clubList = new ArrayList<>();
        for (Club club: clubRepository.findAll()){
            if (club.getName().toLowerCase().contains(name.toLowerCase())){
                clubList.add(clubMapper.clubToClubDTO(club));
            }
        }
        return clubList;
    }

    @Override
    public List<ClubDTO> getClubByCity(String city) {
        List<ClubDTO> clubList = new ArrayList<>();
        for (Club club: clubRepository.findAll()){
            if (club.getCity().toLowerCase().contains(city.toLowerCase())){
                clubList.add(clubMapper.clubToClubDTO(club));
            }
        }
        return clubList;
    }

    @Override
    public Optional<Club> updateClub(UUID uuidClub, Club clubUpdated) {
        Optional<Club> clubOptional = clubRepository.findById(uuidClub);

        if (clubOptional.isPresent()){
            updatingClub(clubOptional.get(), clubUpdated);
            return Optional.of(clubRepository.saveAndFlush(clubOptional.get()));
        }
        return Optional.empty();
    }

    private void updatingClub(Club club, Club clubUpdated){
        if(clubUpdated.getName() != null){
            club.setName(clubUpdated.getName());
        }

        if(clubUpdated.getDateOfFoundation() != null){
            club.setDateOfFoundation(clubUpdated.getDateOfFoundation());
        }

        if(clubUpdated.getCity() != null){
            club.setCity(clubUpdated.getCity());
        }

        if(clubUpdated.getCoach() != null){
            club.setCoach(clubUpdated.getCoach());
        }

        if(clubUpdated.getStadium() != null){
            club.setStadium(clubUpdated.getStadium());
        }
    }

    @Override
    public boolean deleteClub(UUID uuidClub) {
        if (clubRepository.existsById(uuidClub)){
            clubRepository.deleteById(uuidClub);
            return true;
        }
        return false;
    }

}
