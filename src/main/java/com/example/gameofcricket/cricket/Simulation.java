package com.example.gameofcricket.cricket;

public class Simulation
{
    public static void startSimulation(Team battingTeam, Team bowlingTeam, int overs,int countMatches)
    {



        int target=0;
        Play teamPlay =new Play();
        teamPlay.Bat(battingTeam,bowlingTeam,target,overs,countMatches);
        target= battingTeam.getScore();
        target++;
        teamPlay.Bat(bowlingTeam,battingTeam,target,overs,countMatches);
    }
}
