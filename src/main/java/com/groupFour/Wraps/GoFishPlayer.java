package com.groupFour.Wraps;

import com.groupFour.Hand;
import com.groupFour.Player;

public class GoFishPlayer {
    private Player player;
    private Hand hand;
    private String name;

    public GoFishPlayer(Player player){
        this.player=player;
        this.hand=new Hand();
    }

    public GoFishPlayer(String name){
        this.name = name;
    }

    public GoFishPlayer(){this(new Player()); }
}
