package com.example.gameofcricket.cricket.player;

import com.example.gameofcricket.GameOfCricketApplication;
import com.example.gameofcricket.cricket.Team;
import com.example.gameofcricket.dao.PlayerStatsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UpdatePlayerStats
{
   public static List<PlayerStats> playerStats=new ArrayList<>();
    public  static void updatePlayerStats(Team battingTeam, Team bowlingTeam,int countMatches)
    {
        if(countMatches==1)
        {
            for(Player i:battingTeam.players)
            {
                PlayerStats newPlayer=new PlayerStats();
                newPlayer.setName(i.getName());
                newPlayer.setRuns(i.getRuns());
                newPlayer.setWickets(i.getWickets());
                newPlayer.setHighestScore(i.getRuns());
                if(i.getRuns()>=50&&i.getRuns()<100)
                {
                    newPlayer.setHalfCentury(1);
                }
                else if (i.getRuns()>=100)
                {
                    newPlayer.setHalfCentury(1);
                }
                newPlayer.setInnings(1);
                playerStats.add(newPlayer);
                GameOfCricketApplication.playerStatsRepository.save(newPlayer);
            }

        }
        else
        {
            int changeValue;
            for (PlayerStats j:playerStats)
            {

                for(Player i : battingTeam.players)
                {
                    Optional<PlayerStats> optionalPlayerStats=GameOfCricketApplication.playerStatsRepository.findById(j.getName());
                    PlayerStats object=optionalPlayerStats.get();

                    if(i.getName().equals(object.getName()))
                    {
                        changeValue=object.getRuns();
                        changeValue+=i.getRuns();
                        object.setRuns(changeValue);
                        changeValue=object.getWickets();
                        changeValue+=i.getWickets();
                        object.setWickets(changeValue);
                        changeValue=object.getInnings();
                        changeValue++;
                        object.setInnings(changeValue);
                        if(i.getRuns()>=50&&i.getRuns()<100)
                        {
                            changeValue=object.getHalfCentury();
                            changeValue++;
                           object.setHalfCentury(changeValue);
                        }
                        else if (i.getRuns()>=100)
                        {
                            changeValue=object.getCentury();
                            changeValue++;
                            object.setHalfCentury(changeValue);
                        }
                        if(object.getRuns()<i.getRuns())
                        {
                            object.setHighestScore(i.getRuns());
                        }

                        GameOfCricketApplication.playerStatsRepository.save(object);

                    }
                }

            }
            for (PlayerStats j:playerStats)
            {

                for(Player i : bowlingTeam.players)
                {
                    Optional<PlayerStats> optionalPlayerStats=GameOfCricketApplication.playerStatsRepository.findById(j.getName());
                    PlayerStats object=optionalPlayerStats.get();
                    if(i.getName()==object.getName())
                    {

                        changeValue=object.getRuns();
                        changeValue+=i.getRuns();
                        object.setRuns(changeValue);
                        changeValue=object.getWickets();
                        changeValue+=i.getWickets();
                        object.setWickets(changeValue);
                        changeValue=object.getInnings();
                        changeValue++;
                        object.setInnings(changeValue);
                        if(i.getRuns()>=50&&i.getRuns()<100)
                        {
                            changeValue=object.getHalfCentury();
                            changeValue++;
                            object.setHalfCentury(changeValue);
                        }
                        else if (i.getRuns()>=100)
                        {
                            changeValue=object.getCentury();
                            changeValue++;
                            object.setHalfCentury(changeValue);
                        }
                        if(object.getRuns()<i.getRuns())
                        {
                            object.setHighestScore(i.getRuns());
                        }

                        GameOfCricketApplication.playerStatsRepository.save(object);

                    }
                }

            }
        }
    }
    public void print()
    {
        for(PlayerStats i:playerStats)
        {
            System.out.println(i.getName()+" "+i.getRuns()+" "+i.getHalfCentury()+" "+i.getCentury());
        }
    }
}
