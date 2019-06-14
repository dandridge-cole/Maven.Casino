package com.groupFour;

import com.groupFour.Games.*;

import java.util.ArrayList;
import java.util.List;

class Mediator {
    private static final Boolean ALLOW_CUSTOM_WALLET = true;
    private Console console = new Console(System.in,System.out);
    private Player player = new Player();
    private List<String> gameNames = new ArrayList<>();
    private Boolean quit = false;

    public void run(){
        initGamesList();
        while(!quit) {
            initPlayer(this.player);
            initPlayerWallet(this.player);
            mainMenu();
        }
    }

    private void initPlayer(Player player){
        String name = console.getStringInput("Welcome to the best virtual casino ever!  And whom do we have the honor of fleecing today?");
        player.setName(name);
    }

    private void initPlayerWallet(Player player){
        if(ALLOW_CUSTOM_WALLET) {
            Double amount = console.getDoubleInput("And how much may we exchange for you, to get started?");
            Double confirmedAmt = confirmValidWalletIncrease(amount, player);
            player.setWallet(confirmedAmt);
        }
        else player.setWallet(Player.DEFAULT_WALLET);
    }

    private void initGamesList(){
        gameNames.add(Blackjack.gameName);
        gameNames.add(Craps.gameName);
        gameNames.add(GoFish.gameName);
        gameNames.add(GreaterThanThree.gameName);
        gameNames.add(Spanish21.gameName);
    }

    private void startGame(){
        Boolean prevMenu=false;
        while(!prevMenu) {
            String selection = buildGamesMenu();
            switch (selection.toLowerCase()) {
                case "0":
                case "blackjack": {
                    Blackjack game = new Blackjack();
                    game.setup();
                    break;
                }
                case "1":
                case "craps": {
                    Craps game = new Craps();
                    game.setup();
                    break;
                }
                case "2":
                case "go fish": {
                    GoFish game = new GoFish();
                    game.setup();
                    break;
                }
                case "3":
                case "greater than three": {
                    GreaterThanThree game = new GreaterThanThree();
                    game.setup();
                    break;
                }
                case "4":
                case "spanish 21": {
                    Spanish21 game = new Spanish21();
                    game.setup();
                    break;
                }
                case "5":
                case "previous menu": {
                    prevMenu = true;
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    private String buildGamesMenu() {
        StringBuilder builder = new StringBuilder("Please select a game:");
        for (int i = 0; i < gameNames.size(); i++) {
            builder.append(String.format("\n\t%d: %S", i, gameNames.get(i)));
        }
        builder.append(String.format("\n\t%d: Previous Menu\n", gameNames.size()));
        return console.getStringInput(builder.toString());
    }


    private void greetPlayer(){
        console.println(String.format("Hello %s, you currently have $%,1.2f.",player.getName(),player.getWallet()));
    }

    private void mainMenu(){
        boolean resetPlayer=false;
        while(!quit&&!resetPlayer){
            Integer menuItem=0;
            greetPlayer();
            String selection = buildMainMenu();
            switch (selection.toLowerCase()) {
                case "0":
                case "choose a game":{
                    startGame();
                    break;
                }
                case "1":
                case "increase balance":{
                    increaseBalance();
                    break;
                }
                case "2":
                case "reset player":{
                    resetPlayer=true;
                    break;
                }
                case "3":
                case "quit":{
                    if(!keepTheCustomer()) quit=true;
                    break;
                }
                default: break;
            }
        }
    }

    private String buildMainMenu() {
        Integer menuItem=0;
        StringBuilder builder = new StringBuilder("What would you like to do?");
        builder.append(String.format("\n\t%d: Choose a game", menuItem++));
        builder.append(String.format("\n\t%d: Increase Balance", menuItem++));
        builder.append(String.format("\n\t%d: Reset Player", menuItem++));
        builder.append(String.format("\n\t%d: Quit\n", menuItem));
        return console.getStringInput(builder.toString());
    }

    private Boolean keepTheCustomer() {
        Boolean kept = true;
        String answer = console.getStringInput("Can we get you a complimentary drink?");
        switch (answer.toLowerCase()) {
            case "n":
            case "no":
            case "no thankyou":
            case "no thank you": {
                kept = false;
                break;
            }
            default:
                break;
        }
        //more time wasting could be added here;
        return kept;
    }
    private void increaseBalance(){
        Double amount = (console.getDoubleInput("You currently have $%,1.2f. How much would you like to add?",player.getWallet()));
        Double confirmedAmt = confirmValidWalletIncrease(amount, player);
        player.setWallet(player.getWallet()+confirmedAmt);
    }

    private Double confirmValidWalletIncrease(Double amount, Player player) {
        while(amount<=0||amount>999999999) {
            if (amount <= 0) {
                amount = console.getDoubleInput("I'm sorry, but we do not exchange negative or zero balances. Please enter a valid amount.");
            }
            else{
                amount = console.getDoubleInput("I'm sorry, but we are not able to exchange billions in individual transactions. Please enter a reasonable amount.");
            }
        }
        return amount;
    }
}
