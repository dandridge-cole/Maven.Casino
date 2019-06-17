package com.groupFour;

import com.groupFour.Games.*;
import com.groupFour.Wraps.BlackjackPlayer;
import com.groupFour.Wraps.CrapsPlayer;
import com.groupFour.Wraps.GoFishPlayer;
import com.groupFour.Wraps.Spanish21Player;

import java.util.ArrayList;
import java.util.List;

class   Mediator {
    private static final Boolean ALLOW_CUSTOM_WALLET = true;
    private Console console;
    private Player player;
    private List<String> gameNames;
    private Boolean quit;
    private List<String> bannedPlayers=new ArrayList<>();

    Mediator(Console console, Player player) {
        this.console = console;
        this.player = player;
        this.gameNames = new ArrayList<>();
        this.quit = false;
    }

    Mediator(Console console) {this(console, new Player());}

    Mediator() {
        this(new Console(System.in,System.out));
    }

    void run(){
        initGamesList();
        initBannedPlayers();
        while(!quit) {
            initPlayer(this.player);
            if(!quit)initPlayerWallet(this.player);
            mainMenu();
        }
    }


    /* *************
     * INTIALIZERS *
     * ************/

    void initPlayer(Player player){// could be private except for testing
        String welcomeMessage=
                "*****                  *****\n" +
                "****                    ****\n" +
                "**         Casino         **\n" +
                "**   Opulence  Vulgaire   **\n" +
                "****                    ****\n" +
                "*****                  *****\n" +
                "\n\nWelcome to the best virtual casino ever!  And whom do we have the honor of fleecing today?";
        String name = console.getStringInput(welcomeMessage);
        isBannedPlayer(name);
        player.setName(name);
    }

    void initPlayerWallet(Player player){// could be private except for testing
        if(ALLOW_CUSTOM_WALLET) {
            Double amount = console.getDoubleInput("And how much may we exchange for you, to get started?");
            Double confirmedAmt = confirmValidWalletIncrease(amount, player);
            player.setWallet(confirmedAmt);
        }
        else player.setWallet(Player.DEFAULT_WALLET);
    }

    void initGamesList(){ // could be private except for testing
        this.gameNames.add(Blackjack.gameName);
        this.gameNames.add(Craps.gameName);
        this.gameNames.add(GoFish.gameName);
        this.gameNames.add(GreaterThanThree.gameName);
        this.gameNames.add(Spanish21.gameName);
    }

    void initBannedPlayers(){

        this.bannedPlayers.add("anish patel");
        this.bannedPlayers.add("donald trump");
        this.bannedPlayers.add("bob's mom");
    }

    void isBannedPlayer(String name){
        if (this.bannedPlayers.contains(name.toLowerCase())){
            this.quit=true;
            this.console.println("I'm sorry "+ name +", but you are not welcome at the best virtual casino ever. Have a nice day.");
        }
    }

    private Boolean keepTheCustomer() {
        Boolean kept = true;
        String answer = console.getStringInput("Could we offer you a complimentary drink?");
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
    void increaseBalance(){
        Double amount = (console.getDoubleInput("You currently have $%,1.2f. How much would you like to add?",player.getWallet()));
        Double confirmedAmt = confirmValidWalletIncrease(amount, player);
        player.setWallet(player.getWallet()+confirmedAmt);
    }

    Double confirmValidWalletIncrease(Double amount, Player player) {  // could be private except for testing
        while(amount<=0||amount>999999999) {
            if (amount <= 0) {
                amount = console.getDoubleInput("I'm sorry, but we do not exchange negative balances. Please enter a valid amount.");
            }
            else{
                amount = console.getDoubleInput("I'm sorry, but we are not able to exchange billions in individual transactions. Please enter a reasonable amount.");
            }
        }
        return amount;
    }


    /* ***********
     * MAIN MENU *
     * **********/

    private void greetPlayer(){
        console.println(String.format("Hello %s, you currently have $%,1.2f.",player.getName(),player.getWallet()));
    }

    private String buildMainMenu() {
        Integer menuItem=0;
        StringBuilder builder = new StringBuilder("\n" +
                "****************\n" +
                "* CASINO LOBBY *\n" +
                "****************\n" +
                "\nHow may we serve you today?"+
                String.format("\n\t%d: Choose a game", menuItem++)+
                String.format("\n\t%d: Increase Balance", menuItem++)+
                String.format("\n\t%d: Reset Player", menuItem++)+
                String.format("\n\t%d: Quit\n", menuItem));
        return console.getStringInput(builder.toString());
    }

    private void mainMenu(){
        boolean resetPlayer=false;
        while(!quit&&!resetPlayer){
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


    /* ************
     * GAMES MENU *
     * ***********/

    String buildGamesMenu() { // could be private except for testing
        StringBuilder builder = new StringBuilder("\n" +
                "****************\n" +
                "* GAMING FLOOR *\n" +
                "****************\n" +
                "\nPlease select a game:");
        for (int i = 0; i < gameNames.size(); i++) {
            builder.append(String.format("\n\t%d: %S", i, gameNames.get(i)));
        }
        builder.append(String.format("\n\t%d: Previous Menu\n", gameNames.size()));
        return console.getStringInput(builder.toString());
    }

    private void startGame(){
        Boolean prevMenu=false;
        while(!prevMenu) {
            String selection = buildGamesMenu();
            switch (selection.toLowerCase()) {
                case "0":
                case "blackjack": {
                    Blackjack game = new Blackjack(new BlackjackPlayer(this.player),this.console);
                    game.setup();
                    break;
                }
                case "1":
                case "craps": {
                    Craps game = new Craps(new CrapsPlayer(this.player),this.console);
                    game.setup();
                    break;
                }
                case "2":
                case "go fish": {
                    GoFish game = new GoFish(new GoFishPlayer(this.player),this.console);
                    game.setup();
                    break;
                }
                case "3":
                case "greater than three": {
                    GreaterThanThree game = new GreaterThanThree(this.player,this.console);
                    game.setup();
                    break;
                }
                case "4":
                case "spanish 21": {
                    Spanish21 game = new Spanish21(new Spanish21Player(this.player),this.console);
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
}
