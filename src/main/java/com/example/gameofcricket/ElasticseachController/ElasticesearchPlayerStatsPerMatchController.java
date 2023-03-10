package com.example.gameofcricket.ElasticseachController;

import com.example.gameofcricket.cricket.player.PlayerStatsPerMatch;
import com.example.gameofcricket.elasticSearchRepository.PlayerStatsPerMatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ElasticesearchPlayerStatsPerMatchController
{
    @Autowired
    private PlayerStatsPerMatchRepo playerStatsPerMatchRepo;
    @RequestMapping("/esScoreCard/{id}")
    public List<PlayerStatsPerMatch> getScoreCard(@PathVariable int id) {
        return playerStatsPerMatchRepo.getPlayerStatsPerMatchByMatchId(id);
    }
}
