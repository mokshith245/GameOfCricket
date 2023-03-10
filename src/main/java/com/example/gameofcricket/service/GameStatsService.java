package com.example.gameofcricket.service;
import com.example.gameofcricket.cricket.results.GameStats;
import com.example.gameofcricket.dao.repositories.GameStatsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@Slf4j
public class GameStatsService
{

    @Autowired
    private  GameStatsRepository gameStatsRepository;
    public List<GameStats> getMatchDetailsByMatchId( int id)
    {
        log.info("Getting match stats");
        List<GameStats> getGameStats= gameStatsRepository.getMatchStatsByMatchId(id);
        return getGameStats;
    }

}
