package com.groupFour.Games;

import com.groupFour.Deck;
import com.groupFour.Hand;
import com.groupFour.Interfaces.Game;
import com.groupFour.Wraps.GoFishPlayer;

public class GoFish extends Game {

    private GoFishPlayer goFishPlayer;

    private Deck deck;
    private int[] house;
    private int[] player;
    private int turn = 0;  //0 is player, 1 is house
    private int countSetHouse = 0;  //counts # of sets house won
    private int countSetPlayer = 0; //counts # of sets player won
    String askedFor = "";           //rank asked for in current turn
    String lastAskHouse = "";     //rank last asked for by house

    public GoFish(GoFishPlayer player){
        this.player = player;
        this.deck = new Deck();
        this.house = new Hand();
    }

    public GoFish(){this(new GoFishPlayer());}

    public void setup() {
        //initialize and shuffle new deck
        //initialize house bins
        //initialize player bins
        //deal house cards and update house bins
        //deal player cards and update house bins
        //initiate beginning turn
    }

    public void turn(){
        //if player not 1 displayPlayerBins
        //if player is 1 evaluateBins
        //askForPrompt
        //checkIfBinsContain
        //turnOverMessage
        //loop
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
         // addToBins
     }

     public void turnOverMessage() {
        //display turnOverMessage
         //adjust turn to other player
     }

     public void evaluateBins() {
        //askFor = algorithm for house to determine what to ask for not lastAskHouse

     }

}
