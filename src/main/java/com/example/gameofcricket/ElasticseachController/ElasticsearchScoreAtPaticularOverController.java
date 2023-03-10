package com.example.gameofcricket.ElasticseachController;

import com.example.gameofcricket.cricket.results.ScoreAtParticularOver;
import com.example.gameofcricket.elasticSearchRepository.UpdateScoreAfterEveryBallRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ElasticsearchScoreAtPaticularOverController {
    @Autowired
    private UpdateScoreAfterEveryBallRepo updateScoreAfterEveryBallRepo;

    @GetMapping("/esGetScore/{id}/{name}/{over}")
    public List<ScoreAtParticularOver> getScore(@PathVariable int id, @PathVariable String name, @PathVariable float over) {
        return updateScoreAfterEveryBallRepo.getScoreAtParticularOversByMatchIdAndTeamNameAndOvers(id, name, over);

    }
}
