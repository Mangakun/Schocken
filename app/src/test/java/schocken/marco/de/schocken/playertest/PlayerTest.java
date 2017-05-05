package schocken.marco.de.schocken.playertest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import schocken.marco.de.schocken.exceptions.MaxPenaltyException;
import schocken.marco.de.schocken.exceptions.TooManyShotsException;
import schocken.marco.de.schocken.game.dice.Dice;
import schocken.marco.de.schocken.game.player.Player;
import schocken.marco.de.schocken.game.player.impl.PlayerImpl;
import schocken.marco.de.schocken.game.settings.GameSettings;

/**
 * Created by Marco on 14.02.2017.
 * This class contains test methods for the class {@link Player}.
 */

public class PlayerTest implements GameSettings{

    /**
     * An object of the class {@link Player}.
     */
    private static Player player;

    /**
     * A player name.
     */
    private static final String playerName = "Marco";

    /**
     * This method creates a new player.
     */
    @BeforeClass
    public static void createGame() {
        player = new PlayerImpl(playerName);
    }

    /**
     * This method resets a player.
     */
    @Before
    public void resetPlayer(){
        player.resetAll();
    }

    /**
     * This method tests the name of a player.
     */
    @Test
    public void playerNameTest(){
        Assert.assertEquals("The player name should be " ,playerName ,player.getName());
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
            } catch (MaxPenaltyException e) {
                e.printStackTrace();
                Assert.fail(e.getMessage());
            }
        }
        Assert.assertEquals(maxPenalties,player.getPenalties());
    }

    /**
     * This method tests the penalties of a player.
     */
    @Test
    public void penaltiesTest2(){
        try {
            player.addPenalties(maxPenalties+1);
            Assert.fail("You cant give the player more penalties than the max penalties.");
        } catch (MaxPenaltyException e) {
            e.printStackTrace();
        }
    }


    /**
     * This method tests the dices which are out.
     */
    @Test
    public void dicesOutTest(){
        Assert.assertEquals(0,player.getDicesOut().size());
    }


    /**
     * This method tests the dice value.
     */
    @Test
    public void diceValueTest(){
        try {
            player.rollTheDices();
        } catch (TooManyShotsException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        List<Dice> dicesOut = player.getDicesOut();
        Assert.assertEquals("The dices which are out should be",0,dicesOut.size());
        List<Dice> dicesUnderTheCup = player.getDicesUnderTheCup();
        Assert.assertEquals("The dices under the cup should be",maxDices,player.getDicesUnderTheCup().size());
        for(int i=0; i<maxDices;++i){
            player.takeDiceOut(dicesUnderTheCup.get(maxDices-1-i));
        }
        Assert.assertEquals("The dices which are out should be",maxDices,player.getDicesOut().size());
        Assert.assertEquals("The dices which are out should be",maxDices,dicesOut.size());
    }

    /**
     * This method tests the shots of a player.
     */
    @Test
    public void rollTheDiceTest(){
        /*
        TODO: implementation of this test
         */
    }
//
//    /**
//     * This method tests the shots of a player.
//     */
//    @Test
//    public void shotsTest2(){
//        Player player = new PlayerImpl("Marco");
//        for(int i=0; i<maxShots+1;++i){
//            try {
//                player.increaseShots();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /**
//     * This method tests the penalties belonging to the dice value.
//     */
//    @Test
//    public void penaltiesBelongingToTheDiceValueTest(){
//        Assert.fail();
//    }
}
