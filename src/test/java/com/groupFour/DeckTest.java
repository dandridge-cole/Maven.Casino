package com.groupFour;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void newDeckTest() {
        Deck deck = new Deck();
        String expected = "Deck [ACE of SPADES, TWO of SPADES, THREE of SPADES, FOUR of SPADES, FIVE of SPADES, SIX of SPADES, SEVEN of SPADES, EIGHT of SPADES, NINE of SPADES, TEN of SPADES, JACK of SPADES, QUEEN of SPADES, KING of SPADES, ACE of HEARTS, TWO of HEARTS, THREE of HEARTS, FOUR of HEARTS, FIVE of HEARTS, SIX of HEARTS, SEVEN of HEARTS, EIGHT of HEARTS, NINE of HEARTS, TEN of HEARTS, JACK of HEARTS, QUEEN of HEARTS, KING of HEARTS, ACE of CLUBS, TWO of CLUBS, THREE of CLUBS, FOUR of CLUBS, FIVE of CLUBS, SIX of CLUBS, SEVEN of CLUBS, EIGHT of CLUBS, NINE of CLUBS, TEN of CLUBS, JACK of CLUBS, QUEEN of CLUBS, KING of CLUBS, ACE of DIAMONDS, TWO of DIAMONDS, THREE of DIAMONDS, FOUR of DIAMONDS, FIVE of DIAMONDS, SIX of DIAMONDS, SEVEN of DIAMONDS, EIGHT of DIAMONDS, NINE of DIAMONDS, TEN of DIAMONDS, JACK of DIAMONDS, QUEEN of DIAMONDS, KING of DIAMONDS]";
        String actual = deck.toString();
        Assert.assertEquals(expected, actual);
        System.out.println(deck.toString());
    }

    @Test
    public void shuffleTest() {
        Deck deck = new Deck();
        String original = "Deck [ACE of SPADES, TWO of SPADES, THREE of SPADES, FOUR of SPADES, FIVE of SPADES, SIX of SPADES, SEVEN of SPADES, EIGHT of SPADES, NINE of SPADES, TEN of SPADES, JACK of SPADES, QUEEN of SPADES, KING of SPADES, ACE of HEARTS, TWO of HEARTS, THREE of HEARTS, FOUR of HEARTS, FIVE of HEARTS, SIX of HEARTS, SEVEN of HEARTS, EIGHT of HEARTS, NINE of HEARTS, TEN of HEARTS, JACK of HEARTS, QUEEN of HEARTS, KING of HEARTS, ACE of CLUBS, TWO of CLUBS, THREE of CLUBS, FOUR of CLUBS, FIVE of CLUBS, SIX of CLUBS, SEVEN of CLUBS, EIGHT of CLUBS, NINE of CLUBS, TEN of CLUBS, JACK of CLUBS, QUEEN of CLUBS, KING of CLUBS, ACE of DIAMONDS, TWO of DIAMONDS, THREE of DIAMONDS, FOUR of DIAMONDS, FIVE of DIAMONDS, SIX of DIAMONDS, SEVEN of DIAMONDS, EIGHT of DIAMONDS, NINE of DIAMONDS, TEN of DIAMONDS, JACK of DIAMONDS, QUEEN of DIAMONDS, KING of DIAMONDS]";
        deck.shuffle();
        String actual = deck.toString();
        assertNotEquals(original, actual);
        System.out.println(deck.toString());
    }

    @Test
    public void getCardFromDrawTest() {
        Deck deck = new Deck();
        Card poppedCard = new Card();
        poppedCard = deck.getCardFromDraw();
        String expected = "KING of DIAMONDS";  //this is the card on top of a new deck
        String actual = poppedCard.toString();
        assertEquals(expected, actual);
        System.out.println(poppedCard);
    }

    @Test
    public void drawSizeTest() {
        Deck deck = new Deck();
        int actual = deck.drawSize();
        int expected = 52;
        assertEquals(expected, actual);
        System.out.println("Draw size is " + actual);
    }

    @Test
    public void discardSizeTest() {
        Deck deck = new Deck();
        int actual = deck.discardSize();
        int expected = 0;
        assertEquals(expected, actual);
        System.out.println("Discard size is " + actual);
    }

    @Test
    public void putCardOnDiscardTest() {
        Deck deck = new Deck();
        Card card = new Card(Card.Rank.FOUR, Card.Suit.SPADES);
        System.out.println("Discard size is " + deck.discardSize()); //Discard pile starts at 0
        deck.putCardOnDiscard(card);
        int expected = 1;
        int actual = deck.discardSize();
        assertEquals(expected, actual);
        System.out.println("Discard size is " + deck.discardSize());
        System.out.println(deck.discardToString());
    }

    @Test
    public void getCardFromDiscardTest() {
        Deck deck = new Deck();
        Card card1 = new Card(Card.Rank.FOUR, Card.Suit.SPADES);
        deck.putCardOnDiscard(card1);
        Card card2 = new Card(Card.Rank.FIVE, Card.Suit.HEARTS);
        deck.putCardOnDiscard(card2);
        Card card3 = new Card(Card.Rank.ACE, Card.Suit.CLUBS);
        deck.putCardOnDiscard(card3);
        System.out.println("Discard size is " + deck.discardSize());
        Card removedCard = new Card();
        removedCard = deck.getCardFromDiscard();
        String actual = (removedCard.toString());
        String expected = "ACE of CLUBS";
        assertEquals(expected, actual);
        System.out.println("Removed card :" + actual);
        System.out.println("Discard size is " + deck.discardSize());
    }

    @Test
    //Test to remove all TENS from deck
    public void removeCardsFromDrawTest() {
        Deck deck = new Deck();
        Card.Rank removeRank;
        removeRank = Card.Rank.TEN;
        deck.removeCardsFromDraw(removeRank);
        int expected = 48;
        int actual = (deck.drawSize());
        assertEquals(expected, actual);
        System.out.println("Draw size is " + deck.drawSize());
    }

    @Test
    //Test that when cards are removed the deck no longer contains them
    public void removeCardsFromDrawTest2() {
        Deck deck = new Deck();
        Card.Rank removeRank;
        removeRank = Card.Rank.TEN;
        deck.removeCardsFromDraw(removeRank);
        assertEquals(false, deck.getDraw().contains(Card.Rank.TEN));
    }

        @Test
    public void renewDrawTest() {
        Deck deck = new Deck();
        Card card = new Card(Card.Rank.FOUR, Card.Suit.SPADES);
        deck.putCardOnDiscard(card);
        System.out.println("Original draw size is " + deck.drawSize());
        System.out.println("Discard size is " + deck.discardSize());
        deck.renewDraw();
        int expected = 53;
        int actual = deck.drawSize();
        assertEquals(expected, actual);
        System.out.println("After renewDraw size is " + deck.drawSize());
        assertEquals(0, deck.discardSize());
        System.out.println("Discard size is " + deck.discardSize());
    }

}