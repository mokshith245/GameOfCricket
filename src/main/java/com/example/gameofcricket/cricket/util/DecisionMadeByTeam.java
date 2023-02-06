package com.example.gameofcricket.cricket.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DecisionMadeByTeam
{
    public static String getDecisionMadeByTeam()
    {
        List<String> batOrBall=new ArrayList<>();
        batOrBall.add("Bowl");
        batOrBall.add("Bat");

        Random randChoose = new Random();
        String optedTo=batOrBall.get(randChoose.nextInt(batOrBall.size()));
        if(optedTo=="Bat")
        {
            System.out.println("Bat");
        }
        else
        {
            System.out.println("Bowl");
        }

        return optedTo;
    }
}
