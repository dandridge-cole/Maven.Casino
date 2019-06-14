package com.groupFour;


public class Card {

    public enum Rank{
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    public enum Suit{
        SPADES, HEARTS, CLUBS, DIAMONDS
    }

    public enum RankAbrev{
        ACE("A"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"),
        EIGHT("8"), NINE("9"), TEN("10"), JACK("J"), QUEEN("Q"), KING("K");
        private String value;
        private RankAbrev(String value)
        {
            this.value = value;
        }

        public String toString()
        {
            return this.value;
        }
    }

    public enum SuitAbrev{
        SPADES("\u2660"), HEARTS("\u2661"), CLUBS("\u2663"), DIAMONDS("\u2662");
        private String value;
        private SuitAbrev(String value)
        {
            this.value = value;
        }

        public String toString() { return this.value; }
    }

    private Suit suit;
    private Rank rank;
    private SuitAbrev suitAbrev;
    private RankAbrev rankAbrev;


    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        this.rankAbrev=RankAbrev.valueOf(rank.toString());
        this.suitAbrev=SuitAbrev.valueOf(suit.toString());
    }

    //null constructor
    public Card(){}

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
        return (rank + " of " + suit);
    }

    public String toStringAbrev(){
        return (rankAbrev.toString() + suitAbrev.toString());
    }

}
