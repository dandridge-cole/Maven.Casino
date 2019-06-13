package com.groupFour;

import com.groupFour.Games.*;

public class Mediator {
    static final Boolean ALLOW_CUSTOM_WALLET = true;
    Console in = new Console(System.in,System.out);
    Player player;


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

    void run(){
        initPlayer(this.player);
        initPlayerWallet(this.player);
    }

    public void initPlayer(Player player){
        player.setName(in.getStringInput("Welcome to the best virtual casino ever!  And whom do we have the honor of fleecing today?"));
    }

    public void initPlayerWallet(Player player){
        if(ALLOW_CUSTOM_WALLET) player.setWallet(in.getDoubleInput("And how much may we exchange for you, to get started?"));
        else player.setWallet(player.DEFAULT_WALLET);
    }

    private void listGames(){}

    private void greetPlayer(){
        in.println(String.format("Hello %s, you currently have $%1.2f.",player.getName(),player.getWallet()));
    }

    private void mainMenu(){}
}
