package com.example.gameofcricket.service;

import com.example.gameofcricket.cricket.results.ScoreAtParticularOver;
import com.example.gameofcricket.dao.repositories.UpdateScoreAfterEveryBallRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ScoreAtParticularTimeServiceTest {

    @Mock
    private UpdateScoreAfterEveryBallRepository updateScoreAfterEveryBallRepository;
    @InjectMocks
    private ScoreAtParticularTimeService scoreAtParticularTimeService;


    @Test
    void getScoreAtOver() {
        ScoreAtParticularOver scoreAtParticularOver = new ScoreAtParticularOver();
        List<ScoreAtParticularOver> scoreAtParticularOverList = new ArrayList<>();
        scoreAtParticularOverList.add(scoreAtParticularOver);
        when(scoreAtParticularTimeService.getScoreAtOver(anyInt(), anyString(), anyFloat())).thenReturn(scoreAtParticularOverList);
        Assertions.assertInstanceOf(ScoreAtParticularOver.class, scoreAtParticularTimeService.getScoreAtOver(1, "India", (float) 9.2).get(0));


    }
}