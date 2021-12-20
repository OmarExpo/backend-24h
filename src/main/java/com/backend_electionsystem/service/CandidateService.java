package com.backend_electionsystem.service;

import com.backend_electionsystem.entity.Candidate;
import com.backend_electionsystem.exception.ResourceNotFoundException;
import com.backend_electionsystem.repository.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;
    // Constructor Injection
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }
    ////

    public List<Candidate> addCandidates(List<Candidate> candidates){
        return candidateRepository.saveAll(candidates);
    }

    public Candidate addSingleCandidate(Candidate candidate){
        return candidateRepository.save(candidate);
    }

    public List<Candidate> getAllCandidates(){
        return candidateRepository.findAll();
    }

    public Candidate getCandidate(Integer id){
        return candidateRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Candidate not found with id: "+ id));
    }

    public String removeCandidate(Integer id){
        candidateRepository.deleteById(id);
        return "Candidate with id "+ id + " removed";
    }


}

