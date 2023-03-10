package com.example.gameofcricket.cricket;
import com.example.gameofcricket.GameOfCricketApplication;
import com.example.gameofcricket.cricket.player.Player;
import com.example.gameofcricket.cricket.results.ScoreAtParticularOver;
import com.example.gameofcricket.cricket.util.GameSimulationUtils;
public class OutcomeOfBall
{
    public static void runsOfBall()
    {
        if (GameSimulationUtils.getRuns() == 0) Runs.dot(GameSimulationUtils.getStriker());
        if (GameSimulationUtils.getRuns() == 1 || GameSimulationUtils.getRuns() == 3) {
            if (GameSimulationUtils.getStriker() == GameSimulationUtils.getPlayer1())
                GameSimulationUtils.setStriker(Runs.updateMatchStatsOdd(GameSimulationUtils.getPlayer1(), GameSimulationUtils.getPlayer2(), GameSimulationUtils.getStriker()));
            else {
                GameSimulationUtils.setStriker(Runs.updateMatchStatsOdd(GameSimulationUtils.getPlayer2(), GameSimulationUtils.getPlayer1(), GameSimulationUtils.getStriker()));
            }
        }
        if (GameSimulationUtils.getRuns() == 2 || GameSimulationUtils.getRuns() == 4 || GameSimulationUtils.getRuns() == 6) {
            if (GameSimulationUtils.getStriker() == GameSimulationUtils.getPlayer1())
                GameSimulationUtils.setStriker( Runs.updateMatchStatsEven(GameSimulationUtils.getPlayer1(), GameSimulationUtils.getStriker()));
            else {
                GameSimulationUtils.setStriker(Runs.updateMatchStatsEven(GameSimulationUtils.getPlayer2(), GameSimulationUtils.getStriker()));
            }
        }
        if (GameSimulationUtils.getRuns() == 5)
        {
            if (GameSimulationUtils.getStriker() == GameSimulationUtils.getPlayer1())
                Runs.wide();
            else {
                Runs.wide();
            }
        }
    }
    public static void wideCheck( ScoreAtParticularOver scoreAtParticularOver,float checkOvers)
    {
        GameSimulationUtils.setTotalExtras(GameSimulationUtils.getTotalExtras()+1);
        scoreAtParticularOver.setOvers(checkOvers);
        scoreAtParticularOver.setScore(GameSimulationUtils.getScore());
    }

    public static void  extras()
    {
        int addRuns = GameSimulationUtils.getBowling().getNumberOfRunsGiven();
        addRuns++;
        GameSimulationUtils.getBowling().setNumberOfRunsGiven(addRuns);
        int addExtras = GameSimulationUtils.getBowling().getExtras();
        addExtras++;
        GameSimulationUtils.getBowling().setExtras(addExtras);
        GameSimulationUtils.setTotalExtras(GameSimulationUtils.getTotalExtras()+1);
        GameSimulationUtils.getBattingTeam().setExtras(GameSimulationUtils.getTotalExtras());
    }
    public static Player wick(Player player, Player striker) {
        int balls = player.getNumberOfBallsPlayed();
        balls++;
        player.setNumberOfBallsPlayed(balls);
        GameSimulationUtils.setBatsManOrder(GameSimulationUtils.getBatsManOrder()+1);
        if (GameSimulationUtils.getBatsManOrder() == 11)
            return null;
        player = GameSimulationUtils.getBattingTeam().players.get(GameSimulationUtils.getBatsManOrder());
        striker = GameSimulationUtils.getBattingTeam().players.get(GameSimulationUtils.getBatsManOrder());
        player.setInnings(player.getInnings() + 1);
        int bowlerWicket = GameSimulationUtils.getBowling().getWickets();
        bowlerWicket++;
        GameSimulationUtils.getBowling().setWickets(bowlerWicket);
        if (GameSimulationUtils.isNoBall()) GameSimulationUtils.setNoBall( false);
        return player;
    }

    public static void update(ScoreAtParticularOver scoreAtParticularOver)
    {
        scoreAtParticularOver.setWickets(GameSimulationUtils.getTotalExtras());
        GameOfCricketApplication.updateScoreAfterEveryBallRepository.save(scoreAtParticularOver);
        GameOfCricketApplication.updateScoreAfterEveryBallRepo.save(scoreAtParticularOver);
        GameSimulationUtils.getBattingTeam().setScore(GameSimulationUtils.getScore());
        GameSimulationUtils.getBattingTeam().setExtras(GameSimulationUtils.getTotalExtras());
        GameSimulationUtils.getBattingTeam().setOvers(GameSimulationUtils.getTotal_overs());
    }

}
