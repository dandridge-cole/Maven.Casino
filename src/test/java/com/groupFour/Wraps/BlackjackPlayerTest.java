package com.groupFour.Wraps;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackjackPlayerTest {

    @Test
    public void getBalance() {
        //Given
        Double expected = 500.0;
        BlackjackPlayer jack = new BlackjackPlayer(expected);
        //When
        Double actual = jack.getBalance();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setBalance() {
        //Given
        BlackjackPlayer jack = new BlackjackPlayer((double) 500);
        Double expected = 400.0;
        //When
        jack.setBalance(expected);
        Double actual = jack.getBalance();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addToBalance() {
        //Given

        BlackjackPlayer jack = new BlackjackPlayer(400.0);
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
        BlackjackPlayer jack = new BlackjackPlayer(600.0);
        Double expectedBalance = 400.0;
        //When
        jack.subtractFromBalance(200.0);
        Double actual = jack.getBalance();
        //Then
        Assert.assertEquals(expectedBalance, actual);
    }
}