package com.example.gameofcricket.ElasticseachController;

import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.elasticSearchRepository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ElasticsearchPlayerController
{
    @Autowired
    private PlayerRepo playerRepo;

    @GetMapping("/esGetPlayer/{id}")
    public Player getPlayer(@PathVariable int id)
    {
        return playerRepo.getPlayerByPlayerId(id);
    }

    @GetMapping("/esGetPlayerByRoleAndTeamName/{role}/{name}")
    public List<Player> GetPlayerByRoleAndTeamName(@PathVariable String role, @PathVariable String name)
    {
        return playerRepo.getPlayerByRoleAndTeamName(role,name);
    }

}
