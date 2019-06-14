package com.groupFour.Games;

import com.groupFour.Dice;
import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.*;

public class GreaterThanThreeTest {

    Dice dice = new Dice(5);
    ArrayList<Integer> diceResult = new ArrayList<Integer>();
    ArrayList<Integer> finalList = new ArrayList<Integer>();
    Integer rollCount = 0;

    @Test
    public void setup() {
        for (int i = 0; i < diceResult.size(); i++) {
            for (int j = i + 1; j < diceResult.size(); j++) {
                if (diceResult.get(i).equals(diceResult.get(j))) {
                    finalList.add(i);
                }
            }
        }
        Assert.assertTrue(finalList != diceResult);

    }

    @Test
    public void rollCountTest(){
        if(diceResult.size() > 1){rollCount++;}
        int expected = 1;
        int actual = rollCount;

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void reRollNewDiceSizeTest() {
        diceResult.add(5);
        diceResult.add(3);
        diceResult.add(5);
        diceResult.add(6);
        diceResult.add(2);

        Dice reRollDice = new Dice(5 - finalList.size());
        for (int i = 0; i < diceResult.size(); i++) {
            for (int j = i + 1; j < diceResult.size(); j++) {
                if (diceResult.get(i).equals(diceResult.get(j))) {
                    finalList.add(diceResult.get(i));
                    finalList.add(diceResult.get(j));
                }
            }
        }
        Integer result = diceResult.size() - finalList.size();
        Integer expected = 2;
        Integer actual = result;

        Assert.assertEquals(expected, actual);

    }
    @Test
    public void endConditionTest(){

    }

    @Test
    public void takeTurn() {
    }

    @Test
    public void resolve() {
    }
}