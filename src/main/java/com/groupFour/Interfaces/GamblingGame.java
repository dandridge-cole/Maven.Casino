package com.groupFour.Interfaces;

abstract public class GamblingGame extends Game implements GamblingGameInterface{
    protected Double currentBet;
    private Double minBet;
    private Double maxBet;

    public GamblingGame() {
        super();
    }

    public GamblingGame(Double currentBet, Double minBet, Double maxBet) {
        this.currentBet = currentBet;
        this.minBet = minBet;
        this.maxBet = maxBet;
    }

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
        if(minBet>0&&(this.maxBet==null||minBet<this.maxBet)) this.minBet = minBet;
    }

    public Double getMaxBet() {
        return maxBet;
    }

    public void setMaxBet(Double maxBet) { if(maxBet>0&&(this.minBet==null||maxBet>this.minBet)) this.maxBet = maxBet; }
}
