package com.example.gameofcricket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController

public class GameOfCricketApplication
{
    public static void main(String[] args) throws InterruptedException
    {
        SpringApplication.run(GameOfCricketApplication.class, args);

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter number of Overs ");
        int overs= sc.nextInt();

        int check=1;
        while(check>0)
        {


            Team team1Obj = new Team();

            List<Player> team1 = team1Obj.create_team();

            Team team2Obj = new Team();
            List<Player> team2 = team2Obj.create_team();


            Team wonToss = Toss.tossTheCoin(team1Obj, team2Obj);

            String chooseBatOrBall = DecisionMadeByTeam.getDecisionMadeByTeam();

            Simulation.startSimulation(team1Obj, team2Obj, team1, team2, wonToss, chooseBatOrBall, overs);

            MatchResults.getMatchResults(team1Obj, team2Obj, wonToss, chooseBatOrBall, overs);

            ScoreCard.getScorecard(team1Obj, team1, team2, wonToss, chooseBatOrBall);



            System.out.println("Enter 1 for Next Match Simulation");
            System.out.println("Enter 0 to exit Simulation");
            check=sc.nextInt();
            if(check==0)
                break;

        }


    }

    @GetMapping("/")
    public String sm() {return "Useless";}












}
