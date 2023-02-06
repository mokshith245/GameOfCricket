package com.example.gameofcricket.cricket;

import com.example.gameofcricket.cricket.player.Player;

import java.util.List;
import java.util.Objects;

public class Simulation
{
    public static void startSimulation(Team battingTeam, Team bowlingTeam, int overs)
    {



        int target=0;
        LetsPlay teamLetsPlay =new LetsPlay();
        teamLetsPlay.Bat(battingTeam,bowlingTeam,target,overs);
        target= battingTeam.getScore();
        target++;
        teamLetsPlay.Bat(bowlingTeam,battingTeam,target,overs);
    }
}
