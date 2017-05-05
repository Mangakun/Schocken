package schocken.marco.de.schocken.presenters.game.impl;

import schocken.marco.de.schocken.game.GameExtension;
import schocken.marco.de.schocken.game.impl.GameImpl;
import schocken.marco.de.schocken.presenters.game.ButtonManagement;
import schocken.marco.de.schocken.presenters.game.GamePresenter;
import schocken.marco.de.schocken.views.game.GameView;

/**
 * Created by marco on 30.03.17.
 */

public class GamePresenterImpl implements GamePresenter, ButtonManagement {

    /**
     * An object of the class {@link GameView}.
     */
    private GameView gameView;

    /**
     * An object of the class {@link GameExtension}.
     */
    private GameExtension game;

    /**
     * Constructor of the class {@link GamePresenterImpl}.
     * @param gameView An object of the class {@link GameView}.
     */
    public GamePresenterImpl(final GameView gameView){
        this.gameView = gameView;
        this.game = new GameImpl(this);
        // clear all the buttons
        gameView.clearButtons();
    }

    @Override
    public void stay() {
        game.stay();
    }

    @Override
    public void block() {
        game.block();
    }

    @Override
    public void blind() {
        game.blind();
    }

    @Override
    public void rollTheDice() {
        // roll the dices
        game.rollTheDice();
    }

    @Override
    public void addPlayers(String[] playerNames) {
        // add the players to the game
        game.addPlayers(playerNames);
    }

    @Override
    public void showRollTheDiceButton() {
        gameView.showRollTheDiceButton();
    }

    @Override
    public void disableTheRollTheDiceButton() {
        gameView.disableTheRollTheDiceButton();
    }

    @Override
    public void showBlindButton() {
        gameView.showBlindButton();
    }

    @Override
    public void disableBlindButton() {
        gameView.disableBlindButton();
    }

    @Override
    public void showStayButton() {
        gameView.showStayButton();
    }

    @Override
    public void disableStayButton() {
        gameView.disableStayButton();
    }

    @Override
    public void showBlockButton() {
        gameView.showBlockButton();
    }

    @Override
    public void disableBlockButton() {
        gameView.disableBlockButton();
    }
}
