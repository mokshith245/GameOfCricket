package com.example.gameofcricket.cricket;

import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.cricket.player.PlayerRole;
import jakarta.persistence.*;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Document(indexName ="team")
public class Team {

    @org.springframework.data.annotation.Transient
    @OneToMany(mappedBy = "teamName")
    public List<Player> players = new ArrayList<>();
    @Id
    @org.springframework.data.annotation.Id
    @Field(type = FieldType.Keyword,name ="team_id")
    private String name;
    private int numberOfMatchesPlayed;
    @Transient
    @org.springframework.data.annotation.Transient
    private int score;
    @Transient
    @org.springframework.data.annotation.Transient
    private int wickets;
    @Transient
    @org.springframework.data.annotation.Transient
    private float overs;
    @Transient
    @org.springframework.data.annotation.Transient
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

    public int getExtras() {
        return extras;
    }

    public void setExtras(int extras) {
        this.extras = extras;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Player> create_team() {
        for (int i = 1; i <= 11; i++) {
            Player cricketer = new Player();

            cricketer.setName(String.format("Player%d", i));
            cricketer.setTeamName(getName());
            if (i <= 6)
                cricketer.setPlayerRole(PlayerRole.Batsman);
            else
                cricketer.setPlayerRole(PlayerRole.Bowler);
            players.add(cricketer);
        }
        return players;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", numberOfMatchesPlayed=" + numberOfMatchesPlayed +
                ", score=" + score +
                ", wickets=" + wickets +
                ", overs=" + overs +
                ", extras=" + extras +
                '}';
    }
}
