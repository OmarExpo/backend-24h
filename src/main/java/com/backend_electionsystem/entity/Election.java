package com.backend_electionsystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Election {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String electionName;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "election_party",
            joinColumns = @JoinColumn(name = "election_id"),
            inverseJoinColumns = @JoinColumn(name = "party_id")
    )
    private Set<Party> parties = new HashSet<>();



    public Election(int id, String electionName) {
        this.id = id;
        this.electionName = electionName;
    }

    public Set<Party> getParties() {
        return parties;
    }


    public void addParty(Party party){
        parties.add(party);
    }
}
