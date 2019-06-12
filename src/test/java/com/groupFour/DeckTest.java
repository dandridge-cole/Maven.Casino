package com.groupFour;

import org.junit.Test;

import java.util.Stack;

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

    @Test
    public void getCard() {
        Deck deck = new Deck();
        assertEquals("KING of DIAMONDS\n", deck.getCard().toString()); //last card in an unshuffled deck
    }


    @Test
    public void putCard() {
//        Stack<Card> discard = new  Stack<Card>();
//
//
//
    }

    @Test
    public void removeCard() {
    }

    @Test
    public void renewDraw() {
    }
}