package com.groupFour.Games;

import com.groupFour.*;
import com.groupFour.Interfaces.GamblingGame;
import com.groupFour.Wraps.BlackjackPlayer;

import java.util.HashMap;
import java.util.Map;

public class Blackjack extends GamblingGame {

    static final String gameName = "Blackjack";
    private Hand dealerHand;
    private Deck deck;
    private BlackjackPlayer player;
    private Console console = new Console(System.in, System.out);
    private HashMap<String, Integer> blackJackValue = new HashMap<String, Integer>();
    private int handValue;





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

    public void dealCards(){

    }

    public void dealCardToDealer(){
        Card card = this.deck.getCardFromDraw();
        this.dealerHand.addCard(card);
        console.println(card.toStringAbrev());
        console.println(dealerHand.handToString() + " Dealer has ");

    }

    public void dealCardToUser(){

    }

    public void resolve() {

    }

    public void validateBet() {

    }

    public void takeTurn() {

    }

    public void setup() {
        blackJackValue.put("TWO", 2);
        blackJackValue.put("THREE", 3);
        blackJackValue.put("FOUR", 4);
        blackJackValue.put("FIVE", 5);
        blackJackValue.put("SIX", 6);
        blackJackValue.put("SEVEN", 7);
        blackJackValue.put("EIGHT", 8);
        blackJackValue.put("NINE", 9);
        blackJackValue.put("TEN", 10);
        blackJackValue.put("JACK", 10);
        blackJackValue.put("KING", 10);
        blackJackValue.put("QUEEN", 10);
        blackJackValue.put("ACE", 1);


    }

    public int getHandValue() {
        return handValue;
    }

    public int setHandValue(Hand hand){
        handValue = 0;
        for (Card card:hand.getCards()){
            int value = blackJackValue.get(card.getRank().toString());
            handValue+= value;
        }
        Boolean containsAce=false;
        for(Card card: hand.getCards()){
            if (card.getRank()== Card.Rank.ACE) containsAce=true;
                if (containsAce && handValue<12)handValue+=10;
        }



        return handValue;


    }
}
