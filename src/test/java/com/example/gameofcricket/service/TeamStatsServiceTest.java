package com.example.gameofcricket.service;

import com.example.gameofcricket.cricket.Team;
import com.example.gameofcricket.dao.repositories.TeamRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class TeamStatsServiceTest {
    @Mock
    private TeamRepository teamRepository;
    @InjectMocks
    private TeamStatsService teamStatsService;

    @Test
    void getTeamStats() {
        Team team = new Team();
        when(teamStatsService.getTeamStats(anyString())).thenReturn(team);
        Assertions.assertInstanceOf(Team.class, team);

    }
}