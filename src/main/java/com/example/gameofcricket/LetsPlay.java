package com.example.gameofcricket;

import java.text.DecimalFormat;
import java.util.*;

import static java.lang.Math.*;

public class LetsPlay
{
    List<Player> team1;
    List<Player> team2;
    Team team1_obj;

    int batsManOrder;
    int score;
    float total_overs;
    Player striker;

    Player player1;
    Player player2;

    int totalWickets;

    int runs;

    int bowler;
    Player bowling;

    int totalExtras;


    public void Bat(List<Player>batting,List<Player>bowl,Team bats,int target,int overs)
    {
        boolean allOut=false;
        boolean victory=false;

        team1_obj=bats;
        team1=batting;
        team2=bowl;
        batsManOrder =0;
        score=0;
        total_overs=0;
        striker=team1.get(batsManOrder);

        player1=team1.get(batsManOrder);
        batsManOrder++;
        player2=team1.get(batsManOrder);

        totalWickets = 0;

        totalExtras=0;

        runs = 0;

        bowler=5;
        bowling=team2.get(bowler);
        RandomGenerator generateRuns=new RandomGenerator();

        int ballsBowled=1;
        while(team1.size()-1> totalWickets)
        {


                while (total_overs<overs)
                {

                    if(striker.getPlayerRole()==PlayerRole.Batsman)
                        runs= generateRuns.generateBatsmanRuns();
                    else
                        runs=generateRuns.generateBowlerRuns();

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
                if(ballsBowled==6)
                {
                    total_overs++;
                    float round_off=(float) bowling.getNumberOfOversBowled();

                    bowling.setNumberOfOversBowled((float) ceil(round_off));

                    bowler++;

                    bowling=team2.get(bowler);
                    if(bowler==10)
                    {
                        bowler=4;
                    }
                }
                if(totalWickets ==10)
                {
                    allOut=true;
                    break;
                }


                float balls=(float)(0.1)+bowling.getNumberOfOversBowled();

                DecimalFormat df = new DecimalFormat("#.##");
                    balls=Float.valueOf(df.format(balls));
                bowling.setNumberOfOversBowled(balls);
                if(ballsBowled!=6)
                    ballsBowled++;
                else
                    ballsBowled=1;

            if(target>0&&score>target)
            {
                victory=true;
                break;
            }


            }

                if(total_overs==overs)
                    break;

            team1_obj.setScore(score);
            team1_obj.setExtras(totalExtras);
            team1_obj.setWickets(totalWickets);
            team1_obj.setOvers(total_overs);
                if(allOut||victory)
                {
                    break;
                }

        }

    }


    public void dot()
    {
        if (striker.getName()==player1.getName())
        {

            int x=player1.getNumberOfBallsPlayed();
            x++;
            player1.setNumberOfBallsPlayed(x);
            striker =player1;


        }
        else
        {

            int x=player2.getNumberOfBallsPlayed();
            x++;
            player2.setNumberOfBallsPlayed(x);

            striker =player2;


        }
    }

