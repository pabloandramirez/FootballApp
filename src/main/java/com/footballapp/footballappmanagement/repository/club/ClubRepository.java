package com.footballapp.footballappmanagement.repository.club;

import com.footballapp.footballappmanagement.domain.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClubRepository extends JpaRepository<Club, UUID> {
}
