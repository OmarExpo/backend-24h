package com.backend_electionsystem.controller;

import com.backend_electionsystem.entity.Candidate;
import com.backend_electionsystem.service.CandidateService;
import com.backend_electionsystem.service.ElectionService;
import com.backend_electionsystem.service.PartyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CandidateController.class)
class CandidateControllerTest {

    // Testing Rest APis using WebMvcTest and MockMvc Annotations - Testing in SpringBoot

    @Autowired
    CandidateController controller;
    @Autowired
    ElectionService electionService;
    @Autowired
    PartyService partyService;

    @Autowired
    MockMvc mvc;

    @MockBean
    private CandidateService candidateService;


    @Test
    void newCandidate() throws Exception {
        // Mock the Candidate data we want to save
        Candidate candidate = new Candidate();
        candidate.setFirstName("newCand");
        candidate.setLastName("lastCand");

        when(candidateService.addSingleCandidate(any(Candidate.class))).thenReturn(candidate);

        // Mock Request '/candidate'
        mvc.perform(MockMvcRequestBuilders.post("/addCandidate")
                .content(new ObjectMapper().writeValueAsString(candidate))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("newCand"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("lastCand"));


    }


    @Test
    void getCandidate() throws Exception{
        // Mock the data return by the Candidate Service class
        Candidate candidate = new Candidate();
        candidate.setFirstName("testName");
        candidate.setLastName("lastNameTest");

        when(candidateService.getCandidate(anyInt())).thenReturn(candidate);

        // Create a Mcok HTTP request o verify the mock
        mvc.perform(MockMvcRequestBuilders.get("/candidate/12"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("testName"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("lastNameTest"))
                .andExpect(status().isOk());
    }


}

