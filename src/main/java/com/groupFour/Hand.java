package com.groupFour;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> hand;

    public void addCard(Card card){
        hand.add(card);
    }
    public void removeCard(Card card){
        hand.remove(card);
    }

    public String handToString(){
        StringBuilder builder = new StringBuilder();
        for (Card card: this.hand){
            builder.append(card.toString()).append("\n");
        }return builder.toString();
    }

    public String handToStringAbrev(){
        StringBuilder builder = new StringBuilder();
        for (Card card: this.hand){
            builder.append(card.toStringAbrev()).append("\n");
        }return builder.toString();
    }

    public ArrayList<Card> getCards(){
        return this.hand;
    }
}
