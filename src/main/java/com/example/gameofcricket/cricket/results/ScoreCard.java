package com.example.gameofcricket.cricket.results;

import com.example.gameofcricket.GameOfCricketApplication;
import com.example.gameofcricket.cricket.Team;
import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.cricket.player.PlayerStatsPerMatch;

import java.util.List;

public class ScoreCard {



    public  void getScorecard(Team battingTeam, Team bowlingTeam,int matchId)
    {
        System.out.println(battingTeam.getName());

        for (Player i : battingTeam.players) {

            i.setTeamName(battingTeam.getName());
        }
        scorecard(battingTeam,matchId);
        System.out.println(bowlingTeam.getName());

        for (Player i : bowlingTeam.players) {
            i.setTeamName(bowlingTeam.getName());
        }
        scorecard(bowlingTeam,matchId);
    }
    public void scorecard(Team team,int matchId)
    {

          Team teamMatches= GameOfCricketApplication.teamRepository.getTeamStatsByTeamName(team.getName());
        if(teamMatches.getNumberOfMatchesPlayed()>1) {
            int setStats;
             for (Player i : team.players) {
                    PlayerStatsPerMatch playerStatsPerMatch = new PlayerStatsPerMatch();
                        playerStatsPerMatch.setPlayerId(i.getPlayerId());
                        playerStatsPerMatch.setMatchNumber(team.getNumberOfMatchesPlayed());
                        playerStatsPerMatch.setMatchId(matchId);
                        playerStatsPerMatch.setName(i.getName());
                        setStats=GameOfCricketApplication.playerStatsPerMatchRepository.getNumberOfBallsPlayedSum(i.getPlayerId());
                        playerStatsPerMatch.setNumberOfBallsPlayed(i.getNumberOfBallsPlayed() -setStats );
                        setStats=GameOfCricketApplication.playerStatsPerMatchRepository.getExtrasSum(i.getPlayerId());
                        playerStatsPerMatch.setExtras(i.getExtras() - setStats);
                        float oversBowled=GameOfCricketApplication.playerStatsPerMatchRepository.geNumberOfOversBowledSum(i.getPlayerId());
                        playerStatsPerMatch.setNumberOfOversBowled(i.getNumberOfOversBowled() - oversBowled);
                        setStats=GameOfCricketApplication.playerStatsPerMatchRepository.getNumberOfRunsGivenSum(i.getPlayerId());
                        playerStatsPerMatch.setNumberOfRunsGiven(i.getNumberOfRunsGiven() - setStats);
                        setStats=GameOfCricketApplication.playerStatsPerMatchRepository.getRunsSum(i.getPlayerId());
                        playerStatsPerMatch.setRuns(i.getRuns() - setStats);
                        playerStatsPerMatch.setTeamName(i.getTeamName());
                        setStats=GameOfCricketApplication.playerStatsPerMatchRepository.getWicketsSum(i.getPlayerId());
                        playerStatsPerMatch.setWickets(i.getWickets() - setStats);
                        playerStatsPerMatch.setPlayerRole(i.getPlayerRole());
                        GameOfCricketApplication.playerStatsPerMatchRepository.save(playerStatsPerMatch);
                    }
        }
        else{
            for (Player i : team.players) {
                PlayerStatsPerMatch playerStatsPerMatch = new PlayerStatsPerMatch();
                playerStatsPerMatch.setPlayerId(i.getPlayerId());
                playerStatsPerMatch.setMatchNumber(team.getNumberOfMatchesPlayed());
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
}

