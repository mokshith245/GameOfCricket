package com.example.gameofcricket;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Simulation
{
    public static void startSimulation(Team team1Obj, Team team2Obj,List<Player> team1,List<Player> team2,
                                       Team wonToss,String chooseBatOrBall,int overs)
    {



        int target=0;
        if(wonToss==team1Obj)
        {
            if(Objects.equals(chooseBatOrBall, "Bat"))
            {
                LetsPlay team1LetsPlay =new LetsPlay();
                team1LetsPlay.Bat(team1,team2,team1Obj,target,overs);

                target= team1Obj.getScore();
                target++;
                LetsPlay team2LetsPlay =new LetsPlay();
                team2LetsPlay.Bat(team2,team1,team2Obj,target,overs);


            }
            else
            {
                LetsPlay team2LetsPlay =new LetsPlay();
                team2LetsPlay.Bat(team2,team1,team2Obj,target,overs);

                target= team2Obj.getScore();
                target++;
                LetsPlay team1LetsPlay =new LetsPlay();
                team1LetsPlay.Bat(team1,team2,team1Obj,target,overs);


            }

        }
        else
        {
            if (chooseBatOrBall == "Bat")
            {
                LetsPlay team2LetsPlay = new LetsPlay();
                team2LetsPlay.Bat(team2, team1, team2Obj,target,overs);

                target= team2Obj.getScore();
                target++;
                LetsPlay team1LetsPlay = new LetsPlay();
                team1LetsPlay.Bat(team1, team2, team1Obj,target,overs);


            }
            else
            {
                LetsPlay team1LetsPlay = new LetsPlay();
                team1LetsPlay.Bat(team1, team2, team1Obj,target,overs);

                target= team1Obj.getScore();
                target++;
                LetsPlay team2LetsPlay = new LetsPlay();
                team2LetsPlay.Bat(team2, team1, team2Obj,target,overs);



            }
        }
    }
}
