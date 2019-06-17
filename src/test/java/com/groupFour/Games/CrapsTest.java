package com.groupFour.Games;

import com.groupFour.Console;
import com.groupFour.Dice;
import com.groupFour.Interfaces.GamblingGame;
import com.groupFour.Player;
import com.groupFour.Wraps.CrapsPlayer;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsTest {

   private Player x = new Player();
   private Dice dice = new Dice(2);
   private Console in = new Console(System.in, System.out);

    @Test
    public void checkComeOutWin() {
        //Given
        Craps game = new Craps(new CrapsPlayer(x), dice, in, false,7, true);
        //When
        dice.rollDice();
        Integer lastRollTotal = game.lastRollTotal();
        Boolean actual = game.checkComeOutWin(lastRollTotal, game.getPassLineBet());
        //Assert
        if(game.getPassLineBet()){
            Assert.assertEquals((lastRollTotal == 7 || lastRollTotal == 11), actual);
        } else {
            Assert.assertEquals((lastRollTotal == 2 || lastRollTotal == 3 || lastRollTotal == 12), actual);
        }
    }

    @Test
    public void checkComeOutWin2craps() {
        //Given
        Craps game = new Craps(new CrapsPlayer(x), dice, in, false,7, false);
        //When
        dice.rollDice();
        Integer lastRollTotal = game.lastRollTotal();
        Boolean actual = game.checkComeOutWin(lastRollTotal, game.getPassLineBet());
        //Assert
        if(game.getPassLineBet()){
            Assert.assertEquals((lastRollTotal == 7 || lastRollTotal == 11), actual);
        } else {
            Assert.assertEquals((lastRollTotal == 2 || lastRollTotal == 3 || lastRollTotal == 12), actual);
        }
    }

    @Test
    public void checkComeOutLoss() {
        //Given
        Craps game = new Craps(new CrapsPlayer(x), dice, in, false,7, true);
        //When
        dice.rollDice();
        Integer lastRollTotal = game.lastRollTotal();
        Boolean actual = game.checkComeOutLoss(lastRollTotal, game.getPassLineBet());
        //Assert
        if(game.getPassLineBet()){
            Assert.assertEquals((lastRollTotal == 2 || lastRollTotal == 3 || lastRollTotal == 12), actual);
        } else {
            Assert.assertEquals((lastRollTotal == 7 || lastRollTotal == 11), actual);
        }
    }

    @Test
    public void checkComeOutLoss2() {
        //Given
        Craps game = new Craps(new CrapsPlayer(x), dice, in, false,7, false);
        //When
        dice.rollDice();
        Integer lastRollTotal = game.lastRollTotal();
        Boolean actual = game.checkComeOutLoss(lastRollTotal, game.getPassLineBet());
        //Assert
        if(game.getPassLineBet()){
            Assert.assertEquals((lastRollTotal == 2 || lastRollTotal == 3 || lastRollTotal == 12), actual);
        } else {
            Assert.assertEquals((lastRollTotal == 7 || lastRollTotal == 11), actual);
        }
    }

    @Test
    public void validateBet() {
        //Given
        Double minBet = 6.0;
        Double maxBet = 6000.0;
        Double balance = 200.0;
        Double placeBet = 50.0;
        CrapsPlayer value = new CrapsPlayer();
        Craps game = new Craps(value, dice, in, true,5, true);
        game.setMaxBet(maxBet);
        game.setMinBet(minBet);
        value.setBalance(balance);
        //When

        Boolean actual = game.validateBet(placeBet);
        //Assert
        Assert.assertTrue(actual);
    }
    @Test
    public void validateBet2() {
        //Given
        Double minBet = 6.0;
        Double maxBet = 6000.0;
        Double balance = 200.0;
        Double placeBet = 5.0;
        CrapsPlayer value = new CrapsPlayer();
        Craps game = new Craps(value, dice, in, true,5, true);
        game.setMaxBet(maxBet);
        game.setMinBet(minBet);
        value.setBalance(balance);
        //When

        Boolean actual = game.validateBet(placeBet);
        //Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void takeTurn() {
    }

    @Test
    public void resolveTest(){
        // Given
        Double expectedBet = 10d;
        Craps game = new Craps(new CrapsPlayer(x), dice, in, true,5, true);
        game.setCurrentBet(expectedBet);
        Double initial = game.getPlayer().getBalance();
        // When
        game.resolve();
        Double actual = game.getPlayer().getBalance();
        // Assert
        Assert.assertEquals(expectedBet, (Double) ((actual - initial)/2));
    }

    @Test
    public void setup() {
        //Given
        Double minBet = 4.0;
        Double maxBet = 5000.0;
        CrapsPlayer value = new CrapsPlayer();
        Craps game = new Craps(value, dice, in, true,5, true);
        //When
        game.setup(minBet, maxBet);
        Double actualMax = game.getMaxBet();
        Double actualMin = game.getMinBet();

        //Assert
        Assert.assertEquals(minBet, actualMin);
        Assert.assertEquals(maxBet, actualMax);

    }

    @Test
    public void getPlayer() {
        //Given
        CrapsPlayer value = new CrapsPlayer();
        Craps game = new Craps(value, dice, in, true,5, true);
        //When
        CrapsPlayer actual = game.getPlayer();
        //Assert
        Assert.assertEquals(value, actual);
    }

    @Test
    public void getDice() {
        //Given
        Dice value = new Dice(2);
        Craps game = new Craps(new CrapsPlayer(x), value, in, true,5, true);
        //When
        Dice actual = game.getDice();
        //Assert
        Assert.assertEquals(value, actual);


    }

    @Test
    public void getDisplay() {
        //Given
        Console value = new Console(System.in, System.out);
        Craps game = new Craps(new CrapsPlayer(x), dice, value, true,5, true);
        //When
        Console actual = game.getDisplay();
        //Assert
        Assert.assertEquals(value, actual);
    }

    @Test
    public void getPointPhaseState() {
        //Given
        Boolean value = true;
        Craps game = new Craps(new CrapsPlayer(x), dice, in, value,5, true);
        //When
        Boolean actual = game.getPointPhaseState();
        //Assert
        Assert.assertEquals(value, actual);
    }

    @Test
    public void getPointNum() {
        //Given
        Integer value = 6;
        Craps game = new Craps(new CrapsPlayer(x), dice, in, false,value, true);
        //When
        Integer actual = game.getPointNum();
        //Assert
        Assert.assertEquals(value, actual);
    }

    @Test
    public void getPassLineBet() {
        //Given
        Boolean value = true;
        Craps game = new Craps(new CrapsPlayer(x), dice, in, false,5, value);
        //When
        Boolean actual = game.getPassLineBet();
        //Assert
        Assert.assertEquals(value, actual);
    }

    @Test
    public void setPassLineBet() {
        //Given
        Boolean value = true;
        Craps game = new Craps(new CrapsPlayer(x), dice, in, false,5, null);

        //When
        game.setPassLineBet(value);
        Boolean actual = game.getPassLineBet();
        //Assert
        Assert.assertEquals(value, actual);
    }

    @Test
    public void lastRollTotalTest() {
        //Given
        Craps game = new Craps(new CrapsPlayer(x), dice, in, false,5, true);
        //When
        dice.rollDice();
        Integer actual = dice.getDiceResult().get(0) + dice.getDiceResult().get(1);
        //Assert
        Assert.assertTrue(actual <= 12 && actual >= 2);
    }

    @Test
    public void constructorTestAll() {
        //Given
        CrapsPlayer expectedCP = new CrapsPlayer(x);
        Dice expectedDice = dice;
        Console expectedConsole = in;
        Boolean expPS = false;
        Integer expPN = 0;
        Boolean expPL = false;
        Object[] expectedArr = {expectedCP, expectedDice, expectedConsole, expPS, expPN, expPL};
        //When
        Craps game = new Craps(expectedCP, expectedDice, expectedConsole, expPS, expPN, expPL);
        Object[] actualArr = {game.getPlayer(), game.getDice(), game.getDisplay(), game.getPointPhaseState(),
            game.getPointNum(), game.getPassLineBet()};
        //Assert
        Assert.assertArrayEquals(expectedArr, actualArr);
    }

    @Test
    public void constructorTest2() {
        //Given
        CrapsPlayer expectedCP = new CrapsPlayer(x);
        Console expectedConsole = in;
        Object[] expectedArr = {expectedCP,expectedConsole};
        //When
        Craps game = new Craps(expectedCP, expectedConsole);
        Object[] actualArr = {game.getPlayer(), game.getDisplay()};
        //Assert
        Assert.assertArrayEquals(expectedArr, actualArr);
    }

    @Test
    public void constructorTestDefault() {
        //Given
        Console expectedConsole = in;
        //When
        Craps game = new Craps(expectedConsole);
        Console actualConsole = game.getDisplay();
        //Assert
        Assert.assertEquals(expectedConsole, actualConsole);
    }

    @Test
    public void SetBetTest(){
        // Given
        Double expected = 15.00;
        Craps game = new Craps(new CrapsPlayer(x), dice, in, false,5, null);
        // When
        game.setBet(expected);
        Double actual = game.getCurrentBet();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void pointRollResult(){
        // Given
        Integer pointNum = 5;
        Craps game = new Craps(new CrapsPlayer(x), dice, in, false, pointNum, true);
        dice.rollDice();
        // When
        Boolean actual = game.pointRollResult(pointNum, game.getPassLineBet());
        //
        if(game.getPassLineBet()){
            if(game.lastRollTotal() == pointNum){
                Assert.assertTrue(actual);
            } else {
                Assert.assertFalse(actual);
            }
        } else if(!game.getPassLineBet()){
            if(game.lastRollTotal() == pointNum){
                Assert.assertFalse(actual);
            } else {
                Assert.assertTrue(actual);
            }
        }
    }

    @Test
    public void pointRollResultLoseTest(){
        // Given
        Integer pointNum = 5;
        Craps game = new Craps(new CrapsPlayer(x), dice, in, false, pointNum, true);
        dice.rollDice();
        // When
        Boolean actual = game.pointRollResultLose(pointNum, game.getPassLineBet());
        //
        if(game.getPassLineBet()){
            if(game.lastRollTotal() == 7){
                Assert.assertTrue(actual);
            } else {
                Assert.assertFalse(actual);
            }
        } else if(!game.getPassLineBet()){
            if(game.lastRollTotal() == pointNum){
                Assert.assertTrue(actual);
            } else {
                Assert.assertFalse(actual);
            }
        }
    }
}