package com.backend_electionsystem.repository;

import com.backend_electionsystem.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    // Deleting Candidate by firstName using JPQL
    @Modifying
    @Transactional
    @Query("DELETE FROM Candidate where firstName = :firstName")
    Integer deleteCandidateByFirstName(String firstName);

    @Query("select c from Candidate c where c.firstName = :firstName")
    String getCandidateByFirstName(String firstName);
}
