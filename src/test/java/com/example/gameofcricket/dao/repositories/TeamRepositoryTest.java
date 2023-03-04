package com.example.gameofcricket.dao.repositories;

import com.example.gameofcricket.cricket.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TeamRepositoryTest {
    @Autowired
    private TeamRepository teamRepository;

    @Test
    void getTeamStatsByTeamName() {
        Team team = new Team("India");
        team.setNumberOfMatchesPlayed(2);
        teamRepository.save(team);
        Team actualResult = teamRepository.getTeamStatsByTeamName("India");
        assertNotNull(actualResult);

    }
}