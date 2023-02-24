package com.example.gameofcricket.dao.repositories;
import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.dao.compositeKeys.PlayerId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer>
{
    @Query(
            value = "select * from player WHERE player_id=:id",
            nativeQuery = true
    )
    List<Player> getPlayer(@Param("id") int id);


}
