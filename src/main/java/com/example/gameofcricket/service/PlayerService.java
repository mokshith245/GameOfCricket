package com.example.gameofcricket.service;
import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.dao.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PlayerService
{
    @Autowired
    private PlayerRepository playerRepository;


    public List<Player> getPLayer(int id) {
        List<Player> player=playerRepository.getPlayer(id);
        return player;
    }
}
