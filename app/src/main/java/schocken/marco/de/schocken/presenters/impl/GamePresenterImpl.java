package schocken.marco.de.schocken.presenters.impl;

import schocken.marco.de.schocken.game.Game;
import schocken.marco.de.schocken.game.impl.GameImpl;
import schocken.marco.de.schocken.presenters.GamePresenter;
import schocken.marco.de.schocken.views.GameView;

/**
 * Created by marco on 30.03.17.
 */

public class GamePresenterImpl implements GamePresenter {

    /**
     * An object of the class {@link GameView}.
     */
    private GameView gameView;

    /**
     * An object of the class {@link Game}.
     */
    private Game game;

    /**
     * Constructor of the class {@link GamePresenterImpl}.
     * @param gameView An object of the class {@link GameView}.
     */
    public void GamePresenterImpl(final GameView gameView){
        this.gameView = gameView;
        this.game = new GameImpl(this);
    }
}
