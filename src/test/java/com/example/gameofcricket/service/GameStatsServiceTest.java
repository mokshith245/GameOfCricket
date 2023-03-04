package com.example.gameofcricket.service;

import com.example.gameofcricket.cricket.results.GameStats;
import com.example.gameofcricket.dao.repositories.GameStatsRepository;
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
class GameStatsServiceTest {
    @InjectMocks
    private GameStatsService gameStatsService;
    @Mock
    private GameStatsRepository gameStatsRepository;

    @Test
    void getMatchDetailsByMatchId() {
        GameStats gameStats = new GameStats();
        List<GameStats> gameStatsList = new ArrayList<>();
        gameStatsList.add(gameStats);
        when(gameStatsRepository.getMatchStatsByMatchId(anyInt())).thenReturn(gameStatsList);
        Assertions.assertInstanceOf(GameStats.class, gameStatsService.getMatchDetailsByMatchId(1).get(0));


    }
}