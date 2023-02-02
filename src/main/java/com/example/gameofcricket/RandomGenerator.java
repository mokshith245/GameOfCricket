package com.example.gameofcricket;

import java.util.Random;

public class RandomGenerator
{
    int runs;
    int index;
    char c;
    public int generateBatsmanRuns()
    {
        String s = "012345670123456";
        Random random = new Random();
         index = random.nextInt(s.length());
         c = s.charAt(index);


          runs=Character.getNumericValue(c);
         return runs;
    }
    public int generateBowlerRuns()
    {
        String s = "0124567";
        Random random = new Random();
         index = random.nextInt(s.length());
         c = s.charAt(index);


         runs=Character.getNumericValue(c);
        return runs;
    }

}
