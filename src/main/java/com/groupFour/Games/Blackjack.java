package com.groupFour.Games;

import com.groupFour.Deck;
import com.groupFour.Hand;
import com.groupFour.Interfaces.GamblingGame;
import com.groupFour.Player;
import com.groupFour.Wraps.BlackjackPlayer;

public class Blackjack extends GamblingGame {

    static final String gameName = "Blackjack";
    private Hand dealerHand;
    private Deck deck;
    private BlackjackPlayer player;


    public Blackjack(BlackjackPlayer player) {
        super();
        this.player = player;
        this.dealerHand=new Hand();
        this.deck=new Deck();
    }


    public Blackjack() {
        this(new BlackjackPlayer());
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
