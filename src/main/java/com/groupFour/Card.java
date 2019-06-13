package com.groupFour;


public class Card {

    public enum Rank{
        ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);
        int value;
        Rank(int value) { this.value = value; }
    }

    public enum Suit{
        SPADES, HEARTS, CLUBS, DIAMONDS
    }

    private Suit suit;
    private Rank rank;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    //null constructor
    public Card(){}

    public Rank getRank() {
        return rank;
    }

    public int getValue() { return rank.value; }  //added to return numbers for cards Ace=1 King=13

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
        return (rank + " of " + suit);
    }

    public String toStringAbrev(){
        return null;
    }

}
