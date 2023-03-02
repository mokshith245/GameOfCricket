package com.example.gameofcricket.service;

import com.example.gameofcricket.GameOfCricketApplication;
import com.example.gameofcricket.cricket.StartGame;
import com.example.gameofcricket.cricket.Team;
import com.example.gameofcricket.dao.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


import java.util.List;
@Service
public class GameService {
    private  int matchCount ;
    private static List<Team> teams;

    public void createGame(int overs){
        List<Team> teams = GameOfCricketApplication.teamRepository.getTeams();
        //  teams= GameOfCricketApplication.teamRepository.findAll();
//        for (Team team:teams
//        ) {
//            team.players=team.create_team();
//
//        }
//        teams=new ArrayList<>();
//        Team india = new Team("India");
//        india.players = india.create_team();
//        Team pakistan = new Team("Pakistan");
//        pakistan.players = pakistan.create_team();
//        Team newZealand = new Team("New Zealand");
//        newZealand.players = newZealand.create_team();
//        Team australia = new Team("Australia");
//        australia.players = australia.create_team();
//        Team southAfrica = new Team("South Africa");
//        southAfrica.players = southAfrica.create_team();
//        Team england = new Team("England");
//        england.players = england.create_team();
//        Team afghanistan = new Team("Afghanistan");
//        afghanistan.players = afghanistan.create_team();
//        Team bangladesh = new Team("Bangladesh");
//        bangladesh.players = bangladesh.create_team();
//        Team westIndies = new Team("West Indies");
//        westIndies.players = westIndies.create_team();
//        teams.add(india);
//        teams.add(pakistan);
//        teams.add(newZealand);
//        teams.add(southAfrica);
//        teams.add(afghanistan);
//        teams.add(australia);
//        teams.add(bangladesh);
//        teams.add(england);
//        teams.add(westIndies);
//        GameOfCricketApplication.teamRepository.saveAll(teams);
//        for (Team team:teams
//        ) {
//            GameOfCricketApplication.playerRepository.saveAll(team.players);
//
//        }
        System.out.println(teams.size());
        if(GameOfCricketApplication.gameStatsRepository.getMaxId().isEmpty())
            matchCount=1;
        else {
            matchCount=GameOfCricketApplication.gameStatsRepository.getMaxId().get();
            matchCount++;
        }
        StartGame startGame=new StartGame();
        startGame.startGame(teams,overs,matchCount);


    }
}
