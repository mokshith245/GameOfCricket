package com.example.gameofcricket;

import java.util.List;

public class ScoreCard
{
    public static void getScorecard(Team team1Obj, List<Player> team1,List<Player> team2, Team wonToss, String chooseBatOrBall)
    {
        if(wonToss==team1Obj)
        {
            if(chooseBatOrBall=="Bat")
            {
                for (Player i : team1)
                {
                    System.out.println(i.getName() + " " + i.getRuns() + " " + i.getNumberOfBallsPlayed() + " " + i.getWickets() + " " + i.getNumberOfRunsGiven() + " " + i.getNumberOfOversBowled() + " " + i.getExtras());
                }
                System.out.println("Team 2");
                for (Player i : team2)
                {
                    System.out.println(i.getName() + " " + i.getRuns() + " " + i.getNumberOfBallsPlayed() + " " + i.getWickets() + " " + i.getNumberOfRunsGiven() + " " + i.getNumberOfOversBowled() + " " + i.getExtras());
                }
            }
            else
            {
                for (Player i : team2)
                {
                    System.out.println(i.getName() + " " + i.getRuns() + " " + i.getNumberOfBallsPlayed() + " " + i.getWickets() + " " + i.getNumberOfRunsGiven() + " " + i.getNumberOfOversBowled() + " " + i.getExtras());
                }
                System.out.println("Team 1");
                for (Player i : team1)
                {
                    System.out.println(i.getName() + " " + i.getRuns() + " " + i.getNumberOfBallsPlayed() + " " + i.getWickets() + " " + i.getNumberOfRunsGiven() + " " + i.getNumberOfOversBowled() + " " + i.getExtras());
                }
            }
        }
        else
        {
            if(chooseBatOrBall=="Bat")
            {
                for (Player i : team2)
                {
                    System.out.println(i.getName() + " " + i.getRuns() + " " + i.getNumberOfBallsPlayed() + " " + i.getWickets() + " " + i.getNumberOfRunsGiven() + " " + i.getNumberOfOversBowled() + " " + i.getExtras());
                }
                System.out.println("Team 1");
                for (Player i : team1)
                {
                    System.out.println(i.getName() + " " + i.getRuns() + " " + i.getNumberOfBallsPlayed() + " " + i.getWickets() + " " + i.getNumberOfRunsGiven() + " " + i.getNumberOfOversBowled() + " " + i.getExtras());
                }
            }
            else
            {
                for (Player i : team1)
                {
                    System.out.println(i.getName() + " " + i.getRuns() + " " + i.getNumberOfBallsPlayed() + " " + i.getWickets() + " " + i.getNumberOfRunsGiven() + " " + i.getNumberOfOversBowled() + " " + i.getExtras());
                }
                System.out.println("Team 2");
                for (Player i : team2)
                {
                    System.out.println(i.getName() + " " + i.getRuns() + " " + i.getNumberOfBallsPlayed() + " " + i.getWickets() + " " + i.getNumberOfRunsGiven() + " " + i.getNumberOfOversBowled() + " " + i.getExtras());
                }
            }
        }
    }

}
