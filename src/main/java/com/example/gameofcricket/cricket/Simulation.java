package com.example.gameofcricket.cricket;

import com.example.gameofcricket.GameOfCricketApplication;

public class Simulation
{
    public static void startSimulation(Team battingTeam, Team bowlingTeam, int overs,int countMatches)
    {
        int numberOfMatches= battingTeam.getNumberOfMatchesPlayed();
        numberOfMatches++;
        battingTeam.setNumberOfMatchesPlayed(numberOfMatches);
        numberOfMatches= bowlingTeam.getNumberOfMatchesPlayed();
        numberOfMatches++;
        bowlingTeam.setNumberOfMatchesPlayed(numberOfMatches);
        int target=0;
        Play teamPlay =new Play();
        teamPlay.Bat(battingTeam,bowlingTeam,target,overs,countMatches);
        GameOfCricketApplication.teamStats.save(battingTeam);
        target= battingTeam.getScore();
        target++;
        teamPlay.Bat(bowlingTeam,battingTeam,target,overs,countMatches);
        GameOfCricketApplication.teamStats.save(bowlingTeam);
    }
}
