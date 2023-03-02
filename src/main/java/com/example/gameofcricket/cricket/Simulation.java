package com.example.gameofcricket.cricket;

import com.example.gameofcricket.GameOfCricketApplication;
import com.example.gameofcricket.cricket.player.Player;

public class Simulation
{
    public static void startSimulation(Team battingTeam, Team bowlingTeam, int overs,int countMatches)
    {
       // System.out.println(battingTeam.players.get(0).getTeamName());
        GameOfCricketApplication.playerRepository.saveAll(battingTeam.players);
        GameOfCricketApplication.playerRepository.saveAll(bowlingTeam.players);
        int numberOfMatches= battingTeam.getNumberOfMatchesPlayed();
        numberOfMatches++;
        battingTeam.setNumberOfMatchesPlayed(numberOfMatches);
        numberOfMatches= bowlingTeam.getNumberOfMatchesPlayed();
        numberOfMatches++;
        bowlingTeam.setNumberOfMatchesPlayed(numberOfMatches);
        int target=0;
        Play teamPlay =new Play();
        teamPlay.Bat(battingTeam,bowlingTeam,target,overs,countMatches);
        GameOfCricketApplication.teamRepository.save(battingTeam);
        target= battingTeam.getScore();
        target++;
        teamPlay.Bat(bowlingTeam,battingTeam,target,overs,countMatches);
        GameOfCricketApplication.teamRepository.save(bowlingTeam);
    }
}
