package schocken.marco.de.schocken.presenters.game;

import schocken.marco.de.schocken.game.Game;

/**
 * Created by marco on 30.03.17.
 */

public interface GamePresenter extends Game{

    /**
     * This method add the player to the game.
     * @param playerNames A string array of player names.
     */
    void addPlayers(final String[] playerNames);



}
