package com.groupFour.Games;

import com.groupFour.Dice;
import com.groupFour.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GreaterThanThreeTest {
    Integer rollCount = 0;
    ArrayList<Integer> diceResult = new ArrayList<Integer>(5);
    ArrayList<Integer> finalList = new ArrayList<Integer>();

    @Test
    public void setupTest() {
        Dice dice = new Dice(5);
        dice.rollDice();

        Assert.assertNotNull(dice.rollDice());
    }

    @Test
    public void GTTconstructor() {
        // Given
        GreaterThanThree game = new GreaterThanThree();
        String expected = "Player 1";

        // When
        String actual = game.getPlayer().getName();

        // Assert
        Assert.assertEquals(expected, actual);
    }




//    @Test
//    public void rollCountTest(){
//        Dice dice = new Dice(5);
//        if(dice != null){rollCount++;}
//
//        Integer expected = 1;
//        Integer actual = rollCount;
//
//        Assert.assertEquals(expected,actual);
//    }

    @Test
    public void compareDiceResultTest() {
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
    public void reRollTest() {
        Dice reRollDice = new Dice(5 - finalList.size());

        Integer expected = 2;
        Integer actual = reRollDice.rollDice().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkRollCountTest() {
        Dice dice = new Dice(5);
        if(dice != null){rollCount++;}
        Dice dice2 = new Dice(5);
        if(dice != null){rollCount++;}
        Dice dice3 = new Dice(5);
        if(dice != null){rollCount++;}
        Dice dice4 = new Dice(5);
        if(dice != null){rollCount++;}

        Integer expected = 4;
        Integer actual = rollCount;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void takeTurnTest() {
        boolean result = diceResult.contains(finalList.get(1));
        Assert.assertTrue(result);
    }

    @Test
    public void takeTurnTest2(){
        boolean result = diceResult.contains(finalList.get(1));

        }


    @Test
    public void askIfRollAgainTest(){

    }

    @Test
    public void resolveTest() {
    }

    @Test
    public void endConditionCheckerTest() {

    }
}