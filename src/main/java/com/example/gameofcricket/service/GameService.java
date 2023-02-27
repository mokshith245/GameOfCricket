package com.example.gameofcricket.service;

import com.example.gameofcricket.GameOfCricketApplication;
import com.example.gameofcricket.cricket.StartGame;
import com.example.gameofcricket.cricket.Team;
import com.example.gameofcricket.dao.repositories.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GameService {
    private int matchCount = 1;

    private static List<Team> teams;

    static{
        teams=new ArrayList<>();
        Team india = new Team("India");
        india.players = india.create_team();
        Team pakistan = new Team("Pakistan");
        pakistan.players = pakistan.create_team();
        Team newZealand = new Team("New Zealand");
        newZealand.players = newZealand.create_team();
        Team australia = new Team("Australia");
        australia.players = australia.create_team();
        Team southAfrica = new Team("South Africa");
        southAfrica.players = southAfrica.create_team();
        Team england = new Team("England");
        england.players = england.create_team();
        Team afganistan = new Team("Afganistan");
        afganistan.players = afganistan.create_team();
        Team bangladesh = new Team("Bangladesh");
        bangladesh.players = bangladesh.create_team();
        Team westIndies = new Team("West Indies");
        westIndies.players = westIndies.create_team();
        teams.add(india);
        teams.add(pakistan);
        teams.add(newZealand);
        teams.add(southAfrica);
        teams.add(afganistan);
        teams.add(australia);
        teams.add(bangladesh);
        teams.add(england);
        teams.add(westIndies);
    }

    public void createGame(int overs){
        StartGame startGame=new StartGame();
        startGame.startGame(teams,overs,matchCount);
        matchCount++;

    }
}
