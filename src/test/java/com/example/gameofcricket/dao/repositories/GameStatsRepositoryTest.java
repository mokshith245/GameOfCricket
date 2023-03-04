package com.example.gameofcricket.dao.repositories;

import com.example.gameofcricket.cricket.results.GameStats;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class GameStatsRepositoryTest {
    @Autowired
    private GameStatsRepository gameStatsRepository;

    @Test
    void getMatchStatsByMatchId() {
        List<GameStats> gameStatsOfTeams = new ArrayList<>();
        GameStats gameStats = new GameStats();
        gameStats.setMatchId(1);
        gameStats.setExtras(4);
        gameStats.setTeamName("India");
        gameStats.setWon("won by 1 run");
        gameStatsOfTeams.add(gameStats);
        gameStatsRepository.saveAll(gameStatsOfTeams);
        List<GameStats> actualResult = gameStatsRepository.getMatchStatsByMatchId(1);
        assertNotNull(actualResult);


    }
}