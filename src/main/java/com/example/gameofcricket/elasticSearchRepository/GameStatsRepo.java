package com.example.gameofcricket.elasticSearchRepository;

import com.example.gameofcricket.cricket.results.GameStats;
import com.example.gameofcricket.dao.compositeKeys.GameStatsId;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface GameStatsRepo extends ElasticsearchRepository<GameStats, String>
{
    @Query("{\n" +
            "    \"match\": {\n" +
            "      \"matchId\": \"?0\"\n" +
            "      \n" +
            "    }\n" +
            "  }")
    List<GameStats> getGameStatsByMatchId(int id);
}
