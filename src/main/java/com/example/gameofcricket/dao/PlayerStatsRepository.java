package com.example.gameofcricket.dao;

import com.example.gameofcricket.cricket.player.PlayerStats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerStatsRepository extends CrudRepository<PlayerStats,String>
{

}
