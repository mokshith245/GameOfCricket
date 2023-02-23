package com.example.gameofcricket.cricket.player;
import com.example.gameofcricket.GameOfCricketApplication;
import com.example.gameofcricket.cricket.Team;
import java.util.List;
public class UpdatePlayerStats {
    public static void updatePlayerStats(Team battingTeam, Team bowlingTeam) {
        List<PlayerStats> optionalPlayerStatsBattingTeam = GameOfCricketApplication.playerStatsRepository.getPlayerStatsByTeamName(battingTeam.getName());
        List<PlayerStats> optionalPlayerStatsBowlingTeam = GameOfCricketApplication.playerStatsRepository.getPlayerStatsByTeamName(bowlingTeam.getName());


        if (optionalPlayerStatsBattingTeam.isEmpty()) {
            UpdatePlayerStats.updateForFirstMatch(battingTeam);

        } else if(!optionalPlayerStatsBattingTeam.isEmpty()) {
            UpdatePlayerStats.updateForMatches(battingTeam);

        }

         if(optionalPlayerStatsBowlingTeam.isEmpty())
        {
            UpdatePlayerStats.updateForFirstMatch(bowlingTeam);
        }
        else if(!optionalPlayerStatsBowlingTeam.isEmpty())
        {
            updateForMatches(bowlingTeam);
        }
    }
    public static void updateForFirstMatch(Team team) {
        for (Player i : team.players) {
            PlayerStats newPlayer = new PlayerStats();
            newPlayer.setPlayerName(i.getName());
            newPlayer.setRuns(i.getRuns());
            newPlayer.setWickets(i.getWickets());
            newPlayer.setHighestScore(i.getRuns());
            newPlayer.setTeamName(i.getTeamName());
            if (i.getRuns() >= 50 && i.getRuns() < 100) {
                newPlayer.setHalfCentury(1);
            } else if (i.getRuns() >= 100) {
                newPlayer.setHalfCentury(1);
            }
            if(i.getNumberOfBallsPlayed()>0)
            newPlayer.setInnings(1);
            GameOfCricketApplication.playerStatsRepository.save(newPlayer);
        }
    }
    public static void updateForMatches(Team team) {
        int changeValue;
        List<PlayerStats> optionalPlayerStats = GameOfCricketApplication.playerStatsRepository.getPlayerStatsByTeamName(team.getName());
        for (PlayerStats object : optionalPlayerStats) {
            for (Player i : team.players) {

                if (i.getName().equals(object.getPlayerName())) {
                    changeValue = object.getRuns();
                    changeValue += i.getRuns();
                    object.setRuns(changeValue);
                    changeValue = object.getWickets();
                    changeValue += i.getWickets();
                    object.setWickets(changeValue);
                    if(i.getNumberOfBallsPlayed()>0)
                    {
                        changeValue = object.getInnings();
                        changeValue++;
                        object.setInnings(changeValue);
                    }
                    if (i.getRuns() >= 50 && i.getRuns() < 100) {
                        changeValue = object.getHalfCentury();
                        changeValue++;
                        object.setHalfCentury(changeValue);
                    } else if (i.getRuns() >= 100) {
                        changeValue = object.getCentury();
                        changeValue++;
                        object.setHalfCentury(changeValue);
                    }
                    if (object.getRuns() < i.getRuns()) {
                        object.setHighestScore(i.getRuns());
                    }
                    GameOfCricketApplication.playerStatsRepository.save(object);
                }
            }
        }
    }
}



