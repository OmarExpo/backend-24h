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

}