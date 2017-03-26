package schocken.marco.de.schocken.exceptions;

/**
 * Created by Marco on 23.03.2017.
 */

import schocken.marco.de.schocken.game.dice.Dice;

/**
 * An exception class for not founding a dice.
 */
public class DiceNotFoundException extends Exception {

    /**
     * Constructor of the class {@link DiceNotFoundException}.
     * @param dice An object of te class {@link Dice}.
     */
    public DiceNotFoundException(final Dice dice){
        super("The dice "+dice.getValue()+" was not found!");

    }
}
