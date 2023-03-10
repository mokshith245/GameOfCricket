package com.example.gameofcricket.cricket.util;
import com.example.gameofcricket.cricket.Team;
import com.example.gameofcricket.cricket.player.Player;
import lombok.Getter;
import lombok.Setter;

public class GameSimulationUtils
{
    @Getter@Setter
    public static Team battingTeam, bowlingTeam;
    @Getter@Setter
    public static Player striker, player1, player2, bowling;
    @Getter@Setter
    public static int batsManOrder, score, totalWickets, runs, bowler, totalExtras;
    @Getter@Setter
    public static float total_overs, balls;
    @Getter@Setter
    public static boolean noBall;


}
