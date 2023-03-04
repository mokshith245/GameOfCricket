package com.example.gameofcricket.controller;

import com.example.gameofcricket.cricket.results.GameStats;
import com.example.gameofcricket.service.GameStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetStatsOfMatchController {
    @Autowired
    private GameStatsService gameStatsService;

    @GetMapping("/MatchDetails/{id}")
    public List<GameStats> getMatchDetails(@PathVariable int id) {
        return gameStatsService.getMatchDetailsByMatchId(id);
    }


}
