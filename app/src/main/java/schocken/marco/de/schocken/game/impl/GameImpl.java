package schocken.marco.de.schocken.game.impl;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import schocken.marco.de.schocken.exceptions.MaxPenaltyException;
import schocken.marco.de.schocken.exceptions.PlayerNotFoundException;
import schocken.marco.de.schocken.exceptions.TooManyShotsException;
import schocken.marco.de.schocken.game.GameExtension;
import schocken.marco.de.schocken.game.enums.GameStart;
import schocken.marco.de.schocken.game.player.Player;
import schocken.marco.de.schocken.game.player.impl.PlayerImpl;
import schocken.marco.de.schocken.game.round.Round;
import schocken.marco.de.schocken.game.round.impl.RoundImpl;
import schocken.marco.de.schocken.game.settings.GameSettings;
import schocken.marco.de.schocken.presenters.game.ButtonManagement;
import schocken.marco.de.schocken.presenters.game.GamePresenter;

/**
 * Created by Marco on 14.02.2017.
 */

public class GameImpl implements GameExtension, GameSettings{

    /**
     * Message string for debug.
     */
    private final String msg ="GameImpl";

    /**
     * An object of the class {@link GamePresenter}.
     */
    private final ButtonManagement buttonManagement;

    /**
     * A list of players.
     */
    private List<Player> players;

    /**
     * A list of players, which play the current round.
     */
    private List<Player> playersOfTheCurrentRound;

    /**
     * A list of rounds;
     */
    private List<Round> rounds;

    /**
     * The current player.
     */
    private Player currentPlayer;

    /**
     * The player, which started the current round.
     */
    private Player startPlayer;

    /**
     * The current round.
     */
    private Round currentRound;

    /**
     * Boolean which says, if the current round is finished.
     */
    private boolean currentRoundFinish;

    /**
     * The penalties stack.
     */
    private int penaltiesStack;

    /**
     * The max shots.
     */
    private int maxShots;

    /**
     * TODO: documentation.
     */
    private GameStart gameStart = GameStart.FIRSTPLAYER;
    /**
     * Constructor of the class {@link GameImpl}.
     */
    public GameImpl(final ButtonManagement buttonManagement){
        this.buttonManagement = buttonManagement;
        players = new ArrayList<>();
        rounds = new ArrayList<>();

    }


//    @Override
//    public Player getPlayer(final int position) throws PlayerNotFoundException {
//        try{
//            return players.get(position);
//        }catch(IndexOutOfBoundsException exception) {
//            throw new PlayerNotFoundException(position);
//        }
//    }
//
//    @Override
//    public Player getPlayer(String playerName) throws PlayerNotFoundException {
//        for(Player player: players){
//            if(player.getName().equals(playerName)) {
//                return player;
//            }
//        }
//        throw new PlayerNotFoundException(playerName);
//    }

//    @Override
//    public List<Player> getPlayers() {
//        return null;
//    }
//
//    @Override
//    public void addPlayer(final Player player) {
//        players.add(player);
//    }
//
//    @Override
//    public void nextPlayer() {
//        /*
//        TODO: change view -> delete all buttons
//         */
//        if(players.indexOf(currentPlayer)==players.size()-1){
//            currentPlayer = players.get(0);
//        }else {
//            currentPlayer = players.get(players.indexOf(currentPlayer)+1);
//        }
//        // a player with three dices has to be skipped
//        if(currentPlayer.getDicesOut().size() == GameSettings.maxDices){
//            // is the current player equal teh start player, then the round has finished
//            if(currentPlayer == startPlayer){
//                distributePenalties();
//            }else{
//                nextPlayer();
//            }
//
//        }else{
//            // look how much shots are left
//        }
//
//
//    }

//    @Override
//    public Player getCurrentPlayer() {
//        return currentPlayer;
//    }
//
//    @Override
//    public boolean removePlayer(Player player) {
//        return players.remove(player);
//    }
//
//    @Override
//    public Round getCurrentRound() {
//        return currentRound;
//    }
//
    @Override
    public void startGame() {
        switch (gameStart) {
            case FIRSTPLAYER:
                startPlayer = players.get(0);
                break;
            case HIGHESTNUMBER:
                throw new UnsupportedOperationException("The algorithm for calculating the highest Number is missing!");
//                     break;
            default:
                try {
                    throw new Exception("Undefinied gameStart!");
                }catch(final Exception exception){
                    exception.printStackTrace();
                }
                break;
        }
    }

    @Override
    public void stay() {

    }

    @Override
    public void block() {

    }

