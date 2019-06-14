package com.groupFour.Games;

import com.groupFour.*;
import com.groupFour.Interfaces.GamblingGame;
import com.groupFour.Interfaces.GamblingPlayer;
import com.groupFour.Wraps.BlackjackPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.groupFour.Wraps.BlackjackPlayer.hand;

public class Blackjack extends GamblingGame {

    static final String gameName = "Blackjack";
    public static Hand dealerHand;
    private static Deck deck;
    private BlackjackPlayer bjPlayer;
    private HashMap<String, Integer> blackJackValue = new HashMap<String, Integer>();
    private int handValue;
    private Console console;

    public Blackjack(BlackjackPlayer player) {
        this(new Console(System.in, System.out),player);
    }

    public Blackjack(Console console, BlackjackPlayer player) {
        super();
        this.console = console;
        this.bjPlayer = player;
        dealerHand=new Hand();
        deck=new Deck();
    }


    public Blackjack() {
        this(new BlackjackPlayer());
    }

    public void placeBet() {
        Double bet;
        bet = 0.0;
        while (bet<getMinBet() || bet>getMaxBet()) {
            bet = console.getDoubleInput("How much would you like to bet?\n" + "Current minimum bet: " + getMinBet() + "\n" + "Current max bet: " + getMaxBet());
        } setCurrentBet(bet);


    }

    public void dealCards(){
        dealCardToUser(2);
        dealCardToDealer(1);
        System.out.println("Player draws: \n" + BlackjackPlayer.hand.handToStringAbrev());
        System.out.println("Dealer shows: " + dealerHand.handToStringAbrev());
        dealCardToDealer(1);

    }

    public void dealCardToDealer(int drawSize){
        Card card;
        for (int j = 0; j< drawSize; j++) {
            card = deck.getCardFromDraw();
            dealerHand.addCard(card);
        }
    }

    public void dealCardToUser(int drawSize) {
        Card card;
        for (int j = 0; j < drawSize; j++) {
            card = deck.getCardFromDraw();
            hand.addCard(card);
        }
    }

    public void resolve() {

    }

    public boolean validateBet(double playerBalance) { //check if balance has enough to make minimum bet
        double minimumBet = getMinBet();
    return (playerBalance >= minimumBet);
    }

    public void takeTurn() {
        if (validateBet(bjPlayer.getBalance())){

        }

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

        setMaxBet(500.0);
        setMinBet(10.0);


    }

    public int calculateHandValue(Hand hand){
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
