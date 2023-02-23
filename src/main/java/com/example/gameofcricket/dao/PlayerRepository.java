package com.example.gameofcricket.dao;
import com.example.gameofcricket.cricket.player.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface PlayerRepository extends CrudRepository<Player,PlayerId>
{
    @Query(
            value = "select * from player WHERE team_name=:teamName AND match_id=:id ORDER BY runs DESC LIMIT 1 ",
            nativeQuery = true
    )
    List<Player> getHighestRunsInTeam(@Param("teamName") String teamName,@Param("id") int id);
    @Query(
            value = "select * from player WHERE  match_id=:id AND runs > 49",
            nativeQuery = true
    )
    List<Player> getPlayerFiftyScoreInMatchByMatchId(@Param("id") int id);

    @Query(
            value = "select * from player WHERE  match_id=:id AND runs > 99",
            nativeQuery = true
    )
    List<Player> getPlayerHundredScoreInMatchByMatchId(@Param("id") int id);

    @Query(
            value = "select * from player WHERE  match_id=:id",
            nativeQuery = true
    )
    List<Player> getScoreCardOfMatchByMatchId(@Param("id")int id);


}
