package com.footballapp.footballappmanagement.repository.stadium;

import com.footballapp.footballappmanagement.domain.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface StadiumRepository extends JpaRepository<Stadium, UUID> {
}
