package com.backend_electionsystem.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;


    @ManyToOne
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Election election;


    public Candidate(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Candidate(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

           /*
            @ManyToOne
            @JoinColumn(name = "candidate_id", referencedColumnName = "id")
            private  Party party;
          */


}
