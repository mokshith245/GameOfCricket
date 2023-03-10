package com.example.gameofcricket.cricket.player;

import com.example.gameofcricket.GameOfCricketApplication;
import com.example.gameofcricket.cricket.Team;

import java.util.List;

public class UpdatePlayerStats {
    public static void update(Team team, int matchId) {
        int changeValue;
        Team teamMatches = GameOfCricketApplication.teamRepository.getTeamStatsByTeamName(team.getName());
        if (teamMatches.getNumberOfMatchesPlayed() > 1) {
            List<PlayerStatsPerMatch> teamPlayers = GameOfCricketApplication.playerStatsPerMatchRepository.getTeam(team.getName(), teamMatches.getNumberOfMatchesPlayed() - 1);

            for (Player i : team.players) {
                for (PlayerStatsPerMatch j : teamPlayers) {
                    if (j.getPlayerId() == i.getPlayerId()) {
                        if (i.getRuns() - j.getRuns() >= 50 && i.getRuns() - j.getRuns() < 100) {
                            changeValue = i.getHalfCentury();
                            changeValue++;
                            i.setHalfCentury(changeValue);
                        } else if (i.getRuns() - j.getRuns() >= 100) {
                            changeValue = i.getCentury();
                            changeValue++;
                            i.setHalfCentury(changeValue);
                        }
                        if (i.getRuns() - j.getRuns() < j.getRuns()) {
                            i.setHighestScore(i.getRuns() - j.getRuns());
                        }
                        GameOfCricketApplication.playerRepository.save(i);
                        GameOfCricketApplication.playerRepo.save(i);
                    }

                }
            }
        } else {
            for (Player i : team.players) {
                if (i.getRuns() >= 50 && i.getRuns() < 100) {
                    changeValue = i.getHalfCentury();
                    changeValue++;
                    i.setHalfCentury(changeValue);
                } else if (i.getRuns() >= 100) {
                    changeValue = i.getCentury();
                    changeValue++;
                    i.setHalfCentury(changeValue);
                }
                i.setHighestScore(i.getRuns());
                GameOfCricketApplication.playerRepository.save(i);
                GameOfCricketApplication.playerRepo.save(i);
            }
        }

    }
}



