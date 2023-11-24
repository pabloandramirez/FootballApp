package com.footballapp.footballappmanagement.repository.player;

import com.footballapp.footballappmanagement.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {
}
