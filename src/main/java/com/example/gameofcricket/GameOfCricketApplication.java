package com.example.gameofcricket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController

public class GameOfCricketApplication
{
    public static void main(String[] args) throws InterruptedException
    {
        SpringApplication.run(GameOfCricketApplication.class, args);

        Play team1_play=new Play();
        team1_play.Bat();

    }

    @GetMapping("/")
    public String sm() {return "Hii";}


//    List<team> teams=new ArrayList<>();











}
