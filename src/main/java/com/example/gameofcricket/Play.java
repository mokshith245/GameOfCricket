package com.example.gameofcricket;

import java.text.DecimalFormat;
import java.util.*;

import static java.lang.Math.*;

public class Play
{


    List<Player> team1;


    List<Player> team2;
    Team team1_obj=new Team();
    Team team2_obj=new Team();


    int k;
    int score;
    float total_overs;
    Player striker;

    Player player1;
    Player player2;

    int wickets;

    int runs;

    int bowler;
    Player bowling;





    public void Bat(List<Player>batting,List<Player>bowl,Team bats,int target)
    {
        boolean allOut=false;
        boolean victory=false;

        team1_obj=bats;
        team1=batting;
        team2=bowl;
        k=0;
        score=0;
        total_overs=0;
        striker=team1.get(k);

        player1=team1.get(k);
        player2=team1.get(k+1);

        wickets = 0;

        runs = 0;

        bowler=5;
        bowling=team2.get(bowler);


        //Map<String, Integer> map = new LinkedHashMap();

        while(team1.size()-1>k)
        {


            String s = "01234567";
            int j=1;

                while (total_overs<15)
                {

                    Random random = new Random();
                    int index = random.nextInt(s.length());
                    char c = s.charAt(index);


                     runs=  Character.getNumericValue(c);
                    System.out.println("RUNS "+runs+" "+j);
                    switch (runs)
                    {
                        case 0:
                            dot();
                            break;

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
                            wide();
                            break;
                        case 6:
                            six();
                            break;
                        case 7:
                            wick();
                            break;

                }
                if(runs==5)
                {
                    continue;
                }
                if(j==6)
                {
                    total_overs++;
                    float round_off=(float) bowling.getNumber_of_overs_bowled();

                    bowling.setNumber_of_overs_bowled((float) ceil(round_off));
                    System.out.println(bowling.getNumber_of_overs_bowled());
                    bowler++;
                    bowling=team2.get(bowler);
                    if(bowler==10)
                    {
                        bowler=4;
                    }
                }
                if(wickets==10)
                {
                    allOut=true;
                    break;
                }


                float balls=(float)(0.1)+bowling.getNumber_of_overs_bowled();
                //System.out.println(balls);
                DecimalFormat df = new DecimalFormat("#.##");
                    balls=Float.valueOf(df.format(balls));
                bowling.setNumber_of_overs_bowled(balls);
                if(j!=6)
                    j++;
                else
                    j=1;

            if(target>0&&score>target)
            {
                victory=true;
                break;
            }


            }

            team1_obj.setScore(score);

                if(allOut||victory)
                {
                    if(victory)
                    {
                        System.out.print("Won in ");
                        System.out.println(total_overs);

                    }
                    else
                    System.out.println("All Out");

                    break;
                }

        }

    }


    public void dot()
    {
        if (striker.getName()==player1.getName())
        {

            int x=player1.getNumber_of_balls_played();
            x++;
            player1.setNumber_of_balls_played(x);
            striker =player1;


        }
        else
        {

            int x=player2.getNumber_of_balls_played();
            x++;
            player2.setNumber_of_balls_played(x);

            striker =player2;


        }
    }

    public void Single()
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

    }
    public void doubles()
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
    }
    public void triple()
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

    }
    public void four()
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

    }
    public void six()
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

    }
    public void wick()
        {
            if(striker.getName()==player1.getName())
            {
               // System.out.println(k);
                int x = player1.getNumber_of_balls_played();
                x++;
                player1.setNumber_of_balls_played(x);
                wickets++;
                player1=team1.get(k);
                striker=team1.get(k);
                k++;

                int bowler_wicket=bowling.getWickets();
                bowler_wicket++;
                bowling.setWickets(bowler_wicket);
            }
            else
            {
                //System.out.println("down "+k);
                int x = player1.getNumber_of_balls_played();
                x++;
                player1.setNumber_of_balls_played(x);
                wickets++;
                player2=team1.get(k);
                striker=team1.get(k);

                k++;


                int bowler_wicket=bowling.getWickets();
                bowler_wicket++;
                bowling.setWickets(bowler_wicket);

            }

        }
    public void wide()
    {
        if (striker.getName() == player1.getName())
        {
            int wide_run=bowling.getExtras()+1;
            bowling.setExtras(wide_run);

            score+=runs;
            int bowler_runs=bowling.getNumber_of_runs_given();
            bowler_runs+=runs;
            bowling.setNumber_of_runs_given(bowler_runs);
        }
        else
        {
            int wide_run=bowling.getExtras()+1;
            bowling.setExtras(wide_run);

            score+=runs;
            int bowler_runs=bowling.getNumber_of_runs_given();
            bowler_runs+=runs;
            bowling.setNumber_of_runs_given(bowler_runs);
        }

    }
    }



