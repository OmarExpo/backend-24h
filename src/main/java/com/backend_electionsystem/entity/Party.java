package com.backend_electionsystem.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String partyName;


    @OneToMany(mappedBy = "party")
    private Set<Candidate> candidateSet = new HashSet<>();


    @ManyToOne
    //@JoinColumn(name = "party_id", referencedColumnName = "id")
    private Election election;

    public Party(int id, String partyName) {
        this.id = id;
        this.partyName = partyName;
    }

    public Party(String partyName) {
        this.partyName = partyName;
    }


            public Set<Candidate> getCandidateSet() {
                return candidateSet;
            }

            public void addCandidate(Candidate candidate){
                candidateSet.add(candidate);
            }


}
