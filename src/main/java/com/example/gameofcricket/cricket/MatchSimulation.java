package com.example.gameofcricket.cricket;

import com.example.gameofcricket.cricket.player.PlayerRole;
import com.example.gameofcricket.cricket.results.ScoreAtParticularOver;
import com.example.gameofcricket.cricket.util.GameSimulationUtils;
import com.example.gameofcricket.cricket.util.Constants;
import com.example.gameofcricket.cricket.util.RandomGenerator;
import java.text.DecimalFormat;
import static java.lang.Math.ceil;
public class MatchSimulation {

    public static void Bat(Team battingTeam, Team bowlingTeam, int target, int oversForMatch, int countMatches) {
        float checkOvers = Constants.INITIAL_OVERS;
        GameSimulationUtils.setBatsManOrder(Constants.FIRST_BATSMAN);
        GameSimulationUtils.setScore(Constants.INITIAL_SCORE);
        GameSimulationUtils.setTotal_overs(Constants.INITIAL_OVERS);
        GameSimulationUtils.setTotalWickets(Constants.INITIAL_WICKETS);
        GameSimulationUtils.setTotalExtras(Constants.INITIAL_EXTRAS);
        GameSimulationUtils.setRuns(Constants.INITIAL_RUNS);
        GameSimulationUtils.setBowler(Constants.STARTING_BOWLER_IN_TEAM);
        int ballsBowled = Constants.FIRST_BALL;
        boolean allOut = false;
        GameSimulationUtils.setNoBall( Constants.NO_BALL);
        boolean victory = false;
        GameSimulationUtils.setBattingTeam( battingTeam);
        GameSimulationUtils.setBowlingTeam(bowlingTeam);
        GameSimulationUtils.setStriker( battingTeam.players.get(GameSimulationUtils.getBatsManOrder()));
        GameSimulationUtils.setPlayer1( battingTeam.players.get(GameSimulationUtils.getBatsManOrder()));
        GameSimulationUtils.setBatsManOrder(GameSimulationUtils.getBatsManOrder()+1);
        GameSimulationUtils.setPlayer2( battingTeam.players.get(GameSimulationUtils.getBatsManOrder()));
        GameSimulationUtils.setBowling( bowlingTeam.players.get(GameSimulationUtils.getBowler()));
        GameSimulationUtils.getPlayer1().setInnings(GameSimulationUtils.getPlayer1().getInnings() + 1);
        GameSimulationUtils.getPlayer2().setInnings(GameSimulationUtils.getPlayer2().getInnings() + 1);
        RandomGenerator generateRuns = new RandomGenerator();
        while (GameSimulationUtils.getBattingTeam().players.size() - 1 > GameSimulationUtils.getTotalWickets()) {
            while (GameSimulationUtils.getTotal_overs() < oversForMatch) {
                ScoreAtParticularOver scoreAtParticularOver = new ScoreAtParticularOver();
                scoreAtParticularOver.setMatchId(countMatches);
                scoreAtParticularOver.setTeamName(battingTeam.getName());
                if (GameSimulationUtils.getStriker().getPlayerRole() == PlayerRole.Batsman)
                    GameSimulationUtils.setRuns(generateRuns.generateBatsmanRuns());
                else GameSimulationUtils.setRuns(generateRuns.generateBowlerRuns());
               RunsScoredByPlayer.playerRuns(scoreAtParticularOver,checkOvers);
               if(GameSimulationUtils.getRuns()==5|| GameSimulationUtils.getRuns()==8) continue;
                if (ballsBowled == 6) {
                    GameSimulationUtils.setTotal_overs(GameSimulationUtils.getTotal_overs()+1);
                    float round_off = GameSimulationUtils.getBowling().getNumberOfOversBowled();
                    GameSimulationUtils.getBowling().setNumberOfOversBowled((float) ceil(round_off));
                    GameSimulationUtils.setBowler(GameSimulationUtils.getBowler()+1);
                    GameSimulationUtils.setBowling( GameSimulationUtils.getBowlingTeam().players.get(GameSimulationUtils.getBowler()));
                    if (GameSimulationUtils.getBowler()== 10)  GameSimulationUtils.setBowler(4);
                }
                if (GameSimulationUtils.getTotalWickets() == 10) {
                    allOut = true;
                    break;}
                GameSimulationUtils.setBalls( (float) (0.1) + GameSimulationUtils.getBowling().getNumberOfOversBowled());
                DecimalFormat df = new DecimalFormat("#.##");
                GameSimulationUtils.setBalls( Float.parseFloat(df.format(GameSimulationUtils.getBalls())));
                GameSimulationUtils.getBowling().setNumberOfOversBowled(GameSimulationUtils.getBalls());
                checkOvers = Runs.storeOvers(checkOvers, scoreAtParticularOver);
                if (ballsBowled != 6) ballsBowled++;
                 else {
                    checkOvers = (float) ceil(checkOvers);
                    ballsBowled = 1;}
                OutcomeOfBall.update(scoreAtParticularOver);
                if (target > 0 && GameSimulationUtils.getScore() > target) {
                    victory = true;
                    break;}}
            if (GameSimulationUtils.getTotal_overs() == oversForMatch) break;
            if (allOut || victory) break;
        }
    }

}
