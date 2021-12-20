package com.backend_electionsystem.controller;

import com.backend_electionsystem.entity.Candidate;
import com.backend_electionsystem.service.CandidateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CandidateController {

    private final CandidateService candidateService;
    // Constructor Injection
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }
    ///
    /**
     *
     * @param
     * @return
     *
     * All CRUD APIs are set
     */

    // Add bulk of Candidates
    @PostMapping("/candidates")
    List<Candidate> addCandidates(@RequestBody List<Candidate> lists){
        return candidateService.addCandidates(lists);
    }

    // Add/create Candidate
    @PostMapping("/addCandidate")
    public Candidate newCandidate(@RequestBody Candidate candidate){
        return candidateService.addSingleCandidate(candidate);
    }

    // Retrieve bulk of Candidates
    @GetMapping("/allCandidates")
    public List<Candidate> getAllCandidates(){
        return candidateService.getAllCandidates();
    }

    // Fetch Single Candidate
    @GetMapping("/candidate/{id}")
    public Candidate getCandidate(@PathVariable Integer id){
        return candidateService.getCandidate(id);
    }

    // Modify/Edit Existing Candidate
    @PutMapping("/updateCandidate")
    public Candidate updateCandidate(@RequestBody Candidate candidate){
        Candidate existingCandidate = candidateService.getCandidate(candidate.getId());

        existingCandidate.setElection(candidate.getElection());
        existingCandidate.setFirstName(candidate.getFirstName());
        existingCandidate.setLastName(candidate.getLastName());

        candidateService.addSingleCandidate(existingCandidate);

        return existingCandidate;
    }

    // Delete Candidate
    @DeleteMapping("/rmCandidate/{id}")
    public String deleteCandidate(@PathVariable Integer id){
        return candidateService.removeCandidate(id);
    }



}