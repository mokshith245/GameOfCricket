package com.example.gameofcricket;

public class Player
{

    private String name;
    private int runs;
    private int number_of_balls_played;
    private int wickets;

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
