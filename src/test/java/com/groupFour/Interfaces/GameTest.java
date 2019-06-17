package com.groupFour.Interfaces;

import com.groupFour.Console;
import com.groupFour.Games.Craps;
import com.groupFour.Games.Spanish21;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {
    Console console = new Console(System.in,System.out);

    @Test
    public void constructorTest() {
        Craps crapGame = new Craps(console);
        Assert.assertNotNull(crapGame.isDonePlaying());
    }

    @Test
    public void exit() {
        Spanish21 s21Game = new Spanish21(console);
        s21Game.exit();
        Assert.assertTrue(s21Game.isDonePlaying());
    }
}