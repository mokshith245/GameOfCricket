package com.example.gameofcricket.ElasticseachController;

import com.example.gameofcricket.cricket.Team;
import com.example.gameofcricket.elasticSearchRepository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ElasticsearchTeamController
{
    @Autowired
    private TeamRepo teamRepo;

    @RequestMapping("/esTeamStats/{name}")
    public Team getTeamStats(@PathVariable String name) {
        return teamRepo.getTeamByName(name);
    }
}
