package com.groupFour.Wraps;

import com.groupFour.Player;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackjackPlayerTest {

    @Test
    public void getBalance() {
        //Given
        Double expected = 500.0;
        Player player = new Player("Player 1", expected);
        BlackjackPlayer jack = new BlackjackPlayer(player);
        //When
        Double actual = jack.getBalance();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setBalance() {
        //Given
        Double expected = 400.0;
        Player player = new Player("Player 1", expected);
        BlackjackPlayer jack = new BlackjackPlayer(player);
        //When
        jack.setBalance(expected);
        Double actual = jack.getBalance();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addToBalance() {
        //Given
        Player player = new Player("Player 1", 400.0);
        BlackjackPlayer jack = new BlackjackPlayer(player);
        Double expectedbalance = 600.0;


        //When
        jack.addToBalance(200.0);
        Double actual = jack.getBalance();
        //Then
        Assert.assertEquals(expectedbalance, actual);
    }

    @Test
    public void subtractFromBalance() {
        //Given
        Player player = new Player("Player 1", 600.0);
        BlackjackPlayer jack = new BlackjackPlayer(player);
        Double expectedBalance = 400.0;
        //When
        jack.subtractFromBalance(200.0);
        Double actual = jack.getBalance();
        //Then
        Assert.assertEquals(expectedBalance, actual);
    }
}