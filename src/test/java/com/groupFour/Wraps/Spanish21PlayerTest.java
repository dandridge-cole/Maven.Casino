package com.groupFour.Wraps;

import com.groupFour.Player;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Spanish21PlayerTest {

    @Test
    public void getBalance() {
        //Given
        Double expected = 500.0;
        Player player = new Player("Player 1", expected);
        Spanish21Player spanish = new Spanish21Player(player);
        //When
        Double actual = spanish.getBalance();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setBalance() {
        //Given
        Player player = new Player("Player 1", 500.0);
        Spanish21Player spanish = new Spanish21Player(player);
        Double expected = 400.0;
        //When
        spanish.setBalance(expected);
        Double actual = spanish.getBalance();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addToBalance() {
        //Given
        Player player = new Player("Player 1", 400.0);
        Spanish21Player spanish = new Spanish21Player(player);
        Double expectedbalance = 600.0;
        //When
        spanish.addToBalance(200.0);
        Double actual = spanish.getBalance();
        //Then
        Assert.assertEquals(expectedbalance, actual);
    }

    @Test
    public void subtractFromBalance() {
        //Given
        Player player = new Player("Player 1", 600.0);
        Spanish21Player spanish = new Spanish21Player(player);
        Double expectedBalance = 400.0;
        //When
        spanish.subtractFromBalance(200.0);
        Double actual = spanish.getBalance();
        //Then
        Assert.assertEquals(expectedBalance, actual);
    }
}