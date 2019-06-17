package com.groupFour.Games;
import com.groupFour.*;
import com.groupFour.Interfaces.GamblingGame;
import com.groupFour.Wraps.BlackjackPlayer;
import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static com.groupFour.Wraps.BlackjackPlayer.playerHand;


public class BlackjackTest {
    Console console;
    private InputStream input;

    /*@Test
    public void placeBetTest() {
        BlackjackPlayer bjPlayer = new BlackjackPlayer();
        Blackjack blackjack = new Blackjack(bjPlayer, console);
        Double bet =50.0;
        String buffer = bet + "\n" + bet + "\n";
        ByteArrayInputStream testInputStream = new ByteArrayInputStream(buffer.getBytes());
        console = new Console(testInputStream,System.out);
        blackjack.setMinBet(10.0);
        blackjack.setMaxBet(500.0);
        blackjack.placeBet();

        Assert.assertEquals(bet,blackjack.getCurrentBet());

    }
*/
    @Test
    public void dealCards() {
        Blackjack blackjack = new Blackjack(console);
        blackjack.dealCards();


        int expectedDealer = 2;
        int expectedUser = 2;

        int actualDealer = Blackjack.dealerHand.getCards().size();
        int actualUser = playerHand.getCards().size();

        Assert.assertEquals(expectedDealer,actualDealer);
        Assert.assertEquals(expectedUser, actualUser);
    }

    @Test
    public void dealCardToDealerTest() {
        Blackjack blackjack = new Blackjack(console);
        Hand dealerHand = new Hand();
        blackjack.dealCard(3, dealerHand);

        int expected = 3;
        int actual = dealerHand.getCards().size();

        Assert.assertEquals(expected,actual);
        System.out.println(Blackjack.dealerHand.handToString());

    }

    @Test
    public void dealCardToUser() {
        Blackjack blackjack = new Blackjack(console);
        Hand playerHand = new Hand();
        BlackjackPlayer player = new BlackjackPlayer();
        blackjack.dealCard(3,playerHand);

        int expected = 3;
        int actual = playerHand.getCards().size();

        Assert.assertEquals(expected,actual);
        System.out.println(playerHand.handToStringAbrev());
    }

    @Test
    public void resolve() {

    }

   /* @Test
    public void validateBet() {
        Blackjack blackjack = new Blackjack(console);
        blackjack.setup();
        Player player = new Player("Bob", 5.0);
        BlackjackPlayer bjPlayer = new BlackjackPlayer(player);
        bjPlayer.setBalance(555.0);
        System.out.println(bjPlayer.getBalance());
        System.out.println(blackjack.getMinBet());
        Assert.assertTrue(blackjack.validateBet(bjPlayer.getBalance()));


    }

    @Test
    public void validateBetFalse() {
        Blackjack blackjack = new Blackjack(console);
        blackjack.setup();
        Player player = new Player("Bob", 5.0);
        BlackjackPlayer bjPlayer = new BlackjackPlayer(player);
        bjPlayer.setBalance(5.0);
        System.out.println(bjPlayer.getBalance());
        System.out.println(blackjack.getMinBet());
        Assert.assertFalse(blackjack.validateBet(bjPlayer.getBalance()));


    }
*/
    @Test
    public void takeTurn() {
    }

    @Test
    public void calculateHandValueTest(){
        Blackjack blackjack = new Blackjack(console);
        Hand hand = new Hand();
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
    public void checkForDealerBj() {
        Blackjack blackjack = new Blackjack(console);
        Hand dealerHand = new Hand();
        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        Card card2 = new Card(Card.Rank.TEN, Card.Suit.SPADES);
        dealerHand.addCard(card);
        dealerHand.addCard(card2);
        blackjack.checkForDealerBj();
        int expected = 21;
        Assert.assertEquals(blackjack.calculateHandValue(dealerHand), expected);
    }

    @Test
    public void checkForUserBj() {
        Blackjack blackjack = new Blackjack(console);
        Hand hand = new Hand();
        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADES);
        Card card2 = new Card(Card.Rank.TEN, Card.Suit.SPADES);
        hand.addCard(card);
        hand.addCard(card2);
        blackjack.checkForUserBj();
        int expected = 21;
        Assert.assertEquals(expected, blackjack.calculateHandValue(hand));

    }

    @Test
    public void checkForBust() {
        Blackjack blackjack = new Blackjack(console);
        Hand hand = new Hand();
        Card card = new Card(Card.Rank.TEN, Card.Suit.SPADES);
        Card card2 = new Card(Card.Rank.TEN, Card.Suit.SPADES);
        Card card3 = new Card(Card.Rank.TEN, Card.Suit.DIAMONDS);
        hand.addCard(card);
        hand.addCard(card2);
        hand.addCard(card3);
        Assert.assertTrue(blackjack.checkForBust(hand));
    }


    @Test
    public void checkForBust2() {
        Blackjack blackjack = new Blackjack(console);
        Hand playerHand = new Hand();
        Card card = new Card(Card.Rank.TEN, Card.Suit.SPADES);
        Card card2 = new Card(Card.Rank.FIVE, Card.Suit.SPADES);
        playerHand.addCard(card);
        playerHand.addCard(card2);

        Assert.assertFalse(blackjack.checkForBust(playerHand));

    }
}