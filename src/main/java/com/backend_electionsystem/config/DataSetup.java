package com.backend_electionsystem.config;

import com.backend_electionsystem.entity.Candidate;
import com.backend_electionsystem.entity.Party;
import com.backend_electionsystem.service.PartyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSetup implements CommandLineRunner {

    private final PartyService partyService;

    public DataSetup(PartyService partyService) {
        this.partyService = partyService;
    }

    @Override
    public void run(String... args) throws Exception {

        Party party1 = new Party(1, "A - Socialdemokratiet");
        Party party2 = new Party(2, "C - Det konservative Folkeparti");
        Party party3 = new Party(3, "F - SF, Socialistisk Folkeparti");
        Party party4 = new Party(4, "O - Dansk Folkeparti");
        Party party5 = new Party(5, "V - Venstre, Danmarks Liberale Parti");
        Party party6 = new Party(6, "Ø - Enhedslisten + De Rød Grønne");

        Candidate candidate1 = new Candidate(1,"Marcel", "Meijer");
        // Candidate candidate2 = new Candidate(2, "Michael", "Kristensen");


        Candidate candidate3 = new Candidate(3, "Per Urban", "Olsen");
        // Candidate candidate4 = new Candidate(4, "Peter", "Askjær");


        Candidate candidate5 = new Candidate(5, "Ulla", "Holm");
        Candidate candidate6 = new Candidate(6, "Kjeld", "Bønkel");

        Candidate candidate7 = new Candidate(7, "Per", "Mortensen");

        Candidate candidate8 = new Candidate(8, "Søren", "Wiese");
        Candidate candidate9 = new Candidate(9, "Carsten", "Bruun");

        Candidate candidate10 = new Candidate(10, "Jette M.", "Søgaard");

        party1.addCandidate(candidate1); //party1.addCandidate(candidate2);
        party2.addCandidate(candidate3); //party2.addCandidate(candidate4);
        party3.addCandidate(candidate5);party3.addCandidate(candidate6);
        party4.addCandidate(candidate7);
        party5.addCandidate(candidate8);party5.addCandidate(candidate9);
        party6.addCandidate(candidate10);

        partyService.addParty(party1);partyService.addParty(party2);
        partyService.addParty(party3);partyService.addParty(party4);
        partyService.addParty(party5);partyService.addParty(party6);

    }
}
