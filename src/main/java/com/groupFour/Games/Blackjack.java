package com.groupFour.Games;

import com.groupFour.Console;
import com.groupFour.Deck;
import com.groupFour.Hand;
import com.groupFour.Interfaces.GamblingGame;
import com.groupFour.Wraps.BlackjackPlayer;

public class Blackjack extends GamblingGame {

    public static final String gameName = "Blackjack";
    private Hand dealerHand;
    private Deck deck;
    private BlackjackPlayer player;
    private Console console;


    public Blackjack(BlackjackPlayer player, Console console) {
        super();
        this.player = player;
        this.dealerHand=new Hand();
        this.deck=new Deck();
        this.console=console;
    }


    public Blackjack(Console console) {
        this(new BlackjackPlayer(),console);
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
