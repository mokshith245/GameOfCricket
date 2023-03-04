package com.example.gameofcricket.cricket;

import com.example.gameofcricket.cricket.player.Player;

import java.util.Objects;

public class Runs {
    public static Player updateMatchStatsEven(Player player1, Player striker, Player bowling, int runs) {
        int balls = player1.getNumberOfBallsPlayed();
        balls++;
        player1.setNumberOfBallsPlayed(balls);
        int add = player1.getRuns();
        add += runs;
        player1.setRuns(add);
        striker = player1;
        int bowlerRuns = bowling.getNumberOfRunsGiven();
        bowlerRuns += runs;
        bowling.setNumberOfRunsGiven(bowlerRuns);
        return striker;
    }

    public static Player updateMatchStatsOdd(Player player1, Player player2, Player striker, Player bowling, int runs) {
        int balls = player1.getNumberOfBallsPlayed();
        balls++;
        player1.setNumberOfBallsPlayed(balls);
        int add = player1.getRuns();
        add += runs;
        player1.setRuns(add);
        striker = player2;
        int bowlerRuns = bowling.getNumberOfRunsGiven();
        bowlerRuns += runs;
        bowling.setNumberOfRunsGiven(bowlerRuns);
        return striker;
    }


}
