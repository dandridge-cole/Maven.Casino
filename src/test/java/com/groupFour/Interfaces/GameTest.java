package com.groupFour.Interfaces;

import com.groupFour.Games.Craps;
import com.groupFour.Games.Spanish21;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void constructorTest() {
        Craps crapGame = new Craps();
        Assert.assertNotNull(crapGame.isDonePlaying());
    }

    @Test
    public void exit() {
        Spanish21 s21Game = new Spanish21();
        s21Game.exit();
        Assert.assertTrue(s21Game.isDonePlaying());
    }
}