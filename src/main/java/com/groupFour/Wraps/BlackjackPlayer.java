package com.groupFour.Wraps;

import com.groupFour.Hand;
import com.groupFour.Interfaces.GamblingPlayer;
import com.groupFour.Player;

public class BlackjackPlayer implements GamblingPlayer {

    private Player player;
    public static Hand hand;


    public BlackjackPlayer(Player player) {
        this.player = player;
        this.hand = new Hand();
   }

   public BlackjackPlayer(){
       this.player=new Player();
       this.hand = new Hand();
   }

    public Double getBalance() {
        return player.getWallet();
    }

    public void setBalance(Double amount) {
        player.setWallet(amount);
    }

    public void addToBalance(Double amount) {
        player.setWallet(player.getWallet()+amount);
    }

    public void subtractFromBalance(Double amount) {
        player.setWallet(player.getWallet()-amount);
    }
}
