package com.footballapp.footballappmanagement.repository.coach;

import com.footballapp.footballappmanagement.domain.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoachRepository extends JpaRepository<Coach, UUID> {
}
