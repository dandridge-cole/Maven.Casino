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
        CrapsPlayer play = new CrapsPlayer();
        Dice dice = new Dice(2);
        Craps game = new Craps(play, dice, in, false,7, true);
        //When
        dice.rollDice();
        Integer rollTotal = game.lastRollTotal();
        Boolean actual = game.checkComeOutWin(rollTotal, game.getPassLineBet());
        //Assert
        Assert.assertTrue((game.getPassLineBet() && (rollTotal == 7 || rollTotal == 11)) == actual);


    }

    @Test
    public void checkComeOutLoss() {
        //Given
        CrapsPlayer play = new CrapsPlayer();

        Craps game = new Craps(play, dice, in, false,7, true);
        //When
        dice.rollDice();
        Integer actual = dice.getDiceResult().get(0) + dice.getDiceResult().get(1);
        //Assert
        Assert.assertTrue(actual ==12 || actual==3 || actual ==2);


    }


    @Test
    public void placeBet() {
        //Given
        Double bet = 5.0;
        Integer value = 6;
        CrapsPlayer player = new CrapsPlayer();
        Craps game = new Craps(player, dice, in, false,value, true);

        //When
        game.placeBet(bet);
        Double actual = game.getCurrentBet();
        //Assert
        Assert.assertEquals(bet, actual);
    }

    @Test
    public void resolve() {
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
    public void lastRollTotal() {
        //Given

        Craps game = new Craps(new CrapsPlayer(x), dice, in, false,5, true);
        //When
        dice.rollDice();
        Integer actual = dice.getDiceResult().get(0) + dice.getDiceResult().get(1);
        //Assert
        Assert.assertTrue(actual <= 12 && actual >= 2);
    }
}