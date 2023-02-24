package com.example.gameofcricket.dao.repositories;
import com.example.gameofcricket.cricket.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface TeamRepository extends CrudRepository<Team,String>
{
    @Query(
            value = "select * from team where name=:i",
            nativeQuery = true
    )
    List<Team> getTeamStatsByTeamName(@Param("i")String i);
}
