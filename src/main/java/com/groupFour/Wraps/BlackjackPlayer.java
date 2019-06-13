package com.groupFour.Wraps;

import com.groupFour.Hand;
import com.groupFour.Interfaces.GamblingPlayer;
import com.groupFour.Player;

public class BlackjackPlayer implements GamblingPlayer {

    private Player player;
    private Hand hand;
    private Double balance;

    public BlackjackPlayer(Player player) {
        this.player = player;
        this.balance=this.player.getWallet();
        this.hand = new Hand();
   }

   public BlackjackPlayer(){
        this.player=new Player();
       this.balance=this.player.getWallet();
       this.hand = new Hand();
   }

    public Double getBalance() {
        return null;
    }

    public void setBalance(Double amount) {

    }

    public void addToBalance(Double amount) {

    }

    public void subtractFromBalance(Double amount) {

    }
}
