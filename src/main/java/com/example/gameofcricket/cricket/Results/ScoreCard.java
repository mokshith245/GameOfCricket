package com.example.gameofcricket.cricket.Results;
import com.example.gameofcricket.GameOfCricketApplication;
import com.example.gameofcricket.cricket.Team;
import com.example.gameofcricket.cricket.player.Player;
public class ScoreCard {
    public static void getScorecard(Team battingTeam, Team bowlingTeam,int matchId)
    {
        System.out.println(battingTeam.getName());
        for (Player i : battingTeam.players) {
            i.setMatchId(matchId);
            i.setTeamName(battingTeam.getName());
            GameOfCricketApplication.playerRepository.save(i);
            System.out.println(i.getName() + " " + i.getRuns() + " " + i.getNumberOfBallsPlayed() + " " + i.getWickets() + " " + i.getNumberOfRunsGiven() + " " + i.getNumberOfOversBowled() + " " + i.getExtras());
        }
        System.out.println(bowlingTeam.getName());
        for (Player i : bowlingTeam.players) {
            i.setMatchId(matchId);
            i.setTeamName(bowlingTeam.getName());
            GameOfCricketApplication.playerRepository.save(i);
            System.out.println(i.getName() + " " + i.getRuns() + " " + i.getNumberOfBallsPlayed() + " " + i.getWickets() + " " + i.getNumberOfRunsGiven() + " " + i.getNumberOfOversBowled() + " " + i.getExtras());
        }
    }
}
