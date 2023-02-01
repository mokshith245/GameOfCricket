package com.example.gameofcricket;

public class Player
{

    private String name;
    private int runs;
    private int number_of_balls_played;
    private int wickets;
    private float number_of_overs_bowled;
    private  int extras;

    private PlayerRole playerRole;

    public PlayerRole getPlayerRole() {
        return playerRole;
    }

    public void setPlayerRole(PlayerRole playerRole) {
        this.playerRole = playerRole;
    }

    public int getExtras() {
        return extras;
    }

    public void setExtras(int extras) {
        this.extras = extras;
    }

    public float getNumber_of_overs_bowled() {
        return number_of_overs_bowled;
    }

    public void setNumber_of_overs_bowled(float number_of_overs_bowled) {
        this.number_of_overs_bowled = number_of_overs_bowled;
    }

    private int number_of_runs_given;

    public int getNumber_of_runs_given() {
        return number_of_runs_given;
    }

    public void setNumber_of_runs_given(int number_of_runs_given) {
        this.number_of_runs_given = number_of_runs_given;
    }

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

    public int getNumber_of_balls_played() {
        return number_of_balls_played;
    }

    public void setNumber_of_balls_played(int number_of_balls_played) {
        this.number_of_balls_played = number_of_balls_played;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

}
