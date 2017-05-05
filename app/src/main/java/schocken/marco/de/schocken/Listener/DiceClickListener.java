package schocken.marco.de.schocken.Listener;

import android.graphics.Color;
import android.view.View;

import schocken.marco.de.schocken.game.dice.Dice;
import schocken.marco.de.schocken.game.player.Player;


/**
 * This class is an extension of the View.OnClickListener.
 * Created by marco on 04.05.17.
 */

public class DiceClickListener implements View.OnClickListener {

    /**
     * An object of the class {@link Player}
     */
    private Player player;

    /**
     * The dice value.
     */
    private Dice dice;

    /**
     * A boolean which holds if a dice should be taken out or not.
     */
    private boolean shouldBeTakenOut;

    /**
     * Constructor of the class {@link DiceClickListener}.
     * @param player An object of the class {@link Player}.
     * @param dice An object of the class {@link Dice}.
     */
    public DiceClickListener(final Player player, final Dice dice){
        this.player = player;
        this.dice = dice;
        shouldBeTakenOut = false;

    }
    @Override
    public void onClick(final View view) {
        //
        if(shouldBeTakenOut){
            player.takeDiceInAgain(dice);
            view.setBackgroundColor(0);
        }else{
            player.takeDiceOut(dice);
            view.setBackgroundColor(Color.BLUE);
        }
        // invert the boolean
        shouldBeTakenOut = !shouldBeTakenOut;

    }
}
