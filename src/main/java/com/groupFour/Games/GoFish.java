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
    private int turn = 1;  //0 is house, 1 is player
    private int countSetHouse = 0;  //counts # of sets house won
    private int countSetPlayer = 0; //counts # of sets player won
    String askedFor = "";           //rank asked for in current turn
    String lastAskHouse = "";     //rank last asked for by house

    public GoFish(GoFishPlayer player){}

    public GoFish(){this(new GoFishPlayer());}

    @Override
    public void takeTurn() {
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

    public void addToBins(int rank, int howMany){
        //increment askedFor bin with rank and howMany
        if (turn == 0){
            house[rank] += 1;
        }
        else if (turn == 1){
            player[rank] += 1;
 //           viewHand();  //can remove after programming
        }
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
        int rank = 0;
         //if there are card draw card from drawStack
            if (deck.drawSize() == 0){
                System.out.println("Draw pile is empty.");
            }
            else {
                Card card = deck.getCardFromDraw();
                rank = (card.getValue());
                addToBins(rank, 1); // addToBins
                if (turn > 0){
                    System.out.println("Your card: " + card.toString());

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
         for (int i = 0; i < 7 ; i++) {    // deal 7 cards to house
             drawCard();
         }
         if (turn == 1){
             viewHand();
         }
     }

     public void viewHand(){
         System.out.print("Your hand: ");
         if (turn == 1) {
            System.out.print("ACE:" + player[1] + ", TWO:"  + player[2] + ", THREE:" + player[3] + ", FOUR:" + player[4] +
                    ", FIVE:" + player[5] + ", SIX:" + player[6] +", SEVEN:" + player[7] + ", EIGHT:" + player[8] +
                    ", NINE:" + player[9] + ", TEN:" + player[10] + ", JACK:" + player[11] + ", QUEEN:" + player[12] +
                    ", KING:" + player[13]);
             System.out.println();
         }
     }


}
