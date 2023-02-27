package com.example.gameofcricket.cricket;

import com.example.gameofcricket.cricket.player.UpdatePlayerStats;
import com.example.gameofcricket.cricket.results.MatchResults;
import com.example.gameofcricket.cricket.results.ScoreCard;
import com.example.gameofcricket.cricket.util.DecisionMadeByTeam;
import com.example.gameofcricket.cricket.util.Toss;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class StartGame
{
    public void startGame(List<Team> teams,int overs,int countMatches)
    {
            System.out.println("Match "+countMatches);
            List<Team> twoTeams=new ArrayList<>(teams);
            Collections.shuffle(twoTeams);
            Team team1Obj = twoTeams.get(0);
            Team team2Obj = twoTeams.get(1);
            Team wonToss = Toss.tossTheCoin(team1Obj, team2Obj);
            String chooseBatOrBall = DecisionMadeByTeam.getDecisionMadeByTeam();
            Team battingTeam,bowlingTeam;
            boolean condition1 = wonToss==team1Obj&& Objects.equals(chooseBatOrBall, "Bat");
            boolean condition2 = wonToss==team2Obj&& Objects.equals(chooseBatOrBall, "Bowl");
            if((condition1 || condition2))
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
            ScoreCard scoreCard=new ScoreCard();
            scoreCard.getScorecard(battingTeam,bowlingTeam,countMatches);
            UpdatePlayerStats.update(battingTeam,countMatches);
            UpdatePlayerStats.update(bowlingTeam,countMatches);
        }
}
