package com.example.gameofcricket;
import com.example.gameofcricket.cricket.*;
import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.cricket.player.PlayerStats;
import com.example.gameofcricket.cricket.player.UpdatePlayerStats;
import com.example.gameofcricket.cricket.util.DecisionMadeByTeam;
import com.example.gameofcricket.cricket.util.Toss;
import com.example.gameofcricket.dao.PlayerRepository;
import com.example.gameofcricket.dao.PlayerStatsRepository;
import com.example.gameofcricket.dao.UpdateScoreAfterEveryBallRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;
@SpringBootApplication
@RestController
public class GameOfCricketApplication
{
    public static PlayerRepository playerRepository;
    public static PlayerStatsRepository playerStatsRepository;
    public static UpdateScoreAfterEveryBallRepository updateScoreAfterEveryBallRepository;
    public static void main(String[] args)
    {
        ConfigurableApplicationContext context= SpringApplication.run(GameOfCricketApplication.class, args);
        playerRepository = context.getBean(PlayerRepository.class);
        playerStatsRepository=context.getBean(PlayerStatsRepository.class);
        updateScoreAfterEveryBallRepository=context.getBean(UpdateScoreAfterEveryBallRepository.class);
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter number of Overs ");
        int overs= sc.nextInt();
        int check=1,countMatches=1;
        while(check>0)
        {
            System.out.println("Match "+countMatches);
            Team team1Obj = new Team("CSK");
            team1Obj.players = team1Obj.create_team("CSK");
            Team team2Obj = new Team("RCB");
            team2Obj.players = team2Obj.create_team("RCB");
            Team wonToss = Toss.tossTheCoin(team1Obj, team2Obj);
            String chooseBatOrBall = DecisionMadeByTeam.getDecisionMadeByTeam();
            Team battingTeam,bowlingTeam;
            if((wonToss==team1Obj&&chooseBatOrBall=="Bat") || (wonToss==team2Obj&&chooseBatOrBall=="Bowl" ))
            {
                battingTeam=team1Obj;
                bowlingTeam=team2Obj;
            }
            else
            {
                battingTeam=team2Obj;
                bowlingTeam=team1Obj;
            }
            Simulation.startSimulation(battingTeam, bowlingTeam, overs,countMatches);
            MatchResults.getMatchResults(battingTeam, bowlingTeam, overs);
            ScoreCard.getScorecard(battingTeam,bowlingTeam);
            UpdatePlayerStats.updatePlayerStats(battingTeam,bowlingTeam,countMatches);
            List<PlayerStats> playerStats=GameOfCricketApplication.playerStatsRepository.getPlayerStatsByCenturyWhereHalfcentury();
            List<Player> p=GameOfCricketApplication.playerRepository.getHighestRunsInTeam();
            p.forEach(e->{
                System.out.println("siva");
                System.out.println(e);
            });
            System.out.println("Enter 1 for Next Match Simulation");
            System.out.println("Enter 0 to exit Simulation");
            check=sc.nextInt();
            if(check==0)
                break;
            countMatches++;
        }
    }
}
