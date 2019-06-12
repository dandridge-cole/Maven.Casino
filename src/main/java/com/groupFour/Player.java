package com.groupFour;

public class Player {

    public Player(String name) {
        this.name = name;
    }

    public Player() {
        this.name = "Player1";
    }

    private String name;

    public Double getWallet() {
        return wallet;
    }

    public void setWallet(Double wallet) {
        this.wallet = wallet;
    }

    private Double wallet;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
