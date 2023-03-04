package com.example.gameofcricket.service;

import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.cricket.results.GameStats;
import com.example.gameofcricket.dao.repositories.PlayerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(SpringExtension.class)
class PlayerServiceTest {
    @Mock
    private PlayerRepository playerRepository;
    @InjectMocks
    private PlayerService playerService;

    @Test
    void getPLayer() {
        Player player = new Player();
        when(playerRepository.getPlayer(anyInt())).thenReturn(player);
        Assertions.assertInstanceOf(Player.class, player);
    }
}