package com.groupFour.Games;

import com.groupFour.Console;
import com.groupFour.Deck;
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
        Integer expected = 5;
        input = new ByteArrayInputStream(expected.toString().getBytes());
        console = new Console(input, System.out );
        GoFish gofish = new GoFish(console);
        gofish.setup();
    }

    @Test
    public void displayPlayerBinsTest() {
        GoFish gofish = new GoFish(console);
        gofish.viewHand();
    }

    @Test
    public void askForInputTest() {
        GoFish gofish = new GoFish(console);
        gofish.askForInput();
    }

    @Test
    public void checkIfBinsContain() {
    }

    @Test
    public void decreaseBins() {
    }

    @Test
    public void addToBins() {
    }

    @Test
    public void checkFor4() {
    }

    @Test
    public void setWonMessage() {
    }

    @Test
    public void goFishMessage() {
    }

    @Test
    public void drawCard() {
    }

    @Test
    public void turnOverMessage() {
    }

    @Test
    public void evaluateBins() {
    }
}