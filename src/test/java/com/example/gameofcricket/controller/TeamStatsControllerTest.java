package com.example.gameofcricket.controller;

import com.example.gameofcricket.cricket.Team;
import com.example.gameofcricket.service.TeamStatsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@WebMvcTest(TeamStatsController.class)
class TeamStatsControllerTest {
    @MockBean
    private TeamStatsService teamStatsService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getTeamStats() throws Exception {

        Team team = new Team();
        when(teamStatsService.getTeamStats(anyString())).thenReturn(team);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/TeamStats/{name}", "India").
                        accept(MediaType.APPLICATION_JSON)).
                andExpect(MockMvcResultMatchers.status().isOk());

    }
}