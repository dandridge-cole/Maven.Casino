package com.groupFour.Interfaces;

import com.groupFour.Console;
import com.groupFour.Games.Blackjack;
import com.groupFour.Games.Craps;
import com.groupFour.Games.Spanish21;
import org.junit.Assert;
import org.junit.Test;

public class GamblingGameTest {
    Console console = new Console(System.in,System.out);

    @Test
    public void getMaxBet() {
        Spanish21 s21Game = new Spanish21(console);
        Double expected = 50.00;
        s21Game.setMaxBet(expected);
        Double actual = s21Game.getMaxBet();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setMaxBet() {
        Spanish21 s21Game = new Spanish21(console);
        s21Game.setMinBet(10.00);
        Double expected = 150.00;
        s21Game.setMaxBet(expected);
        Double actual = s21Game.getMaxBet();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setMaxBetNegative() {
        Craps crapGame = new Craps(console);
        Double invalid = -150.00;
        crapGame.setMaxBet(invalid);
        Double expected=null;
        Double actual = crapGame.getMaxBet();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setMaxBetTooLow() { // can't allow maxBet < minBet
        Blackjack bjGame = new Blackjack(console);
        Double expected = null;
 //       bjGame.setMaxBet(expected);
        bjGame.setMinBet(30.00);
        Double invalid = 25.00;
        bjGame.setMaxBet(invalid);
        Double actual = bjGame.getMaxBet();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getMinBet() {
        Craps crapGame = new Craps(console);
        Double expected = 50.00;
        crapGame.setMinBet(expected);
        Double actual = crapGame.getMinBet();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setMinBet() {
        Craps crapGame = new Craps(console);
        crapGame.setMaxBet(500.00);
        Double expected = 150.00;
        crapGame.setMinBet(expected);
        Double actual = crapGame.getMinBet();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setMinBetNegative() {
        Blackjack bjGame = new Blackjack(console);
        bjGame.setMaxBet(500.00);
        Double invalid = -50.00;
        bjGame.setMinBet(invalid);
        Double expected=null;
        Double actual = bjGame.getMinBet();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setMinBetTooHigh() { // can't allow maxBet < minBet
        Blackjack bjGame = new Blackjack(console);
        bjGame.setMaxBet(5.00);
        Double invalid = 500.00;
        bjGame.setMinBet(invalid);
        Double expected=null;
        Double actual = bjGame.getMinBet();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getCurrentBet() {
        Blackjack bjGame = new Blackjack(console);
        bjGame.setMinBet(50.00);
        bjGame.setMaxBet(500.00);
        Double expected = 50.00;
        bjGame.setCurrentBet(expected);
        Double actual = bjGame.getCurrentBet();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setCurrentBet() {
        Blackjack bjGame = new Blackjack(console);
        bjGame.setMinBet(50.00);
        bjGame.setMaxBet(500.00);
        Double expected = 150.00;
        bjGame.setCurrentBet(expected);
        Double actual = bjGame.getCurrentBet();
        Assert.assertEquals(expected,actual);
    }
/*
    @Test
    public void setCurrentBetBeforeMax() {
        Spanish21 s21Game = new Spanish21();
        s21Game.setMinBet(50.00);
        Double invalidBet = 100.00;
        Double expected = null;
        s21Game.setCurrentBet(invalidBet);
        Double actual = s21Game.getCurrentBet();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setCurrentBetBeforeMin() {
        Spanish21 s21Game = new Spanish21();
        s21Game.setMaxBet(500.00);
        Double invalidBet = 100.00;
        Double expected = null;
        s21Game.setCurrentBet(invalidBet);
        Double actual = s21Game.getCurrentBet();
        Assert.assertEquals(expected,actual);
    }
*/
    @Test
    public void setCurrentBetTooHigh() {
        Spanish21 s21Game = new Spanish21(console);
        s21Game.setMinBet(50.00);
        s21Game.setMaxBet(500.00);
        Double invalidBet = 1000.00;
        Double expected = 1000.00;
        s21Game.setCurrentBet(invalidBet);
        Double actual = s21Game.getCurrentBet();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setCurrentBetTooLow() {
        Spanish21 s21Game = new Spanish21(console);
        s21Game.setMinBet(50.00);
        s21Game.setMaxBet(500.00);
        Double invalidBet = 10.00;
        Double expected = 50.00;
        s21Game.setCurrentBet(invalidBet);
        Double actual = s21Game.getCurrentBet();
        Assert.assertEquals(invalidBet,actual);
    }

/* I wasn't sure how and when validateBet would be called.  perhaps a few of these tests on setCurrentBet are unnecessary
    @Test
    public void setCurrentBetInsuficientFunds() {
        Spanish21 s21Game = new Spanish21();
        s21Game.setMinBet(50.00);
        s21Game.setMaxBet(500.00);
        Double invalidBet = 100.00;
        Double expected = null;
        s21Game.setCurrentBet(invalidBet);
        Double actual = s21Game.getCurrentBet();
        Assert.assertEquals(expected,actual);
    }*/
}