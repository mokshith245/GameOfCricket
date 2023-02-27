package com.example.gameofcricket.cricket.player;

import com.example.gameofcricket.dao.compositeKeys.PlayerId;
import jakarta.persistence.*;

@Entity

public class Player
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int playerId;
    private String name;
    private String teamName;
    private int runs,numberOfBallsPlayed,wickets,innings,highestScore;
    private float numberOfOversBowled;
    private  int extras,numberOfRunsGiven,halfCentury, century;

    private PlayerRole playerRole;


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

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getInnings() {
        return innings;
    }

    public void setInnings(int innings) {
        this.innings = innings;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }

    public int getHalfCentury() {
        return halfCentury;
    }

    public void setHalfCentury(int halfCentury) {
        this.halfCentury = halfCentury;
    }

    public int getCentury() {
        return century;
    }

    public void setCentury(int century) {
        this.century = century;
    }



    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", name='" + name + '\'' +
                ", teamName='" + teamName + '\'' +
                ", runs=" + runs +
                ", numberOfBallsPlayed=" + numberOfBallsPlayed +
                ", wickets=" + wickets +
                ", numberOfOversBowled=" + numberOfOversBowled +
                ", innings=" + innings +
                ", highestScore=" + highestScore +
                ", extras=" + extras +
                ", numberOfRunsGiven=" + numberOfRunsGiven +
                ", halfCentury=" + halfCentury +
                ", century=" + century +
                ", playerRole=" + playerRole +
                '}';
    }
}
