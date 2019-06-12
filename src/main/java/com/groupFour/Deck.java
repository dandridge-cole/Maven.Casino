package com.groupFour;

import java.util.*;

public class Deck {

    Stack<Card> deck;
//    private Stack<Card> draw;
//    private Stack<Card> discard;

    public Deck() {
        deck = new Stack<Card>();
        for (Card.Suit suit : Card.Suit.values()){
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(new Card(rank, suit));
            }
        }
    }

    // Other constructors for modified decks, multiple decks, etc.


    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Card getCard(){
        return deck.pop(); // return a pop off the stack
    }

//    public void putCard(Stack<Card> pickDeck){
//        // push a card onto the stack
//    }
//
//    public void removeCard(Card toRemove){
//        // removes toRemove from deck
//    }
//
//    public void renewDraw(){
//        // Shuffle discard into draw pile
//    }

    @Override
    public String toString() {
        return "Deck " + deck;
    }

}
