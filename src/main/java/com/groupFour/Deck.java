package com.groupFour;

import java.util.*;

public class Deck {

    Stack<Card> deck;
    Stack<Card> discard;
    //    private Stack<Card> draw;

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

    public void putCard(Card toPut){
        discard.push(toPut);
    }

    public void removeCard(Card toRemove){
       deck.remove(toRemove);
    }

    public void renewDraw(){
        // Shuffle discard into draw pile
    }

    @Override
    public String toString() {
        return "Deck " + deck;
    }

}
