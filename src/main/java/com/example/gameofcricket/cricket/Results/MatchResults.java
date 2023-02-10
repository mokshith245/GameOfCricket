package com.example.gameofcricket.cricket.Results;

import com.example.gameofcricket.cricket.Team;

public class MatchResults
{
    public static void getMatchResults(Team battingTeam, Team bowlingTeam, int overs)
    {
        if (battingTeam.getScore() < bowlingTeam.getScore()) {
            int wonByWickets = 10 - bowlingTeam.getWickets();
            System.out.println(bowlingTeam.getName()+"  Won by  " + wonByWickets + " wickets.");
            System.out.println(battingTeam.getName()+" = " + battingTeam.getScore() + "/" + battingTeam.getWickets());
            System.out.println("Overs = " + battingTeam.getOvers() + "/" + overs);
            System.out.println(bowlingTeam.getName()+" score = " + bowlingTeam.getScore() + "/" + bowlingTeam.getWickets());
            System.out.println("Overs = " + bowlingTeam.getOvers() + "/" + overs);


        } else {
            System.out.println(battingTeam.getName()+" Won by " + (battingTeam.getScore() - bowlingTeam.getScore()) + " runs.");
            System.out.println(battingTeam.getName()+" score = " + battingTeam.getScore() + "/" + battingTeam.getWickets());
            System.out.println("Overs = " + battingTeam.getOvers() + "/" + overs);
            System.out.println(bowlingTeam.getName()+" score = " + bowlingTeam.getScore() + "/" + bowlingTeam.getWickets());
            System.out.println("Overs = " + bowlingTeam.getOvers() + "/" + overs);

        }
    }
}
