package com.example.gameofcricket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController

public class GameOfCricketApplication {
    public static void main(String[] args) {
        SpringApplication.run(GameOfCricketApplication.class, args);
        Team team1=new Team();
        Team team2=new Team();

        int wickets=0;
        int score=0;
        String s="0123456W";
        while(wickets!=10)
        {
            for(int i=0;i<6;i++)
            {

                Random random = new Random();
                int index = random.nextInt(s.length());
               char c= s.charAt(index);
               int runs=0;
                if(c!='W') {
                        runs = Character.getNumericValue(c);
                        

                }
                else
                {

                    wickets++;
                }
                System.out.println(runs);
            }
        }


    }

    @GetMapping("/")
    public String sm() {return "Hii";}


//    List<team> teams=new ArrayList<>();











}
