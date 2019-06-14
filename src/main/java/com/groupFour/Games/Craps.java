package com.groupFour.Games;
import com.groupFour.Console;

import com.groupFour.Dice;
import com.groupFour.Interfaces.GamblingGame;
import com.groupFour.Wraps.CrapsPlayer;

public class Craps extends GamblingGame {

    public static final String gameName = "Craps";
    private Dice dice;
    private CrapsPlayer player;
    private Console console;

    public Craps(CrapsPlayer player, Console console) {
        super();
        this.player = player;
        this.dice = new Dice(2);
        this.console=console;
    }
    public Craps(Console console) {
        this(new CrapsPlayer(),console);
    }


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
