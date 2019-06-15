package com.groupFour.Games;
import com.groupFour.Console;

import com.groupFour.Console;
import com.groupFour.Dice;
import com.groupFour.Interfaces.Game;
import com.groupFour.Player;

import java.util.ArrayList;
import java.util.List;

public class GreaterThanThree extends Game {

    public static final String gameName = "Greater than Three";
    protected Dice dice;
    protected Player player;
    protected Console console;
    protected ArrayList<Integer> finalList;
    protected Integer rollCount = 1;
    protected Boolean isDonePlaying;
    protected Integer[] theDice = {0,0,0,0,0,0,0};
    protected Boolean win = false;
    protected Integer numDiceKept = 0;
    protected Integer whichDiceToKeep;

    public GreaterThanThree(Player player, Console console){
        super();
        this.player = player;
        this.dice=new Dice(5);
        this.console=console;
        this.finalList = new ArrayList<Integer>();
        this.isDonePlaying = false;
    }




    public GreaterThanThree(Console console){
        this(new Player(),console);
    }

    public void setup() {
        while(!this.isDonePlaying){
            takeTurn();
        }
    }
    public void compareDiceResult(){
        for(int i=1;i<7;i++){
            theDice[i]=0;
        }
        for (Integer die:dice.getDiceResult()) {
            theDice[die]++;
        }
        for(Integer die:finalList){
            theDice[die]++;
        }
        for (int i = 1; i < 7; i++) {
            if(theDice[i] > 2){
                win =true;
                console.println("Congratulations you won with " + theDice[i] + " " + i +"'s!");
            }
        }
    }

    public void takeTurn() {
        dice.setRollCount(0);
        win = false;
        dice.rollDice();
        dice.setRollCount(rollCount++);
        compareDiceResult();

        while (!win && dice.getRollCount() <= 4) {
            console.println("You rolled " + dice.toString());
            if (finalList.size() > 0)
                console.println("You now have " + finalList.toString() + " and " + dice.toString());
            boolean invalidInput = true;
            numDiceKept = whichDiceToKeep(numDiceKept, invalidInput);
            Dice reRollDice = new Dice(5 - numDiceKept);
            dice = reRollDice;
            dice.rollDice();
            dice.setRollCount(rollCount++);
            compareDiceResult();
        }
        if( rollCount >= 4 ){
            console.println("You've had enough turns, you've either already won or you're not going to." +
                    "        ");
        }
        isDonePlaying = true;
        if (isDonePlaying == true) {
            String answer = console.getStringInput("Would you like to play again?");
            switch (answer.toLowerCase()) {
                case "y":
                case "yes":
                case "yes please":
                case "yes thank you": {
                    isDonePlaying = false;
                    GreaterThanThree game = new GreaterThanThree(this.player,this.console);
                    game.setup();
                    break;
                }
                case "no":
                case "n": {
                    isDonePlaying = true;
                    break;
                }
                default:
                    break;
            }
        }
    }

    protected Integer whichDiceToKeep(Integer numDiceKept, boolean invalidInput) {
        while (invalidInput){
            List<Integer> temp = new ArrayList<>();
            List<Integer> temp2 = dice.getDiceResult();
            String rawDiceToKeep = console.getStringInput(
                    "Please enter the values of the dice you would like to add to your collection, separated by a space. " +
                    "Enter 0 to add no dice.");
            if(rawDiceToKeep.equals("0")){
                invalidInput=false;
            }
            else{
                String[] splitDiceToKeep = rawDiceToKeep.split(" ");
                invalidInput = false;
                invalidInput = isInvalidInput(invalidInput, temp, splitDiceToKeep);
                if (!invalidInput) {
                    numDiceKept = moveKeptDiceToFinal(numDiceKept, temp, temp2);
                }
            }
        }
        return numDiceKept;
    }

    public Integer moveKeptDiceToFinal(Integer numDiceKept, List<Integer> temp, List<Integer> temp2) {
        for (Integer daInt:temp) {
            if(dice.getDiceResult().contains(daInt)){
                int i = temp2.indexOf(daInt);
                finalList.add(daInt);
                temp2.remove(i);
                numDiceKept++;
            }
            else {console.println("You ain't got no " + daInt);
            }
        }
        return numDiceKept;
    }

    public boolean isInvalidInput(boolean invalidInput, List<Integer> temp, String[] splitDiceToKeep) {
        for (String string: splitDiceToKeep) {
            try{
                temp.add(Integer.parseInt(string));
            } catch (NumberFormatException nfe) {
                invalidInput = true;
                console.println("C'mon man, that's not even a number!");
            }
        }
        if (!invalidInput){
            for (Integer daInt:temp) {
                if(daInt < 1 || daInt > 6){
                    invalidInput = true;
                    console.println("You realize these dice have six sides, right?");
                }
            }
        }
        return invalidInput;
    }


    public Player getPlayer() {
        return player;
    }

}
