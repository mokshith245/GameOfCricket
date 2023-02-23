package com.example.gameofcricket.controller;
import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class PlayerController
{
    @Autowired
    private PlayerService playerService;
    @RequestMapping("/HighestScore/{id}/{teamName}")
    public List<Player> getHighestScore(@PathVariable int id,@PathVariable String teamName)
    {
        return playerService.getHighestScoreByMatchIdAndTeamName(id,teamName);
    }
    @RequestMapping("/fiftyScore/{id}")
    public List<Player> getNameOfFiftyScoredPlayer(@PathVariable int id)
    {
        return playerService.getFiftyScoredPlayer(id);
    }

    @RequestMapping("/hundredScore/{id}")
    public List<Player> getNameOfHundredScoredPlayer(@PathVariable int id)
    {
        return playerService.getHundredScoredPlayer(id);
    }
    @RequestMapping("/ScoreCard/{id}")
    public List<Player> getScoreCardOFMatch(@PathVariable int id)
    {
        return playerService.getMatchScoreCard(id);
    }



}
