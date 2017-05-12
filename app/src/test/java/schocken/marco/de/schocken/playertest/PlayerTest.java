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
    public void diceOutTest(){

        List<Dice> dicesOut = player.getDicesOut();
        Assert.assertEquals("The dices which are out should be", 0, dicesOut.size());
        List<Dice> dicesUnderTheCup = player.getDicesUnderTheCup();
        Assert.assertEquals("The dices under the cup should be", maxDices, player.getDicesUnderTheCup().size());
        for (int i = 0; i < maxDices; ++i) {
            player.takeDiceOut(dicesUnderTheCup.get(maxDices - 1 - i));
        }
        Assert.assertEquals("The dices which are out should be", maxDices, player.getDicesOut().size());
        Assert.assertEquals("The dices which are out should be", maxDices, dicesOut.size());
    }

    /**
     * This method tests the shots of a player.
     * MaxShots is test here.
     */
    @Test
    public void rollTheDiceTestWithMaxShots3(){
        // first roll
        Assert.assertTrue("The player can roll!",player.rollTheDices());
        Assert.assertFalse("The player is not finished", player.isFinished());
        // second roll
        Assert.assertTrue("The player can roll!",player.rollTheDices());
        Assert.assertFalse("The player is not finished", player.isFinished());
        // third roll
        Assert.assertTrue("The player can roll!",player.rollTheDices());
        Assert.assertTrue("The player is finished", player.isFinished());
        // fourth roll
        Assert.assertFalse("The player can not roll!",player.rollTheDices());
    }

    /**
     * This method tests the shots of a player.
     * Less than maxShots is tested here.
     */
    @Test
    public void rollTheDiceTestWithMaxShots2(){
        player.setCurrentMaxShots(2);
        Assert.assertTrue("The player can roll!",player.rollTheDices());
        Assert.assertFalse("The player is not finished", player.isFinished());
        // second roll
        Assert.assertTrue("The player can roll!",player.rollTheDices());
        Assert.assertTrue("The player is finished", player.isFinished());
        // third roll
        Assert.assertFalse("The player can not roll!",player.rollTheDices());
    }
    /**
     * This method tests the shots of a player.
     * Less than maxShots is tested here.
     */
    @Test
    public void rollTheDiceTestWithMaxShots1(){
        player.setCurrentMaxShots(1);
        Assert.assertTrue("The player can roll!",player.rollTheDices());
        Assert.assertTrue("The player is not finished", player.isFinished());
        // second roll
        Assert.assertFalse("The player can not roll!",player.rollTheDices());
    }

    /**
     * This method tests the return of the dice value of a player.
     */
    @Test
    public void diceValueTest(){
        /*
        TODO: implementation.
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
