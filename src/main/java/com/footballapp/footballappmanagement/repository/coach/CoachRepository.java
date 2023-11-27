package com.footballapp.footballappmanagement.repository.coach;

import com.footballapp.footballappmanagement.domain.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CoachRepository extends JpaRepository<Coach, UUID> {
}
