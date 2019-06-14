package com.groupFour.Games;

import com.groupFour.Deck;
import com.groupFour.Hand;
import com.groupFour.Interfaces.GamblingGame;
import com.groupFour.Wraps.Spanish21Player;

public class Spanish21 extends GamblingGame {

    public static final String gameName = "Spanish 21";
    private Hand dealerHand;
    private Deck deck;
    private Spanish21Player player;

    public Spanish21(Spanish21Player player){
        super();
        this.player = player;
        this.dealerHand=new Hand();
        this.deck=new Deck();
    }

    public Spanish21(){this(new Spanish21Player());}

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
