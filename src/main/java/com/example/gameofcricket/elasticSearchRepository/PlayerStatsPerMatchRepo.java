package com.example.gameofcricket.elasticSearchRepository;

import com.example.gameofcricket.cricket.player.PlayerStatsPerMatch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PlayerStatsPerMatchRepo extends ElasticsearchRepository<PlayerStatsPerMatch, String>
{
     List<PlayerStatsPerMatch>getPlayerStatsPerMatchByMatchId(int id);


}
