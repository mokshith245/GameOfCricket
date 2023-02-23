package com.example.gameofcricket.dao;

import com.example.gameofcricket.cricket.Team;
import com.example.gameofcricket.cricket.results.GameStats;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameStatsRepository extends CrudRepository<GameStats,GameStatsId>
{

    @Query(
            value = "select * from game_stats where match_id=:i",
            nativeQuery = true
    )
    public List<GameStats> getMatchStatsByMatchId(@Param("i")int i);

}
