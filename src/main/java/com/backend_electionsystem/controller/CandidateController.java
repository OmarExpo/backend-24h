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

    @PostMapping("/candidates")
    List<Candidate> addCandidates(@RequestBody List<Candidate> lists){
        return candidateService.addCandidates(lists);
    }

    @PostMapping("/addCandidate")
    public Candidate newCandidate(@RequestBody Candidate candidate){
        return candidateService.addSingleCandidate(candidate);
    }

    @GetMapping("/allCandidates")
    public List<Candidate> getAllCandidates(){
        return candidateService.getAllCandidates();
    }

    @GetMapping("/candidate/{id}")
    public Candidate getCandidate(@PathVariable Integer id){
        return candidateService.getCandidate(id);
    }

    @PutMapping("/updateCandidate")
    public Candidate updateCandidate(@RequestBody Candidate candidate){
        Candidate existingCandidate = candidateService.getCandidate(candidate.getId());

        existingCandidate.setElection(candidate.getElection());
        existingCandidate.setFirstName(candidate.getFirstName());
        existingCandidate.setLastName(candidate.getLastName());

        candidateService.addSingleCandidate(existingCandidate);

        return existingCandidate;
    }

    @DeleteMapping("/deleteCandidate")
    public String deleteCandidate(@PathVariable Integer id){
        return candidateService.removeCandidate(id);
    }





    /*
    @PutMapping("/updateElection")
    public Election updateElection(@RequestBody Election election){
        Election existingElection = service.getElection(election.getId());

        existingElection.setElectionName(election.getElectionName());
        existingElection.setCandidates(election.getCandidates());
        existingElection.setParties(election.getParties());

        service.addElection(existingElection);

        return existingElection;
    }

    @DeleteMapping("/endElection")
    public String deleteElection(@PathVariable Integer id){
        return service.removeElection(id);
    }

     */

}