    @Override
    public void blind() {
        /**
         * 1. Es darf nur der Startspieler blind drücken können.
         * 2. Wenn er der nicht ist, dann eine RuntimeException schmeissen!
         * 3. Es muss eine variable gesetzt werden, dass die Runde blind gespielt wird.
         */

    }

    @Override
    public void rollTheDice() {
        if (currentPlayer.getShots() < maxShots){
            try {
                currentPlayer.rollTheDices();
            } catch (TooManyShotsException e) {
                e.printStackTrace();
                /*
                TODO: remove current player from the active players!
                TODO: go on with next player!
                 */
            }
            /**
             * TODO: update GUI
             */
        }else{
            //nextPlayer();
        }
    }

//    @Override
//    public void resign() {
//        // if the current player is equal the start player
//        if(currentPlayer == startPlayer){
//            // set the max shots
//            maxShots = currentPlayer.getShots();
//        }
//        /*
//        TODO: hier schon besten und sclechtesten Spieler bestimmen ?
//         */
//        // call next player
//        nextPlayer();
//    }
//
//    @Override
//    public void discover() {
//        // TODO: update dice gui
//    }
//
//    @Override
//    public void currentPlayerFinish() {
//        /*
//        TODO: hier schon neuen besten und schlechtesten player analysieren ?
//         */
//        nextPlayer();
//    }

    /**
     * This method resets all players for a new game.
     */
    private void newGame(){
        for(final Player player : players){
            player.resetAll();
        }
    }

    /**
     * This method resets all players for a new half.
     */
    private void newHalf(){
        for(final Player player : players){
            player.resetForNewHalf();
        }
    }

    /**
     * This method creates a new round.
     */
    private void newRound(){
        // create a new round
        final Round round = new RoundImpl();
        // add round to rounds
        rounds.add(round);
        // set new round as current round
        currentRound = round;
    }

    /**
     * This method handles the things, when a round has ended. A round ha ended, when a player has both halfs.
     */
    private void roundEnded(){
        throw new UnsupportedOperationException("roundEnded is not implemented yet!");
    }

    /**
     * This method distributes the penalties.
     */
    private void distributePenalties(){
        currentRoundFinish = true;
        final Player bestPlayer = determineBestPlayer();
        final Player worstPlayer = determineWorstPlayer();
        if(bestPlayer == worstPlayer){
            try {
                throw new Exception("The best player cant be the worst player at once !");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // get penalties from the best player
        int penalties = bestPlayer.getPenaltiesOfDiceValue();
        // penalties == 13 -> somebody dices a shock out
        if(penalties == 13){
            throw new UnsupportedOperationException("Schock out is not implemented yet!");
        }else{
            // check if there are still penalties left on the stack
            if (penaltiesStack > 0){
                Log.d(msg,"On the stack are "+penaltiesStack+" penalties left");
                // look up, if the penalties can be take from the penalties stack.
                penalties = Math.max(penaltiesStack,penalties);
                Log.d(msg,"I cant take "+penalties+" penalties from the stack");
                penaltiesStack-=penalties;
                Log.d(msg,"On the stack are "+penaltiesStack+" left");
            }else{
                // reduce penalties from the winner
                Log.d(msg,"The winner has "+bestPlayer.getPenalties()+" penalties");
                penalties = Math.min(bestPlayer.getPenalties(),penalties);
                Log.d(msg,"I cant take "+penalties+" penalties from the best player");
            }
            // add calculated penalties to the worst player
            try {
                worstPlayer.addPenalties(penalties);
            } catch (MaxPenaltyException e) {
                e.printStackTrace();
            }
        }
        /*
        TODO: auf Wurfanzahl eingehen!
         */
        // set new startPlayer
        startPlayer = worstPlayer;
        newHalf();
    }

    /**
     * This method determines the best player.
     */
    private Player determineBestPlayer(){
        throw new UnsupportedOperationException("determineBestPlayer is not implemented yet!");
        /*
        TODO; implementation.
         */

    }

    /**
     * This method determines the worst player.
     */
    private Player determineWorstPlayer(){
        throw new UnsupportedOperationException("determineWorstPlayer is not implemented yet!");
          /*
        TODO; implementation.
         */
    }


    /**
     * This method creates the turn options a player has.
     */
    private void createTurnOptions(){
        throw new UnsupportedOperationException("createTurnOptions is not implemented yet!");
        /*
        TODO: implementation.
         */
    }


    @Override
    public void addPlayers(final String[] playerNames) {
        for(final String playerName : playerNames){
            Log.d(msg, "Add "+playerName+ " to the game!");
            final Player player = new PlayerImpl(playerName);
            players.add(player);
        }
    }
}
