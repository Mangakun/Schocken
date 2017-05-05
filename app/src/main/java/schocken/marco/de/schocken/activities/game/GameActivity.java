package schocken.marco.de.schocken.activities.game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;


import java.util.List;

import schocken.marco.de.schocken.Listener.DiceClickListener;
import schocken.marco.de.schocken.R;
import schocken.marco.de.schocken.game.Game;
import schocken.marco.de.schocken.game.dice.Dice;
import schocken.marco.de.schocken.game.player.Player;
import schocken.marco.de.schocken.presenters.game.GamePresenter;
import schocken.marco.de.schocken.presenters.game.impl.GamePresenterImpl;
import schocken.marco.de.schocken.views.game.GameView;

/**
 * TODO: documentation
 */
public class GameActivity extends AppCompatActivity implements GameView {

    /**
     * A debug string.
     */
    private String msg = "GameActivity: ";

    /**
     * TODO: documentation.
     */
    private Button[] buttons;

    /**
     * An object of the class {@link GamePresenter}.
     */
    private GamePresenter gamePresenter;


    /**
     * Constructor of the class {@link GameActivity}.
     */
    public GameActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set content view
        setContentView(R.layout.activity_game);
        // get intent
        final Intent intent = getIntent();
        // get player names
        final String[] players = intent.getStringArrayExtra("players");
        // create a new game
        gamePresenter = new GamePresenterImpl(this);
        // add player names
        gamePresenter.addPlayers(players);
        // init buttons
        buttons = new Button[]{(Button) findViewById(R.id.button1), (Button) findViewById(R.id.button2), (Button) findViewById(R.id.button3)};
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);

    }

    /**
     * This method handles the click of the button
     * @param view An object of the class {@link View}.
     */
    public void rollTheDice(final View view){
        gamePresenter.rollTheDice();
    }


    @Override
    public void clearButtons() {
        disableBlindButton();
        disableBlockButton();
        disableStayButton();
        disableTheRollTheDiceButton();
    }

    @Override
    public void uncoverDices(final Player currentPlayer) {
        // get list of dices which are under the cup
        final List<Dice> dicesUnderCup = currentPlayer.getDicesUnderTheCup();
        // iterate over these dices
        for(int i=0; i< dicesUnderCup.size();++i){
            buttons[i].setOnClickListener(new DiceClickListener(currentPlayer,dicesUnderCup.get(i)));
            buttons[i].setText(""+dicesUnderCup.get(i));
            buttons[i].setVisibility(View.VISIBLE);
            buttons[i].setBackgroundColor(0);
        }
        /*
        TODO: für die anderen Buttons den OnClickListener auf null setzen ?
         */
    }

    @Override
    public void showRollTheDiceButton() {
        ((Button) findViewById(R.id.rollTheDiceButton)).setVisibility(View.VISIBLE);
    }

    @Override
    public void disableTheRollTheDiceButton() {
        ((Button) findViewById(R.id.rollTheDiceButton)).setVisibility(View.GONE);
    }

    @Override
    public void showBlindButton() {

    }

    @Override
    public void disableBlindButton() {

    }

    @Override
    public void showStayButton() {

    }

    @Override
    public void disableStayButton() {

    }

    @Override
    public void showBlockButton() {

    }

    @Override
    public void disableBlockButton() {

    }
}
