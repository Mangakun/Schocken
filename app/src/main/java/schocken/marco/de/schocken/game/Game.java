package schocken.marco.de.schocken.game;

import java.util.List;

import schocken.marco.de.schocken.exceptions.PlayerNotFoundException;
import schocken.marco.de.schocken.game.player.Player;

/**
 * Created by Marco on 14.02.2017.
 */

public interface Game {

    /**
     * This method returns the player at the given position.
     *
     * @param position The position.
     * @return An object of the class {@link Player},
     */
    Player getPlayer(final int position) throws PlayerNotFoundException;

    /**
     * This method returns the player with the given name.
     *
     * @param playerName A name of a player.
     * @return An object of the class {@link Player}.
     */
    Player getPlayer(final String playerName) throws PlayerNotFoundException;

    /**
     * This method returns a list of all player.
     *
     * @return A list of all players.
     */
    List<Player> getPlayers();

    /**
     * This method adds a player to the game.
     * @param player An object of the class {@link Player}.
     */
    void addPlayer(final Player player);

    /**
     * This method calls the next player.
     */
    void nextPlayer();

}


