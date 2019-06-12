package com.groupFour;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void getRank() {
        Card.Rank expected = Card.Rank.ACE;
        Card card = new Card(expected, Card.Suit.SPADES);
        Card.Rank actual = card.getRank();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setRank() {
        Card card = new Card(Card.Rank.FOUR, Card.Suit.SPADES);
        Card.Rank expected = Card.Rank.JACK;
        card.setRank(expected);
        Card.Rank actual = card.getRank();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSuit() {
        Card.Suit expected = Card.Suit.CLUBS;
        Card card = new Card(Card.Rank.FOUR, expected);
        Card.Suit actual = card.getSuit();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setSuit() {
        Card card = new Card(Card.Rank.FOUR, Card.Suit.SPADES);
        Card.Suit expected = Card.Suit.DIAMONDS;
        card.setSuit(expected);
        Card.Suit actual = card.getSuit();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void toString1() {
        Card card = new Card(Card.Rank.FOUR, Card.Suit.SPADES);
        String expected = "FOUR of SPADES";
        String actual = (card.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringAbrev() {
    }
}