package com.example.gameofcricket.cricket.results;

import com.example.gameofcricket.dao.compositeKeys.OversId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(OversId.class)
public class ScoreAtParticularOver {
    @Id
    private String teamName;
    @Id
    private float overs;
    @Id
    private int matchId;

    private int score;

    private int wickets;

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

    public float getOvers() {
        return overs;
    }

    public void setOvers(float overs) {
        this.overs = overs;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    @Override
    public String toString() {
        return "Overs{" +
                "teamName='" + teamName + '\'' +
                ", overs=" + overs +
                ", matchId=" + matchId +
                ", score=" + score +
                ", wickets=" + wickets +
                '}';
    }
}
