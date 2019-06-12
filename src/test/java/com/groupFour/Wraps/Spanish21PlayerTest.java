package com.groupFour.Wraps;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Spanish21PlayerTest {

    @Test
    public void getBalance() {
        //Given
        Double expected = 500.0;
        Spanish21Player spanish = new Spanish21Player(expected);
        //When
        Double actual = spanish.getBalance();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setBalance() {
        //Given
        Spanish21Player spanish = new Spanish21Player((double) 500);
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
        Spanish21Player spanish = new Spanish21Player(400.0);
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
        Spanish21Player spanish = new Spanish21Player(600.0);
        Double expectedBalance = 400.0;
        //When
        spanish.subtractFromBalance(200.0);
        Double actual = spanish.getBalance();
        //Then
        Assert.assertEquals(expectedBalance, actual);
    }
}