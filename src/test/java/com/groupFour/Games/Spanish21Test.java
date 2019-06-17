package com.groupFour.Games;

import com.groupFour.Card;
import com.groupFour.Console;
import com.groupFour.Hand;
import com.groupFour.Wraps.Spanish21Player;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

import static com.groupFour.Wraps.Spanish21Player.playerHand;
import static org.junit.Assert.*;

public class Spanish21Test {
    Console console;
    private InputStream input;


    @Test
    public void dealCards() {
        Spanish21 spanish21 = new Spanish21(console);
        spanish21.dealCards();


        int expectedDealer = 2;
        int expectedUser = 2;

        int actualDealer = Spanish21.dealerHand.getCards().size();
        int actualUser = playerHand.getCards().size();

        Assert.assertEquals(expectedDealer,actualDealer);
        Assert.assertEquals(expectedUser, actualUser);
    }

    @Test
    public void dealCardToDealerTest() {
        Spanish21 spanish21 = new Spanish21(console);
        Hand dealerHand = new Hand();
        spanish21.dealCard(3, dealerHand);

        int expected = 3;
        int actual = dealerHand.getCards().size();

        Assert.assertEquals(expected,actual);
        System.out.println(Spanish21.dealerHand.handToString());

    }

    @Test
    public void dealCardToUser() {
        Spanish21 spanish21 = new Spanish21(console);
        Hand playerHand = new Hand();
        Spanish21Player player = new Spanish21Player();
        spanish21.dealCard(3,playerHand);

        int expected = 3;
        int actual = playerHand.getCards().size();

        Assert.assertEquals(expected,actual);
        System.out.println(playerHand.handToStringAbrev());
    }

    @Test
    public void resolve() {

    }

    @Test
    public void takeTurn() {
    }

    @Test
    public void calculateHandValueTest(){
        Spanish21 spanish21 = new Spanish21(console);
        Hand hand = new Hand();
        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        Card card2 = new Card(Card.Rank.FIVE, Card.Suit.SPADES);
        Card card3 = new Card(Card.Rank.SEVEN, Card.Suit.SPADES);
        hand.addCard(card);
        hand.addCard(card2);
        hand.addCard(card3);
        int handValue = spanish21.calculateHandValue(hand);

        int expected = 13;
        int actual = handValue;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkForDealerBj() {
        Spanish21 spanish21 = new Spanish21(console);
        Hand dealerHand = new Hand();
        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        Card card2 = new Card(Card.Rank.TEN, Card.Suit.SPADES);
        dealerHand.addCard(card);
        dealerHand.addCard(card2);
        spanish21.checkForDealerBj();
        int expected = 21;
        Assert.assertEquals(spanish21.calculateHandValue(dealerHand), expected);
    }

    @Test
    public void checkForUserBj() {
        Spanish21 spanish21 = new Spanish21(console);
        Hand hand = new Hand();
        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        Card card2 = new Card(Card.Rank.TEN, Card.Suit.SPADES);
        hand.addCard(card);
        hand.addCard(card2);
        spanish21.checkForUserBj();
        int expected = 21;
        Assert.assertEquals(expected, spanish21.calculateHandValue(hand));

    }

    @Test
    public void checkForBust() {
        Spanish21 spanish21 = new Spanish21(console);
        Hand hand = new Hand();
        Card card = new Card(Card.Rank.TEN, Card.Suit.SPADES);
        Card card2 = new Card(Card.Rank.TEN, Card.Suit.SPADES);
        Card card3 = new Card(Card.Rank.TEN, Card.Suit.DIAMONDS);
        hand.addCard(card);
        hand.addCard(card2);
        hand.addCard(card3);
        Assert.assertTrue(spanish21.checkForBust(hand));
    }


    @Test
    public void checkForBust2() {
        Spanish21 spanish21 = new Spanish21(console);
        Hand playerHand = new Hand();
        Card card = new Card(Card.Rank.TEN, Card.Suit.SPADES);
        Card card2 = new Card(Card.Rank.FIVE, Card.Suit.SPADES);
        playerHand.addCard(card);
        playerHand.addCard(card2);

        Assert.assertFalse(spanish21.checkForBust(playerHand));

    }

}