package com.footballapp.footballappmanagement.mapper.stadium;

import com.footballapp.footballappmanagement.domain.Stadium;
import com.footballapp.footballappmanagement.model.dto.stadium.StadiumDTO;

public interface StadiumMapper {

    Stadium stadiumDTOtoStadium(StadiumDTO stadiumDTO);

    StadiumDTO stadiumToStadiumDTO(Stadium stadium);
}
