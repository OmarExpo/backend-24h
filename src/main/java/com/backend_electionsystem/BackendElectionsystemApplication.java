package com.backend_electionsystem;

import com.backend_electionsystem.entity.Candidate;
import com.backend_electionsystem.entity.Party;
import com.backend_electionsystem.service.CandidateService;
import com.backend_electionsystem.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendElectionsystemApplication implements CommandLineRunner {

    @Autowired
    private PartyService partyService;
    @Autowired
    private CandidateService candidateService;

    public static void main(String[] args) {
        SpringApplication.run(BackendElectionsystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        partyService.addParty(new Party(1, "A - Socialdemokratiet"));
        partyService.addParty(new Party(2, "C - Det konservative Folkeparti"));
        partyService.addParty(new Party(3, "F - SF, Socialistisk Folkeparti"));
        partyService.addParty(new Party(4, "O - Dansk Folkeparti"));
        partyService.addParty(new Party(5, "V - Venstre, Danmarks Liberale Parti"));
        partyService.addParty(new Party(6, "Ø - Enhedslisten + De Rød Grønne"));

        candidateService.addSingleCandidate(new Candidate(1, "Marcel", "Meijer"));
        candidateService.addSingleCandidate(new Candidate(2, "Michael", "Kristensen"));
        candidateService.addSingleCandidate(new Candidate(3, "Per Urban", "Olsen"));



    }
}
