package schocken.marco.de.schocken.game.player;

/**
 * Created by Marco on 14.02.2017.
 */

import java.util.List;

import schocken.marco.de.schocken.exceptions.MaxPenaltyException;
import schocken.marco.de.schocken.exceptions.TooManyShotsException;
import schocken.marco.de.schocken.game.dice.Dice;
import schocken.marco.de.schocken.game.settings.GameSettings;

/**
 * Interface for the Player.
 */
public interface Player extends GameSettings{

    /**
     * This method return the name of the player.
     * @return
     */
    String getName();

    /**
     * This method rolls the dices which are in the cup.
     * @return True, if the rolling was successful.
     */
    boolean rollTheDices();

    /**
     * This method returns the dice value.
     * @return The dice value.
     */
    int getDiceValue();

    /**
     * This method add penalties.
     * @param penalties The penalties.
     */
    void addPenalties(final int penalties) throws MaxPenaltyException;

    /**
     * This method sets the penalties.
     * @param penalties The penalties.
     */
    void setPenalties(final int penalties) throws MaxPenaltyException;

    /**
     * This method returns the penalties of the player.
     * @return The penalties of the player.
     */
    int getPenalties();

    /**
     * This method returns the dices which are out.
     * @return The dices which are out.
     */
    List<Dice> getDicesOut();

    /**
     * This method returns the dices which are under the cup.
     * @return
     */
    List<Dice> getDicesUnderTheCup();

    /**
     * This method takes a dice in again.
     * @param dice An object of the class dice.
     */
    boolean takeDiceInAgain(final Dice dice);

    /**
     * This method takes a dice out of a cup.
     * @param dice An object of the class dice.
     */
    boolean takeDiceOut(final Dice dice);

    /**
     * This method returns the state of a player, if the is playing or if he has finished the current round.
     * @return
     */
    boolean isFinished();

    /**
     * This method sets the finish state of the player.
     * @param finish The state of the player.
     */
    void setFinish(final boolean finish);

    /**
     * This method returns the shots of a player.
     * @return The shots of the player.
     */
    int getShots();

    /**
     * TODO: documentation.
     */
    void callBlind();

    /**
     * TODO: documentation.
     */
    void callBlock();

    /**
     * This method returns the count of the penalties belonging to the dice value.
     * @return The penalties belonging to the dice value.
     */
    int getPenaltiesOfDiceValue();

    /**
     * This method resets all variables of a player.
     */
    void resetAll();

    /**
     * This method resets all relevant variables of a player for a new half.
     */
    void resetForNewHalf();

    /**
     * This method sets the current max shots a player has in this round.
     * @param currentMaxShots The current max shots.
     */
    void setCurrentMaxShots(final int currentMaxShots);
}
