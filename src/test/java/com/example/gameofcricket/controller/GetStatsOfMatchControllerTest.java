package com.example.gameofcricket.controller;

import com.example.gameofcricket.cricket.results.GameStats;
import com.example.gameofcricket.service.GameStatsService;
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

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@WebMvcTest(GetStatsOfMatchController.class)
class GetStatsOfMatchControllerTest {

    @MockBean
    private GameStatsService gameStatsService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getMatchDetails() throws Exception {
        GameStats gameStats = new GameStats();
        List<GameStats> gameStatsList = new ArrayList<>();
        gameStatsList.add(gameStats);
        when(gameStatsService.getMatchDetailsByMatchId(anyInt())).thenReturn(gameStatsList);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/MatchDetails/{id}", 1).
                        accept(MediaType.APPLICATION_JSON)).
                andExpect(MockMvcResultMatchers.status().isOk());
    }
}