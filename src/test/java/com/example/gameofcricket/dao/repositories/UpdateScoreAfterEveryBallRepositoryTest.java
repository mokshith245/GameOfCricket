package com.example.gameofcricket.dao.repositories;

import com.example.gameofcricket.cricket.results.ScoreAtParticularOver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UpdateScoreAfterEveryBallRepositoryTest {
    @Autowired
    private UpdateScoreAfterEveryBallRepository updateScoreAfterEveryBallRepository;

    @Test
    void getScoreAt() {
        ScoreAtParticularOver scoreAtParticularOver = new ScoreAtParticularOver();
        scoreAtParticularOver.setMatchId(1);
        scoreAtParticularOver.setOvers((float) 9.2);
        scoreAtParticularOver.setScore(34);
        scoreAtParticularOver.setTeamName("India");
        scoreAtParticularOver.setWickets(3);
        updateScoreAfterEveryBallRepository.save(scoreAtParticularOver);
        List<ScoreAtParticularOver> actualResult = updateScoreAfterEveryBallRepository.getScoreAt(1, "India", (float) 9.2);
        assertNotNull(actualResult);
    }
}