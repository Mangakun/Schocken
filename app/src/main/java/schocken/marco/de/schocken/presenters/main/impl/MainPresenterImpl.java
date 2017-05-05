package schocken.marco.de.schocken.presenters.main.impl;



/**
 * Created by marco on 11.01.17.
 */

import schocken.marco.de.schocken.presenters.main.MainPresenter;
import schocken.marco.de.schocken.views.main.MainView;

/**
 * TODO: documentation.
 */
public class MainPresenterImpl implements MainPresenter {

    /**
     * A {@link MainView} object.
     */
    private MainView mainView;

    /**
     * Constructor of the class {@link MainView}.
     * @param mainView
     */
    public MainPresenterImpl(final MainView mainView){
    this.mainView = mainView;
    }

    @Override
    public void startGame() {
        mainView.startGame();
    }
}
