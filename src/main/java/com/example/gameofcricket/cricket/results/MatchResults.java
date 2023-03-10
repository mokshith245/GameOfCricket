package com.example.gameofcricket.cricket.results;

import com.example.gameofcricket.GameOfCricketApplication;
import com.example.gameofcricket.cricket.Team;

public class MatchResults {
    public static void getMatchResults(Team battingTeam, Team bowlingTeam, int overs, int matchId) {
        GameStats gameStatsBatting = new GameStats();
        GameStats gameStatsBowling = new GameStats();
        if (battingTeam.getScore() < bowlingTeam.getScore()) {
            gameStatsBatting = MatchResults.team(gameStatsBatting, battingTeam, matchId);
            int wonByWickets = 10 - bowlingTeam.getWickets();
            gameStatsBatting.setWon(bowlingTeam.getName() + "  Won by  " + wonByWickets + " wickets.");
            gameStatsBowling = MatchResults.team(gameStatsBowling, bowlingTeam, matchId);
            gameStatsBowling.setWon(bowlingTeam.getName() + "  Won by  " + wonByWickets + " wickets.");

        } else if (battingTeam.getScore() - bowlingTeam.getScore() == 0) {

            gameStatsBatting = MatchResults.team(gameStatsBatting, battingTeam, matchId);
            gameStatsBatting.setWon("Match Drawn");
            gameStatsBowling = MatchResults.team(gameStatsBowling, bowlingTeam, matchId);
            gameStatsBowling.setWon("Match Drawn");

        } else {
            gameStatsBatting = MatchResults.team(gameStatsBatting, battingTeam, matchId);
            gameStatsBatting.setWon(battingTeam.getName() + " Won by " + (battingTeam.getScore() - bowlingTeam.getScore()) + " runs.");
            gameStatsBowling = MatchResults.team(gameStatsBowling, bowlingTeam, matchId);
            gameStatsBowling.setWon(battingTeam.getName() + " Won by " + (battingTeam.getScore() - bowlingTeam.getScore()) + " runs.");


        }
        GameOfCricketApplication.gameStatsRepository.save(gameStatsBowling);
        GameOfCricketApplication.gameStatsRepo.save(gameStatsBowling);
        GameOfCricketApplication.gameStatsRepository.save(gameStatsBatting);
        GameOfCricketApplication.gameStatsRepo.save(gameStatsBatting);
    }

    public static GameStats team(GameStats gameStats, Team team, int matchId) {
        gameStats.setTeamName(team.getName());
        gameStats.setScore(team.getScore());
        gameStats.setOvers(team.getOvers());
        gameStats.setMatchId(matchId);
        gameStats.setWickets(team.getWickets());
        gameStats.setExtras(team.getExtras());
        return gameStats;
    }


}
