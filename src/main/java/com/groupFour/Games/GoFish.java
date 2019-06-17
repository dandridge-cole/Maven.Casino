package com.groupFour.Games;

import com.groupFour.Card;
import com.groupFour.Console;
import com.groupFour.Deck;
import java.util.Random;
import com.groupFour.Interfaces.Game;
import com.groupFour.Wraps.GoFishPlayer;

public class GoFish extends Game {

    public static final String gameName = "Go Fish";
    private GoFishPlayer goFishPlayer;
    private Console console;

    private Deck deck;
    private int[] house = new int[14]; //0 will not be used, Ace=1 King=13
    private int[] player = new int[14];
    private int turn = 1;  //0 is house, 1 is player
    private int countSetHouse = 0;  //counts # of sets house won
    private int countSetPlayer = 0; //counts # of sets player won
    int askedFor = 0;           //rank asked for in current turn
    boolean gameIsOver = false;  //test for game in play


//this constructor used for testing
    public GoFish(Console console, Deck deck, int[] house, int[] player){
        this.console = console;
        this.deck = deck;
        this.house = house;
        this.player = player;
        this.turn = 1;
        this.countSetHouse = 0;
        this.countSetPlayer = 0;
        this.askedFor = 0;
    }


    public GoFish(GoFishPlayer player, Console console){
        super();
        this.goFishPlayer = player;
        this.console = console;
    }

    public GoFish(Console console){
        this(new GoFishPlayer(), console);
    }

    //**************************************************************************************

    @Override
    public void takeTurn() {

        boolean inplay = true;
        askedFor = 0; //reset askedFor

        while (gameIsOver == false) {
            if (turn == 1) {    //if Player's turn display PlayerBins
                console.println("Your turn begins.");
                inplay = true;
            } else if (turn == 0) {  //if Houses turn evaluate Bins
                console.println("House's turn begins.");
                inplay = true;

            }
            while (inplay) {
                 askForInput();

                //check if opponent has askedFor
                int howMany = checkIfBinsContain();
                if (howMany > 0) {        // if true
                    decreaseBins(askedFor, howMany);   //remove the cards from opponent
                    addToBins(askedFor, howMany);      //give to player
                    checkFor4();                      //checkFor4
                    isHandEmpty();       // check if hand isEmpty


                } else {              //if false
                    goFish();        //gofish
                    checkFor4();
                    turnOver();      //set turn to next player
                    inplay = false;  //end current turn
                }
            }   // loop to continue players turn

      }  //END Game


    }

    public void setup() {
        console.println("Welcome to a game of GO FISH");
        gameRules();
        deck = new Deck();   //initialize and shuffle new deck
        deck.shuffle();
        initializeBins(house); //initialize bins
        initializeBins(player);
        deal();  //deal house and player hands
        turn = 1;  //player starts
        takeTurn();
    }

    public String displayPlayerBins(){
        return null;
    }

    public void askForInput(){
        if (turn == 1) {
            viewHand();
            askedFor = console.getIntegerInput("House, do you have any: ");

            while (askedFor < 0 || askedFor > 13) { //scan
                askedFor = console.getIntegerInput("That's not a card number! Try again");
            }
            console.println("Card asked for is: " + askedFor);
        }

        if (turn == 0){
            houseAsksFor();  //set askFor
            console.println("House asks: Do you have any : " + askedFor);
        }
    }


    public int checkIfBinsContain(){
        int howMany = 0;
        if (askedFor == 0) {
            gameIsOver = true;
        }
        else if (turn == 1){    // on Player's turn check HouseBins
            howMany = house[askedFor];
            console.println("House has " + howMany);
        }
        else if (turn == 0){    // on House's turn Player checks bins and responds
            howMany = player[askedFor];
            console.println("You have " + howMany);
        }

       return howMany;
    }

    //decrease askedFor bin with rank and howMany
    public void decreaseBins(int askedFor, int howMany){
        if (turn == 1){
            house[askedFor] -= howMany;
        }
        else if (turn == 0){
            player[askedFor] -= howMany;
        }
        console.println(askedFor + "s have been transferred.\n");
    }

    //increment askedFor bin with rank and howMany
    public void addToBins(int rank, int howMany){
        if (turn == 0){
            house[rank] += howMany;
        }
        else if (turn == 1){
            player[rank] += howMany;
        }
    }

    public void checkFor4(){      //check if any bins have 4
        if (turn == 0) {
            for (int i = 0; i < house.length; i++) {
                if (house[i] == 4) {
                    house[i] = 0;  //if YES: decrease Bin with 4 to 0
                    System.out.println("House won the set of : " + i +"s");
                    countSetHouse ++;   //increase countSet+ AND display setWon Message
                    System.out.println("House has won " + countSetHouse + " sets.");
                }
            }
        }else if (turn == 1){
            for (int i = 0; i < player.length; i++) {
                if (player[i] == 4){
                    player[i] = 0;
                    console.println("You won the set of : " + i + "s");
                    countSetPlayer++;
                    console.println("You have won " + countSetPlayer + " sets.");
                }
            }
        }
    }

