package com.example.gameofcricket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DecisionMadeByTeam
{
    public static String getDecisionMadeByTeam()
    {
        List<String> batOrBall=new ArrayList<>();
        batOrBall.add("Ball");
        batOrBall.add("Bat");

        Random randChoose = new Random();
        String opted=batOrBall.get(randChoose.nextInt(batOrBall.size()));
        if(opted=="Bat")
        {
            System.out.println("Bat");
        }
        else
        {
            System.out.println("Bowl");
        }

        return opted;
    }
}
