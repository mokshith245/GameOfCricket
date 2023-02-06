package com.example.gameofcricket.cricket;

import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.cricket.player.PlayerRole;
import com.example.gameofcricket.cricket.util.RandomGenerator;

import java.text.DecimalFormat;
import java.util.*;

import static java.lang.Math.*;

public class LetsPlay
{
    //Team team1Obj;
    Team battingTeam;
    Team bowlingTeam;
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

    boolean noBall;
    float balls;

    public void Bat(Team battingTeam,Team bowlingTeam,int target,int overs)
    {
        boolean allOut=false;

        noBall=false;

        boolean victory=false;



        this.battingTeam=battingTeam;
        this.bowlingTeam=bowlingTeam;
        batsManOrder =0;
        score=0;
        total_overs=0;
        striker=battingTeam.players.get(batsManOrder);

        player1=battingTeam.players.get(batsManOrder);
        batsManOrder++;
        player2=battingTeam.players.get(batsManOrder);

        totalWickets = 0;

        totalExtras=0;

        runs = 0;

        bowler=5;
        bowling=bowlingTeam.players.get(bowler);
        RandomGenerator generateRuns=new RandomGenerator();

        int ballsBowled=1;
        while(battingTeam.players.size()-1> totalWickets)
        {


                while (total_overs<overs)
                {

                    if(striker.getPlayerRole()== PlayerRole.Batsman)
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
                if(runs==8)
                {
                    noBall=true;
                    score++;
                    int addRuns=bowling.getNumberOfRunsGiven();
                    addRuns++;
                    bowling.setNumberOfRunsGiven(addRuns);
                    int addExtras=bowling.getExtras();
                    addExtras++;
                    bowling.setExtras(addExtras);

                    totalExtras++;
                    battingTeam.setExtras(totalExtras);

                    continue;
                }
                if(ballsBowled==6)
                {
                    total_overs++;
                    float round_off=(float) bowling.getNumberOfOversBowled();

                    bowling.setNumberOfOversBowled((float) ceil(round_off));

                    bowler++;

                    bowling=bowlingTeam.players.get(bowler);
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


                balls=(float)(0.1)+bowling.getNumberOfOversBowled();

                DecimalFormat df = new DecimalFormat("#.##");
                    balls=Float.valueOf(df.format(balls));
                bowling.setNumberOfOversBowled(balls);
                if(ballsBowled!=6)
                    ballsBowled++;
                else
                    ballsBowled=1;


                    battingTeam.setScore(score);
                    battingTeam.setExtras(totalExtras);
                    battingTeam.setOvers(total_overs);
            if(target>0&&score>target)
            {
                System.out.println("Check");
                victory=true;
                break;

            }



            }

                if(total_overs==overs)
                    break;


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

            if(striker.getName()==player1.getName()&&noBall==false)
            {

                int balls = player1.getNumberOfBallsPlayed();
                balls++;
                player1.setNumberOfBallsPlayed(balls);
                totalWickets++;
                battingTeam.setWickets(totalWickets);
                batsManOrder++;
                if(batsManOrder==11)
                    return;
                player1=battingTeam.players.get(batsManOrder);
                striker=battingTeam.players.get(batsManOrder);

                int bowlerWicket=bowling.getWickets();
                bowlerWicket++;
                bowling.setWickets(bowlerWicket);
            }
            else if(noBall==false)
            {

                int balls = player2.getNumberOfBallsPlayed();
                balls++;
                player2.setNumberOfBallsPlayed(balls);
                totalWickets++;
                battingTeam.setWickets(totalWickets);
                batsManOrder++;
                if(batsManOrder==11)
                    return;
                player2=battingTeam.players.get(batsManOrder);
                striker=battingTeam.players.get(batsManOrder);

                int bowlerWicket=bowling.getWickets();
                bowlerWicket++;
                bowling.setWickets(bowlerWicket);

            }
            if(noBall==true)
                noBall=false;

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



