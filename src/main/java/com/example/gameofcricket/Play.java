package com.example.gameofcricket;

import java.util.*;

import static java.lang.Math.floor;

public class Play extends Thread
{
    Team team1_obj=new Team();

    List<Player> team1=team1_obj.create_team();

    Team team2_obj=new Team();
    List<Player> team2=team2_obj.create_team();
    int k=1;
    int score=0;
    float total_overs=0;
    Player striker=team1.get(k);

    Player player1=team1.get(k);
    Player player2=team1.get(k+1);

    int wickets = 0;

    int runs = 0;

    int bowler=5;
    Player bowling=team2.get(bowler);





    public List<Player> Bat() throws InterruptedException {
        Map<String, Integer> map = new LinkedHashMap();

        while(team1.size()-1>k)
        {


            String s = "01234567";

                for (int j = 0; j < 6; j++)
                {

                    Random random = new Random();
                    int index = random.nextInt(s.length());
                    char c = s.charAt(index);


                     runs=  Character.getNumericValue(c);
                    switch (runs)
                    {

                        case 1:
                            Single();
                            break;
                        case 2:
                            doubles();
                            break;
                        case 3:
                            triple();
                            break;
                        case 4:
                            four();
                            break;
                        case 5:
                            six();
                            break;
                        case 6:
                            break;
                        case 7:
                            wick();
                            break;

                }
                if(j==5)
                {
                    total_overs=(float) floor(total_overs);
                    float round_off=(float) bowling.getNumber_of_overs_bowled();
                    bowling.setNumber_of_overs_bowled((float) floor(round_off));
                    bowler++;
                    bowling=team2.get(bowler);
                    if(bowler==10)
                    {
                        bowler=4;
                    }
                }
                if(total_overs==20)
                    break;
                float balls=(float) (j*0.1)+bowling.getNumber_of_overs_bowled();
                total_overs=balls;
                bowling.setNumber_of_overs_bowled(balls);




            }


        }
//        for (Player i:team1)
//        {
//            System.out.println(i.getName()+" "+i.getRuns()+" "+i.getNumber_of_balls_played());
//        }
//        System.out.println(score);

        for (Player i:team2)
        {
            System.out.println(i.getName()+" "+i.getWickets()+" "+i.getNumber_of_runs_given()+" "+i.getNumber_of_overs_bowled());
        }
        System.out.println(total_overs);
        return team1;
    }



