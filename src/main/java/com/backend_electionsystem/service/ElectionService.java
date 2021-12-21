package com.backend_electionsystem.service;

import com.backend_electionsystem.entity.Election;
import com.backend_electionsystem.exception.ResourceNotFoundException;
import com.backend_electionsystem.repository.ElectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionService {

    private ElectionRepository electionRepository;

    public ElectionService(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }
    ///

    public Election addElection(Election election){
        return electionRepository.save(election);
    }

    public Election getElection(Integer electionId){
        return electionRepository.findById(electionId).orElseThrow(()-> new ResourceNotFoundException("Subject not found with id: "+ electionId));

    }

    public List<Election> getAllElections(){
        return electionRepository.findAll();
    }

    public String removeElection(Integer electionId){
        electionRepository.deleteById(electionId);
        return "Election deleted with id: "+ electionId;
    }

    public List<Election> addElections(List<Election> lists) {
        return electionRepository.saveAll(lists);
    }
}
