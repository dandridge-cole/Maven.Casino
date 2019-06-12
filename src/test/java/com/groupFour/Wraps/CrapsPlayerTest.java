package com.groupFour.Wraps;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsPlayerTest {

    @Test
    public void getBalance() {
        //Given
        Double expected = 500.0;
       CrapsPlayer craps= new CrapsPlayer(expected);
        //When
        Double actual = craps.getBalance();
        //Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void setBalance() {
        //Given
        CrapsPlayer craps = new CrapsPlayer((double) 500);
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

        CrapsPlayer craps = new CrapsPlayer(400.0);
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
        CrapsPlayer craps = new CrapsPlayer(600.0);
        Double expectedBalance = 400.0;
        //When
        craps.subtractFromBalance(200.0);
        Double actual = craps.getBalance();
        //Then
        Assert.assertEquals(expectedBalance, actual);
    }
}