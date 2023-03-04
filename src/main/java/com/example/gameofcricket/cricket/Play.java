package com.example.gameofcricket.cricket;

import com.example.gameofcricket.GameOfCricketApplication;
import com.example.gameofcricket.cricket.results.ScoreAtParticularOver;
import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.cricket.player.PlayerRole;
import com.example.gameofcricket.cricket.util.RandomGenerator;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.Objects;

import static java.lang.Math.*;

@Component
public class Play {


    Team battingTeam, bowlingTeam;
    int batsManOrder, score, totalWickets, runs, bowler, totalExtras;
    float total_overs, balls;
    Player striker, player1, player2, bowling;
    boolean noBall;

    public void Bat(Team battingTeam, Team bowlingTeam, int target, int oversForMatch, int countMatches) {
        float checkOvers = 0;
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
        player1.setInnings(player1.getInnings() + 1);
        player2.setInnings(player2.getInnings() + 1);
        RandomGenerator generateRuns = new RandomGenerator();
        while (battingTeam.players.size() - 1 > totalWickets) {
            while (total_overs < oversForMatch) {
                ScoreAtParticularOver scoreAtParticularOver = new ScoreAtParticularOver();
                scoreAtParticularOver.setMatchId(countMatches);

                scoreAtParticularOver.setTeamName(battingTeam.getName());
                if (striker.getPlayerRole() == PlayerRole.Batsman)
                    runs = generateRuns.generateBatsmanRuns();
                else
                    runs = generateRuns.generateBowlerRuns();
                if (runs == 0) dot();
                if (runs == 1 || runs == 3) {
                    score += runs;
                    if (striker == player1)
                        striker = Runs.updateMatchStatsOdd(player1, player2, striker, bowling, runs);
                    else {
                        striker = Runs.updateMatchStatsOdd(player2, player1, striker, bowling, runs);
                    }
                }
                if (runs == 2 || runs == 4 || runs == 6) {
                    score += runs;
                    if (striker == player1)
                        striker = Runs.updateMatchStatsEven(player1, striker, bowling, runs);
                    else {
                        striker = Runs.updateMatchStatsEven(player2, striker, bowling, runs);
                    }
                }
                if (runs == 5) if (striker == player1)
                    wide(bowling, runs);
                else {
                    wide(bowling, runs);
                }
                if (runs == 7) if (!noBall) {
                    if (striker == player1)
                        player1 = wick(player1, striker, bowling, runs);
                    else {
                        player2 = wick(player2, striker, bowling, runs);
                    }
                }

                if (runs == 5) {
                    scoreAtParticularOver.setOvers(checkOvers);
                    scoreAtParticularOver.setScore(score);
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
                balls = Float.parseFloat(df.format(balls));
                bowling.setNumberOfOversBowled(balls);
                if (ballsBowled != 6) {
                    checkOvers = (float) (0.1) + checkOvers;
                    DecimalFormat format = new DecimalFormat("#.##");
                    checkOvers = Float.parseFloat(format.format(checkOvers));
                    scoreAtParticularOver.setOvers(checkOvers);
                    scoreAtParticularOver.setScore(score);
                    ballsBowled++;
                } else {
                    checkOvers = (float) (0.1) + checkOvers;
                    DecimalFormat format = new DecimalFormat("#.##");
                    checkOvers = Float.parseFloat(format.format(checkOvers));
                    scoreAtParticularOver.setOvers(checkOvers);
                    scoreAtParticularOver.setScore(score);
                    checkOvers = (float) ceil(checkOvers);
                    ballsBowled = 1;
                }
                scoreAtParticularOver.setWickets(totalWickets);
                GameOfCricketApplication.updateScoreAfterEveryBallRepository.save(scoreAtParticularOver);
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

    public Player wick(Player player, Player striker, Player bowling, int runs) {

        int balls = player.getNumberOfBallsPlayed();
        balls++;
        player.setNumberOfBallsPlayed(balls);
        totalWickets++;
        battingTeam.setWickets(totalWickets);
        batsManOrder++;
        if (batsManOrder == 11)
            return null;
        player = battingTeam.players.get(batsManOrder);
        striker = battingTeam.players.get(batsManOrder);
        player.setInnings(player.getInnings() + 1);
        int bowlerWicket = bowling.getWickets();
        bowlerWicket++;
        bowling.setWickets(bowlerWicket);

        if (noBall)
            noBall = false;
        return player;
    }

    public void wide(Player bowling, int runs) {
        score++;
        totalExtras++;
        int wide_run = bowling.getExtras() + 1;
        bowling.setExtras(wide_run);
        int bowlerRuns = bowling.getNumberOfRunsGiven();
        bowlerRuns++;
        bowling.setNumberOfRunsGiven(bowlerRuns);

    }
}



