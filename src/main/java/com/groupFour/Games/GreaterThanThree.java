package com.groupFour.Games;
import com.groupFour.Console;

import com.groupFour.Dice;
import com.groupFour.Interfaces.Game;
import com.groupFour.Player;

public class GreaterThanThree extends Game {

    public static final String gameName = "Greater than Three";
    private Dice dice;
    private Player player;
    private Console console;

    public GreaterThanThree(Player player, Console console){
        this.player = player;
        this.dice=new Dice(5);
        this.console=console;
    }

    public GreaterThanThree(Console console){
        this(new Player(),console);
    }

    public void reRoll(){

    }
    public void takeTurn() {

    }

    public void setup() {

    }

    public void placeBet(Double amount) {

    }

    public void resolve() {

    }

    public void validateBet() {

    }
}
