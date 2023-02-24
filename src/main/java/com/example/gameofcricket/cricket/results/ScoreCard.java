package com.example.gameofcricket.cricket.results;

import com.example.gameofcricket.GameOfCricketApplication;
import com.example.gameofcricket.cricket.Team;
import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.cricket.player.PlayerStatsPerMatch;
public class ScoreCard {

    public  void getScorecard(Team battingTeam, Team bowlingTeam,int matchId)
    {
        System.out.println(battingTeam.getName());
        for (Player i : battingTeam.players) {

            i.setTeamName(battingTeam.getName());

            GameOfCricketApplication.playerRepository.save(i);

        }
        scorecard(battingTeam,matchId);
        System.out.println(bowlingTeam.getName());
        for (Player i : bowlingTeam.players) {

            i.setTeamName(bowlingTeam.getName());
            GameOfCricketApplication.playerRepository.save(i);
        }
        scorecard(bowlingTeam,matchId);
    }
    public void scorecard(Team team,int matchId)
    {
        for(Player i:team.players)
        {
            PlayerStatsPerMatch playerStatsPerMatch=new PlayerStatsPerMatch();
            playerStatsPerMatch.setPlayerId(i.getPlayerId());
            playerStatsPerMatch.setMatchId(matchId);
            playerStatsPerMatch.setName(i.getName());
            playerStatsPerMatch.setNumberOfBallsPlayed(i.getNumberOfBallsPlayed());
            playerStatsPerMatch.setExtras(i.getExtras());
            playerStatsPerMatch.setNumberOfOversBowled(i.getNumberOfOversBowled());
            playerStatsPerMatch.setNumberOfRunsGiven(i.getNumberOfRunsGiven());
            playerStatsPerMatch.setRuns(i.getRuns());
            playerStatsPerMatch.setTeamName(i.getTeamName());
            playerStatsPerMatch.setWickets(i.getWickets());
            playerStatsPerMatch.setPlayerRole(i.getPlayerRole());
            GameOfCricketApplication.playerStatsPerMatchRepository.save(playerStatsPerMatch);

        }

    }
}
