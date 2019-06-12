package com.groupFour;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;

public class HandTest {

    @Test
    public void addCardTest() {
    Hand hand = new Hand();
    Card card = new Card(Card.Rank.ACE, Card.Suit.DIAMONDS);
    hand.addCard(card);

    boolean actual = hand.getCards().contains(card);

    Assert.assertTrue(actual);


    }

    @Test
    public void removeCard() {
        Hand hand = new Hand();
        Card card = new Card(Card.Rank.ACE, Card.Suit.DIAMONDS);
        hand.addCard(card);
        hand.removeCard(card);

        boolean actual = hand.getCards().contains(card);

        Assert.assertFalse(actual);


    }

    @Test
    public void handToStringTest() {
        Hand hand = new Hand();
        Card card = new Card(Card.Rank.ACE, Card.Suit.DIAMONDS);
        hand.addCard(card);

        String expected = "ACE of DIAMONDS";
        String actual = hand.handToString();
    }

    @Test
    public void getCards() {
        Hand hand = new Hand();
        Card card = new Card(Card.Rank.ACE, Card.Suit.DIAMONDS);

        hand.addCard(card);

        String expected = "ACE of DIAMONDS";
        String actual = hand.getCards().toString();
    }
}