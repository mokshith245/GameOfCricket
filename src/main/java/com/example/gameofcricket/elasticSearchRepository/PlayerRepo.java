package com.example.gameofcricket.elasticSearchRepository;

import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.cricket.player.PlayerRole;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PlayerRepo extends ElasticsearchRepository<Player,Integer>
{
    @Query("{\n" +
            "    \"match\": {\n" +
            "      \"playerId\": \"?0\"\n" +
            "    }\n" +
            "  }")
    Player getPlayerByPlayerId(int id);

    @Query("{\n" +
            "    \"bool\": {\n" +
            "      \"must\": [\n" +
            "        {\"match\": {\n" +
            "          \"playerRole\":\"?0\"\n" +
            "        }}\n" +
            "      ],\"filter\": [\n" +
            "        {\"term\": {\n" +
            "          \"teamName.keyword\":\"?1\"\n" +
            "        }}\n" +
            "      ]\n" +
            "    }\n" +
            "  }")
    List<Player> getPlayerByRoleAndTeamName(String role, String name);

}
