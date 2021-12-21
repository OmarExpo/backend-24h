package com.backend_electionsystem.controller;

import com.backend_electionsystem.entity.Candidate;
import com.backend_electionsystem.entity.Election;
import com.backend_electionsystem.entity.Party;
import com.backend_electionsystem.service.CandidateService;
import com.backend_electionsystem.service.ElectionService;
import com.backend_electionsystem.service.PartyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class ElectionController {

    private ElectionService electionService;
    private PartyService partyService;
    private CandidateService candidateService;

    public ElectionController(ElectionService electionService, PartyService partyService, CandidateService candidateService) {
        this.electionService = electionService;
        this.partyService = partyService;
        this.candidateService = candidateService;
    }
    ///

    /**
     *
     * @param
     * @return
     *
     * All CRUD APIs are set
     * with Relations with Candidate & Party
     * in this Controller
     */

    @PostMapping("/newElection")
    public Election createElection(@RequestBody Election election){
        return electionService.addElection(election);
    }

    @PostMapping("/elections")
    public List<Election> addElections(@RequestBody List<Election> lists){
        return electionService.addElections(lists);
    }

    @GetMapping("/allElections")
    public List<Election> getElections(){
        return electionService.getAllElections();
    }

    @GetMapping("/election/{id}")
    public Election getElectionById(@PathVariable Integer id){
        return electionService.getElection(id);
    }

    @PutMapping("/updateElection")
    public Election updateElection(@RequestBody Election election){
        Election existingElection = electionService.getElection(election.getId());

        existingElection.setElectionName(election.getElectionName());
        existingElection.setCandidates(election.getCandidates());
        existingElection.setParties(election.getParties());

        electionService.addElection(existingElection);

        return existingElection;
    }

    @DeleteMapping("/endElection")
    public String deleteElection(@PathVariable Integer id){
        return electionService.removeElection(id);
    }

    // Add Party to Election
    @PutMapping("/election/{electionId}/candidate/{candidateId}/party/{partyId}")
    public Election addPartyToElection(
            @PathVariable Integer electionId,
            @PathVariable Integer partyId,
            @PathVariable Integer candidateId
    ){
        Election election = electionService.getElection(electionId);
        Party party = partyService.getParty(partyId);
        Candidate candidate = candidateService.getCandidate(candidateId);

        party.addCandidate(candidate);

        election.addParty(party);

        return electionService.addElection(election);
    }

    // Add Candidate to Party

}
