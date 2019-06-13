package com.groupFour.Games;

import com.groupFour.Deck;
import com.groupFour.Hand;
import com.groupFour.Interfaces.GamblingGame;
import com.groupFour.Wraps.Spanish21Player;

public class Spanish21 extends GamblingGame {

    static final String gameName = "Spanish 21";
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
