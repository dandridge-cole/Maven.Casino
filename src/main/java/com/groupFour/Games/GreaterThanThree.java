package com.groupFour.Games;

import com.groupFour.Dice;
import com.groupFour.Interfaces.Game;
import com.groupFour.Player;

public class GreaterThanThree extends Game {

    private Dice dice;
    private Player player;

    public GreaterThanThree(Player player){
        this.player = player;
        this.dice=new Dice();
    }

    public GreaterThanThree(){this(new Player());}

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
