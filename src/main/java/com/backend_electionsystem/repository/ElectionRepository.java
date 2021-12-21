package com.backend_electionsystem.repository;

import com.backend_electionsystem.entity.Election;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionRepository extends JpaRepository<Election, Integer> {
}
