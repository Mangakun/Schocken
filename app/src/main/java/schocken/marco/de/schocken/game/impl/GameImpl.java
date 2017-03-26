package schocken.marco.de.schocken.game.impl;

import java.util.ArrayList;
import java.util.List;

import schocken.marco.de.schocken.exceptions.PlayerNotFoundException;
import schocken.marco.de.schocken.game.Game;
import schocken.marco.de.schocken.game.player.Player;
import schocken.marco.de.schocken.game.round.Round;
import schocken.marco.de.schocken.game.settings.GameSettings;

/**
 * Created by Marco on 14.02.2017.
 */

public class GameImpl implements Game, GameSettings{

    /**
     * A list of players.
     */
    private List<Player> players;

    /**
     * A list of rounds;
     */
    private List<Round> rounds;
    /**
     * Constructor of the class {@link GameImpl}.
     */
    public GameImpl(){
        players = new ArrayList<>();
        rounds = new ArrayList<>();
    }


    @Override
    public Player getPlayer(final int position) throws PlayerNotFoundException {
        try{
            return players.get(position);
        }catch(IndexOutOfBoundsException exception) {
            throw new PlayerNotFoundException(position);
        }
    }

    @Override
    public Player getPlayer(String playerName) throws PlayerNotFoundException {
        for(Player player: players){
            if(player.getName().equals(playerName)) {
                return player;
            }
        }
        throw new PlayerNotFoundException(playerName);
    }

    @Override
    public List<Player> getPlayers() {
        return null;
    }

    @Override
    public void addPlayer(final Player player) {
        players.add(player);
    }

    @Override
    public void nextPlayer() {

    }
}
