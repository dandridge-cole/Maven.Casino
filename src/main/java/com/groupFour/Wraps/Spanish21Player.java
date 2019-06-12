package com.groupFour.Wraps;

import com.groupFour.Hand;
import com.groupFour.Interfaces.GamblingPlayer;
import com.groupFour.Player;

public class Spanish21Player implements GamblingPlayer {

    private Player player;
    private Hand hand;
    private  Double balance;

    public Spanish21Player(Double balance) {
        this.balance = balance;
    }

    public Double getBalance(){
        return null;
    }

    public void setBalance(Double amount) {

    }

    public void addToBalance(Double amount) {

    }

    public void subtractFromBalance(Double amount) {

    }
}
