package schocken.marco.de.schocken.activities.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import schocken.marco.de.schocken.R;
import schocken.marco.de.schocken.activities.game.GameActivity;
import schocken.marco.de.schocken.presenters.main.MainPresenter;
import schocken.marco.de.schocken.presenters.main.impl.MainPresenterImpl;
import schocken.marco.de.schocken.views.main.MainView;

public class MainActivity extends AppCompatActivity implements MainView {

    /**
     * A debug string.
     */
    private final String msg = "MainActivityold: ";

    /**
     * A object of the class {@link MainPresenter}.
    */
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // create new main presenter
        mainPresenter = new MainPresenterImpl(this);
    }

    /**
     * This method starts the game.
     * @param view An object of the class {@link View}.
     */
    public void startGame(final View view){
        mainPresenter.startGame();
    }

        @Override
    public void startGame() {
        Log.d(msg, "startGame");
        final Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("players", new String[]{"Marco","Michelle"});
        startActivity(intent);
    }

}
