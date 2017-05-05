package schocken.marco.de.schocken.game.player.impl;

/**
 * Created by Marco on 14.02.2017.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import schocken.marco.de.schocken.exceptions.DiceNotFoundException;
import schocken.marco.de.schocken.exceptions.MaxPenaltyException;
import schocken.marco.de.schocken.exceptions.TooManyShotsException;
import schocken.marco.de.schocken.game.dice.Dice;
import schocken.marco.de.schocken.game.dice.impl.DiceImpl;
import schocken.marco.de.schocken.game.player.Player;

/**
 * The implementation class of a player.
 */
public class PlayerImpl implements Player{

    /**
     * The name of the player.
     */
    private String name;

    /**
     * A list of dices which set the player out.
     */
    private List<Dice> dicesOut;

    /**
     * A list of dices which has the player under the cup.
     */
    private List<Dice> dicesIn;

    /**
     * The list of the dices of a player.
     */
    private List<Dice> dices;

    /**
     * The penalties the player has.
     */
    private int penalties;

    /**
     * A boolean which holds the state of a player.
     * Is the player playing or has he finished the round.
     */
    private boolean finish;

    /**
     * The shots of the player.
     */
    private short currentShots;

    /**
     * The count of halfs a player has.
     */
    private int halfs;


    /**
     * Constructor of the class {@link Player}.
     */
    public PlayerImpl(final String name){
        this.name = name;
        dicesOut = new ArrayList<>(maxDices);
        dicesIn = new ArrayList<>(maxDices);
        dices = new ArrayList<>(maxDices);
        for (int i=0; i<maxDices ;++i){
            dices.add(new DiceImpl());
            dicesIn.add(dices.get(i));
        }
        finish = false;
        currentShots = 0;
        penalties = 0;
        halfs = 0;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean rollTheDices() throws TooManyShotsException {
        // increase shots
        ++ currentShots;
        for(int i=0; i<dicesIn.size();++i){
            dicesIn.get(i).roll();
        }
        return true;
    }

    @Override
    public int getDiceValue() {
        Collections.sort(dicesOut);
        double sum = 0;
        for(int i=dicesOut.size()-1; i >= 0;--i){
            sum += dicesOut.get(i).getValue()* Math.pow(10,i);
        }
        return (int)sum;
    }

    @Override
    public void addPenalties(final int penalties) throws MaxPenaltyException{
        this.penalties+=penalties;
        if(this.penalties > maxPenalties){
            throw new MaxPenaltyException("The penalties cant be more than "+maxPenalties+"!");
        }
    }

    @Override
    public void setPenalties(final int penalties) throws MaxPenaltyException {
        this.penalties = penalties;
        if(this.penalties>maxPenalties){
            throw new MaxPenaltyException("The penalties cant be more than "+maxPenalties+"!");
        }
        if( penalties > maxPenalties){
            throw new MaxPenaltyException("The value of the parameter penalties cant be more than "+maxPenalties+"!");
        }
    }

    @Override
    public int getPenalties() {
        return penalties;
    }

    @Override
    public List<Dice> getDicesOut() {
        return dicesOut;
    }

    @Override
    public List<Dice> getDicesUnderTheCup() {
        return dicesIn;
    }

    @Override
    public boolean takeDiceInAgain(final Dice dice) {
        // take in the dice
        if(dicesIn.contains(dice)){
            try {
                throw new Exception("The dice object is already in the list of the dices which are in! This shouldn't be");
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        // add the dice to the list of dices which are under the cup
        dicesIn.add(dice);
        // remove the dice of the list of dices which are out
        return dicesOut.remove(dice);
    }

    @Override
    public boolean takeDiceOut(final Dice dice) {
        if(dicesOut.contains(dice)){
            try {
                throw new Exception("The dice object is already in the list of the dices which are in! This shouldn't be");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // add the dice to the list of dices which are out
        dicesOut.add(dice);
        // remove the dice of the list of dices which are under the cup.
        return dicesIn.remove(dice);
    }

    @Override
    public boolean isFinished() {
        return finish;
    }

    @Override
    public void setFinish(final boolean finish) {
        this.finish = finish;
    }

    @Override
    public short getShots() {
        return currentShots;
    }

    @Override
    public void callBlind() {

    }

    @Override
    public void callBlock() {

    }

    @Override
    public int getPenaltiesOfDiceValue() {
        return 0;
    }

    @Override
    public void resetAll() {
        /*
        TODO:
        Strafsteine zurück setzen

        Hälften zurück setzen
        rausgelegte Würfel zurück setzen
        würfelanzahl zurücksetzen
         */
        penalties = 0;
        halfs = 0;
        shots = 0;
        dicesOut.clear();
    }

    @Override
    public void resetForNewHalf() {
        penalties = 0;
        shots = 0;
        dicesOut.clear();
    }

    /**
     * This method returns the dice objedt which has the given dice value.
     * @param dice A dice object.
     * @return The dice which is equal the given dice.
     */
    private Dice getDice(final Dice dice) throws DiceNotFoundException {
        // iterate over the dices to get the right dice which has the given dice value
        for(int i=0; i< dices.size();++i){
            final Dice tmp = dices.get(i);
            if(tmp.getValue() == dice.getValue() && tmp.equals(dice)){
                    return tmp;
            }
        }

       throw new DiceNotFoundException(dice);
    }

    @Override
    public String toString() {
        return "PlayerImpl{" +
                "name='" + name + '\'' +
                '}';
    }
}
