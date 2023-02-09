package com.example.gameofcricket.dao;

import com.example.gameofcricket.cricket.player.PlayerStats;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerStatsRepository extends CrudRepository<PlayerStats,String>
{
    @Query(
            value = "SELECT * FROM player_stats  WHERE half_century=1",
            nativeQuery = true)
    public List<PlayerStats> getPlayerStatsByCenturyWhereHalfcentury();

    public List<PlayerStats> getPlayerStatsByName(String name);


}
