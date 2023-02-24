package com.example.gameofcricket.controller;

import com.example.gameofcricket.cricket.player.PlayerStatsPerMatch;
import com.example.gameofcricket.service.PlayerStatsPerMatchPerMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class PlayerStatsPerMatchController
{
    @Autowired
    private PlayerStatsPerMatchPerMatchService playerStatsPerMatchPerMatchService;
    @RequestMapping("/highestScore/{id}/{teamName}")
    public List<PlayerStatsPerMatch> getHighestScore(@PathVariable int id, @PathVariable String teamName)
    {
        return playerStatsPerMatchPerMatchService.getHighestScoreByMatchIdAndTeamName(id,teamName);
    }
    @RequestMapping("/fiftyScore/{id}")
    public List<PlayerStatsPerMatch> getNameOfFiftyScoredPlayer(@PathVariable int id)
    {
        return playerStatsPerMatchPerMatchService.getFiftyScoredPlayer(id);
    }

    @RequestMapping("/hundredScore/{id}")
    public List<PlayerStatsPerMatch> getNameOfHundredScoredPlayer(@PathVariable int id)
    {
        return playerStatsPerMatchPerMatchService.getHundredScoredPlayer(id);
    }
    @RequestMapping("/scoreCard/{id}")
    public List<PlayerStatsPerMatch> getScoreCardOFMatch(@PathVariable int id)
    {
        return playerStatsPerMatchPerMatchService.getMatchScoreCard(id);
    }
}
