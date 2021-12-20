package com.backend_electionsystem.repository;

import com.backend_electionsystem.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Integer> {
}
