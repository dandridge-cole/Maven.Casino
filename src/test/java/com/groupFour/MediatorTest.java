package com.groupFour;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MediatorTest {


    @Test
    public void initWalletTest(){
        Player player = new Player("Player 1", null);
        Mediator med = new Mediator();
        med.initPlayerWallet(player);
        Assert.assertNotNull(player.getWallet());
    }

    @Test
    public void initPlayerTest(){
        Player player = null;
        Mediator med = new Mediator();
        med.initPlayer(player);
        Assert.assertNotNull(player);
    }
}