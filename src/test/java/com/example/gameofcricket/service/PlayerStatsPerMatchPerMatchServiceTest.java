package com.example.gameofcricket.service;

import com.example.gameofcricket.cricket.player.PlayerStatsPerMatch;
import com.example.gameofcricket.dao.repositories.PlayerStatsPerMatchRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PlayerStatsPerMatchPerMatchServiceTest {
    @Mock
    private PlayerStatsPerMatchRepository playerStatsPerMatchRepository;
    @InjectMocks
    private PlayerStatsPerMatchPerMatchService playerStatsPerMatchPerMatchService;

    @Test
    void getRunsScoredPlayer() {
        PlayerStatsPerMatch playerStatsPerMatch = new PlayerStatsPerMatch();
        List<PlayerStatsPerMatch> playerStatsPerMatchList = new ArrayList<>();
        playerStatsPerMatchList.add(playerStatsPerMatch);
        when(playerStatsPerMatchPerMatchService.getMatchScoreCard(anyInt())).thenReturn(playerStatsPerMatchList);
        Assertions.assertInstanceOf(PlayerStatsPerMatch.class, playerStatsPerMatchPerMatchService.getMatchScoreCard(1).get(0));
    }
}