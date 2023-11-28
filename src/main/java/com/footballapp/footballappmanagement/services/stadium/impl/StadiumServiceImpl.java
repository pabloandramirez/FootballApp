package com.footballapp.footballappmanagement.services.stadium.impl;

import com.footballapp.footballappmanagement.domain.Stadium;
import com.footballapp.footballappmanagement.mapper.stadium.StadiumMapper;
import com.footballapp.footballappmanagement.model.dto.stadium.StadiumDTO;
import com.footballapp.footballappmanagement.repository.stadium.StadiumRepository;
import com.footballapp.footballappmanagement.services.stadium.StadiumService;
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
public class StadiumServiceImpl implements StadiumService {

    private final StadiumRepository stadiumRepository;

    private final StadiumMapper stadiumMapper;

    @Override
    public Stadium createStadium(StadiumDTO stadiumDTO) {
        Stadium stadium = stadiumMapper.stadiumDTOtoStadium(stadiumDTO);
        return stadiumRepository.save(stadium);
    }

    @Override
    public Optional<StadiumDTO> getStadiumById(UUID idStadium) {
        Optional<Stadium> stadiumOptional = stadiumRepository.findById(idStadium);
        if (stadiumOptional.isPresent()){
            return Optional.of(stadiumMapper.stadiumToStadiumDTO(stadiumOptional.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<StadiumDTO> allStadiums() {
        List<StadiumDTO> stadiumDTOS = new ArrayList<>();
        for (Stadium stadium: stadiumRepository.findAll()){
            stadiumDTOS.add(stadiumMapper.stadiumToStadiumDTO(stadium));
        }
        return stadiumDTOS;
    }

    @Override
    public List<StadiumDTO> stadiumByName(String name) {
        List<StadiumDTO> stadiumDTOS = new ArrayList<>();
        for (Stadium stadium : stadiumRepository.findAll()){
            if (stadium.getName().toLowerCase().contains(name.toLowerCase())){
                stadiumDTOS.add(stadiumMapper.stadiumToStadiumDTO(stadium));
            }
        }
        return stadiumDTOS;
    }

    @Override
    public List<StadiumDTO> stadiumByCityName(String cityName) {
        List<StadiumDTO> stadiumDTOS = new ArrayList<>();
        for (Stadium stadium : stadiumRepository.findAll()){
            if (stadium.getCity().toLowerCase().contains(cityName.toLowerCase())){
                stadiumDTOS.add(stadiumMapper.stadiumToStadiumDTO(stadium));
            }
        }
        return stadiumDTOS;
    }

    @Override
    public Optional<Stadium> updateStadium(UUID uuidStadium, Stadium stadiumUpdated) {
        Optional<Stadium> stadiumOptional = stadiumRepository.findById(uuidStadium);
        if (stadiumOptional.isPresent()){
            updating(stadiumOptional.get(), stadiumUpdated);
            return Optional.of(stadiumRepository.saveAndFlush(stadiumOptional.get()));
        }
        return Optional.empty();
    }

    private void updating(Stadium stadium, Stadium stadiumUpdated){
        if (stadiumUpdated.getName() != null){
            stadium.setName(stadiumUpdated.getName());
        }

        if (stadiumUpdated.getCity() != null){
            stadium.setCity(stadiumUpdated.getCity());
        }

        if (stadiumUpdated.getClub() != null){
            stadium.setClub(stadiumUpdated.getClub());
        }

        if (stadiumUpdated.getCapacity() != null){
            stadium.setCapacity(stadiumUpdated.getCapacity());
        }

        if (stadiumUpdated.getConstructionDate() != null){
            stadium.setConstructionDate(stadiumUpdated.getConstructionDate());
        }
    }

    @Override
    public boolean deleteStadium(UUID uuidStadium) {
        if (stadiumRepository.existsById(uuidStadium)){
            stadiumRepository.deleteById(uuidStadium);
            return true;
        }
        return false;
    }

}
