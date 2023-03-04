package com.example.gameofcricket.service;
import com.example.gameofcricket.cricket.player.PlayerStatsPerMatch;
import com.example.gameofcricket.dao.repositories.PlayerStatsPerMatchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PlayerStatsPerMatchPerMatchService
{
    @Autowired
    private PlayerStatsPerMatchRepository playerStatsPerMatchRepository;

    public List<PlayerStatsPerMatch> getHighestScoreByMatchIdAndTeamName(int id, String teamName)
    {
        log.info("Getting the player who scored highest runs in team");
        List<PlayerStatsPerMatch> getHighestScore=playerStatsPerMatchRepository.getHighestRunsInTeam(teamName,id);
        return getHighestScore;
    }
    public List<PlayerStatsPerMatch> getRunsScoredPlayer(int id,int runs)
    {
        log.info("Getting the Players who scored more than "+runs+" runs");
        List<PlayerStatsPerMatch> getRunsScorePlayer=playerStatsPerMatchRepository.getPlayerRunsScoreInMatchByMatchId(id,runs);
        return getRunsScorePlayer;
    }


    public List<PlayerStatsPerMatch> getMatchScoreCard(int id)
    {
        log.info("Getting the match scorecard");
        List<PlayerStatsPerMatch> getScorecard=playerStatsPerMatchRepository.getScoreCardOfMatchByMatchId(id);
        return getScorecard;
    }


}
