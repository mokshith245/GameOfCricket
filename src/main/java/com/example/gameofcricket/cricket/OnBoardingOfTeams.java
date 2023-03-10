package com.example.gameofcricket.cricket;

import com.example.gameofcricket.GameOfCricketApplication;

public class OnBoardingOfTeams {
    public static void startSimulation(Team battingTeam, Team bowlingTeam, int overs, int countMatches) {
        GameOfCricketApplication.playerRepository.saveAll(battingTeam.players);
        GameOfCricketApplication.playerRepository.saveAll(bowlingTeam.players);
        GameOfCricketApplication.playerRepo.saveAll(battingTeam.players);
        GameOfCricketApplication.playerRepo.saveAll(bowlingTeam.players);
        int numberOfMatches = battingTeam.getNumberOfMatchesPlayed();
        numberOfMatches++;
        battingTeam.setNumberOfMatchesPlayed(numberOfMatches);
        numberOfMatches = bowlingTeam.getNumberOfMatchesPlayed();
        numberOfMatches++;
        bowlingTeam.setNumberOfMatchesPlayed(numberOfMatches);
        int target = 0;
        MatchSimulation teamPlay = new MatchSimulation();
        teamPlay.Bat(battingTeam, bowlingTeam, target, overs, countMatches);
        GameOfCricketApplication.teamRepository.save(battingTeam);
        GameOfCricketApplication.teamRepo.save(battingTeam);
        target = battingTeam.getScore();
        target++;
        teamPlay.Bat(bowlingTeam, battingTeam, target, overs, countMatches);
        GameOfCricketApplication.teamRepository.save(bowlingTeam);
        GameOfCricketApplication.teamRepo.save(bowlingTeam);
    }
}
