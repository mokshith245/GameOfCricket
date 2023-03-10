package com.example.gameofcricket.elasticSearchRepository;

import com.example.gameofcricket.cricket.results.ScoreAtParticularOver;
import com.example.gameofcricket.dao.compositeKeys.OversId;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UpdateScoreAfterEveryBallRepo extends ElasticsearchRepository<ScoreAtParticularOver, String>
{
    @Query("{\n" +
            "    \"bool\": {\n" +
            "      \"must\": [\n" +
            "        { \"match\": { \"matchId\":\"?0\" } },\n" +
            "        { \"match\": { \"teamName.keyword\": \"?1\" }},\n" +
            "        {\"match\": { \"overs\": \"?2\" }}\n" +
            "      ]\n" +
            "    }\n" +
            "  }")
    List<ScoreAtParticularOver> getScoreAtParticularOversByMatchIdAndTeamNameAndOvers(int id,String name,float over);


}
