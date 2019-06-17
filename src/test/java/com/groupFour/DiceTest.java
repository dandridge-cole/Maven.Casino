package com.groupFour;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DiceTest {
//    @Test
//    public void DiceNullTest(){
//        Dice dice = new Dice(0);
//        ArrayList<Integer> actual = dice.rollDice();
//        Integer expected = null;
//
//        Assert.assertNull(actual, expected);
//    }

    @Test
    public void rollDiceTest() {
        Dice dice = new Dice(1);
        int min = 1;
        int max = 6;
        ArrayList<Integer> temp = dice.rollDice();
        int actual = 0;
        for (int i: temp) {
            actual += i;
        }
        Assert.assertTrue(actual <= max);
        Assert.assertTrue(actual >= min);
    }

    @Test
    public void rollDiceTest2() {
        Dice dice = new Dice(2);
        int min = 2;
        int max = 12;
        ArrayList<Integer> temp = dice.rollDice();
        int actual = 0;
        for (int i: temp) {
            actual += i;
        }
        Assert.assertTrue(actual <= max);
        Assert.assertTrue(actual >= min);
    }

    @Test
    public void rollDiceTest3() {
        Dice dice = new Dice(3);
        int min = 3;
        int max = 18;

        ArrayList<Integer> temp = dice.rollDice();
        int actual = 0;
        for (int i: temp) {
            actual += i;
        }
        Assert.assertTrue(actual <= max);
        Assert.assertTrue(actual >= min);
    }

    @Test
    public void getDiceResultTest() {
        Dice dice = new Dice(3);
        dice.rollDice();
        ArrayList<Integer> diceResults = dice.getDiceResult();
        Integer actual = diceResults.size();
        Integer expected = 3;

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void getDiceResultTest2(){
        Integer max = 6;
        Integer min = 1;
        Dice dice = new Dice(3);
        Boolean expected = true;
        ArrayList<Integer> diceResults = dice.getDiceResult();
        for (Integer diceResult : diceResults) {
            if (diceResult < min || diceResult > max) {
                expected = false;
            }
            assertTrue(expected);
        }
    }

}
