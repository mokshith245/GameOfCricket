package com.example.gameofcricket.dao;
import com.example.gameofcricket.cricket.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface TeamStats extends CrudRepository<Team,String>
{
    @Query(
            value = "select * from team where match_id=:i",
            nativeQuery = true
    )
    public List<Team> getMatchStatsByMatchId(@Param("i")int i);
}