    public void isHandEmpty() {
        if (turn == 1) {
            boolean playerHandIsEmpty = true;

            for (int i = 0; i < player.length; i++) {
                if (player[i] > 0) {
                    playerHandIsEmpty = false;
                    break;
                }
            }
            if (playerHandIsEmpty){
                console.println("Your hand is empty.");
                refillHand();
            }
        } else if (turn == 0) {
            boolean houseHandIsEmpty = true;

            for (int i = 0; i < house.length; i++) {
                if (house[i] > 0) {
                    houseHandIsEmpty = false;
                    break;
                }
            }
            if (houseHandIsEmpty){
                console.println("House's hand is empty.");
                refillHand();
            }
        }
    }

    public void refillHand(){
        int drawNum = 5;

        if (deck.drawSize() == 0){
            gameIsOver = true;
            gameOverMessage();
        }
        else {
           console.println("Refill cards in hand.");
           if (deck.drawSize() < 5)
               drawNum = deck.drawSize();
           for (int i = 0; i < drawNum; i++)
               drawCard();
        }
    }

    public void goFish() {
        console.println("GO FISH!");  //displays goFish Message
        drawCard();
    }

     public void drawCard() {
        int rank = 0;
        if (deck.drawSize() == 0){   //if there are NO cards
            console.println("Draw pile is empty.");
        }
        else {
            Card card = deck.getCardFromDraw();  //if there are cards
            rank = (card.getValue());
            if (turn > 0){
                console.println("Your card: " + card.toString());
            }
            else if (turn == 0){
                console.println("House has drawn a card.");
            }
            addToBins(rank, 1); // addToBins
        }
     }

     public void turnOver() {
        if (turn == 0) {
            console.println("House's turn is over.");
            turn = 1;
        } else if( turn == 1){
            console.println("Your turn is over.");
            turn = 0;
        }
        console.println("");
        console.println("");
     }

     public void houseAsksFor() {  //askFor = algorithm for house to determine what to ask for; not lastAskHouse
        askedFor = 1;
        Random random = new Random();
         askedFor =  (random.nextInt((12) + 1))+ askedFor %13;
     }

     public void initializeBins(int[] bin){
         for (int i = 0; i < bin.length-1; i++) {
             bin[i] = 0;
         }
     }

     public void deal(){
         int rank = 0;
         turn = 0;  //deal house
         console.println("Dealing house");
         for (int i = 0; i < 7 ; i++) {    // deal 7 cards to house
             Card card = deck.getCardFromDraw();  //if there are cards
             rank = (card.getValue());
             addToBins(rank, 1); // addToBins
         }

         turn = 1;  //deal player
         console.println("Dealing Player's hand:");
         for (int i = 0; i < 7 ; i++) {    // deal 7 cards to player
             Card card = deck.getCardFromDraw();  //if there are cards
             rank = (card.getValue());
             console.println("Your card: " + card.toString());
             addToBins(rank, 1); // addToBins
         }
         console.println("");
     }

     public int[] getplayerBin(){
        return player;
     }

    public int[] getHouseBin(){
        return house;
    }

     public void gameOverMessage(){
    console.println("GAME IS OVER!");
        if (countSetHouse > countSetPlayer){
            console.println("HOUSE WIN with " + countSetHouse + " sets.");
        }
        else {
            console.println("YOU WIN with " + countSetPlayer + " sets.");
        }
     }

     public void gameRules(){
        console.println("When entering cards ACE=1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack=11, QUEEN=12, KING=13\n " +
                "To Quit the game while in play enter 0 when prompted for a card. ");
     }

     public void viewHand(){
             console.println("Your hand:  ACE:" + player[1] + ", TWO:"  + player[2] + ", THREE:" + player[3] + ", FOUR:" + player[4] +
                    ", FIVE:" + player[5] + ", SIX:" + player[6] +", SEVEN:" + player[7] + ", EIGHT:" + player[8] +
                    ", NINE:" + player[9] + ", TEN:" + player[10] + ", JACK:" + player[11] + ", QUEEN:" + player[12] +
                    ", KING:" + player[13]);
             console.println("");
     }

     //won't need this after testing
    public void viewHouseHand(){
        console.println("House's hand: ");
            console.println("Houses hand: \n ACE:" + house[1] + ", TWO:"  + house[2] + ", THREE:" + house[3] + ", FOUR:" + house[4] +
                    ", FIVE:" + house[5] + ", SIX:" + house[6] +", SEVEN:" + house[7] + ", EIGHT:" + house[8] +
                    ", NINE:" + house[9] + ", TEN:" + house[10] + ", JACK:" + house[11] + ", QUEEN:" + house[12] +
                    ", KING:" + house[13]);
            console.println("");
        }



}
