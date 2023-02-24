package com.example.gameofcricket.dao.repositories;

import com.example.gameofcricket.cricket.player.PlayerStatsPerMatch;
import com.example.gameofcricket.dao.compositeKeys.PlayerStatsPerMatchId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlayerStatsPerMatchRepository extends CrudRepository<PlayerStatsPerMatch, PlayerStatsPerMatchId>
{
    @Query(
            value = "select * from player_stats_per_match WHERE team_name=:teamName AND match_id=:id ORDER BY runs DESC LIMIT 1 ",
            nativeQuery = true
    )
    List<PlayerStatsPerMatch> getHighestRunsInTeam(@Param("teamName") String teamName,@Param("id") int id);
    @Query(
            value = "select * from player_stats_per_match WHERE  match_id=:id AND runs > 49",
            nativeQuery = true
    )
    List<PlayerStatsPerMatch> getPlayerFiftyScoreInMatchByMatchId(@Param("id") int id);

    @Query(
            value = "select * from player_stats_per_match WHERE  match_id=:id AND runs > 99",
            nativeQuery = true
    )
    List<PlayerStatsPerMatch> getPlayerHundredScoreInMatchByMatchId(@Param("id") int id);

    @Query(
            value = "select * from player_stats_per_match WHERE  match_id=:id",
            nativeQuery = true
    )
    List<PlayerStatsPerMatch> getScoreCardOfMatchByMatchId(@Param("id")int id);


}
