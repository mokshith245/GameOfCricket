package com.example.gameofcricket.cricket.results;

import com.example.gameofcricket.dao.compositeKeys.GameStatsId;
import jakarta.persistence.*;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.stereotype.Service;

@Service
@Entity
@IdClass(GameStatsId.class)
@Document(indexName = "gamestats")
public class GameStats {
    @Id
    private String teamName;
    private int score;
    private String won;
    @Id
    private int matchId;
    private float overs;
    private int wickets;
    private int extras;

    @org.springframework.data.annotation.Id
    @org.springframework.data.annotation.AccessType(org.springframework.data.annotation.AccessType.Type.PROPERTY)
    public String getElasticsearchId() {
        return teamName + '-' + matchId;
    }
    public void setElasticsearchId(String ignored) {
    }

    public int getExtras() {
        return extras;
    }

    public void setExtras(int extras) {
        this.extras = extras;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public float getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getWon() {
        return won;
    }

    public void setWon(String won) {
        this.won = won;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public float getOvers() {
        return overs;
    }

    public void setOvers(float overs) {
        this.overs = overs;
    }

    @Override
    public String toString() {
        return "GameStats{" +
                "teamName='" + teamName + '\'' +
                ", score=" + score +
                ", won='" + won + '\'' +
                ", matchId=" + matchId +
                ", overs=" + overs +
                ", wickets=" + wickets +
                ", extras=" + extras +
                '}';
    }
}
