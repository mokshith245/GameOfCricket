package com.example.gameofcricket;
import com.example.gameofcricket.cricket.Simulation;
import com.example.gameofcricket.cricket.Team;
import com.example.gameofcricket.cricket.player.UpdatePlayerStats;
import com.example.gameofcricket.cricket.results.MatchResults;
import com.example.gameofcricket.cricket.results.ScoreCard;
import com.example.gameofcricket.cricket.util.DecisionMadeByTeam;
import com.example.gameofcricket.cricket.util.Toss;
import com.example.gameofcricket.dao.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
@SpringBootApplication
public class GameOfCricketApplication
{
    public static TeamRepository teamRepository;
    public static PlayerRepository playerRepository;
    public static PlayerStatsRepository playerStatsRepository;
    public static UpdateScoreAfterEveryBallRepository updateScoreAfterEveryBallRepository;
    public static GameStatsRepository gameStatsRepository;
    public static void main(String[] args)
    {
        ConfigurableApplicationContext context= SpringApplication.run(GameOfCricketApplication.class, args);
        playerRepository = context.getBean(PlayerRepository.class);
        playerStatsRepository=context.getBean(PlayerStatsRepository.class);
        updateScoreAfterEveryBallRepository=context.getBean(UpdateScoreAfterEveryBallRepository.class);
        teamRepository =context.getBean(TeamRepository.class);
        gameStatsRepository=context.getBean(GameStatsRepository.class);
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter number of Overs ");
        int overs= sc.nextInt();
        int check=1,countMatches=1;
        List<Team> teams=new ArrayList<>();
        Team india = new Team("India");
        india.players = india.create_team();
        Team pakistan = new Team("Pakistan");
        pakistan.players = pakistan.create_team();
        Team newZealand = new Team("New Zealand");
        newZealand.players = newZealand.create_team();
        Team australia = new Team("Australia");
        australia.players = australia.create_team();
        Team southAfrica = new Team("South Africa");
        southAfrica.players = southAfrica.create_team();
        Team england = new Team("England");
        england.players = england.create_team();
        Team afganistan = new Team("Afganistan");
        afganistan.players = afganistan.create_team();
        Team bangladesh = new Team("Bangladesh");
        bangladesh.players = bangladesh.create_team();
        Team westIndies = new Team("West Indies");
        westIndies.players = westIndies.create_team();
        teams.add(india);
        teams.add(pakistan);
        teams.add(newZealand);
        teams.add(southAfrica);
        teams.add(afganistan);
        teams.add(australia);
        teams.add(bangladesh);
        teams.add(england);
        teams.add(westIndies);
        while(check>0)
        {
            System.out.println("Match "+countMatches);
            List<Team> twoTeams=new ArrayList<>(teams);
            Collections.shuffle(twoTeams);
            Team team1Obj = twoTeams.get(0);
            Team team2Obj = twoTeams.get(1);
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
            MatchResults.getMatchResults(battingTeam, bowlingTeam, overs,countMatches);
            ScoreCard.getScorecard(battingTeam,bowlingTeam,countMatches);
            UpdatePlayerStats.updatePlayerStats(battingTeam,bowlingTeam);
            System.out.println("Enter 1 for Next Match Simulation");
            System.out.println("Enter 0 to exit Simulation");
            check=sc.nextInt();
            if(check==0)
                break;
            countMatches++;
        }

    }
}