    public void Single() throws InterruptedException
    {

        if (striker.getName()==player1.getName())
        {
            score+=runs;
            int x=player1.getNumber_of_balls_played();
            x++;
            player1.setNumber_of_balls_played(x);
            int add=player1.getRuns();
            add+=runs;

            player1.setRuns(add);
            striker =player2;

            int bowler_runs=bowling.getNumber_of_runs_given();
            bowler_runs+=runs;

            bowling.setNumber_of_runs_given(bowler_runs);
        }
        else
        {
            score+=runs;
            int x=player2.getNumber_of_balls_played();
            x++;
            player2.setNumber_of_balls_played(x);
            int add=player2.getRuns();
            add+=runs;
            player2.setRuns(add);
            striker =player1;

            int bowler_runs=bowling.getNumber_of_runs_given();
            bowler_runs+=runs;
            bowling.setNumber_of_runs_given(bowler_runs);
        }
        Thread.sleep(100);
    }
    public void doubles() throws InterruptedException
    {

        if (striker.getName()==player1.getName())
        {
            score+=runs;
            int x=player1.getNumber_of_balls_played();
            x++;
            player1.setNumber_of_balls_played(x);
            int add=player1.getRuns();
            add+=runs;
            player1.setRuns(add);
            striker =player1;

            int bowler_runs=bowling.getNumber_of_runs_given();
            bowler_runs+=runs;
            bowling.setNumber_of_runs_given(bowler_runs);
        }
        else
        {
            score+=runs;
            int x=player2.getNumber_of_balls_played();
            x++;
            player2.setNumber_of_balls_played(x);
            int add=player2.getRuns();
            add+=runs;
            player2.setRuns(add);
            striker =player2;

            int bowler_runs=bowling.getNumber_of_runs_given();
            bowler_runs+=runs;
            bowling.setNumber_of_runs_given(bowler_runs);
        }
        Thread.sleep(100);
    }
    public void triple() throws InterruptedException
    {

        if (striker.getName()==player1.getName())
        {
            score+=runs;
            int x=player1.getNumber_of_balls_played();
            x++;
            player1.setNumber_of_balls_played(x);
            int add=player1.getRuns();
            add+=runs;
            player1.setRuns(add);
            striker =player2;

            int bowler_runs=bowling.getNumber_of_runs_given();
            bowler_runs+=runs;
            bowling.setNumber_of_runs_given(bowler_runs);
        }
        else
        {
            score+=runs;
            int x=player2.getNumber_of_balls_played();
            x++;
            player2.setNumber_of_balls_played(x);
            int add=player2.getRuns();
            add+=runs;
            player2.setRuns(add);
            striker =player1;

            int bowler_runs=bowling.getNumber_of_runs_given();
            bowler_runs+=runs;
            bowling.setNumber_of_runs_given(bowler_runs);
        }
        Thread.sleep(100);
    }
    public void four() throws InterruptedException
    {
        if (striker.getName()==player1.getName())
        {
            score+=runs;
            int x=player1.getNumber_of_balls_played();
            x++;
            player1.setNumber_of_balls_played(x);
            int add=player1.getRuns();
            add+=runs;
            player1.setRuns(add);
            striker =player1;

            int bowler_runs=bowling.getNumber_of_runs_given();
            bowler_runs+=runs;
            bowling.setNumber_of_runs_given(bowler_runs);
        }
        else
        {
            score+=runs;
            int x=player2.getNumber_of_balls_played();
            x++;
            player2.setNumber_of_balls_played(x);
            int add=player2.getRuns();
            add+=runs;
            player2.setRuns(add);
            striker =player2;

            int bowler_runs=bowling.getNumber_of_runs_given();
            bowler_runs+=runs;
            bowling.setNumber_of_runs_given(bowler_runs);
        }
        Thread.sleep(100);
    }
    public void six() throws InterruptedException
    {
        if (striker.getName() == player1.getName())
        {
            score+=runs;
            int x = player1.getNumber_of_balls_played();
            x++;
            player1.setNumber_of_balls_played(x);
            int add = player1.getRuns();
            add += runs;
            player1.setRuns(add);
            striker = player1;

            int bowler_runs=bowling.getNumber_of_runs_given();
            bowler_runs+=runs;
            bowling.setNumber_of_runs_given(bowler_runs);
        }
        else
        {
            score+=runs;
            int x = player2.getNumber_of_balls_played();
            x++;
            player2.setNumber_of_balls_played(x);
            int add = player2.getRuns();
            add += runs;
            player2.setRuns(add);
            striker = player2;

            int bowler_runs=bowling.getNumber_of_runs_given();
            bowler_runs+=runs;
            bowling.setNumber_of_runs_given(bowler_runs);
        }
        Thread.sleep(100);
    }
    public void wick() throws InterruptedException
        {
            if(striker.getName()==player1.getName())
            {
                System.out.println(k);
                wickets++;
                player1=team1.get(k);
                striker=team1.get(k);
                k++;

                int bowler_wicket=bowling.getWickets();
                bowler_wicket++;
                bowling.setRuns(bowler_wicket);
            }
            else if (striker.getName()== player2.getName())
            {
                wickets++;
                player2=team1.get(k);
                striker=team1.get(k);
                System.out.println(k);
                k++;


                int bowler_wicket=bowling.getWickets();
                bowler_wicket++;
                bowling.setRuns(bowler_wicket);

            }
            Thread.sleep(100);
        }
    }



