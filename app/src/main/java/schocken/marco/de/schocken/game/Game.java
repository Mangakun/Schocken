package schocken.marco.de.schocken.game;

/**
 * Created by marco on 02.05.17.
 */

/**
 * The main interface of the play Schocken.
 */
public interface Game {

    /**
     * This method lets the shot as he is.
     */
    void stay();

    /**
     * This method sets the block for the current player active
     */
    void block();

    /**
     * This method sets the class blind active.
     */
    void blind();

    /**
     * This method rolls the dices of the current player.
     */
    void rollTheDice();
}
