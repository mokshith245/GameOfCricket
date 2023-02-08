package com.example.gameofcricket.dao;

import com.example.gameofcricket.cricket.Overs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateScoreAfterEveryBallRepository extends CrudRepository<Overs,OversId>
{

}
