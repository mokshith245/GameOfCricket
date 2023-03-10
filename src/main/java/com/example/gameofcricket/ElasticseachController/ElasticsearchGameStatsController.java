package com.example.gameofcricket.ElasticseachController;

import com.example.gameofcricket.cricket.results.GameStats;
import com.example.gameofcricket.elasticSearchRepository.GameStatsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ElasticsearchGameStatsController
{
    @Autowired
    private GameStatsRepo gameStatsRepo;

    @GetMapping("/esMatchDetails/{id}")
    public List<GameStats> getMatchDetails(@PathVariable int id) {
        return gameStatsRepo.getGameStatsByMatchId(id);
    }
}
