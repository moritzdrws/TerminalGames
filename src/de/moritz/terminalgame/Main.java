package de.moritz.terminalgame;

import de.moritz.terminalgame.game.GameManager;
import de.moritz.terminalgame.game.QuadConnect;

public class Main {

    public static final String PREFIX = "[TerminalGames] ";

    private static GameManager gameManager;

    public static void main(String[] args) {
        System.out.println(Main.PREFIX + "erfolgreich gestartet.");

        Main.gameManager = new GameManager();
        Main.gameManager.registerGame(new QuadConnect());
    }

    public static GameManager getGameManager() {
        return Main.gameManager;
    }
}
