package com.example.gameofcricket.dao.repositories;
import com.example.gameofcricket.cricket.results.ScoreAtParticularOver;
import com.example.gameofcricket.dao.compositeKeys.OversId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UpdateScoreAfterEveryBallRepository extends CrudRepository<ScoreAtParticularOver, OversId>
{
    @Query(
            value = "select * from score_at_particular_over WHERE (match_id=:m AND team_name=:t and overs between :o-0.01 and :o+0.01)",
            nativeQuery = true
    )
    public List<ScoreAtParticularOver> getScoreAt(@Param("m")int m, @Param("t")String t, @Param("o")float o);

}