    public void Single()
    {

        if (striker.getName()==player1.getName())
        {
            score+=runs;
            int balls=player1.getNumberOfBallsPlayed();
            balls++;
            player1.setNumberOfBallsPlayed(balls);
            int add=player1.getRuns();
            add+=runs;

            player1.setRuns(add);
            striker =player2;

            int bowlerRuns=bowling.getNumberOfRunsGiven();
            bowlerRuns+=runs;

            bowling.setNumberOfRunsGiven(bowlerRuns);
        }
        else
        {
            score+=runs;
            int balls=player2.getNumberOfBallsPlayed();
            balls++;
            player2.setNumberOfBallsPlayed(balls);
            int add=player2.getRuns();
            add+=runs;
            player2.setRuns(add);
            striker =player1;

            int bowlerRuns=bowling.getNumberOfRunsGiven();
            bowlerRuns+=runs;
            bowling.setNumberOfRunsGiven(bowlerRuns);
        }

    }
    public void doubles()
    {

        if (striker.getName()==player1.getName())
        {
            score+=runs;
            int balls=player1.getNumberOfBallsPlayed();
            balls++;
            player1.setNumberOfBallsPlayed(balls);
            int add=player1.getRuns();
            add+=runs;
            player1.setRuns(add);
            striker =player1;

            int bowleRuns=bowling.getNumberOfRunsGiven();
            bowleRuns+=runs;
            bowling.setNumberOfRunsGiven(bowleRuns);
        }
        else
        {
            score+=runs;
            int  balls=player2.getNumberOfBallsPlayed();
             balls++;
            player2.setNumberOfBallsPlayed( balls);
            int add=player2.getRuns();
            add+=runs;
            player2.setRuns(add);
            striker =player2;

            int bowlerRuns=bowling.getNumberOfRunsGiven();
            bowlerRuns+=runs;
            bowling.setNumberOfRunsGiven(bowlerRuns);
        }
    }
    public void triple()
    {

        if (striker.getName()==player1.getName())
        {
            score+=runs;
            int balls=player1.getNumberOfBallsPlayed();
            balls++;
            player1.setNumberOfBallsPlayed(balls);
            int add=player1.getRuns();
            add+=runs;
            player1.setRuns(add);
            striker =player2;

            int bowlerRuns=bowling.getNumberOfRunsGiven();
            bowlerRuns+=runs;
            bowling.setNumberOfRunsGiven(bowlerRuns);
        }
        else
        {
            score+=runs;
            int balls=player2.getNumberOfBallsPlayed();
            balls++;
            player2.setNumberOfBallsPlayed(balls);
            int add=player2.getRuns();
            add+=runs;
            player2.setRuns(add);
            striker =player1;

            int bowlerRuns=bowling.getNumberOfRunsGiven();
            bowlerRuns+=runs;
            bowling.setNumberOfRunsGiven(bowlerRuns);
        }

    }
    public void four()
    {
        if (striker.getName()==player1.getName())
        {
            score+=runs;
            int balls=player1.getNumberOfBallsPlayed();
            balls++;
            player1.setNumberOfBallsPlayed(balls);
            int add=player1.getRuns();
            add+=runs;
            player1.setRuns(add);
            striker =player1;

            int bowler_runs=bowling.getNumberOfRunsGiven();
            bowler_runs+=runs;
            bowling.setNumberOfRunsGiven(bowler_runs);
        }
        else
        {
            score+=runs;
            int balls=player2.getNumberOfBallsPlayed();
            balls++;
            player2.setNumberOfBallsPlayed(balls);
            int add=player2.getRuns();
            add+=runs;
            player2.setRuns(add);
            striker =player2;

            int bowlerRuns=bowling.getNumberOfRunsGiven();
            bowlerRuns+=runs;
            bowling.setNumberOfRunsGiven(bowlerRuns);
        }

    }
    public void six()
    {
        if (striker.getName() == player1.getName())
        {
            score+=runs;
            int balls = player1.getNumberOfBallsPlayed();
            balls++;
            player1.setNumberOfBallsPlayed(balls);
            int add = player1.getRuns();
            add += runs;
            player1.setRuns(add);
            striker = player1;

            int bowlerRuns=bowling.getNumberOfRunsGiven();
            bowlerRuns+=runs;
            bowling.setNumberOfRunsGiven(bowlerRuns);
        }
        else
        {
            score+=runs;
            int balls = player2.getNumberOfBallsPlayed();
            balls++;
            player2.setNumberOfBallsPlayed(balls);
            int add = player2.getRuns();
            add += runs;
            player2.setRuns(add);
            striker = player2;

            int bowlerRuns=bowling.getNumberOfRunsGiven();
            bowlerRuns+=runs;
            bowling.setNumberOfRunsGiven(bowlerRuns);
        }

    }
    public void wick()
        {

            if(striker.getName()==player1.getName())
            {

                int balls = player1.getNumberOfBallsPlayed();
                balls++;
                player1.setNumberOfBallsPlayed(balls);
                totalWickets++;
                batsManOrder++;
                if(batsManOrder==11)
                    return;
                player1=team1.get(batsManOrder);
                striker=team1.get(batsManOrder);

                int bowlerWicket=bowling.getWickets();
                bowlerWicket++;
                bowling.setWickets(bowlerWicket);
            }
            else
            {

                int balls = player2.getNumberOfBallsPlayed();
                balls++;
                player2.setNumberOfBallsPlayed(balls);
                totalWickets++;
                batsManOrder++;
                if(batsManOrder==11)
                    return;
                player2=team1.get(batsManOrder);
                striker=team1.get(batsManOrder);

                int bowlerWicket=bowling.getWickets();
                bowlerWicket++;
                bowling.setWickets(bowlerWicket);

            }

        }
    public void wide()
    {

        if (striker.getName() == player1.getName())
        {
            totalExtras++;
            int wide_run=bowling.getExtras()+1;
            bowling.setExtras(wide_run);

            score+=runs;
            int bowlerRuns=bowling.getNumberOfRunsGiven();
            bowlerRuns+=runs;
            bowling.setNumberOfRunsGiven(bowlerRuns);
        }
        else
        {
            totalExtras++;
            int wideRun=bowling.getExtras()+1;
            bowling.setExtras(wideRun);

            score+=runs;
            int bowlerRuns=bowling.getNumberOfRunsGiven();
            bowlerRuns+=runs;
            bowling.setNumberOfRunsGiven(bowlerRuns);
        }

    }
    }



