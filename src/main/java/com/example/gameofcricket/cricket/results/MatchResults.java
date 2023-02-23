package com.example.gameofcricket.cricket.results;

import com.example.gameofcricket.GameOfCricketApplication;
import com.example.gameofcricket.cricket.Team;

public class MatchResults
{
    public static void getMatchResults(Team battingTeam, Team bowlingTeam, int overs,int matchId)
    {

        if (battingTeam.getScore() < bowlingTeam.getScore()) {
            GameStats gameStatsBatting=new GameStats();
            gameStatsBatting.setTeamName(battingTeam.getName());
            gameStatsBatting.setScore(battingTeam.getScore());
            gameStatsBatting.setOvers(battingTeam.getOvers());
            gameStatsBatting.setMatchId(matchId);
            gameStatsBatting.setExtras(battingTeam.getExtras());
            gameStatsBatting.setWickets(battingTeam.getWickets());
            int wonByWickets = 10 - bowlingTeam.getWickets();
            gameStatsBatting.setWon(bowlingTeam.getName()+"  Won by  " + wonByWickets + " wickets.");
            GameStats gameStatsBowling=new GameStats();
            gameStatsBowling.setExtras(bowlingTeam.getExtras());
            gameStatsBowling.setTeamName(bowlingTeam.getName());
            gameStatsBowling.setScore(bowlingTeam.getScore());
            gameStatsBowling.setMatchId(matchId);
            gameStatsBowling.setOvers(battingTeam.getOvers());
            gameStatsBowling.setWickets(bowlingTeam.getWickets());
            gameStatsBowling.setWon(bowlingTeam.getName()+"  Won by  " + wonByWickets + " wickets.");
            GameOfCricketApplication.gameStatsRepository.save(gameStatsBowling);
            GameOfCricketApplication.gameStatsRepository.save(gameStatsBatting);
        } else {
            if(battingTeam.getScore()-bowlingTeam.getScore()==0) {
                GameStats gameStatsBatting=new GameStats();
                gameStatsBatting.setExtras(battingTeam.getExtras());
                gameStatsBatting.setTeamName(battingTeam.getName());
                gameStatsBatting.setScore(battingTeam.getScore());
                gameStatsBatting.setOvers(battingTeam.getOvers());
                gameStatsBatting.setMatchId(matchId);
                gameStatsBatting.setWickets(battingTeam.getWickets());
                gameStatsBatting.setWon("Match Drawn");
                GameStats gameStatsBowling=new GameStats();
                gameStatsBowling.setExtras(bowlingTeam.getExtras());
                gameStatsBowling.setTeamName(bowlingTeam.getName());
                gameStatsBowling.setScore(bowlingTeam.getScore());
                gameStatsBowling.setMatchId(matchId);
                gameStatsBowling.setOvers(battingTeam.getOvers());
                gameStatsBowling.setWickets(bowlingTeam.getWickets());
                gameStatsBowling.setWon("Match Drawn");
                GameOfCricketApplication.gameStatsRepository.save(gameStatsBowling);
                GameOfCricketApplication.gameStatsRepository.save(gameStatsBatting);
            }
            else {
                GameStats gameStatsBatting=new GameStats();
                gameStatsBatting.setTeamName(battingTeam.getName());
                gameStatsBatting.setScore(battingTeam.getScore());
                gameStatsBatting.setOvers(battingTeam.getOvers());
                gameStatsBatting.setMatchId(matchId);
                gameStatsBatting.setWickets(battingTeam.getWickets());
                gameStatsBatting.setExtras(battingTeam.getExtras());
                gameStatsBatting.setWon(battingTeam.getName() + " Won by " + (battingTeam.getScore() - bowlingTeam.getScore()) + " runs.");
                GameStats gameStatsBowling=new GameStats();
                gameStatsBowling.setExtras(bowlingTeam.getExtras());
                gameStatsBowling.setTeamName(bowlingTeam.getName());
                gameStatsBowling.setScore(bowlingTeam.getScore());
                gameStatsBowling.setMatchId(matchId);
                gameStatsBowling.setOvers(battingTeam.getOvers());
                gameStatsBowling.setWickets(bowlingTeam.getWickets());
                gameStatsBowling.setWon(battingTeam.getName() + " Won by " + (battingTeam.getScore() - bowlingTeam.getScore()) + " runs.");
                GameOfCricketApplication.gameStatsRepository.save(gameStatsBowling);
                GameOfCricketApplication.gameStatsRepository.save(gameStatsBatting);
            }

        }
    }
}
