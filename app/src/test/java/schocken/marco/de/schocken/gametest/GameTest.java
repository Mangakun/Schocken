package schocken.marco.de.schocken.gametest;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import schocken.marco.de.schocken.exceptions.PlayerNotFoundException;
import schocken.marco.de.schocken.game.GameExtension;
import schocken.marco.de.schocken.game.impl.GameImpl;
import schocken.marco.de.schocken.game.player.Player;
import schocken.marco.de.schocken.game.player.impl.PlayerImpl;
import schocken.marco.de.schocken.game.settings.GameSettings;
import schocken.marco.de.schocken.presenters.game.ButtonManagement;

/**
 * Created by Marco on 14.02.2017.
 */

public class GameTest implements GameSettings {


//    /**
//     * A list of players.
//     */
//    private static List<Player> players;
//
//    /**
//     * An object of the class {@link GameExtension}.
//     */
//    private static GameExtension game;
//
//    /**
//     * Player names.
//     */
//    private static String[] playerNames={"Marco","Michelle"};
//
//
//    private static ButtonManagement buttonManagement = new ButtonManagement() {
//        @Override
//        public void showRollTheDiceButton() {
//
//        }
//
//        @Override
//        public void disableTheRollTheDiceButton() {
//
//        }
//
//        @Override
//        public void showBlindButton() {
//
//        }
//
//        @Override
//        public void disableBlindButton() {
//
//        }
//
//        @Override
//        public void showStayButton() {
//
//        }
//
//        @Override
//        public void disableStayButton() {
//
//        }
//
//        @Override
//        public void showBlockButton() {
//
//        }
//
//        @Override
//        public void disableBlockButton() {
//
//        }
//    };
//
//    @BeforeClass
//    public static void createGame() {
//        game = new GameImpl(buttonManagement);
//        game.addPlayers(playerNames);
//    }
//
//    /**
//     * This method tests the instances.
//     */
//    @Test
//    public void instanceTest(){
//        Assert.assertNotNull(game);
//    }
//
//    /**
//     *
//     * @param playerName
//     * @return
//     */
//    private boolean existsPlayerName(final String playerName){
//        for(final String str : playerNames){
//            if(str.equals(playerName)){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * This method tests the player names.
//     */
//    @Test
//    public void getPlayerNameTest() {
//        // TODO: wieder aufnehmen
////       for(final Player player : game.getPlayers()){
////           final String playerName = player.getName();
////            Assert.assertTrue(existsPlayerName(playerName));
////       }
//    }
//
//    /**
//     * This method tests a wromg player name.
//     */
//    @Test
//    public void wrongPlayerFromGameTest(){
//        // TODO: wieder aufnehmen
////        try {
////            Player player = game.getPlayer("zzzzzzzzzzz");
////            Assert.fail("The player name should not be in the game!");
////        } catch (PlayerNotFoundException exception) {
////            exception.printStackTrace();
////        }
//    }
//
//    @Test
//    public void rightPlayerPositionTest(){
//        // TODO: wieder aufnehmen
////        final int position = 1;
////        try {
////            Player player = game.getPlayer(position);
////        } catch (PlayerNotFoundException e) {
////            e.printStackTrace();
////            Assert.fail("The game should have a player with the position "+position);
////        }
//
//    }
//
//    /**
//     * This method tests a wrong player position test
//     */
//    @Test
//    public void wrongPlayerPositionTest() {
//        // TODO: wieder aufnehmen
////        final int position = 3;
////        try {
////            Player player = game.getPlayer(position);
////            Assert.fail("The game should not be have less than "+position+ " positions!");
////        } catch (PlayerNotFoundException exception) {
////            exception.printStackTrace();
////        }
//    }
//
//    /**
//     * This methods tests the start of a game.
//     */
//    @Test
//    public void startGameTest(){
//        // TODO: wieder aufnehmen
////        game.getCurrentPlayer().rollTheDices();
////        /**
////         * TODO: implementation.
////         */
////        Assert.fail();
//    }
//
//    /**
//     * This method tests the next player method.
//     */
//    @Test
//    public void nextPlayerTest(){
//        /**
//         * TODO: implementation.
//         */
//        Assert.fail();
//    }
//
//    /**
//     * This method tests the distribution of the penalties.
//     */
//    @Test
//    public void distributePenaltiesTest(){
//        /**
//         * TODO: implementation.
//         */
//        Assert.fail();
//    }
//
//    /**
//     * This method tests the end of a round.
//     */
//    @Test
//    public void roundEndedTest(){
//        /**
//         * TODO: implementation.
//         */
//        Assert.fail();
//    }
}
