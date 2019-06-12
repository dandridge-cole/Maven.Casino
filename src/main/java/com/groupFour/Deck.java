package com.groupFour;

import java.util.*;

public class Deck {

    Stack<Card> draw;
    Stack<Card> discard = new Stack<Card>();

    // Other constructors for modified decks, multiple decks, etc.

//create a new draw Stack of 52 cards
    public Deck(){
        draw = new Stack<Card>();
        for (Card.Suit suit : Card.Suit.values()){
            for (Card.Rank rank : Card.Rank.values()) {
                draw.add(new Card(rank, suit));
            }
        }
    }


    public void shuffle(){
        Collections.shuffle(draw);
    }

    public int drawSize(){
        return draw.size();
    }

    public int discardSize(){
        return discard.size();
    }

    public Card getCardFromDraw(){
        return draw.pop();
    }

    public Card getCardFromDiscard(){
        return discard.pop();
    }

    public void putCardOnDiscard(Card card){
        discard.push(card);
    }

    //used to customize the draw Stack for certain games
    public void removeCardsFromDraw(Card.Rank rank){
        System.out.println("Removing " + rank);
        for (int i = 0; i < drawSize(); i++) {
            if (draw.get(i).getRank().equals(rank)) {
                draw.remove(draw.get(i));
            }
        }
    }

    // used to add discard pile into draw pile
    public void renewDraw(){
        draw.addAll(discard);
        }


    @Override
    public String toString() {
        return "Deck " + draw;
    }

    public String discardToString() {
        return "Discard pile: " + discard;
    }


}
