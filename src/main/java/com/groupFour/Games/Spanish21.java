package com.groupFour.Games;
import com.groupFour.*;
import com.groupFour.Interfaces.GamblingGame;
import com.groupFour.Wraps.Spanish21Player;
import java.util.HashMap;

import static com.groupFour.Wraps.BlackjackPlayer.playerHand;
import static com.groupFour.Wraps.Spanish21Player.*;

public class Spanish21 extends GamblingGame {

    public static final String gameName = "spanish21";
    protected static Hand dealerHand;
    private static Deck deck;
    private Spanish21Player spanishPlayer;
    private HashMap<String, Integer> spanish21Value = new HashMap<>();
    private int handValue;
    private Console console;

    public Spanish21(Spanish21Player player, Console console) {
        super();
        this.console = console;
        this.spanishPlayer = player;
        dealerHand=new Hand();
        deck=new Deck();
        spanish21Value.put("TWO", 2);
        spanish21Value.put("THREE", 3);
        spanish21Value.put("FOUR", 4);
        spanish21Value.put("FIVE", 5);
        spanish21Value.put("SIX", 6);
        spanish21Value.put("SEVEN", 7);
        spanish21Value.put("EIGHT", 8);
        spanish21Value.put("NINE", 9);
        spanish21Value.put("TEN", 10);
        spanish21Value.put("JACK", 10);
        spanish21Value.put("KING", 10);
        spanish21Value.put("QUEEN", 10);
        spanish21Value.put("ACE", 1);
    }

    public Spanish21(Console console) {
        this(new Spanish21Player(),console);
    }

    public void setup() {
        while (!isDonePlaying()){
            int option = 0;
            option = console.getIntegerInput("Enter 1 to Sit at the table or 2 to exit back to the lobby.");
            if (option == 1){
                takeTurn();
            }else if (option == 2){
                isDonePlaying();
            }else{
                exit();
            }
        }exit();
    }

    public boolean validateBet(double playerBalance) { //check if balance has enough to make minimum bet
        double minimumBet = getMinBet();
        return (playerBalance >= minimumBet);
    }

    public void takeTurn() {
        setMaxBet(500.0);
        setMinBet(10.0);
        setCurrentBet(0.0);
        if (validateBet(spanishPlayer.getBalance())){
            playerHand = new Hand();
            dealerHand = new Hand();
            deck = new Deck();
            modifyDeck();
            deck.shuffle();
            placeBet();
            dealCards();
            resolve();
        }else{
            System.out.println("You don't have enough to make a bet!");
            exit();
        }
    }

    public void placeBet() {
        Double bet;
        bet = 0.0;
        while (bet<getMinBet() || bet>getMaxBet()) {
            bet = console.getDoubleInput("How much would you like to lose?\n" + "Current minimum bet: " + getMinBet() + "\n" + "Current max bet: " + getMaxBet() + "\n Enter 1 to Exit ");
            if (bet == 1){
                setup();
            }
        } setCurrentBet(bet);
    }

    public void dealCards(){
        dealCard(2, playerHand);
        dealCard(1, dealerHand);
        System.out.println("Player draws: \n" + playerHand.handToStringAbrev());
        System.out.println("Dealer shows: " + dealerHand.handToStringAbrev());
        dealCard(1, dealerHand);
        checkForUserBj();
        checkForDealerBj();
    }

    public void dealCard(int drawSize, Hand hand){
        Card card;
        for (int j = 0; j< drawSize; j++) {
            card = deck.getCardFromDraw();
            hand.addCard(card);
        }
    }

    public void playerOptions(int choice){
        switch (choice) {
            case 1: //hit
                dealCard(1, playerHand);
                System.out.println("Player draws: \n" + playerHand.handToStringAbrev());
                checkForBust(playerHand);
                resolve();
                break;

            case 2: //stay
                dealerChoice();
                break;

            case 3: //double
                dealCard(1, playerHand);
                setCurrentBet(getCurrentBet()*2);
                System.out.println("Player Doubled Down: \n" + playerHand.handToStringAbrev());
                checkForBust(playerHand);
                dealerChoice();
                break;
        }
    }
    public void dealerChoice(){
        while (calculateHandValue(dealerHand) < 17) {
            dealCard(1, dealerHand);
        }
        if (calculateHandValue(dealerHand) >21 ){
            printHands();
            System.out.println("DEALER BUST!");
            spanishPlayer.addToBalance(getCurrentBet());
            System.out.println("Remaining Balance: $" + spanishPlayer.getBalance());
            takeTurn();
        } else if (calculateHandValue(dealerHand) > calculateHandValue(playerHand)){
            printHands();
            spanishPlayer.subtractFromBalance(getCurrentBet());
            System.out.println("Dealer Wins! \n Remaining Balance: $" + spanishPlayer.getBalance());
            takeTurn();
        } else if (calculateHandValue(dealerHand) < calculateHandValue(playerHand)){
            printHands();
            spanishPlayer.addToBalance(getCurrentBet());
            System.out.println("You Win!\n" + "Remaining balance: " + spanishPlayer.getBalance());
            takeTurn();
        } else {
            printHands();
            System.out.println("PUSH!\n" + "Remaining balance: " + spanishPlayer.getBalance());
            takeTurn();
        }
    }

    public void resolve() {
        if (handValue == 21) {
            System.out.println("Congrats! You won: " + getCurrentBet());
            spanishPlayer.addToBalance(getCurrentBet());
        } else {
            int option = 0;
            option = console.getIntegerInput("Enter 1 to Hit\n" + "Enter 2 to Stay \n" + "Enter 3 to Double");
            playerOptions(option);
        }
    }

    public int calculateHandValue(Hand hand){
        handValue = 0;
        for (Card card:hand.getCards()){
            int value = spanish21Value.get(card.getRank().toString());
            handValue+= value;
        }
        Boolean containsAce=false;
        for(Card card: hand.getCards()) {
            if (card.getRank() == Card.Rank.ACE) containsAce = true;
            if (containsAce && handValue < 12) handValue += 10;
        }return handValue;
    }

    public void modifyDeck(){
            deck.removeCardsFromDraw(Card.Rank.TEN);
    }

    public void checkForDealerBj(){
        if (calculateHandValue(dealerHand) == 21){
            System.out.println(dealerHand.handToStringAbrev());
            System.out.println("Dealer got 21! You Lose!\n" + "Remaining balance: " + spanishPlayer.getBalance());
            spanishPlayer.subtractFromBalance(getCurrentBet());
            takeTurn();
        }
    }

    public void checkForUserBj(){
        if (calculateHandValue(playerHand) == 21){
            System.out.println(playerHand.handToStringAbrev());
            spanishPlayer.addToBalance(getCurrentBet());
            System.out.println("You got 21!\n" + "Remaining balance: " + spanishPlayer.getBalance());
            takeTurn();
        }
    }

    public void checkForBust(Hand hand){
        if (calculateHandValue(hand)>21){
            printHands();
            System.out.println("BUST!");
            spanishPlayer.subtractFromBalance(getCurrentBet());
            System.out.println("Remaining Balance: $" + spanishPlayer.getBalance());
            takeTurn();
        }
    }

    public void printHands(){
        System.out.println("Player playerHand: \n" + playerHand.handToStringAbrev());
        System.out.println("Dealer playerHand: \n" + dealerHand.handToStringAbrev());
    }
}
