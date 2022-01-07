package com.backend_electionsystem.repository;

import com.backend_electionsystem.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface PartyRepository extends JpaRepository<Party, Integer> {

}
