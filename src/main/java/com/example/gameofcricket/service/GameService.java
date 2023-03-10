package com.example.gameofcricket.service;

import com.example.gameofcricket.GameOfCricketApplication;
import com.example.gameofcricket.cricket.StartGame;
import com.example.gameofcricket.cricket.Team;
import com.example.gameofcricket.dao.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


import java.util.List;

@Service
@Slf4j
public class GameService {
    private int matchCount;
    private static List<Team> teams;


    public void createGame(int overs) {
        log.info("Starting match");
        List<Team> teams = GameOfCricketApplication.teamRepository.getTeams();
//
        if (GameOfCricketApplication.gameStatsRepository.getMaxId().isEmpty())
            matchCount = 1;
        else {
            matchCount = GameOfCricketApplication.gameStatsRepository.getMaxId().get();
            matchCount++;
        }
        StartGame startGame = new StartGame();
        startGame.startGame(teams, overs, matchCount);

    }
}
