package com.footballapp.footballappmanagement.repository.stadium;

import com.footballapp.footballappmanagement.domain.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StadiumRepository extends JpaRepository<Stadium, UUID> {
}
