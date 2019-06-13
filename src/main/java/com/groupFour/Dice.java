package com.groupFour;

import java.util.ArrayList;
import java.util.Random;

public class Dice {
    final private Integer numberOfDice;
    private ArrayList<Integer> diceResult = new ArrayList<Integer>();

    public Dice(Integer numberOfDice) {
        this.numberOfDice = numberOfDice;
    }



    public ArrayList<Integer> rollDice(){
        Random random = new Random();
        for (int i = 0; i < numberOfDice; i++) {
            Integer roll = random.nextInt(6)+ 1;
            diceResult.add(roll);
        }
        return diceResult;
    }

    public ArrayList<Integer> getDiceResult() {

        return this.diceResult;
    }


}

