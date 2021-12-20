package com.backend_electionsystem.service;

import com.backend_electionsystem.entity.Party;
import com.backend_electionsystem.exception.ResourceNotFoundException;
import com.backend_electionsystem.repository.PartyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyService {

    private final PartyRepository partyRepository;

    public PartyService(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }
    ///

    public List<Party> addParties(List<Party> lists){

        return partyRepository.saveAll(lists);
    }

    public Party addParty(Party party){
        return partyRepository.save(party);
    }

    public List<Party> getAllParties(){
        return partyRepository.findAll();
    }

    public Party getParty(Integer partyId){
        return partyRepository.findById(partyId).orElseThrow(()-> new ResourceNotFoundException("Party not found with id: "+ partyId));
    }

    public String deleteParty(Integer partyId){
        partyRepository.deleteById(partyId);
        return "Party with id: "+ partyId + " not found";
    }

}
