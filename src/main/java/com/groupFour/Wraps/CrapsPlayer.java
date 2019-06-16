package com.groupFour.Wraps;

import com.groupFour.Hand;
import com.groupFour.Interfaces.GamblingPlayer;
import com.groupFour.Player;

public class CrapsPlayer implements GamblingPlayer {

    private Player player;
    private Hand hand;
    private Double balance;


    public CrapsPlayer(Player player) {
        this.player = player;
        this.balance=this.player.getWallet();
        this.hand = new Hand();
    }
    public CrapsPlayer() {
        this.player=new Player();
        this.balance=this.player.getWallet();
        this.hand = new Hand();
    }

    public Double getBalance(){
        return player.getWallet();
    }

    public void setBalance(Double amount) {
        player.setWallet(amount);
    }

    public void addToBalance(Double amount) {
        player.setWallet(player.getWallet() + amount);
    }

    public void subtractFromBalance(Double amount) {
        player.setWallet(player.getWallet() - amount);
    }
}
