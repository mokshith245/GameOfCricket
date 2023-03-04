package com.example.gameofcricket.service;

import com.example.gameofcricket.cricket.results.ScoreAtParticularOver;
import com.example.gameofcricket.dao.repositories.UpdateScoreAfterEveryBallRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ScoreAtParticularTimeService
{
    @Autowired
    private UpdateScoreAfterEveryBallRepository updateScoreAfterEveryBallRepository;
    public List<ScoreAtParticularOver> getScoreAtOver(int id, String name, float over)
    {
        log.info("Getting the stats at "+over+"overs");
        List<ScoreAtParticularOver> scoreAtThisOver=updateScoreAfterEveryBallRepository.getScoreAt(id,name,over);
        return scoreAtThisOver;
    }
}
