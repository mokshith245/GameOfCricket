package com.example.gameofcricket.dao.repositories;

import com.example.gameofcricket.cricket.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, String> {
    @Query(
            value = "select * from team where name=:name",
            nativeQuery = true
    )
    Team getTeamStatsByTeamName(@Param("name") String name);

    @Query(
            value = "select * from team",
            nativeQuery = true
    )
    List<Team> getTeams();

}
