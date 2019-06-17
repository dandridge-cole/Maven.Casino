package com.groupFour.Games;
import com.groupFour.Console;
import com.groupFour.Dice;
import com.groupFour.Interfaces.GamblingGame;
import com.groupFour.Wraps.CrapsPlayer;

public class Craps extends GamblingGame {
   public static final String gameName = "Craps";
    private CrapsPlayer player;
    private Dice dice;
    private Console display;
    private Boolean pointPhaseState;
    private Integer pointNum;
    private Boolean passLineBet;

    public Craps(CrapsPlayer player, Dice dice, Console display, Boolean pointPhaseState, Integer pointNum, Boolean passLineBet) {
        super(0.0, 5.0, 10000.0);
        this.player = player;
        this.dice = dice;
        this.display = display;
        this.pointPhaseState = pointPhaseState;
        this.pointNum = pointNum;
        this.passLineBet = passLineBet;
    }

    public Craps(CrapsPlayer player, Console console) {
        super();
        this.player = player;
        this.dice = new Dice(2);
        this.display=console;
    }

    public Craps(Console console) {
        this(new CrapsPlayer(),console);
    }

    // Get/set currentBet(), minBet(), maxBet()

    public void setup() {
        setup(5.0, 1000.0);
        while(!isDonePlaying())takeTurn();
    }
    public void takeTurn() {
        String input = "";
        displayWaitForInput("You're the shooter");
        setPassLineBet(true);
        switch(display.getIntegerInput("Choose a bet: " +
                "(1)Pass Line\n(2)Don't Pass Line\n")){
            case 1:{
                setPassLineBet(true);
                break;
            }
            case 2:{
                setPassLineBet(false);
                break;
            }
            default:{
                takeTurn();
            }
        }
        placeBet();
        dice.rollDice();
        display.println("The dice have been rolled. It's a " + lastRollTotal());
        if(checkComeOutWin(lastRollTotal(), getPassLineBet())){
            // Win
            resolve();
            pointPhaseState = false;
        }
        if(checkComeOutLoss(lastRollTotal(), getPassLineBet())){
            if(display.getStringInput("Do you want to try again? (y/n)").toLowerCase().equals("n")) {
                exit();
                pointPhaseState = false;
            }
        }
        pointNum = lastRollTotal();
        while(pointPhaseState){
            displayWaitForInput("The point has been established at: " + getPointNum());
            dice.rollDice();
            display.println("The dice have been rolled. It's a " + lastRollTotal());
            if(pointRollResult(pointNum, getPassLineBet())){
                resolve();
                pointPhaseState = false;
            }
        }
    }
    public void displayWaitForInput(String text){
        display.println(text + "\n\n");
        display.getStringInput("Press Enter");
    }
    public Boolean checkComeOutWin(Integer lastRollTotal, Boolean bet){
        if(bet){
            return lastRollTotal == 7 || lastRollTotal == 11;
        } else {
            return lastRollTotal == 2 || lastRollTotal == 3 || lastRollTotal == 12;
        }
    }
    public Boolean checkComeOutLoss(Integer lastRollTotal, Boolean bet){
        if(bet){
            return lastRollTotal == 2 || lastRollTotal == 3 || lastRollTotal == 12;
        } else {
            return lastRollTotal == 7 || lastRollTotal == 11;
        }
    }
    public void placeBet() {
        Double desiredBet = display.getDoubleInput("How much will you bet?");
        if(validateBet(desiredBet)) setBet(desiredBet);
        else display.println("Your amount was invalid");
    }
    public void resolve() {
        display.println(String.format("You gained $%.2f", getCurrentBet()));
        player.addToBalance(2 * getCurrentBet());
        display.println(String.format("Your total funds: $%.2f", player.getBalance()));
    }
    public boolean validateBet(double desiredBet) {
        return (desiredBet >= getMinBet() && desiredBet <= getMaxBet() && desiredBet <= player.getBalance());
    }
    public Integer lastRollTotal() {
        Integer total = 0;
        for(Integer n : dice.getDiceResult()) total += n;
        return total;
    }
    public void setBet(Double desiredBet){
        player.subtractFromBalance(desiredBet);
        setCurrentBet(desiredBet);
    }
    public void setup(Double min, Double max){
        setMinBet(min);
        setMaxBet(max);
    }
    public Boolean pointRollResult(Integer pointNum, Boolean bet) {
        return (bet && lastRollTotal() == pointNum) || (!bet && lastRollTotal() == 7);
    }

    public Dice getDice() {
        return dice;
    }
    public Console getDisplay() {
        return display;
    }
    public Boolean getPointPhaseState() {
        return pointPhaseState;
    }
    public Integer getPointNum() {
        return pointNum;
    }
    public Boolean getPassLineBet() {
        return passLineBet;
    }
    public CrapsPlayer getPlayer() {
        return player;
    }

    public void setPassLineBet(Boolean passLineBet) {
        this.passLineBet = passLineBet;
    }
}


