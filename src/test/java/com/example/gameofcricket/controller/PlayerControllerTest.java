package com.example.gameofcricket.controller;

import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@WebMvcTest(PlayerController.class)
class PlayerControllerTest {
    @MockBean
    private PlayerService playerService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPlayerStats() throws Exception {
        Player player = new Player();
        when(playerService.getPLayer(anyInt())).thenReturn(player);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/playerStats/{id}", 1).
                        accept(MediaType.APPLICATION_JSON)).
                andExpect(MockMvcResultMatchers.status().isOk());
    }
}