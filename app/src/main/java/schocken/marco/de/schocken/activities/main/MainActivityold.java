package schocken.marco.de.schocken.activities.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import schocken.marco.de.schocken.R;
import schocken.marco.de.schocken.presenters.main.impl.MainPresenterImpl;
import schocken.marco.de.schocken.views.main.MainView;


public class MainActivityold extends AppCompatActivity /*implements MainView */{


//    private String msg = "MainActivityold: ";
//
//    /**
//     * TODO: documentation.
//     */
//    private MainPresenterImpl mainPresenter;
//
//    /**
//     * Constructor of the class {@link com.schocken.schocken.activities.main.MainActivityold}.
//     */
//    public MainActivityold(){
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_old);
//        // create new main presenter
//        mainPresenter = new MainPresenterImpl(this);
//        //     buttons = new Button[]{(Button) findViewById(R.id.button), (Button) findViewById(R.id.button2), (Button) findViewById(R.id.button3)};
    }
    /**
     * ***************************
     * Button methods start
     * ***************************
     */

//    /**
//     * This method starts the game.
//     * @param view An object of the class {@link View}.
//     */
//    public void startGame(final View view){
//        mainPresenter.startGame();
//    }
//
//    /**
//     * ***************************
//     * Button methods end
//     * ***************************
//     */
//
//    @Override
//    public void startGame() {
//        Log.d(msg, "startGame");
//        final Intent intent = new Intent(this,GameActivity.class);
//        intent.putExtra("players", new String[]{"Marco","Michelle"});
//        startActivity(intent);
//    }
}
