package com.groupFour;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class MediatorTest {

    private InputStream testInputStream;
    private Console console;

    @Test
    public void initWalletTest(){
        Double expected =50.0;
        testInputStream = new ByteArrayInputStream(expected.toString().getBytes());
        console = new Console(testInputStream,System.out);
        Player player = new Player("Player 1", null);
        Mediator med = new Mediator(console);
        med.initPlayerWallet(player);
        Double actual = player.getWallet();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void initPlayerTest(){
        String expected = "test data";
        testInputStream = new ByteArrayInputStream(expected.getBytes());
        console = new Console(testInputStream,System.out);
        Player player=new Player(null,null);
        Mediator med = new Mediator(console);
        med.initPlayer(player);
        String actual = player.getName();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void initAndBuildGamesMenu() {
        String expected = "test data";
        testInputStream = new ByteArrayInputStream(expected.getBytes());
        console = new Console(testInputStream,System.out);
        Mediator med = new Mediator(console);
        med.initGamesList();
        String actual = med.buildGamesMenu();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void confirmValidWalletIncrease() {
        Double expected =50.0;
        testInputStream = new ByteArrayInputStream(expected.toString().getBytes());
        console = new Console(testInputStream,System.out);
        Mediator med = new Mediator(console);
        Double invalid=-1.0;
        Player player = new Player("asdf",10.0);
        Double actual = med.confirmValidWalletIncrease(invalid,player);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void increaseBalance() {
        Double initialWallet = 50.0;
        Double increase = 25.0;
        Double expected =initialWallet+increase;
        Player player = new Player("asdf",initialWallet);
        testInputStream = new ByteArrayInputStream(increase.toString().getBytes());
        console = new Console(testInputStream,System.out);
        Mediator med = new Mediator(console,player);
        med.increaseBalance();
        Double actual = player.getWallet();
        Assert.assertEquals(expected,actual);
    }
}