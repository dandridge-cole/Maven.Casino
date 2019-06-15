package com.groupFour.Games;
import com.groupFour.*;
import com.groupFour.Interfaces.GamblingGame;
import com.groupFour.Interfaces.Game;
import com.groupFour.Wraps.BlackjackPlayer;
import java.util.HashMap;
import static com.groupFour.Wraps.BlackjackPlayer.playerHand;

public class Blackjack extends GamblingGame {

    public static final String gameName = "Blackjack";
    protected static Hand dealerHand;
    private static Deck deck;
    private BlackjackPlayer bjPlayer;
    private HashMap<String, Integer> blackJackValue = new HashMap<>();
    private int handValue;
    private Console console;
    protected int gameCount;

    public Blackjack(BlackjackPlayer player, Console console) {
        super();
        this.console = console;
        this.bjPlayer = player;
        dealerHand=new Hand();
        deck=new Deck();
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

    public Blackjack(Console console) {
        this(new BlackjackPlayer(),console);
    }

    public void setup() {
        while (!isDonePlaying()){
            int option = 0;
            option = console.getIntegerInput("Enter 1 to Sit at the table or 2 to exit back to the lobby.");
            if (option == 1){
                takeTurn();
            }else if (option == 2){
                exit();
            }else{
                setup();
            }
        }
    }

    public boolean validateBet(double playerBalance) { //check if balance has enough to make minimum bet
        double minimumBet = getMinBet();
        return (playerBalance >= minimumBet);
    }

    public void takeTurn() {
        setMaxBet(500.0);
        setMinBet(10.0);
        setCurrentBet(0.0);
        if (validateBet(bjPlayer.getBalance())){
            System.out.println(gameCount);
            playerHand = new Hand();
            dealerHand = new Hand();
            deck = new Deck();
            deck.shuffle();
            placeBet();
            dealCards();
            resolve();
        }else{
            System.out.println("You don't have enough to make a bet!");
            setup();
        }
    }

    public void placeBet() {
        Double bet;
        bet = 0.0;
        while (bet<getMinBet() || bet>getMaxBet()) {
            bet = console.getDoubleInput("How much would you like to bet?\n" + "Current minimum bet: " + getMinBet() + "\n" + "Current max bet: " + getMaxBet() + "\n Enter 1 to Exit ");
            if (bet > bjPlayer.getBalance()){
                System.out.println("Not enough to place that bet.");
                placeBet();
            }else {
                setCurrentBet(bet);
            }
        }
    }

    public void dealCards(){
        dealCard(2, playerHand);
        dealCard(1, dealerHand);
        System.out.println("Player draws: \n" + BlackjackPlayer.playerHand.handToStringAbrev());
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
                System.out.println("Player draws: \n" + BlackjackPlayer.playerHand.handToStringAbrev());
                checkForBust(playerHand);
                resolve();
                break;

            case 2: //stay
                dealerChoice();
                break;

            case 3: //double
                if (getCurrentBet()*2 > bjPlayer.getBalance()){
                    System.out.println("Not enough to boule");
                    resolve();
                }else {
                    dealCard(1, playerHand);
                    setCurrentBet(getCurrentBet() * 2);
                    System.out.println("Player Doubled Down: \n" + BlackjackPlayer.playerHand.handToStringAbrev());
                    checkForBust(playerHand);
                    dealerChoice();
                    break;
                }
        }
    }
    public void dealerChoice(){
        while (calculateHandValue(dealerHand) < 17) {
            dealCard(1, dealerHand);
            }
        if (calculateHandValue(dealerHand) >21 ){
                printHands();
                System.out.println("DEALER BUSTS!");
                bjPlayer.addToBalance(getCurrentBet());
                System.out.println("Remaining Balance: $" + bjPlayer.getBalance());
                takeTurn();
        } else if (calculateHandValue(dealerHand) > calculateHandValue(playerHand)){
                printHands();
                bjPlayer.subtractFromBalance(getCurrentBet());
                System.out.println("Dealer Wins \n Remaining Balance: $" + bjPlayer.getBalance());
                takeTurn();
        } else if (calculateHandValue(dealerHand) < calculateHandValue(playerHand)){
                printHands();
                bjPlayer.addToBalance(getCurrentBet());
                System.out.println("You win!\n" + "Remaining balance: " + bjPlayer.getBalance());
                takeTurn();
        } else {
                printHands();
                System.out.println("PUSH!\n" + "Remaining balance: " + bjPlayer.getBalance());
                takeTurn();
            }
    }

    public void resolve() {
            if (handValue == 21) {
                System.out.println("Congrats! You won: " + getCurrentBet());
                bjPlayer.addToBalance(getCurrentBet());
            } else {
                int option = 0;
                option = console.getIntegerInput("Enter 1 to Hit\n" + "Enter 2 to Stay \n" + "Enter 3 to Double");
                playerOptions(option);
            }
    }

    public int calculateHandValue(Hand hand){
        handValue = 0;
        for (Card card:hand.getCards()){
            int value = blackJackValue.get(card.getRank().toString());
            handValue+= value;
        }
        Boolean containsAce=false;
        for(Card card: hand.getCards()) {
            if (card.getRank() == Card.Rank.ACE) containsAce = true;
            if (containsAce && handValue < 12) handValue += 10;
        }return handValue;
    }

    public void checkForDealerBj(){
        if (calculateHandValue(dealerHand) == 21){
            System.out.println(dealerHand.handToStringAbrev());
            System.out.println("Dealer got BlackJack! You Lose!\n" + "Remaining balance: " + bjPlayer.getBalance());
            bjPlayer.subtractFromBalance(getCurrentBet());
            takeTurn();
        }
    }

    public void checkForUserBj(){
        if (calculateHandValue(playerHand) == 21){
            System.out.println(playerHand.handToStringAbrev());
            bjPlayer.addToBalance(getCurrentBet());
            System.out.println("You got BlackJack!\n" + "Remaining balance: " + bjPlayer.getBalance());
            takeTurn();
        }
    }

    public void checkForBust(Hand hand){
        if (calculateHandValue(hand)>21){
            printHands();
            System.out.println("BUST!");
            bjPlayer.subtractFromBalance(getCurrentBet());
            System.out.println("Remaining Balance: $" + bjPlayer.getBalance());
            takeTurn();
        }
    }

    public void printHands(){
        System.out.println("Player playerHand: \n" + playerHand.handToStringAbrev());
        System.out.println("Dealer playerHand: \n" + dealerHand.handToStringAbrev());
    }
}
