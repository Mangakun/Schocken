package schocken.marco.de.schocken.game.dice;

/**
 * Created by Marco on 14.02.2017.
 */

/**
 * The interface of a dice.
 */
public interface Dice extends Comparable<Dice>{

    /**
     * This method rolls the dice.
     */
    void roll();

    /**
     * This method returns the value of the dice.
     * @return The dice value.
     */
    int getValue();
}
