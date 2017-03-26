package schocken.marco.de.schocken.playertest;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import schocken.marco.de.schocken.game.dice.Dice;
import schocken.marco.de.schocken.game.player.Player;
import schocken.marco.de.schocken.game.player.impl.PlayerImpl;
import schocken.marco.de.schocken.game.settings.GameSettings;

/**
 * Created by Marco on 14.02.2017.
 */

public class PlayerTest implements GameSettings{

    /**
     * This method tests the name of a player.
     */
    @Test
    public void playerNameTest(){
        String name = "Marco";
        Player player = new PlayerImpl(name);
        Assert.assertEquals(name,player.getName());
    }


    /**
     * This method tests the penalties of a player.
     */
    @Test
    public void penaltiesTest(){
        Player player = new PlayerImpl("Marco");
        for(int i=0; i <maxPenalties;++i){
            try {
                player.addPenalties(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Assert.assertEquals(maxPenalties,player.getPenalties());
    }

    /**
     * This method tests the dices which are out.
     */
    @Test
    public void dicesOutTest(){
        Player player = new PlayerImpl("Marco");
        Assert.assertEquals(0,player.getDicesOut().size());
    }


    /**
     * This method tests the dice value.
     */
    @Test
    public void diceValueTest(){
        Player player = new PlayerImpl("Marco");
        player.rollTheDices();
        List<Dice> dicesOut = player.getDicesOut();
        Assert.assertEquals(0,dicesOut.size());
        List<Dice> dicesUnderTheCup = player.getDicesUnderTheCup();
        Assert.assertEquals(maxDices,player.getDicesUnderTheCup().size());
        for(int i=0; i<maxDices;++i){
            player.takeDiceOut(dicesUnderTheCup.get(maxDices-1-i));
        }
        Assert.assertEquals(maxDices,player.getDicesOut().size());
        Assert.assertEquals(maxDices,dicesOut.size());
    }

    /**
     * This method tests the shots of a player.
     */
    @Test
    public void shotsTest(){
        Player player = new PlayerImpl("Marco");
        try {
            player.increaseShots();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(1, player.getShots());
        try {
            player.increaseShots();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(2, player.getShots());
        try {
            player.increaseShots();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(3, player.getShots());
    }

    @Test
    public void shotsTest2(){
        Player player = new PlayerImpl("Marco");
        for(int i=0; i<maxShots+1;++i){
            try {
                player.increaseShots();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
