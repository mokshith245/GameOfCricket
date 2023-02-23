package com.example.gameofcricket.dao;
import com.example.gameofcricket.cricket.player.PlayerStats;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface PlayerStatsRepository extends CrudRepository<PlayerStats,PlayerStatsId>
{
    @Query(
            value = "SELECT * FROM player_stats  WHERE team_name=:name",
            nativeQuery = true)
    public List<PlayerStats> getPlayerStatsByTeamName(@Param("name")String name);


}
