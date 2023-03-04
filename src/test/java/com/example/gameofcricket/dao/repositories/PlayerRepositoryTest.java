package com.example.gameofcricket.dao.repositories;

import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.cricket.player.PlayerRole;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
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
class PlayerRepositoryTest {
    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void getTeam() {

        Player player = new Player();
        player.setTeamName("India");
        playerRepository.save(player);
        Assertions.assertNotNull(playerRepository.findById(player.getPlayerId()));
    }

    @AfterEach
    void tearDown() {
        playerRepository.deleteAll();
    }
}