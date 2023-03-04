package com.example.gameofcricket.controller;

import com.example.gameofcricket.cricket.player.PlayerStatsPerMatch;
import com.example.gameofcricket.service.PlayerStatsPerMatchPerMatchService;
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
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@WebMvcTest(PlayerStatsPerMatchController.class)
class PlayerStatsPerMatchControllerTest {
    @MockBean
    private PlayerStatsPerMatchPerMatchService playerStatsPerMatchPerMatchService;
    @Autowired
    private MockMvc mockMvc;


    @Test
    void getScoreCardOFMatch() throws Exception {
        List<PlayerStatsPerMatch> playerStatsPerMatchList = new ArrayList<>();
        PlayerStatsPerMatch playerStatsPerMatch = new PlayerStatsPerMatch();
        playerStatsPerMatchList.add(playerStatsPerMatch);

        when(playerStatsPerMatchPerMatchService.getMatchScoreCard(anyInt())).thenReturn(playerStatsPerMatchList);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/scoreCard/{id}", 1).
                        accept(MediaType.APPLICATION_JSON)).
                andExpect(MockMvcResultMatchers.status().isOk());
    }
}