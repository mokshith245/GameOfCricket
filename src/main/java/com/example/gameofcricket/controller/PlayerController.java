package com.example.gameofcricket.controller;

import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @RequestMapping("/playerStats/{id}")
    public Player getPlayerStats(@PathVariable int id) {
        return playerService.getPLayer(id);
    }


}
