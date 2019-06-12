package com.groupFour.Interfaces;

public abstract class Game {

    private Boolean donePlaying;

    public Game(){this.donePlaying=false;}

    public abstract void takeTurn();

    public void exit(){
        this.donePlaying=true;
    }

    public Boolean isDonePlaying(){return donePlaying;}

    public abstract void setup();
}
