package com.groupFour.Games;

import com.groupFour.Card;
import com.groupFour.Console;
import com.groupFour.Deck;
import com.groupFour.Hand;
import com.groupFour.Interfaces.Game;
import com.groupFour.Wraps.GoFishPlayer;

import java.util.Arrays;
import java.util.Scanner;

public class GoFish extends Game {

    private GoFishPlayer goFishPlayer;
    Console console;

    private Deck deck;
    private int[] house = new int[14]; //0 will not be used, Ace=1 King=13
    private int[] player = new int[14];
    private int turn = 1;  //0 is house, 1 is player
    private int countSetHouse = 0;  //counts # of sets house won
    private int countSetPlayer = 0; //counts # of sets player won
    int askedFor = 0;           //rank asked for in current turn
    String lastAskHouse = "";     //rank last asked for by house

    public GoFish(GoFishPlayer player){}

    public GoFish(GoFishPlayer player, Console console){
        super();
        this.goFishPlayer = player;
        this.console = console;
    }

    public GoFish(Console console){
        this(new GoFishPlayer(), console);
    }

    @Override
    public void takeTurn() {
        if (turn == 1) {
            console.println("Player's turn.");
            viewHand();
        }
        askForInput();
        //if player not 0 displayPlayerBins
        //if player is 0 evaluateBins
        //askForPrompt
        //checkIfBinsContain
        //turnOverMessage
        //loop
    }

    public void setup() {
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
        askedFor = console.getIntegerInput("Enter a number ACE=1, 2, 3, 4, 5, 6, 7, 8, 9, 10, " +
                "Jack=11, QUEEN=12, KING=13 \n " +
                "Do you have any : ");

        while (askedFor < 0 || askedFor > 13) { //scan
           askedFor = console.getIntegerInput("That's not a card number! Try again");
        }

        console.println("Thank you! Card asked for is: " + askedFor);
    }


    public void checkIfBinsContain(String askedFor){
        //check if opponents bins contain askedFor
        // if YES: decreaseBins to 0
        // if YES: call addToBins and increment askedFor bin by howMany
        // if NO: display goFishMessage
        //    AND drawCard
    }

    public void decreaseBins(int rank, int howMany){
        //decrease askedFor bin with rank and howMany
    }

    public void addToBins(int rank, int howMany){
        //increment askedFor bin with rank and howMany
        if (turn == 0){
            house[rank] += 1;
        }
        else if (turn == 1){
            player[rank] += 1;
        }
        checkFor4();//automatically checkFor4
    }

    public void checkFor4(){      //check if any bins have 4
        if (turn == 0) {
            for (int i = 1; i < house.length; i++) {
                if (house[i] == 4) {
                    house[i] = 0;  //if YES: decrease Bin with 4 to 0
                    System.out.println("House has a set of 4 of :" + i);
                    countSetHouse ++;   //increase countSet+ AND display setWon Message
                    System.out.println("House completed sets = " + countSetHouse);
                }
            }
        }else if (turn == 1){
                for (int i = 1; i < player.length; i++) {
                    if (player[i] == 4){
                        player[i] = 0;
                        console.println("Player has a set of 4 of:" + i);
                        countSetPlayer++;
                        console.println("Player completed sets = " + countSetPlayer);
                    }
                }
        }
    }

    public void goFishMessage() {
        //displays goFish Message
    }

     public void drawCard() {
        int rank = 0;
         //if there are card draw card from drawStack
            if (deck.drawSize() == 0){
                console.println("Draw pile is empty.");
            }
            else {
                Card card = deck.getCardFromDraw();
                rank = (card.getValue());
                addToBins(rank, 1); // addToBins
                if (turn > 0){
                    console.println("Your card: " + card.toString());

                }
            }

     }

     public void turnOverMessage() {
        //display turnOverMessage
         //adjust turn to other player
     }

     public void evaluateBins() {
        //askFor = algorithm for house to determine what to ask for not lastAskHouse
     }

     public void initializeBins(int[] bin){
         for (int i = 0; i < bin.length-1; i++) {
             bin[i] = 0;
         }
     }

     public void deal(){
         turn = 0;
         for (int i = 0; i < 7 ; i++) {    // deal 7 cards to house
             drawCard();
         }
         turn = 1;
         console.println("Dealing your hand:");
         for (int i = 0; i < 7 ; i++) {    // deal 7 cards to house
             drawCard();
         }
     }

     public void viewHand(){
         System.out.print("Your hand: ");
         if (turn == 1) {
             console.println("ACE:" + player[1] + ", TWO:"  + player[2] + ", THREE:" + player[3] + ", FOUR:" + player[4] +
                    ", FIVE:" + player[5] + ", SIX:" + player[6] +", SEVEN:" + player[7] + ", EIGHT:" + player[8] +
                    ", NINE:" + player[9] + ", TEN:" + player[10] + ", JACK:" + player[11] + ", QUEEN:" + player[12] +
                    ", KING:" + player[13]);
             console.println("");
         }
     }



}
