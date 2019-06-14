package com.groupFour.Games;
import com.groupFour.*;
import com.groupFour.Interfaces.GamblingGame;
import com.groupFour.Interfaces.GamblingGameInterface;
import com.groupFour.Interfaces.GamblingPlayer;
import com.groupFour.Wraps.BlackjackPlayer;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.HashMap;

import static org.junit.Assert.*;

public class BlackjackTest {

    @Test
    public void placeBetTest() {

        String invalid = "this isn't a number";
        Double expected =50.0;
        String buffer = invalid+"\n"+expected;
        ByteArrayInputStream testInputStream = new ByteArrayInputStream(buffer.getBytes());
        Console console = new Console(testInputStream,System.out);
        Blackjack blackjack = new Blackjack(new BlackjackPlayer(), console);

        blackjack.placeBet();

        System.out.println(blackjack.getCurrentBet());

    }

    @Test
    public void dealCards() {
       // Blackjack blackjack = new Blackjack();
       // blackjack.dealCards();


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
        int actual = Blackjack.dealerHand.getCards().size();

        Assert.assertEquals(expected,actual);
        System.out.println(Blackjack.dealerHand.handToString());

    }

    @Test
    public void dealCardToUser() {
        Blackjack blackjack = new Blackjack();
        Hand hand = new Hand();
        BlackjackPlayer player = new BlackjackPlayer();
        blackjack.dealCardToUser(3);

        int expected = 3;
        int actual = player.hand.getCards().size();

        Assert.assertEquals(expected,actual);
        System.out.println(player.hand.handToStringAbrev());
    }

    @Test
    public void resolve() {
    }

    @Test
    public void validateBet() {
//        Blackjack blackjack = new Blackjack();
//        blackjack.setup();
        Player player = new Player("Bob", 5.0);
        BlackjackPlayer bjPlayer = new BlackjackPlayer(player);
        bjPlayer.setBalance(555.0);
        System.out.println(bjPlayer.getBalance());
//        System.out.println(blackjack.getMinBet());
//        Assert.assertTrue(blackjack.validateBet(bjPlayer.getBalance()));


    }

    @Test
    public void validateBetFalse() {
        Blackjack blackjack = new Blackjack();
        blackjack.setup();
        Player player = new Player("Bob", 5.0);
        BlackjackPlayer bjPlayer = new BlackjackPlayer(player);
        bjPlayer.setBalance(5.0);
        System.out.println(bjPlayer.getBalance());
        System.out.println(blackjack.getMinBet());
        Assert.assertFalse(blackjack.validateBet(bjPlayer.getBalance()));


    }

    @Test
    public void takeTurn() {
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
    public void calculateHandValue() {
    }
}