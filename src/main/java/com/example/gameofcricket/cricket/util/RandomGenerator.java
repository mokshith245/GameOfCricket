package com.example.gameofcricket.cricket.util;

import java.util.Random;

public class RandomGenerator {
    int runs;
    int index;
    char c;

    public int generateBatsmanRuns() {
        String s = "01234567778012346";
        Random random = new Random();
        index = random.nextInt(s.length());
        c = s.charAt(index);
        runs = Character.getNumericValue(c);
        return runs;
    }

    public int generateBowlerRuns() {
        String s = "0123456778";
        Random random = new Random();
        index = random.nextInt(s.length());
        c = s.charAt(index);
        runs = Character.getNumericValue(c);
        return runs;
    }


}
