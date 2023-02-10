package com.example.gameofcricket.dao;
import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.cricket.player.PlayerStats;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface PlayerRepository extends CrudRepository<Player,String>
{
    @Query(
            value = "select * from player WHERE name like 'CSK%' AND runs = ( SELECT MAX(runs) FROM player )",
            nativeQuery = true
    )
    public List<Player> getHighestRunsInTeam();

}
