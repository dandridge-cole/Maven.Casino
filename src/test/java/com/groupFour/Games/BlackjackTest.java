package com.groupFour.Games;

import com.groupFour.Card;
import com.groupFour.Hand;
import com.groupFour.Interfaces.GamblingGame;
import com.groupFour.Interfaces.GamblingGameInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class BlackjackTest {

    @Test
    public void placeBet() {

    }

    @Test
    public void dealCards() {

    }

    @Test
    public void dealCardToDealer() {


    }

    @Test
    public void dealCardToUser() {
    }

    @Test
    public void resolve() {
    }

    @Test
    public void validateBet() {

    }

    @Test
    public void takeTurn() {
    }

    @Test
    public void setup() {
    }

    @Test
    public void setHandValueTest(){
        Blackjack blackjack = new Blackjack();
        Hand hand = new Hand();
        blackjack.setup();
        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        Card card2 = new Card(Card.Rank.FIVE, Card.Suit.SPADES);
        Card card3 = new Card(Card.Rank.SEVEN, Card.Suit.SPADES);
        hand.addCard(card);
        hand.addCard(card2);
        hand.addCard(card3);
        int handValue = blackjack.setHandValue(hand);

        int expected = 13;
        int actual = handValue;

        Assert.assertEquals(expected,actual);

    }
}