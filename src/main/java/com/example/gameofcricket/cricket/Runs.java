package com.example.gameofcricket.cricket;

import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.cricket.results.ScoreAtParticularOver;
import com.example.gameofcricket.cricket.util.GameSimulationUtils;

import java.text.DecimalFormat;

public class Runs {
    public static Player updateMatchStatsEven(Player player1, Player striker) {
        int balls = player1.getNumberOfBallsPlayed();
        balls++;
        player1.setNumberOfBallsPlayed(balls);
        int add = player1.getRuns();
        add += GameSimulationUtils.getRuns();
        player1.setRuns(add);
        striker = player1;
        int bowlerRuns = GameSimulationUtils.getBowling().getNumberOfRunsGiven();
        bowlerRuns += GameSimulationUtils.getRuns();
        GameSimulationUtils.getBowling().setNumberOfRunsGiven(bowlerRuns);
        return striker;
    }

    public static Player updateMatchStatsOdd(Player player1, Player player2, Player striker) {
        int balls = player1.getNumberOfBallsPlayed();
        balls++;
        player1.setNumberOfBallsPlayed(balls);
        int add = player1.getRuns();
        add += GameSimulationUtils.getRuns();
        player1.setRuns(add);
        striker = player2;
        int bowlerRuns = GameSimulationUtils.getBowling().getNumberOfRunsGiven();
        bowlerRuns += GameSimulationUtils.getRuns();
        GameSimulationUtils.getBowling().setNumberOfRunsGiven(bowlerRuns);
        return striker;
    }
    public static void wide() {
        int wide_run = GameSimulationUtils.getBowling().getExtras() + 1;
        GameSimulationUtils.getBowling().setExtras(wide_run);
        int bowlerRuns = GameSimulationUtils.getBowling().getNumberOfRunsGiven();
        bowlerRuns++;
        GameSimulationUtils.getBowling().setNumberOfRunsGiven(bowlerRuns);

    }
    public static Player dot(Player striker) {
        int x = striker.getNumberOfBallsPlayed();
        x++;
        striker.setNumberOfBallsPlayed(x);
        return striker;
    }
    public static float  storeOvers( float checkOvers, ScoreAtParticularOver scoreAtParticularOver){
        checkOvers = (float) (0.1) + checkOvers;
        DecimalFormat format = new DecimalFormat("#.##");
        checkOvers = Float.parseFloat(format.format(checkOvers));
        scoreAtParticularOver.setOvers(checkOvers);
        scoreAtParticularOver.setScore(GameSimulationUtils.getScore());
        return checkOvers;

    }


}
