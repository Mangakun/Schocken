package schocken.marco.de.schocken.exceptions;

/**
 * Created by Marco on 08.03.2017.
 */

/**
 * An exception class for not founding a {@link schocken.marco.de.schocken.game.player.Player}.
 */
public class PlayerNotFoundException extends Exception {

    /**
     * Constructor of the class {@link PlayerNotFoundException}.
     * @param position A position of a player.
     */
    public PlayerNotFoundException(final int position){
        super("The player at the position "+position+" was not found!");
    }

    /**
     * Constructor of the class {@link PlayerNotFoundException}.
     * @param playerName A player name.
     */
    public PlayerNotFoundException(final String playerName){
        super("The player "+playerName+" was not found!");
    }
}
