package com.example.gameofcricket.elasticSearchRepository;

import com.example.gameofcricket.cricket.Team;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TeamRepo extends ElasticsearchRepository<Team,String>
{
    Team getTeamByName(String name);

}
