package com.groupFour.Interfaces;

public abstract class Game {

    private Boolean donePlaying;

    public abstract void takeTurn();


    public void exit(){
        // flip done playing
    }

    public Boolean isDonePlaying(){return donePlaying;}

    public abstract void setup();
}
