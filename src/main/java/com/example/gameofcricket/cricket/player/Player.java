package com.example.gameofcricket.cricket.player;

public class Player
{

    private String name;
    private int runs;
    private int numberOfBallsPlayed;
    private int wickets;
    private float numberOfOversBowled;
    private  int extras;

    private int numberOfRunsGiven;
    private PlayerRole playerRole;

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

}
