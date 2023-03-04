package com.example.gameofcricket.dao.repositories;

import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.cricket.player.PlayerStatsPerMatch;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PlayerStatsPerMatchRepositoryTest {
    @Autowired
    private PlayerStatsPerMatchRepository playerStatsPerMatchRepository;
    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void getScoreCardOfMatchByMatchId() {
        Player player = new Player();
        player.setTeamName("India");
        playerRepository.save(player);
        PlayerStatsPerMatch playerStatsPerMatch = new PlayerStatsPerMatch();
        playerStatsPerMatch.setMatchId(1);
        playerStatsPerMatch.setMatchNumber(1);
        playerStatsPerMatch.setPlayerId(player.getPlayerId());
        playerStatsPerMatchRepository.save(playerStatsPerMatch);
        List<PlayerStatsPerMatch> actualResult = playerStatsPerMatchRepository.getScoreCardOfMatchByMatchId(1);
        assertNotNull(actualResult);
    }
}