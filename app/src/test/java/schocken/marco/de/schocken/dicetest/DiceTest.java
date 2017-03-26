package schocken.marco.de.schocken.dicetest;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import schocken.marco.de.schocken.game.dice.Dice;
import schocken.marco.de.schocken.game.dice.impl.DiceImpl;

/**
 * Created by Marco on 14.02.2017.
 */

public class DiceTest {

    /**
     * This method tests the initial dice test.
     */
    @Test
    public void initialDiceTest(){
        Dice dice = new DiceImpl();
        Assert.assertEquals(0,dice.getValue());
    }

    /**
     * This method tests the comparable interface
     */
    @Test
    public void comparableTest(){
        final List<Dice> dices = new ArrayList<Dice>();
        int maxDices = 5;
        for(int i=0; i< maxDices;++i){
            dices.add(new DiceImpl(i));
        }
        Collections.sort(dices);
        for(int i=0; i< maxDices;++i){
            Assert.assertEquals(maxDices-1-i,dices.get(i).getValue());
        }
    }

}
