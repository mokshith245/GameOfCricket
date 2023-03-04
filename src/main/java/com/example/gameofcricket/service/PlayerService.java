package com.example.gameofcricket.service;
import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.dao.repositories.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@Slf4j
public class PlayerService
{
    @Autowired
    private PlayerRepository playerRepository;


    public Player getPLayer(int id) {
        log.info("Getting Player Stats");
        Player player=playerRepository.getPlayer(id);
        return player;
    }
}
