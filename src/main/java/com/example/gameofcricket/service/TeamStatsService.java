package com.example.gameofcricket.service;

import com.example.gameofcricket.cricket.Team;
import com.example.gameofcricket.dao.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamStatsService
{
    @Autowired
    private TeamRepository teamRepository;


    public Team getTeamStats(String name)
    {
        Team team=teamRepository.getTeamStatsByTeamName(name);
        return team;
    }


}
