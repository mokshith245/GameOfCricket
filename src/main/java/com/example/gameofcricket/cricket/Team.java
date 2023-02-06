package com.example.gameofcricket.cricket;

import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.cricket.player.PlayerRole;

import java.util.ArrayList;
import java.util.List;

public class Team
{
    public List<Player> players =new ArrayList<Player>();

    private String name;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int score;

    private int wickets;

    private float overs;

    private int extras;

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public float getOvers() {
        return overs;
    }

    public void setOvers(float overs) {
        this.overs = overs;
    }

    public int getExtras()
    {
        return extras;
    }

    public void setExtras(int extras)
    {
        this.extras = extras;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    //    player cricketer=new player();
    public List create_team()
    {
        for(int i=1;i<=11;i++)
        {
            Player cricketer = new Player();
            cricketer.setName(String.format("Player%d", i));
            if(i<=6)
            cricketer.setPlayerRole(PlayerRole.Batsman);
            else
                cricketer.setPlayerRole(PlayerRole.Bowler);
            players.add(cricketer);
        }
        return  players;

    }

//    public void print()
//    {
//
//        for(Player j:players)
//        {
//            System.out.println(j.getName()+" "+j.getRuns());
//        }
//}


}
