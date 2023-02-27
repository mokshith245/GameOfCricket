package com.example.gameofcricket.service;
import com.example.gameofcricket.cricket.player.PlayerStatsPerMatch;
import com.example.gameofcricket.dao.repositories.PlayerStatsPerMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerStatsPerMatchPerMatchService
{
    @Autowired
    private PlayerStatsPerMatchRepository playerStatsPerMatchRepository;

    public List<PlayerStatsPerMatch> getHighestScoreByMatchIdAndTeamName(int id, String teamName)
    {
        List<PlayerStatsPerMatch> getHighestScore=playerStatsPerMatchRepository.getHighestRunsInTeam(teamName,id);
        return getHighestScore;
    }
    public List<PlayerStatsPerMatch> getRunsScoredPlayer(int id,int runs)
    {
        List<PlayerStatsPerMatch> getRunsScorePlayer=playerStatsPerMatchRepository.getPlayerRunsScoreInMatchByMatchId(id,runs);
        return getRunsScorePlayer;
    }


    public List<PlayerStatsPerMatch> getMatchScoreCard(int id)
    {
        List<PlayerStatsPerMatch> getScorecard=playerStatsPerMatchRepository.getScoreCardOfMatchByMatchId(id);
        return getScorecard;
    }

}
