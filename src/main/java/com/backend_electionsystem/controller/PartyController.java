package com.backend_electionsystem.controller;

import com.backend_electionsystem.entity.Candidate;
import com.backend_electionsystem.entity.Party;
import com.backend_electionsystem.service.PartyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PartyController {

    private final PartyService partyService;

    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }
    ///

    @GetMapping("/allParty")
    public List<Party> getAllParties(){
        return partyService.getAllParties();
    }

    @GetMapping("/party/{id}")
    public Party getParty(@PathVariable Integer id){
        return partyService.getParty(id);
    }

    @PostMapping("/addParty")
    public Party addParty(@RequestBody Party party){
        return partyService.addParty(party);
    }
}