package com.groupFour.Games;
import com.groupFour.Console;
import com.groupFour.Dice;
import com.groupFour.Interfaces.GamblingGame;
import com.groupFour.Wraps.CrapsPlayer;

public class Craps extends GamblingGame {
    static final String gameName = "Craps";
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
    public Boolean checkComeOutWin(Integer lastRollTotal, Boolean bet){
        return null;
    }
    public Boolean checkComeOutLoss(Integer lastRollTotal, Boolean bet){
        return null;
    }
    public void placeBet(Double amount) {

    }
    public void resolve() {
    }
    public boolean validateBet(double desiredBet) {
        return true;
    }
    public void takeTurn() {
    }
    public void setup(Double min, Double max){
        // Set min/max bet
    }
    // Get/set currentBet(), minBet(), maxBet()
    public CrapsPlayer getPlayer() {
        return player;
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
    public void setPassLineBet(Boolean passLineBet) {
        this.passLineBet = passLineBet;
    }
    public Integer lastRollTotal() {
        return null;
    }
    public void setup() {

    }
}


