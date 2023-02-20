package com.example.gameofcricket;
import com.example.gameofcricket.cricket.*;
import com.example.gameofcricket.cricket.Results.MatchResults;
import com.example.gameofcricket.cricket.Results.ScoreAtParticularOver;
import com.example.gameofcricket.cricket.Results.ScoreCard;
import com.example.gameofcricket.cricket.player.UpdatePlayerStats;
import com.example.gameofcricket.cricket.util.DecisionMadeByTeam;
import com.example.gameofcricket.cricket.util.Toss;
import com.example.gameofcricket.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
@SpringBootApplication
@RestController
public class GameOfCricketApplication
{
    @Autowired
    public static TeamStats teamStats;
    @Autowired
    public static PlayerRepository playerRepository;
    @Autowired
    public static PlayerStatsRepository playerStatsRepository;
    @Autowired
    public static UpdateScoreAfterEveryBallRepository updateScoreAfterEveryBallRepository;
    @Autowired
    public static GameStatsRepository gameStatsRepository;
    public static void main(String[] args)
    {
        ConfigurableApplicationContext context= SpringApplication.run(GameOfCricketApplication.class, args);
        playerRepository = context.getBean(PlayerRepository.class);
        playerStatsRepository=context.getBean(PlayerStatsRepository.class);
        updateScoreAfterEveryBallRepository=context.getBean(UpdateScoreAfterEveryBallRepository.class);
        teamStats=context.getBean(TeamStats.class);
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
//            List<PlayerStats> playerStats=playerStatsRepository.getPlayerStatsByCenturyWhereHalfcentury();
//            List<Player> p=GameOfCricketApplication.playerRepository.getHighestRunsInTeam();
//            p.forEach(e->{
//                System.out.println("siva");
//                System.out.println(e);
//            });
            List<ScoreAtParticularOver> scoreAtThisOver=updateScoreAfterEveryBallRepository.getScoreAt(2,"CSK",(float) 5.2);
            scoreAtThisOver.forEach(e->{
                System.out.println(e);
            });
            System.out.println("Enter 1 for Next Match Simulation");
            System.out.println("Enter 0 to exit Simulation");
            check=sc.nextInt();
            if(check==0)
                break;
            countMatches++;
        }
        int matchId;
        System.out.println("Enter Match Number to get details of that match ");
        matchId=sc.nextInt();
        List<Team> getDetails=teamStats.getMatchStatsByMatchId(matchId);
        getDetails.forEach(e->{
            System.out.println(e);
        });
    }
}
