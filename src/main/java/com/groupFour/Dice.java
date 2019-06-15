package com.groupFour;

import com.sun.org.apache.xml.internal.utils.StringToIntTable;

import java.util.ArrayList;
import java.util.Random;

public class Dice {
    final protected Integer numberOfDice;
    protected ArrayList<Integer> diceResult = new ArrayList<Integer>();
    protected Integer rollCount = 0;

    public Dice(Integer numberOfDice) {
        this.numberOfDice = numberOfDice;
    }



    public ArrayList<Integer> rollDice(){
        Random random = new Random();
        for (int i = 0; i < numberOfDice; i++) {
            Integer roll = random.nextInt(6)+ 1;
            diceResult.add(roll);
        }
        rollCount++;
        return diceResult;
    }

    public ArrayList<Integer> getDiceResult() {

        return this.diceResult;
    }



    public Integer getRollCount() {
        return rollCount;
    }

    public void setRollCount(Integer rollCount) {
        this.rollCount = rollCount;
    }

    public String toString(){
        StringBuilder build = new StringBuilder();
        for (Integer die: diceResult) {
            build.append(die).append(" ");
        }
    return build.toString();
    }
}

