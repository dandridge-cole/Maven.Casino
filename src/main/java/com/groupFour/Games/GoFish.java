package com.groupFour.Games;

import com.groupFour.Card;
import com.groupFour.Deck;
import com.groupFour.Hand;
import com.groupFour.Interfaces.Game;
import com.groupFour.Wraps.GoFishPlayer;

import java.util.Arrays;

public class GoFish extends Game {

    private GoFishPlayer goFishPlayer;

    private Deck deck;
    private int[] house = new int[14]; //0 will not be used, Ace=1 King=13
    private int[] player = new int[14];
    private int turn = 0;  //0 is player, 1 is house
    private int countSetHouse = 0;  //counts # of sets house won
    private int countSetPlayer = 0; //counts # of sets player won
    String askedFor = "";           //rank asked for in current turn
    String lastAskHouse = "";     //rank last asked for by house

    public GoFish(GoFishPlayer player){}

    public GoFish(){this(new GoFishPlayer());}

    @Override
    public void takeTurn() {
        //if player not 1 displayPlayerBins
        //if player is 1 evaluateBins
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

        //deal house cards and update house bins
        drawCard();



        //deal player cards and update house bins
        //initiate beginning turn
    }

    public String displayPlayerBins(){
        return null;
    }

    public String askForPrompt(){
        //prompt for askFor,
        //returns a string ONE - TEN, ACE, JACK, QUEEN, KING
        return null;
    }

    public void checkIfBinsContain(String askedFor){
        //check if opponents bins contain askedFor
        // if YES: decreaseBins to 0
        // if YES: call addToBins and increment askedFor bin by howMany
        // if NO: display goFishMessage
        //    AND drawCard
    }

    public void decreaseBins(String rank, int howMany){
        //decrease askedFor bin with rank and howMany

    }

    public void addToBins(String rank, int howMany){
        //increment askedFor bin with rank and howMany
        //automatically checkFor4
    }

    public void checkFor4(){
        //check if any bins have 4
        //if YES: decrease Bin with 4 to 0
        // AND increase countSet+ AND display setWon Message
    }

    public void setWonMessage(){
        //displays setWon Message
    }

    public void goFishMessage() {
        //displays goFish Message
    }

     public void drawCard() {
         //if there are card draw card from drawStack
            if (deck.drawSize() == 0){
                System.out.println("Draw pile is empty.");
            }
            else {
                Card card = deck.getCardFromDraw();
                System.out.println(card.getValue());

                if (turn == 0){
                    System.out.println("Your card: " + card.toString());
                }

                // addToBins
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
         for (int i = 0; i < 7 ; i++) {    // deal 7 cards
             drawCard();
         }
     }



}
