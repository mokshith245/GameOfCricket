package com.example.gameofcricket.cricket.player;

import com.example.gameofcricket.cricket.results.GameStats;
import com.example.gameofcricket.dao.compositeKeys.PlayerStatsPerMatchId;
import jakarta.persistence.*;
import org.springframework.data.elasticsearch.annotations.Document;

@Entity
@Document(indexName = "playerstatspermatch")
@IdClass(PlayerStatsPerMatchId.class)
public class PlayerStatsPerMatch {
    @Id
    private int matchId;
    @Id
    private int playerId;
    @ManyToOne(targetEntity = Player.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "playerId", insertable = false, updatable = false)
    private Player player;

    private int matchNumber;
    private String name;

    private String teamName;
    private int runs;
    private int numberOfBallsPlayed;
    private int wickets;
    private float numberOfOversBowled;
    private int extras;

    private int numberOfRunsGiven;

    private PlayerRole playerRole;

    @org.springframework.data.annotation.Id
    @org.springframework.data.annotation.AccessType(org.springframework.data.annotation.AccessType.Type.PROPERTY)
    public String getElasticsearchId() {
        return Integer.toString(matchId)+ '-' + Integer.toString(playerId);
    }
    public void setElasticsearchId(String ignored) {
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getNumberOfBallsPlayed() {
        return numberOfBallsPlayed;
    }

    public void setNumberOfBallsPlayed(int numberOfBallsPlayed) {
        this.numberOfBallsPlayed = numberOfBallsPlayed;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public float getNumberOfOversBowled() {
        return numberOfOversBowled;
    }

    public void setNumberOfOversBowled(float numberOfOversBowled) {
        this.numberOfOversBowled = numberOfOversBowled;
    }

    public int getExtras() {
        return extras;
    }

    public void setExtras(int extras) {
        this.extras = extras;
    }

    public int getNumberOfRunsGiven() {
        return numberOfRunsGiven;
    }

    public void setNumberOfRunsGiven(int numberOfRunsGiven) {
        this.numberOfRunsGiven = numberOfRunsGiven;
    }

    public PlayerRole getPlayerRole() {
        return playerRole;
    }

    public void setPlayerRole(PlayerRole playerRole) {
        this.playerRole = playerRole;
    }

    @Override
    public String toString() {
        return "PlayerStatsPerMatch{" +
                "matchId=" + matchId +
                ", playerId=" + playerId +
                ", name='" + name + '\'' +
                ", teamName='" + teamName + '\'' +
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
