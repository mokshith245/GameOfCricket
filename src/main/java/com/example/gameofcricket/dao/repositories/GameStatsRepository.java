package com.example.gameofcricket.dao.repositories;

import com.example.gameofcricket.cricket.results.GameStats;
import com.example.gameofcricket.dao.compositeKeys.GameStatsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface GameStatsRepository extends JpaRepository<GameStats, GameStatsId> {

    @Query(
            value = "select * from game_stats where match_id=:i",
            nativeQuery = true
    )
    List<GameStats> getMatchStatsByMatchId(@Param("i") int i);

    @Query(
            value = " select MAX(match_id) from game_stats",
            nativeQuery = true
    )
    Optional<Integer> getMaxId();

}
