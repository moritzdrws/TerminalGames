package de.moritz.terminalgames.game;

import de.moritz.terminalgames.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameManager {

    private final List<Game> games;
    private final Map<String, Game> gameMap;


    public GameManager() {
        this.games = new ArrayList<>();
        this.gameMap = new HashMap<>();
    }


    public void registerGame(Game game) {
        this.games.add(game);
        this.gameMap.put(game.getName(), game);

        System.out.println(Main.PREFIX + game.getName() + " wurde erfolgreich geladen.");
    }

    
    public Game getGame(String name) {
        return this.gameMap.get(name);
    }

    public List<Game> getGames() {
        return this.games;
    }
}
