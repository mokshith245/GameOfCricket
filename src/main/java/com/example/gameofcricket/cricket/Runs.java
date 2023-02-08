package com.example.gameofcricket.cricket;

import com.example.gameofcricket.cricket.player.Player;

public class Runs
{
    public static Player Single(Player player1,Player player2,Player striker,Player bowling,int runs)
    {
        if (striker.getName()==player1.getName())
        {

            int balls=player1.getNumberOfBallsPlayed();
            balls++;
            player1.setNumberOfBallsPlayed(balls);
            int add=player1.getRuns();
            add+=runs;
            player1.setRuns(add);
            striker =player2;
            int bowlerRuns=bowling.getNumberOfRunsGiven();
            bowlerRuns+=runs;
            bowling.setNumberOfRunsGiven(bowlerRuns);
        }
        else
        {
            int balls=player2.getNumberOfBallsPlayed();
            balls++;
            player2.setNumberOfBallsPlayed(balls);
            int add=player2.getRuns();
            add+=runs;
            player2.setRuns(add);
            striker =player1;
            int bowlerRuns=bowling.getNumberOfRunsGiven();
            bowlerRuns+=runs;
            bowling.setNumberOfRunsGiven(bowlerRuns);
        }
        return striker;

    }
    public static Player doubles(Player player1,Player player2,Player striker,Player bowling,int runs)
    {

        if (striker.getName()==player1.getName())
        {
            int balls=player1.getNumberOfBallsPlayed();
            balls++;
            player1.setNumberOfBallsPlayed(balls);
            int add=player1.getRuns();
            add+=runs;
            player1.setRuns(add);
            striker =player1;
            int bowleRuns=bowling.getNumberOfRunsGiven();
            bowleRuns+=runs;
            bowling.setNumberOfRunsGiven(bowleRuns);
        }
        else
        {
            int  balls=player2.getNumberOfBallsPlayed();
            balls++;
            player2.setNumberOfBallsPlayed( balls);
            int add=player2.getRuns();
            add+=runs;
            player2.setRuns(add);
            striker =player2;
            int bowlerRuns=bowling.getNumberOfRunsGiven();
            bowlerRuns+=runs;
            bowling.setNumberOfRunsGiven(bowlerRuns);
        }
        return striker;
    }
    public static Player triple(Player player1,Player player2,Player striker,Player bowling,int runs)
    {

        if (striker.getName()==player1.getName())
        {
            int balls=player1.getNumberOfBallsPlayed();
            balls++;
            player1.setNumberOfBallsPlayed(balls);
            int add=player1.getRuns();
            add+=runs;
            player1.setRuns(add);
            striker =player2;
            int bowlerRuns=bowling.getNumberOfRunsGiven();
            bowlerRuns+=runs;
            bowling.setNumberOfRunsGiven(bowlerRuns);
        }
        else
        {
            int balls=player2.getNumberOfBallsPlayed();
            balls++;
            player2.setNumberOfBallsPlayed(balls);
            int add=player2.getRuns();
            add+=runs;
            player2.setRuns(add);
            striker =player1;
            int bowlerRuns=bowling.getNumberOfRunsGiven();
            bowlerRuns+=runs;
            bowling.setNumberOfRunsGiven(bowlerRuns);
        }
        return striker;

    }
    public static Player four(Player player1,Player player2,Player striker,Player bowling,int runs)
    {
        if (striker.getName()==player1.getName())
        {
            int balls=player1.getNumberOfBallsPlayed();
            balls++;
            player1.setNumberOfBallsPlayed(balls);
            int add=player1.getRuns();
            add+=runs;
            player1.setRuns(add);
            striker =player1;
            int bowler_runs=bowling.getNumberOfRunsGiven();
            bowler_runs+=runs;
            bowling.setNumberOfRunsGiven(bowler_runs);
        }
        else
        {
            int balls=player2.getNumberOfBallsPlayed();
            balls++;
            player2.setNumberOfBallsPlayed(balls);
            int add=player2.getRuns();
            add+=runs;
            player2.setRuns(add);
            striker =player2;
            int bowlerRuns=bowling.getNumberOfRunsGiven();
            bowlerRuns+=runs;
            bowling.setNumberOfRunsGiven(bowlerRuns);
        }
        return striker;

    }
    public static Player six(Player player1,Player player2,Player striker,Player bowling,int runs)
    {
        if (striker.getName() == player1.getName())
        {
            int balls = player1.getNumberOfBallsPlayed();
            balls++;
            player1.setNumberOfBallsPlayed(balls);
            int add = player1.getRuns();
            add += runs;
            player1.setRuns(add);
            striker = player1;
            int bowlerRuns=bowling.getNumberOfRunsGiven();
            bowlerRuns+=runs;
            bowling.setNumberOfRunsGiven(bowlerRuns);
        }
        else
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
        }
        return striker;
    }
}
