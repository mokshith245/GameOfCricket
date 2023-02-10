package com.example.gameofcricket.cricket;

import com.example.gameofcricket.GameOfCricketApplication;

public class Simulation
{
    public static void startSimulation(Team battingTeam, Team bowlingTeam, int overs,int countMatches)
    {
        int target=0;
        Play teamPlay =new Play();
        teamPlay.Bat(battingTeam,bowlingTeam,target,overs,countMatches);
        System.out.println(battingTeam.getName());
        GameOfCricketApplication.teamStats.save(battingTeam);
        target= battingTeam.getScore();
        target++;
        teamPlay.Bat(bowlingTeam,battingTeam,target,overs,countMatches);
        System.out.println(bowlingTeam.getName());
        GameOfCricketApplication.teamStats.save(bowlingTeam);
    }
}
