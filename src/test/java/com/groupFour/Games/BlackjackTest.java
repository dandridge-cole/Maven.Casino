package com.groupFour.Games;
import com.groupFour.Card;
import com.groupFour.Deck;
import com.groupFour.Hand;
import com.groupFour.Interfaces.GamblingGame;
import com.groupFour.Interfaces.GamblingGameInterface;
import com.groupFour.Wraps.BlackjackPlayer;
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
        Blackjack blackjack = new Blackjack();
        blackjack.dealCards();

        int expectedDealer = 2;
        int expectedUser = 2;

        int actualDealer = Blackjack.dealerHand.getCards().size();
        int actualUser = BlackjackPlayer.hand.getCards().size();

        Assert.assertEquals(expectedDealer,actualDealer);
        Assert.assertEquals(expectedUser, actualUser);
    }

    @Test
    public void dealCardToDealerTest() {
        Blackjack blackjack = new Blackjack();
        blackjack.dealCardToDealer(3);

        int expected = 3;
        int actual = blackjack.dealerHand.getCards().size();

        Assert.assertEquals(expected,actual);
        System.out.println(blackjack.dealerHand.handToString());

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
    public void calculateHandValueTest(){
        Blackjack blackjack = new Blackjack();
        Hand hand = new Hand();
        blackjack.setup();
        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        Card card2 = new Card(Card.Rank.FIVE, Card.Suit.SPADES);
        Card card3 = new Card(Card.Rank.SEVEN, Card.Suit.SPADES);
        hand.addCard(card);
        hand.addCard(card2);
        hand.addCard(card3);
        int handValue = blackjack.calculateHandValue(hand);

        int expected = 13;
        int actual = handValue;

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void placeBet1() {
    }

    @Test
    public void dealCards1() {
    }

    @Test
    public void dealCardToDealer1() {
    }

    @Test
    public void dealCardToUser1() {
    }

    @Test
    public void resolve1() {
    }

    @Test
    public void validateBet1() {
    }

    @Test
    public void takeTurn1() {
    }

    @Test
    public void setup1() {
    }

    @Test
    public void calculateHandValue() {
    }
}