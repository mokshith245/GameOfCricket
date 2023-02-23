package com.example.gameofcricket.cricket.player;

import com.example.gameofcricket.dao.PlayerId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(PlayerId.class)
public class Player
{
    @Id
    private int matchId;
    @Id
    private String name;
    @Id
    private String teamName;
    private int runs;
    private int numberOfBallsPlayed;
    private int wickets;
    private float numberOfOversBowled;
    private  int extras;

    private int numberOfRunsGiven;

    private PlayerRole playerRole;

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public PlayerRole getPlayerRole()
    {
        return playerRole;
    }

    public void setPlayerRole(PlayerRole playerRole)
    {
        this.playerRole = playerRole;
    }

    public int getExtras()
    {
        return extras;
    }

    public void setExtras(int extras)
    {
        this.extras = extras;
    }

    public float getNumberOfOversBowled()
    {
        return numberOfOversBowled;
    }

    public void setNumberOfOversBowled(float numberOfOversBowled)
    {
        this.numberOfOversBowled = numberOfOversBowled;
    }

    public int getNumberOfRunsGiven()
    {
        return numberOfRunsGiven;
    }

    public void setNumberOfRunsGiven(int numberOfRunsGiven)
    {
        this.numberOfRunsGiven = numberOfRunsGiven;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getRuns()
    {
        return runs;
    }

    public void setRuns(int runs)
    {
        this.runs = runs;
    }

    public int getNumberOfBallsPlayed()
    {
        return numberOfBallsPlayed;
    }

    public void setNumberOfBallsPlayed(int numberOfBallsPlayed)
    {
        this.numberOfBallsPlayed = numberOfBallsPlayed;
    }

    public int getWickets()
    {
        return wickets;
    }

    public void setWickets(int wickets)
    {
        this.wickets = wickets;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", runs=" + runs +
                ", numberOfBallsPlayed=" + numberOfBallsPlayed +
                ", wickets=" + wickets +
                ", numberOfOversBowled=" + numberOfOversBowled +
                ", extras=" + extras +
                ", numberOfRunsGiven=" + numberOfRunsGiven +
                ", playerRole=" + playerRole +
                '}';
    }
}
