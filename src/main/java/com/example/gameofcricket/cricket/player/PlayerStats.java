package com.example.gameofcricket.cricket.player;

import com.example.gameofcricket.dao.PlayerStatsId;
import jakarta.persistence.*;

@Entity
@IdClass(PlayerStatsId.class)
public class PlayerStats
{
    @Id
    private String teamName;
    @Id
    private String playerName;
    private int runs,halfCentury, century;
    private int innings,highestScore,wickets;



    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String name) {
        this.playerName = name;
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

    @Override
    public String toString() {
        return "PlayerStats{" +
                "name='" + playerName + '\'' +
                ", runs=" + runs +
                ", halfCentury=" + halfCentury +
                ", century=" + century +
                ", innings=" + innings +
                ", highestScore=" + highestScore +
                ", wickets=" + wickets +
                '}';
    }
}
