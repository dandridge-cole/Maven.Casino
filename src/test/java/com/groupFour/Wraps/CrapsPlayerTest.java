package com.groupFour.Wraps;

import com.groupFour.Player;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsPlayerTest {

    @Test
    public void getBalance() {
        //Given
        Double expected = 500.0;
        Player player = new Player("Player 1", expected);
       CrapsPlayer craps= new CrapsPlayer(player);
        //When
        Double actual = craps.getBalance();
        //Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void setBalance() {
        //Given
        Player player = new Player("Player 1", 500.0);
        CrapsPlayer craps = new CrapsPlayer(player);
        Double expected = 400.0;
        //When
        craps.setBalance(expected);
        Double actual = craps.getBalance();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addToBalance() {
        //Given
        Player player = new Player("Player 1", 400.0);
        CrapsPlayer craps = new CrapsPlayer(player);
        Double expectedbalance = 600.0;


        //When
        craps.addToBalance(200.0);
        Double actual = craps.getBalance();
        //Then
        Assert.assertEquals(expectedbalance, actual);
    }

    @Test
    public void subtractFromBalance() {
        //Given
        Player player = new Player("Player 1", 600.0);
        CrapsPlayer craps = new CrapsPlayer(player);
        Double expectedBalance = 400.0;
        //When
        craps.subtractFromBalance(200.0);
        Double actual = craps.getBalance();
        //Then
        Assert.assertEquals(expectedBalance, actual);
    }
}