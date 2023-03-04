package com.example.gameofcricket.controller;

import com.example.gameofcricket.cricket.Team;
import com.example.gameofcricket.service.TeamStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamStatsController {
    @Autowired
    private TeamStatsService teamStatsService;

    @RequestMapping("TeamStats/{name}")
    public Team getTeamStats(@PathVariable String name) {
        return teamStatsService.getTeamStats(name);
    }
}
