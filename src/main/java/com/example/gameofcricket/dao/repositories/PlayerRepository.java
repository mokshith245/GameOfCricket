package com.example.gameofcricket.dao.repositories;

import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.dao.compositeKeys.PlayerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    @Query(
            value = "select * from player WHERE player_id=:id",
            nativeQuery = true
    )
    Player getPlayer(@Param("id") int id);

    @Query(
            value = "select * from player WHERE team_name=:name",
            nativeQuery = true
    )
    List<Player> getTeam(@Param("name") String name);


}
