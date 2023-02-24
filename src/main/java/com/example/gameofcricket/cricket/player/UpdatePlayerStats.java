package com.example.gameofcricket.cricket.player;
import com.example.gameofcricket.GameOfCricketApplication;
import com.example.gameofcricket.cricket.Team;
import java.util.List;
public class UpdatePlayerStats {
    public static void update(Team team) {
        int changeValue;
            for (Player i : team.players) {

                    changeValue = i.getRuns();
                    changeValue += i.getRuns();
                    i.setRuns(changeValue);
                    changeValue = i.getWickets();
                    changeValue += i.getWickets();
                    i.setWickets(changeValue);
                    if(i.getNumberOfBallsPlayed()>0)
                    {
                        changeValue = i.getInnings();
                        changeValue++;
                        i.setInnings(changeValue);
                    }
                    if (i.getRuns() >= 50 && i.getRuns() < 100) {
                        changeValue = i.getHalfCentury();
                        changeValue++;
                        i.setHalfCentury(changeValue);
                    } else if (i.getRuns() >= 100) {
                        changeValue = i.getCentury();
                        changeValue++;
                        i.setHalfCentury(changeValue);
                    }
                    if (i.getRuns() < i.getRuns()) {
                        i.setHighestScore(i.getRuns());
                    }
                    GameOfCricketApplication.playerRepository.save(i);

            }

    }
}



