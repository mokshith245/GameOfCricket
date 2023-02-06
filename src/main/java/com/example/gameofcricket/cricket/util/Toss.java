package com.example.gameofcricket.cricket.util;

import com.example.gameofcricket.cricket.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Toss
{
    public static Team tossTheCoin(Team team1Obj, Team team2Obj)
    {
        List<Team> toss=new ArrayList<>();
        toss.add(team1Obj);
        toss.add(team2Obj);

        Random rand_toss = new Random();
        Team wonToss=toss.get(rand_toss.nextInt(toss.size()));

        if(wonToss==team1Obj)
        {
            System.out.print(team1Obj.getName()+" won the toss and opted to ");
        }
        else
        {
            System.out.print(team2Obj.getName()+" won the toss and opted to ");
        }
        return wonToss;

    }
}
