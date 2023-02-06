package com.example.gameofcricket;

import com.example.gameofcricket.cricket.*;
import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.cricket.util.DecisionMadeByTeam;
import com.example.gameofcricket.cricket.util.Toss;
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


            Team team1Obj = new Team("CSK");

            team1Obj.players = team1Obj.create_team();


            Team team2Obj = new Team("SRH");
            team2Obj.players = team2Obj.create_team();


            Team wonToss = Toss.tossTheCoin(team1Obj, team2Obj);

            String chooseBatOrBall = DecisionMadeByTeam.getDecisionMadeByTeam();

            Team battingTeam,bowlingTeam;
            if((wonToss==team1Obj&&chooseBatOrBall=="Bat") || (wonToss==team2Obj&&chooseBatOrBall=="Bowl" ))
            {
                battingTeam=team1Obj;
                bowlingTeam=team2Obj;
            }
            else {
                battingTeam=team2Obj;
                bowlingTeam=team1Obj;
            }

            Simulation.startSimulation(battingTeam, bowlingTeam, overs);

            MatchResults.getMatchResults(battingTeam, bowlingTeam, overs);

            ScoreCard.getScorecard(battingTeam,bowlingTeam);



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
