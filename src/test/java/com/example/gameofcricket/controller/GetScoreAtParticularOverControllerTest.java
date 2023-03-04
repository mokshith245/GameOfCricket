package com.example.gameofcricket.controller;

import com.example.gameofcricket.cricket.results.ScoreAtParticularOver;
import com.example.gameofcricket.service.ScoreAtParticularTimeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@WebMvcTest(GetScoreAtParticularOverController.class)
class GetScoreAtParticularOverControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ScoreAtParticularTimeService scoreAtParticularTimeService;

    @Test
    void getScore() throws Exception {
        List<ScoreAtParticularOver> scoreAtParticularOverList = new ArrayList<>();
        ScoreAtParticularOver scoreAtParticularOver = new ScoreAtParticularOver();
        scoreAtParticularOverList.add(scoreAtParticularOver);
        when(scoreAtParticularTimeService.getScoreAtOver(anyInt(), anyString(), anyFloat())).thenReturn(scoreAtParticularOverList);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/getScore/{id}/{name}/{over}", 1, "India", (float) 4.2).
                        accept(MediaType.APPLICATION_JSON)).
                andExpect(MockMvcResultMatchers.status().isOk());

    }
}