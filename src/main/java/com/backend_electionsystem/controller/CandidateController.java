package com.backend_electionsystem.controller;

import com.backend_electionsystem.entity.Candidate;
import com.backend_electionsystem.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CandidateController {

    private final CandidateService candidateService;
    // Constructor Injection
    @Autowired
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
    public ResponseEntity<Candidate> newCandidate(@RequestBody Candidate candidate){
        return new ResponseEntity<>(candidateService.addSingleCandidate(candidate), HttpStatus.CREATED);
    }


    // Retrieve bulk of Candidates
    @GetMapping("/allCandidates")
    public List<Candidate> getAllCandidates(){
        return candidateService.getAllCandidates();
    }

         /*
            @GetMapping("/allCandidates")
            public List<Candidate> getAllCandidates(){
                return candidateService.getAllCandidates();
            }
          */


    // Fetch Single Candidate
    @GetMapping("/candidate/{id}")
    public Candidate getCandidate(@PathVariable Integer id){
        return candidateService.getCandidate(id);
    }

    // Modify/Edit Existing Candidate
    @PutMapping("/updateCandidate")
    public Candidate updateCandidate(@RequestBody Candidate candidate){
        Candidate existingCandidate = candidateService.getCandidate(candidate.getId());

        //existingCandidate.setElection(candidate.getElection());
        existingCandidate.setFirstName(candidate.getFirstName());
        existingCandidate.setLastName(candidate.getLastName());

        candidateService.addSingleCandidate(existingCandidate);

        return existingCandidate;
    }

    // GENERATE RANDOM VOTES
    @PutMapping("/getVotes")
    public String getRandomVotesForCandidates(){

        int vote = candidateService.getRandomVotes();
        return "Winning vote number is: "+ vote;
    }

    // Delete Candidate
    @DeleteMapping("/rmCandidate/{id}")
    public String deleteCandidate(@PathVariable Integer id){
        return candidateService.removeCandidate(id);
    }


    // Deleting Candidate by firstName using JPQL (Java Persistence Query Language)
    @DeleteMapping("/candidate/delete/{firstName}")
    public ResponseEntity<String> deleteCandidateByFirstName(@PathVariable String firstName){
        return new ResponseEntity<String>(candidateService.deleteCandidateByFirstName(firstName)+" No. of records deleted", HttpStatus.OK);
    }

}