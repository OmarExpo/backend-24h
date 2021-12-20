package com.backend_electionsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    public Party(String partyName) {
        this.partyName = partyName;
    }

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Set<Candidate> candidateSet = new HashSet<>();




}
