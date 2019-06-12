package com.groupFour;

public class Player {

    static final Double DEFAULT_WALLET = 5000.0;

    private String name;
    private Double wallet;

    public Player(String name, Double wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public Player() {
        this.name = "Player 1";
        this.wallet = DEFAULT_WALLET;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWallet(){
        return this.wallet;
    }


}
