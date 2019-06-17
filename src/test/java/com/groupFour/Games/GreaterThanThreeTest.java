package com.groupFour.Games;

import com.groupFour.Console;
import com.groupFour.Dice;
import com.groupFour.Player;
//import com.sun.tools.classfile.ConstantPool;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GreaterThanThreeTest {

    Console console = new Console(System.in, System.out);
    Integer rollCount = 0;
    //ArrayList<Integer> diceResult = new ArrayList<Integer>(5);
    ArrayList<Integer> finalList = new ArrayList<Integer>();


    @Test
    public void GTTconstructor() {
        // Given
        GreaterThanThree game = new GreaterThanThree(console);
        String expected = "Player 1";

        // When
        String actual = game.getPlayer().getName();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setupTest() {
        Dice dice = new Dice(5);
        dice.rollDice();

        Assert.assertNotNull(dice.rollDice());
    }

    @Test
    public void setupTest2() {
        GreaterThanThree game = new GreaterThanThree(console);
        boolean expected = game.isDonePlaying();

        Assert.assertFalse(expected);
    }

    @Test
    public void takeTurnTest() {
        GreaterThanThree game = new GreaterThanThree(console);
        boolean expected = game.win;

        Assert.assertFalse(expected);
    }

    @Test
    public void takeTurnTest2(){
        GreaterThanThree game = new GreaterThanThree(console);
        Integer expected = 1;
        Integer actual = game.rollCount;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void takeTurnTest3(){
        GreaterThanThree game = new GreaterThanThree(console);
        boolean expected = game.rollCount < 4;

        Assert.assertTrue(expected);
    }

    @Test
    public void takeTurnTest4(){
        GreaterThanThree game = new GreaterThanThree(console);
        Integer expected = 5;
        Integer actual = game.dice.rollDice().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void takeTurnTest5(){
        GreaterThanThree game = new GreaterThanThree(console);
        Assert.assertNotSame(game.theDice, game.dice);


    }

    @Test
    public void compareDiceResultsTest(){
        //given
        GreaterThanThree game = new GreaterThanThree(console);
        Integer expected = 7;
        Integer actual = game.theDice.length;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareDiceResultTest2(){
        GreaterThanThree game = new GreaterThanThree(console);
        Integer expected = 0;
        Integer actual = game.finalList.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareDiceResultTest3() {
        GreaterThanThree game = new GreaterThanThree(console);
        boolean actual = game.win;

        Assert.assertFalse(actual);
    }

    @Test
    public void compareDiceResultTest4(){
        GreaterThanThree game = new GreaterThanThree(console);
        Assert.assertNotNull(game.theDice);
    }

    @Test
    public void whichDiceToKeepTest(){
        GreaterThanThree game = new GreaterThanThree(console);
        Integer expected = 0;
        Integer actual = game.numDiceKept;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void whichDiceToKeepTest2(){
        GreaterThanThree game = new GreaterThanThree(console);
        Integer expected = null;
        Integer actual = game.whichDiceToKeep;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void whichDiceToKeepTest3(){
        GreaterThanThree game = new GreaterThanThree(console);

    }

    @Test
    public void getPlayerTest() {
        GreaterThanThree game = new GreaterThanThree(console);
       Assert.assertNotNull(game.getPlayer().getName());
    }


////    @Test
////    public void rollCountTest(){
////        Dice dice = new Dice(5);
////        if(dice != null){rollCount++;}
////
////        Integer expected = 1;
////        Integer actual = rollCount;
////
////        Assert.assertEquals(expected,actual);
////    }
//
//    @Test
//    public void compareDiceResultTest() {
//        for (int i = 0; i < diceResult.size(); i++) {
//            for (int j = i + 1; j < diceResult.size(); j++) {
//                if (diceResult.get(i).equals(diceResult.get(j))) {
//                    finalList.add(i);
//                }
//            }
//        }
//        Assert.assertTrue(finalList != diceResult);
//    }
//
//    @Test
//    public void reRollTest() {
//        Dice reRollDice = new Dice(5 - finalList.size());
//
//        Integer expected = 2;
//        Integer actual = reRollDice.rollDice().size();
//
//        Assert.assertEquals(expected,actual);
//    }
//
//    @Test
//    public void checkRollCountTest() {
//        Dice dice = new Dice(5);
//        if(dice != null){rollCount++;}
//        Dice dice2 = new Dice(5);
//        if(dice != null){rollCount++;}
//        Dice dice3 = new Dice(5);
//        if(dice != null){rollCount++;}
//        Dice dice4 = new Dice(5);
//        if(dice != null){rollCount++;}
//
//        Integer expected = 4;
//        Integer actual = rollCount;
//
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void takeTurnTest() {
//        boolean result = diceResult.contains(finalList.get(1));
//        Assert.assertTrue(result);
//    }
//
//    @Test
//    public void takeTurnTest2(){
//        boolean result = diceResult.contains(finalList.get(1));
//
//        }
//
//
//    @Test
//    public void askIfRollAgainTest(){
//
//    }
//
//    @Test
//    public void resolveTest() {
//    }
//
//    @Test
//    public void endConditionCheckerTest() {
//
//    }


////    @Test
////    public void rollCountTest(){
////        Dice dice = new Dice(5);
////        if(dice != null){rollCount++;}
////
////        Integer expected = 1;
////        Integer actual = rollCount;
////
////        Assert.assertEquals(expected,actual);
////    }
//
//    @Test
//    public void compareDiceResultTest() {
//        for (int i = 0; i < diceResult.size(); i++) {
//            for (int j = i + 1; j < diceResult.size(); j++) {
//                if (diceResult.get(i).equals(diceResult.get(j))) {
//                    finalList.add(i);
//                }
//            }
//        }
//        Assert.assertTrue(finalList != diceResult);
//    }
//
//    @Test
//    public void reRollTest() {
//        Dice reRollDice = new Dice(5 - finalList.size());
//
//        Integer expected = 2;
//        Integer actual = reRollDice.rollDice().size();
//
//        Assert.assertEquals(expected,actual);
//    }
//
//    @Test
//    public void checkRollCountTest() {
//        Dice dice = new Dice(5);
//        if(dice != null){rollCount++;}
//        Dice dice2 = new Dice(5);
//        if(dice != null){rollCount++;}
//        Dice dice3 = new Dice(5);
//        if(dice != null){rollCount++;}
//        Dice dice4 = new Dice(5);
//        if(dice != null){rollCount++;}
//
//        Integer expected = 4;
//        Integer actual = rollCount;
//
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void takeTurnTest() {
//        boolean result = diceResult.contains(finalList.get(1));
//        Assert.assertTrue(result);
//    }
//
//    @Test
//    public void takeTurnTest2(){
//        boolean result = diceResult.contains(finalList.get(1));
//
//        }
//
//
//    @Test
//    public void askIfRollAgainTest(){
//
//    }
//
//    @Test
//    public void resolveTest() {
//    }
//
//    @Test
//    public void endConditionCheckerTest() {
//
//    }
}