package com.example.gameofcricket;
import com.example.gameofcricket.cricket.Simulation;
import com.example.gameofcricket.cricket.StartGame;
import com.example.gameofcricket.cricket.Team;
import com.example.gameofcricket.cricket.player.UpdatePlayerStats;
import com.example.gameofcricket.cricket.results.MatchResults;
import com.example.gameofcricket.cricket.results.ScoreCard;
import com.example.gameofcricket.cricket.util.DecisionMadeByTeam;
import com.example.gameofcricket.cricket.util.Toss;
import com.example.gameofcricket.dao.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;

import java.util.*;
@SpringBootApplication
public class GameOfCricketApplication
{
    public static PlayerStatsPerMatchRepository playerStatsPerMatchRepository;
    public static TeamRepository teamRepository;
    public static PlayerRepository playerRepository;
    public static UpdateScoreAfterEveryBallRepository updateScoreAfterEveryBallRepository;
    public static GameStatsRepository gameStatsRepository;
    public static void main(String[] args)
    {
        ConfigurableApplicationContext context= SpringApplication.run(GameOfCricketApplication.class, args);
        playerRepository = context.getBean(PlayerRepository.class);
        updateScoreAfterEveryBallRepository=context.getBean(UpdateScoreAfterEveryBallRepository.class);
        teamRepository =context.getBean(TeamRepository.class);
        gameStatsRepository=context.getBean(GameStatsRepository.class);
        playerStatsPerMatchRepository=context.getBean((PlayerStatsPerMatchRepository.class));
    }
}
