package schocken.marco.de.schocken.game;

import java.util.List;

import schocken.marco.de.schocken.exceptions.PlayerNotFoundException;
import schocken.marco.de.schocken.game.player.Player;
import schocken.marco.de.schocken.game.round.Round;

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

    /**
     * This method returns the current player.
     * @return An object of the class {@link Player}.
     */
    Player getCurrentPlayer();

    /**
     * This method removes a player from the game.
     * @param player An object of the class {@link Player}.
     * @return True, if the player could be removed.
     */
    boolean removePlayer(final Player player);

    /**
     * This method returns the current round of the game.
     * @return An object of the class {@link Round}.
     */
    Round getCurrentRound();

    /**
     * This method starts a game.
     */
    void startGame();

    /**
     * This method rolls the dices.
     */
    void rollTheDice();

    /**
     * This method resigns the current shot.
     */
    void resign();

    /**
     * This method discovers the dices.
     */
    void discover();

    /**
     * This method finishes the action of the currentPlayer
     */
    void currentPlayerFinish();
}


