package com.groupFour.Games;

import com.groupFour.Dice;
import com.groupFour.Interfaces.GamblingGame;
import com.groupFour.Wraps.CrapsPlayer;

public class Craps extends GamblingGame {

    static final String gameName = "Craps";
    private Dice dice;
    private CrapsPlayer player;

    public Craps(CrapsPlayer player) {
        super();
        this.player = player;
        this.dice = new Dice(2);
    }
    public Craps() { this(new CrapsPlayer());}


    public void placeBet() {

    }

    public void resolve() {

    }

    public boolean validateBet(double bet) {
        return false;
    }

    public void takeTurn() {

    }

    public void setup() {

    }
}
