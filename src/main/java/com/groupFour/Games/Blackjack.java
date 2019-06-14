package com.groupFour.Games;
import com.groupFour.*;
import com.groupFour.Interfaces.GamblingGame;
import com.groupFour.Wraps.BlackjackPlayer;
import java.util.HashMap;
import static com.groupFour.Wraps.BlackjackPlayer.hand;

public class Blackjack extends GamblingGame {

    public static final String gameName = "Blackjack";
    public static Hand dealerHand;
    private static Deck deck;
    private BlackjackPlayer bjPlayer;
    private HashMap<String, Integer> blackJackValue = new HashMap<>();
    private int handValue;
    private Console console;

    public Blackjack(BlackjackPlayer player, Console console) {
        super();
        this.console = console;
        this.bjPlayer = player;
        dealerHand=new Hand();
        deck=new Deck();

        blackJackValue.put("TWO", 2);blackJackValue.put("THREE", 3);blackJackValue.put("FOUR", 4);blackJackValue.put("FIVE", 5);blackJackValue.put("SIX", 6);blackJackValue.put("SEVEN", 7);blackJackValue.put("EIGHT", 8);blackJackValue.put("NINE", 9);blackJackValue.put("TEN", 10);blackJackValue.put("JACK", 10);blackJackValue.put("KING", 10);blackJackValue.put("QUEEN", 10);blackJackValue.put("ACE", 1);
    }


    public Blackjack(Console console) {
        this(new BlackjackPlayer(),console);
    }

    public void placeBet() {
        Double bet;
        bet = 0.0;
        while (bet<getMinBet() || bet>getMaxBet()) {
            bet = console.getDoubleInput("How much would you like to bet?\n" + "Current minimum bet: " + getMinBet() + "\n" + "Current max bet: " + getMaxBet());
        } setCurrentBet(bet);
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
        if (calculateHandValue(hand) == 21){
            System.out.println(hand.handToStringAbrev());
            bjPlayer.addToBalance(getCurrentBet());
            System.out.println("You got BlackJack!\n" + "Remaining balance: " + bjPlayer.getBalance());
            takeTurn();
        }
    }

    public void dealCards(){
        dealCardToUser(2);
        dealCardToDealer(1);
        System.out.println("Player draws: \n" + BlackjackPlayer.hand.handToStringAbrev());
        System.out.println("Dealer shows: " + dealerHand.handToStringAbrev());
        dealCardToDealer(1);
        checkForUserBj();
        checkForDealerBj();


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
        System.out.println("Player hand: \n" + hand.handToStringAbrev());
        System.out.println("Dealer hand: \n" + dealerHand.handToStringAbrev());
    }

    public void dealerChoice(){
        while (calculateHandValue(dealerHand) < 17) {
            dealCardToDealer(1);
            }
        if (calculateHandValue(dealerHand) >21 ){
                printHands();
                System.out.println("DEALER BUSTS!");
                bjPlayer.addToBalance(getCurrentBet());
                System.out.println("Remaining Balance: $" + bjPlayer.getBalance());
                takeTurn();
        } else if (calculateHandValue(dealerHand) > calculateHandValue(hand)){
                printHands();
                bjPlayer.subtractFromBalance(getCurrentBet());
                System.out.println("Dealer Wins \n Remaining Balance: $" + bjPlayer.getBalance());
                takeTurn();
        } else if (calculateHandValue(dealerHand) < calculateHandValue(hand)){
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

    public void playerOptions(int choice){
           switch (choice) {

                case 1: //hit
                    dealCardToUser(1);
                    System.out.println("Player draws: \n" + BlackjackPlayer.hand.handToStringAbrev());
                    checkForBust(hand);
                    resolve();
                    break;

                case 2: //stay
                    dealerChoice();
                    break;

                case 3: //double
                    dealCardToUser(1);
                    setCurrentBet(getCurrentBet()*2);
                    System.out.println("Player Doubled Down: \n" + BlackjackPlayer.hand.handToStringAbrev());
                    checkForBust(hand);
                    resolve();
                    break;

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


    public boolean validateBet(double playerBalance) { //check if balance has enough to make minimum bet
        double minimumBet = getMinBet();
    return (playerBalance >= minimumBet);
    }

    public void takeTurn() {
        setMaxBet(500.0);
        setMinBet(10.0);
        setCurrentBet(0.0);
        if (validateBet(bjPlayer.getBalance())){
            placeBet();
            hand = new Hand();
            dealerHand = new Hand();
            deck = new Deck();
            deck.shuffle();
            dealCards();
            resolve();

        }

    }

    public void setup() {

        while (!isDonePlaying()){
            takeTurn();
        }

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
