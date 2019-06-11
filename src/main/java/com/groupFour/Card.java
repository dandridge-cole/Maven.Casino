package com.groupFour;

enum Suit{
    SPADES, HEARTS, CLUBS, DIAMONDS
}

enum Rank{
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}

public class Card {

    private Suit suit;
    private Rank rank;



    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public String toString(){
        return null;
    }

    public String toStringAbrev(){
        return null;
    }
}
