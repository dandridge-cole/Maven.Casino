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

    public void takeTurn() {
        // one cycle of the game
    }
    public Boolean checkComeOutWin(Integer lastRollTotal, Boolean bet){
        if(bet){
            return lastRollTotal == 7 || lastRollTotal == 11;
        } else {
            return lastRollTotal == 2 || lastRollTotal == 3 || lastRollTotal == 12;
        }
    }
    public Boolean checkComeOutLoss(Integer lastRollTotal, Boolean bet){
        // whether or not you lost the come out roll
        return null;
    }
    public void placeBet() {
        // validate and place a bet made by player input
        // call testable method
    }
    public void resolve() {
        // pay the player on a win
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
        setCurrentBet(desiredBet);
    }
    public void setup() {
        setup(5.0, 1000.0);
    }
    public void setup(Double min, Double max){
        // Set min/max bet
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


