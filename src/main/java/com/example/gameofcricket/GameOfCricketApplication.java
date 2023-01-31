package com.example.gameofcricket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController

public class GameOfCricketApplication
{
    public static void main(String[] args) throws InterruptedException
    {
        SpringApplication.run(GameOfCricketApplication.class, args);


        Team team1_obj=new Team();

        List<Player> team1=team1_obj.create_team();

        Team team2_obj=new Team();
        List<Player> team2=team2_obj.create_team();

        List<Team> toss=new ArrayList<>();
        toss.add(team1_obj);
        toss.add(team2_obj);

        Random rand_toss = new Random();
         Team wonToss=toss.get(rand_toss.nextInt(toss.size()));

         if(wonToss==team1_obj)
         {
             System.out.print("Team1 wom the toss and choose to ");
         }
         else
         {
             System.out.print("Team2 wom the toss and choose to ");
         }

         List<String> batOrBall=new ArrayList<>();
         batOrBall.add("Ball");
         batOrBall.add("Bat");

        Random rand_choose = new Random();
        String chooseBatOrBall=batOrBall.get(rand_choose.nextInt(batOrBall.size()));

        int target=0;

        if(chooseBatOrBall=="Bat")
        {
            System.out.println("Bat");
        }
        else
        {
            System.out.println("Bowl");
        }

        if(wonToss==team1_obj)
        {
            if(chooseBatOrBall=="Bat")
            {
                Play team1_play=new Play();
                team1_play.Bat(team1,team2,team1_obj,target);

                target= team1_obj.getScore();
                target++;
                Play team2_play=new Play();
                team2_play.Bat(team2,team1,team2_obj,target);
            }
            else
            {
                Play team2_play=new Play();
                team2_play.Bat(team2,team1,team2_obj,target);

                target= team2_obj.getScore();
                target++;
                Play team1_play=new Play();
                team1_play.Bat(team1,team2,team1_obj,target);
            }

        }
        else
        {
            if (chooseBatOrBall == "Bat")
            {
                Play team2_play = new Play();
                team2_play.Bat(team2, team1, team2_obj,target);

                target= team2_obj.getScore();
                target++;
                Play team1_play = new Play();
                team1_play.Bat(team1, team2, team1_obj,target);
            }
            else
            {
                Play team1_play = new Play();
                team1_play.Bat(team1, team2, team1_obj,target);

                target= team1_obj.getScore();
                target++;
                Play team2_play = new Play();
                team2_play.Bat(team2, team1, team2_obj,target);
            }
        }



        if(wonToss==team1_obj)
        {
            for (Player i : team1)
            {
                System.out.println(i.getName() + " " + i.getRuns() + " " + i.getNumber_of_balls_played() + " " + i.getWickets() + " " + i.getNumber_of_runs_given() + " " + i.getNumber_of_overs_bowled() + " " + i.getExtras());
            }
            System.out.println("Team 2");
            for (Player i:team2)
            {
                System.out.println(i.getName()+" "+i.getRuns()+" "+i.getNumber_of_balls_played()+" "+i.getWickets()+" "+i.getNumber_of_runs_given()+" "+i.getNumber_of_overs_bowled()+" "+i.getExtras());
            }
        }
        else
        {
            for (Player i:team2)
            {
                System.out.println(i.getName()+" "+i.getRuns()+" "+i.getNumber_of_balls_played()+" "+i.getWickets()+" "+i.getNumber_of_runs_given()+" "+i.getNumber_of_overs_bowled()+" "+i.getExtras());
            }
            System.out.println("Team 1");
            for (Player i : team1)
            {
                System.out.println(i.getName() + " " + i.getRuns() + " " + i.getNumber_of_balls_played() + " " + i.getWickets() + " " + i.getNumber_of_runs_given() + " " + i.getNumber_of_overs_bowled() + " " + i.getExtras());
            }
        }

        if(wonToss==team1_obj)
        {
            if(chooseBatOrBall=="Bat")
            {
                if(team1_obj.getScore()- team2_obj.getScore()<0)
                {
                    System.out.println();
                }
            }
        }


    }

    @GetMapping("/")
    public String sm() {return "Useless";}


//    List<team> teams=new ArrayList<>();











}
