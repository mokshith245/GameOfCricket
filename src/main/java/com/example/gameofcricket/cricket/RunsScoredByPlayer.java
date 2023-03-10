package com.example.gameofcricket.cricket;
import com.example.gameofcricket.cricket.results.ScoreAtParticularOver;
import com.example.gameofcricket.cricket.util.GameSimulationUtils;
public class RunsScoredByPlayer
{
    public static void playerRuns(ScoreAtParticularOver scoreAtParticularOver,float checkOvers)
    {
        if (GameSimulationUtils.getRuns() ==5) {
            GameSimulationUtils.setScore(GameSimulationUtils.getScore()+1);
            OutcomeOfBall.wideCheck(scoreAtParticularOver,checkOvers);
        } else if (GameSimulationUtils.getRuns() == 8) {
            GameSimulationUtils.setNoBall( true);
            GameSimulationUtils.setScore(GameSimulationUtils.getScore()+1);
            OutcomeOfBall.extras();
        } else if (GameSimulationUtils.getRuns() == 7) {
            if (!GameSimulationUtils.isNoBall()) {
                GameSimulationUtils.setTotalWickets(GameSimulationUtils.getTotalWickets()+1);
                GameSimulationUtils.getBattingTeam().setWickets(GameSimulationUtils.getTotalWickets());
                if (GameSimulationUtils.getStriker() == GameSimulationUtils.getPlayer1())
                    GameSimulationUtils.setPlayer1(OutcomeOfBall.wick(GameSimulationUtils.getPlayer1(), GameSimulationUtils.getStriker()));
                else
                    GameSimulationUtils.setPlayer2( OutcomeOfBall.wick(GameSimulationUtils.getPlayer2(), GameSimulationUtils.getStriker()));
            }
        } else {
            GameSimulationUtils.setScore(GameSimulationUtils.getScore()+ GameSimulationUtils.getRuns());
            OutcomeOfBall.runsOfBall();
        }
    }

}
