package com.groupFour;

import java.util.Stack;

public class Deck {

    private Stack<Card> draw;
    private Stack<Card> discard;

    public Deck() {
        // set up a fresh deck
    }
    // Other constructors for modified decks, multiple decks, etc.

    public void shuffle(Stack<Card> pickDeck){}

    public Card getCard(Stack<Card> pickDeck){
        return null; // return a pop off the stack
    }

    public void putCard(Stack<Card> pickDeck){
        // push a card onto the stack
    }

    public void removeCard(Card toRemove){
        // removes toRemove from deck
    }

    public void renewDraw(){
        // Shuffle discard into draw pile
    }
}
