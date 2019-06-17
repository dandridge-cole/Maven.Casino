package com.groupFour.Wraps;

import com.groupFour.Hand;
import com.groupFour.Interfaces.GamblingPlayer;
import com.groupFour.Player;

public class Spanish21Player implements GamblingPlayer {

    private Player player;
    public static Hand playerHand;

    public Spanish21Player(Player player) {
        this.player = player;
        this.playerHand=new Hand();
    }

    public Spanish21Player() {
        this.player=new Player();
        this.playerHand=new Hand();
    }

    public Double getBalance(){
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
