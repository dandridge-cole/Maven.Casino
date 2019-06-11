package com.groupFour.Interfaces;

abstract public class GamblingGame extends Game implements GamblingGameInterface{
    private Double currentBet;
    private Double minBet;
    private Double maxBet;

    public Double getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(Double currentBet) {
        this.currentBet = currentBet;
    }

    public Double getMinBet() {
        return minBet;
    }

    public void setMinBet(Double minBet) {
        this.minBet = minBet;
    }

    public Double getMaxBet() {
        return maxBet;
    }

    public void setMaxBet(Double maxBet) {
        this.maxBet = maxBet;
    }
}
