package com.example.gameofcricket.controller;

import com.example.gameofcricket.cricket.player.PlayerStatsPerMatch;
import com.example.gameofcricket.service.PlayerStatsPerMatchPerMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerStatsPerMatchController {
    @Autowired
    private PlayerStatsPerMatchPerMatchService playerStatsPerMatchPerMatchService;

    @RequestMapping("/highestScore/{id}/{teamName}")
    public List<PlayerStatsPerMatch> getHighestScore(@PathVariable int id, @PathVariable String teamName) {
        return playerStatsPerMatchPerMatchService.getHighestScoreByMatchIdAndTeamName(id, teamName);
    }

    @RequestMapping("/runsScoredPlayer/{id}/{runs}")
    public List<PlayerStatsPerMatch> getNameOfRunsScoredPlayer(@PathVariable int id, @PathVariable int runs) {
        return playerStatsPerMatchPerMatchService.getRunsScoredPlayer(id, runs);
    }


    @RequestMapping("/scoreCard/{id}")
    public List<PlayerStatsPerMatch> getScoreCardOFMatch(@PathVariable int id) {
        return playerStatsPerMatchPerMatchService.getMatchScoreCard(id);
    }
}
