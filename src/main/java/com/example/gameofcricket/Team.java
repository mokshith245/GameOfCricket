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
//    player cricketer=new player();
    List<Player> team=new ArrayList<Player>();

    public List create_team()
    {
        for(int i=1;i<=11;i++)
        {
            Player cricketer = new Player();
            cricketer.setName(String.format("Player %d", i));
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
