package com.example.gameofcricket.service;

import com.example.gameofcricket.cricket.Team;
import com.example.gameofcricket.dao.repositories.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TeamStatsService
{
    @Autowired
    private TeamRepository teamRepository;


    public Team getTeamStats(String name)
    {
        log.info("Getting team stats");
        Team team=teamRepository.getTeamStatsByTeamName(name);
        return team;
    }


}
