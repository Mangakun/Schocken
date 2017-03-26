package schocken.marco.de.schocken.gametest;

import android.content.SyncStatusObserver;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import schocken.marco.de.schocken.exceptions.PlayerNotFoundException;
import schocken.marco.de.schocken.game.Game;
import schocken.marco.de.schocken.game.dice.Dice;
import schocken.marco.de.schocken.game.impl.GameImpl;
import schocken.marco.de.schocken.game.player.Player;
import schocken.marco.de.schocken.game.player.impl.PlayerImpl;
import schocken.marco.de.schocken.game.settings.GameSettings;

/**
 * Created by Marco on 14.02.2017.
 */

public class GameTest implements GameSettings {


    /**
     * A list of players.
     */
    private static List<Player> players;

    /**
     * An object of the class {@link Game}.
     */
    private static Game game;

    /**
     * Player names.
     */
    private static String[] playerNames={"Marco","Michelle"};

    @BeforeClass
    public static void createGame() {
        // new player list
        players = new ArrayList<>();
        for(int i=0; i<playerNames.length;++i){
            players.add(new PlayerImpl(playerNames[i]));
        }

        game = new GameImpl();
        for(final Player player: players) {
            game.addPlayer(player);
        }
    }

    /**
     * This method tests the instances.
     */
    @Test
    public void instanceTest(){
        Assert.assertNotNull(game);
    }

    /**
     *
     * @param playerName
     * @return
     */
    private boolean existsPlayerName(final String playerName){
        for(final String str : playerNames){
            if(str.equals(playerName)){
                return true;
            }
        }
        return false;
    }

    /**
     * This method tests the player names.
     */
    @Test
    public void getPlayerNameTest() {
       for(final Player player : game.getPlayers()){
           final String playerName = player.getName();
            Assert.assertTrue(existsPlayerName(playerName));
       }
    }

    /**
     * This method tests a wromg player name.
     */
    @Test
    public void wrongPlayerFromGameTest(){
        try {
            Player player = game.getPlayer("zzzzzzzzzzz");
            Assert.fail("The player name should not be in the game!");
        } catch (PlayerNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    @Test
    public void rightPlayerPositionTest(){
        final int position = 1;
        try {
            Player player = game.getPlayer(position);
        } catch (PlayerNotFoundException e) {
            e.printStackTrace();
            Assert.fail("The game should have a player with the position "+position);
        }

    }

    /**
     * This method tests a wrong player position test
     */
    @Test
    public void wrongPlayerPositionTest() {
        final int position = 3;
        try {
            Player player = game.getPlayer(position);
            Assert.fail("The game should not be have less than "+position+ " positions!");
        } catch (PlayerNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
