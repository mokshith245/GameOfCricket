package com.example.gameofcricket.cricket;

import com.example.gameofcricket.GameOfCricketApplication;
import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.cricket.player.PlayerRole;
import com.example.gameofcricket.cricket.util.RandomGenerator;
import org.hibernate.sql.ast.tree.expression.Over;

import java.text.DecimalFormat;

import static java.lang.Math.*;

public class Play {
    Team battingTeam, bowlingTeam;
    int batsManOrder, score, totalWickets, runs, bowler, totalExtras;
    float total_overs, balls;
    Player striker, player1, player2, bowling;
    boolean noBall;
    public void Bat(Team battingTeam, Team bowlingTeam, int target, int oversForMatch,int countMatches) {
        float checkOvers=0;
        batsManOrder = 0;
        score = 0;
        total_overs = 0;
        totalWickets = 0;
        totalExtras = 0;
        runs = 0;
        bowler = 5;
        int ballsBowled = 1;
        boolean allOut = false;
        noBall = false;
        boolean victory = false;
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        striker = battingTeam.players.get(batsManOrder);
        player1 = battingTeam.players.get(batsManOrder);
        batsManOrder++;
        player2 = battingTeam.players.get(batsManOrder);
        bowling = bowlingTeam.players.get(bowler);
        RandomGenerator generateRuns = new RandomGenerator();
        while (battingTeam.players.size() - 1 > totalWickets) {
            while (total_overs < oversForMatch) {
                Overs overs=new Overs();
                overs.setMatchId(countMatches);

                overs.setTeamName(battingTeam.getName());
                if (striker.getPlayerRole() == PlayerRole.Batsman)
                    runs = generateRuns.generateBatsmanRuns();
                else
                    runs = generateRuns.generateBowlerRuns();
                switch (runs) {
                    case 0:

                        dot();
                        break;
                    case 1:
                        score += runs;
                        striker = Runs.Single(player1, player2, striker, bowling, runs);
                        break;
                    case 2:
                        score += runs;
                        striker = Runs.doubles(player1, player2, striker, bowling, runs);
                        break;
                    case 3:
                        striker = Runs.triple(player1, player2, striker, bowling, runs);
                        break;
                    case 4:
                        striker = Runs.four(player1, player2, striker, bowling, runs);
                        break;
                    case 5:
                        wide();
                        break;
                    case 6:
                        striker = Runs.six(player1, player2, striker, bowling, runs);
                        break;
                    case 7:
                        wick();
                        break;
                }
                if (runs == 5) {
                    overs.setOvers(checkOvers);
                    overs.setScore(score);
                    continue;
                }
                if (runs == 8) {
                    noBall = true;
                    score++;
                    int addRuns = bowling.getNumberOfRunsGiven();
                    addRuns++;
                    bowling.setNumberOfRunsGiven(addRuns);
                    int addExtras = bowling.getExtras();
                    addExtras++;
                    bowling.setExtras(addExtras);
                    totalExtras++;
                    battingTeam.setExtras(totalExtras);
                    continue;
                }
                if (ballsBowled == 6) {
                    total_overs++;
                    float round_off = bowling.getNumberOfOversBowled();
                    bowling.setNumberOfOversBowled((float) ceil(round_off));
                    bowler++;
                    bowling = bowlingTeam.players.get(bowler);
                    if (bowler == 10) {
                        bowler = 4;
                    }
                }
                if (totalWickets == 10) {
                    allOut = true;
                    break;
                }
                balls = (float) (0.1) + bowling.getNumberOfOversBowled();
                DecimalFormat df = new DecimalFormat("#.##");
                balls = Float.valueOf(df.format(balls));
                bowling.setNumberOfOversBowled(balls);
                if (ballsBowled != 6) {
                    checkOvers = (float) (0.1) +checkOvers;
                    DecimalFormat format = new DecimalFormat("#.##");
                    checkOvers=Float.valueOf(format.format(checkOvers));
                    overs.setOvers(checkOvers);
                    overs.setScore(score);
                    ballsBowled++;
                }
                else {
                    checkOvers = (float) (0.1) +checkOvers;
                    DecimalFormat format = new DecimalFormat("#.##");
                    checkOvers=Float.valueOf(format.format(checkOvers));
                    overs.setOvers(checkOvers);
                    overs.setScore(score);
                    checkOvers=(float)ceil(checkOvers);
                    ballsBowled = 1;
                }

                overs.setWickets(totalWickets);
                GameOfCricketApplication.updateScoreAfterEveryBallRepository.save(overs);
                battingTeam.setScore(score);
                battingTeam.setExtras(totalExtras);
                battingTeam.setOvers(total_overs);
                if (target > 0 && score > target) {
                    victory = true;
                    break;
                }
            }
            if (total_overs == oversForMatch)
                break;
            if (allOut || victory) {
                break;
            }
        }
    }
    public void dot() {
        int x = striker.getNumberOfBallsPlayed();
        x++;
        striker.setNumberOfBallsPlayed(x);
    }
    public void wick() {

        if (striker.getName() == player1.getName() && noBall == false) {

            int balls = player1.getNumberOfBallsPlayed();
            balls++;
            player1.setNumberOfBallsPlayed(balls);
            totalWickets++;
            battingTeam.setWickets(totalWickets);
            batsManOrder++;
            if (batsManOrder == 11)
                return;
            player1 = battingTeam.players.get(batsManOrder);
            striker = battingTeam.players.get(batsManOrder);
            int bowlerWicket = bowling.getWickets();
            bowlerWicket++;
            bowling.setWickets(bowlerWicket);
        } else if (noBall == false) {

            int balls = player2.getNumberOfBallsPlayed();
            balls++;
            player2.setNumberOfBallsPlayed(balls);
            totalWickets++;
            battingTeam.setWickets(totalWickets);
            batsManOrder++;
            if (batsManOrder == 11)
                return;
            player2 = battingTeam.players.get(batsManOrder);
            striker = battingTeam.players.get(batsManOrder);
            int bowlerWicket = bowling.getWickets();
            bowlerWicket++;
            bowling.setWickets(bowlerWicket);
        }
        if (noBall == true)
            noBall = false;
    }
    public void wide() {

        if (striker.getName() == player1.getName()) {
            totalExtras++;
            int wide_run = bowling.getExtras() + 1;
            bowling.setExtras(wide_run);
            score += runs;
            int bowlerRuns = bowling.getNumberOfRunsGiven();
            bowlerRuns += runs;
            bowling.setNumberOfRunsGiven(bowlerRuns);
        } else {
            totalExtras++;
            int wideRun = bowling.getExtras() + 1;
            bowling.setExtras(wideRun);
            score += runs;
            int bowlerRuns = bowling.getNumberOfRunsGiven();
            bowlerRuns += runs;
            bowling.setNumberOfRunsGiven(bowlerRuns);
        }
    }
}



