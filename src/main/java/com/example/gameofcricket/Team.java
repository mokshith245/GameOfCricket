package com.example.gameofcricket;

import java.util.ArrayList;
import java.util.List;

public class Team
{

    Team()
    {
       // create_team();
       // print();
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
    List<Player> team=new ArrayList<Player>();

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
            team.add(cricketer);
        }
        return  team;

    }

    public void print()
    {

        for(Player j:team)
        {
            System.out.println(j.getName()+" "+j.getRuns());
        }
    }


}
