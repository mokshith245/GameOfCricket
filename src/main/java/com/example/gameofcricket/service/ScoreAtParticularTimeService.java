package com.example.gameofcricket.service;

import com.example.gameofcricket.cricket.results.ScoreAtParticularOver;
import com.example.gameofcricket.dao.UpdateScoreAfterEveryBallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreAtParticularTimeService
{
    @Autowired
    private UpdateScoreAfterEveryBallRepository updateScoreAfterEveryBallRepository;
    public List<ScoreAtParticularOver> getScoreAtOver(int id, String name, float over)
    {
        List<ScoreAtParticularOver> scoreAtThisOver=updateScoreAfterEveryBallRepository.getScoreAt(id,name,over);
        return scoreAtThisOver;
    }
}
