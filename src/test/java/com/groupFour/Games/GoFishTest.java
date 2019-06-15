package com.groupFour.Games;

import com.groupFour.Console;
import com.groupFour.Deck;
import com.groupFour.Player;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class GoFishTest {
    private Console console;
    private InputStream input;

    @Test
    public void setupTest() {
        Integer expected = 1;
        input = new ByteArrayInputStream(expected.toString().getBytes());
        console = new Console(input, System.out );
        GoFish gofish = new GoFish(console);
        gofish.setup();
    }

    @Test
    public void getPlayerBinTest() {
        int[] player = {0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        int[] house = {0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1};
        GoFish game = new GoFish(new Console(System.in, System.out), new Deck(), house, player);
        int[] expectedPlayer = {0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        int[] actual =  game.getplayerBin();
        assertArrayEquals(expectedPlayer, actual);
   }

    @Test
    public void askForInputTest() {
        int[] player = {0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        int[] house = {0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1};
        GoFish game = new GoFish(new Console(System.in, System.out), new Deck(), house, player);
        game.askForInput();
    }

    @Test
    public void checkIfBinsContainTest() {
        int[] player = {0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        int[] house = {0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1};
        GoFish game = new GoFish(new Console(System.in, System.out), new Deck(), house, player);
        game.askedFor = 13;
        game.checkIfBinsContain();
        int expected = 1;
    }

    @Test
    public void decreaseBinsTest() {
        int[] player = {0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        int[] house = {0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1};
        GoFish game = new GoFish(new Console(System.in, System.out), new Deck(), house, player);
        game.decreaseBins(13, 1);
        int[] expectedHouse = {0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0};
        int[] actual =  game.getHouseBin();
        assertArrayEquals(expectedHouse, actual);
    }

    @Test
    public void addToBinsTest() {
        int[] player = {0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        int[] house = {0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1};
        GoFish game = new GoFish(new Console(System.in, System.out), new Deck(), house, player);
        game.addToBins(1, 1);
        int[] expectedPlayer = {0, 3, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        int[] actual =  game.getplayerBin();
        assertArrayEquals(expectedPlayer, actual);
   }

    @Test
    public void checkFor4Test() {
        int[] player = {0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        int[] house = {0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1};
        GoFish game = new GoFish(new Console(System.in, System.out), new Deck(), house, player);
        game.addToBins(1, 2);
        int[] expectedPlayer = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}; //check for 4 decrease bin to 0
        int[] actual =  game.getplayerBin();
    }

    @Test
    public void setWonMessage() {
    }

    @Test
    public void goFishMessage() {
        int[] player = {0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        int[] house = {0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1};
        GoFish game = new GoFish(new Console(System.in, System.out), new Deck(), house, player);
        game.goFish();
    }

    @Test
    public void drawCard() {
        int[] player = {0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        int[] house = {0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1};
        GoFish game = new GoFish(new Console(System.in, System.out), new Deck(), house, player);
        game.drawCard();
        int[] expectedPlayer = {0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2}; //check for 4 decrease bin to 0
        int[] actual =  game.getplayerBin();
        assertArrayEquals(expectedPlayer, actual); // new deck top card is King of Diamonds so 13s increase
    }

    @Test
    public void turnOverMessage() {
    }

    @Test
    public void evaluateBins() {
    }
}