package de.moritz.terminalgames.game;

import de.moritz.terminalgames.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameManager {

    private final List<Game> games;
    private final Map<String, Game> gameMap;

    private Game currentGame;

    public GameManager() {
        this.games = new ArrayList<>();
        this.gameMap = new HashMap<>();
    }


    public void registerGame(Game game) {
        this.games.add(game);
        this.gameMap.put(game.getName(), game);

        System.out.println(Main.PREFIX + game.getName() + " wurde erfolgreich geladen.");
    }

    public Game startGame(Game game) {
        if (this.currentGame != null) {
            this.stopGame(this.currentGame);
        }
        this.currentGame = game;
        game.start();

        System.out.println(game.getGamePrefix() + "Spiel wurde gestartet.");
        return game;
    }

    public Game stopGame(Game game) {
        if (this.currentGame != game) {
            return game;
        }
        System.out.println(game.getGamePrefix() + "Spiel wurde gestoppt.");
        this.currentGame = null;
        return game;
    }

    public Game getCurrentGame() {
        return this.currentGame;
    }

    public Game getGame(String name) {
        return this.gameMap.get(name);
    }

    public List<Game> getGames() {
        return this.games;
    }

    public String getGamePrefix() {
        return this.currentGame != null ? this.currentGame.getGamePrefix() : Main.PREFIX;
    }

    public void handle(String message) {
        this.currentGame.handle(message);
    }
}
