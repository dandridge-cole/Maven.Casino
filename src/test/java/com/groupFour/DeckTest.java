package com.groupFour;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void newDeck() {
        Deck deck = new Deck();
        System.out.println(deck.toString());
    }

    @Test
    public void shuffle() {
        Deck deck = new Deck();
        deck.shuffle();
        System.out.println(deck.toString());
    }

    //??How to test this since it is not a string, but enums
    @Test
    public void getCard() {
        Deck deck = new Deck();
        assertEquals("KING of DIAMONDS", deck.getCard()); //last card in an unshuffled deck
    }


    @Test
    public void putCard() {
    }

    @Test
    public void removeCard() {
    }

    @Test
    public void renewDraw() {
    }
}