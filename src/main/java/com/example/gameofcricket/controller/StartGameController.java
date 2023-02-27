package com.example.gameofcricket.controller;

import com.example.gameofcricket.cricket.StartGame;
import com.example.gameofcricket.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartGameController
{
    @Autowired
    private GameService gameService;
    @PostMapping("/startGame")
    public String startGame(@RequestParam int overs){
        gameService.createGame(overs);
        return "game started";
    }


}
