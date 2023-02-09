package com.example.gameofcricket.cricket;

import com.example.gameofcricket.GameOfCricketApplication;
import com.example.gameofcricket.cricket.player.Player;

import java.util.List;

public class ScoreCard {
    public static void getScorecard(Team battingTeam, Team bowlingTeam)
    {
        System.out.println(battingTeam.getName());
        for (Player i : battingTeam.players) {

            GameOfCricketApplication.playerRepository.save(i);
            System.out.println(i.getName() + " " + i.getRuns() + " " + i.getNumberOfBallsPlayed() + " " + i.getWickets() + " " + i.getNumberOfRunsGiven() + " " + i.getNumberOfOversBowled() + " " + i.getExtras());
        }
        System.out.println(bowlingTeam.getName());
        for (Player i : bowlingTeam.players) {
            GameOfCricketApplication.playerRepository.save(i);
            System.out.println(i.getName() + " " + i.getRuns() + " " + i.getNumberOfBallsPlayed() + " " + i.getWickets() + " " + i.getNumberOfRunsGiven() + " " + i.getNumberOfOversBowled() + " " + i.getExtras());
        }


    }
}
