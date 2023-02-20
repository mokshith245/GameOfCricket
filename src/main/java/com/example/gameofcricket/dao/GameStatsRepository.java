package com.example.gameofcricket.dao;

import com.example.gameofcricket.cricket.Results.GameStats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameStatsRepository extends CrudRepository<GameStats,GameStatsId>
{

}
