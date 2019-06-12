package com.groupFour;

import com.groupFour.Games.*;

public class Mediator {
    Console in = new Console(System.in,System.out);

    public void startGame(Integer choice){
        switch(choice){
            case 0:{
                Blackjack game = new Blackjack();
                game.setup();
                break;
            }
            case 1:{
                Craps game = new Craps();
                game.setup();
                break;
            }
            case 2:{
                GoFish game = new GoFish();
                game.setup();
                break;
            }
            case 3:{
                GreaterThanThree game = new GreaterThanThree();
                game.setup();
                break;
            }
            default:{
                Spanish21 game = new Spanish21();
                game.setup();
                break;
            }
        }
    }
}
