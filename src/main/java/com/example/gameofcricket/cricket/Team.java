package com.example.gameofcricket.cricket;
import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.cricket.player.PlayerRole;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity

public class Team
{
    @Transient
    public List<Player> players =new ArrayList<Player>();
    @Id
    private String name;
    private int numberOfMatchesPlayed;
    @Transient
    private int score;
    @Transient
    private int wickets;
    @Transient
    private float overs;
    @Transient
    private int extras;
    public Team(String name) {
        this.name = name;
    }
    public Team() {

    }

    public int getNumberOfMatchesPlayed() {
        return numberOfMatchesPlayed;
    }

    public void setNumberOfMatchesPlayed(int numberOfMatchesPlayed) {
        this.numberOfMatchesPlayed = numberOfMatchesPlayed;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
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
    @Override
    public String toString() {
        return "Team{" +
                ", players=" + players +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", wickets=" + wickets +
                ", overs=" + overs +
                ", extras=" + extras +
                '}';
    }
}
