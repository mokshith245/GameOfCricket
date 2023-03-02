package com.example.gameofcricket.cricket;

import com.example.gameofcricket.cricket.player.Player;

import java.util.Objects;

public class Runs
{
    public static Player updateMatchStats(Player player1,Player player2,Player striker,Player bowling,int runs)
    {
        int balls = player2.getNumberOfBallsPlayed();
        balls++;
        player2.setNumberOfBallsPlayed(balls);
        int add = player2.getRuns();
        add += runs;
        player2.setRuns(add);
        striker = player2;
        int bowlerRuns=bowling.getNumberOfRunsGiven();
        bowlerRuns+=runs;
        bowling.setNumberOfRunsGiven(bowlerRuns);
        return striker;
    }

}
