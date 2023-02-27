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
            //System.out.println(i.getName()+" "+i.getRuns()+" "+i.getNumberOfBallsPlayed()+" "+i.getTeamName());
        }
        scorecard(battingTeam,matchId);
        System.out.println(bowlingTeam.getName());

        for (Player i : bowlingTeam.players) {
            i.setTeamName(bowlingTeam.getName());
            //System.out.println(i.getName()+" "+i.getRuns()+" "+i.getNumberOfBallsPlayed()+" "+i.getTeamName());
        }
        scorecard(bowlingTeam,matchId);
    }
    public void scorecard(Team team,int matchId)
    {

          Team teamMatches= GameOfCricketApplication.teamRepository.getTeamStatsByTeamName(team.getName());
        if(teamMatches.getNumberOfMatchesPlayed()>1) {
            System.out.println(teamMatches.getNumberOfMatchesPlayed());
            List<PlayerStatsPerMatch>teamPlayers=GameOfCricketApplication.playerStatsPerMatchRepository.getTeam(team.getName(),teamMatches.getNumberOfMatchesPlayed()-1);

            for (Player i : team.players) {
               // System.out.println(i.getName()+" "+i.getRuns()+" "+i.getNumberOfBallsPlayed()+" "+i.getTeamName());
                for (PlayerStatsPerMatch j :teamPlayers) {
                    PlayerStatsPerMatch playerStatsPerMatch = new PlayerStatsPerMatch();
                    if (j.getPlayerId() == i.getPlayerId()) {
                        playerStatsPerMatch.setPlayerId(i.getPlayerId());
                        playerStatsPerMatch.setMatchNumber(team.getNumberOfMatchesPlayed());
                        playerStatsPerMatch.setMatchId(matchId);
                        playerStatsPerMatch.setName(i.getName());
                        playerStatsPerMatch.setNumberOfBallsPlayed(i.getNumberOfBallsPlayed() - j.getNumberOfBallsPlayed());
                        playerStatsPerMatch.setExtras(i.getExtras() - j.getExtras());
                        playerStatsPerMatch.setNumberOfOversBowled(i.getNumberOfOversBowled() - j.getNumberOfOversBowled());
                        playerStatsPerMatch.setNumberOfRunsGiven(i.getNumberOfRunsGiven() - j.getNumberOfRunsGiven());
                        playerStatsPerMatch.setRuns(i.getRuns() - j.getRuns());
                        playerStatsPerMatch.setTeamName(i.getTeamName());
                        playerStatsPerMatch.setWickets(i.getWickets() - j.getWickets());
                        playerStatsPerMatch.setPlayerRole(i.getPlayerRole());
                        GameOfCricketApplication.playerStatsPerMatchRepository.save(playerStatsPerMatch);
                    }
                }

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

