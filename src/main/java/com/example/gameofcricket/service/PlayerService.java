package com.example.gameofcricket.service;
import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.dao.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PlayerService
{
    @Autowired
    private PlayerRepository playerRepository;
    public List<Player> getHighestScoreByMatchIdAndTeamName(int id,String teamName)
    {
        List<Player> getHighestScore=playerRepository.getHighestRunsInTeam(teamName,id);
        return getHighestScore;
    }
    public List<Player> getFiftyScoredPlayer(int id)
    {
        List<Player> getFiftyScorePlayer=playerRepository.getPlayerFiftyScoreInMatchByMatchId(id);
        return getFiftyScorePlayer;
    }

    public List<Player> getHundredScoredPlayer(int id)
    {
        List<Player> getHundredScorePlayer=playerRepository.getPlayerHundredScoreInMatchByMatchId(id);
        return getHundredScorePlayer;
    }

    public List<Player> getMatchScoreCard(int id)
    {
        List<Player> getScorecard=playerRepository.getScoreCardOfMatchByMatchId(id);
        return getScorecard;
    }

}
