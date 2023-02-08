package com.example.gameofcricket.cricket.player;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PlayerStats
{
    @Id
    private String name;
    private int runs,halfCentury, century;
    private int innings,highestScore,wickets;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
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

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
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
}
