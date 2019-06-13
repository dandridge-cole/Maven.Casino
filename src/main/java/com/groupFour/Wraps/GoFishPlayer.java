package com.groupFour.Wraps;

import com.groupFour.Hand;
import com.groupFour.Player;

public class GoFishPlayer {
    private Player player;
    private Hand hand;

    public GoFishPlayer(Player player){
        this.player=player;
        this.hand=new Hand();
    }

    public GoFishPlayer(){this(new Player()); }
}
