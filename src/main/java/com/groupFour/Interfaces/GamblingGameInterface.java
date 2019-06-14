package com.groupFour.Interfaces;

public interface GamblingGameInterface {
    public void placeBet(Double amount);
    public void resolve();
    public boolean validateBet(double bet);
}
