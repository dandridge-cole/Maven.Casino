package com.groupFour;

import java.util.ArrayList;
import java.util.Random;

public class Dice {
    final private Integer numberOfDice;
    private ArrayList<Integer> diceResult;

    public Dice(Integer numberOfDice) {
        this.numberOfDice = numberOfDice;
    }



    public void rollDice(){
        Random random = new Random();
        Integer roll = random.nextInt(6)+ 1;

        for (int i = 0; i < numberOfDice; i++) {
            diceResult.add(roll);
        }
    }

    public ArrayList<Integer> getDiceResult() {

        return null;
    }


}

