package com.groupFour.Games;

import com.groupFour.Dice;
import com.groupFour.Interfaces.GamblingGame;
import com.groupFour.Wraps.CrapsPlayer;

public class Craps extends GamblingGame {

    private Dice dice;
    private CrapsPlayer player;

    public Craps(CrapsPlayer player) {
        super();
        this.player = player;
        this.dice = new Dice(2);
    }
    public Craps() { this(new CrapsPlayer());}


    public void placeBet(Double amount) {

    }

    public void resolve() {

    }

    public void validateBet() {

    }

    public void takeTurn() {

    }

    public void setup() {

    }
}
