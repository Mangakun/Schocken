package schocken.marco.de.schocken.views.game;

import java.util.List;

import schocken.marco.de.schocken.game.dice.Dice;
import schocken.marco.de.schocken.game.player.Player;
import schocken.marco.de.schocken.presenters.game.ButtonManagement;

/**
 * Created by marco on 30.03.17.
 */

public interface GameView extends ButtonManagement{

    /**
     * This method clears all buttons.
     */
    void clearButtons();

    /**
     * This method uncover the dices.
     * @param currentPlayer An object of the class {@link Player}.
     */
    void uncoverDices(final Player currentPlayer);
}
