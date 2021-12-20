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

    @OneToMany(mappedBy = "election")
    private Set<Party> parties = new HashSet<>();

    public Election(int id, String electionName) {
        this.id = id;
        this.electionName = electionName;
    }
}
