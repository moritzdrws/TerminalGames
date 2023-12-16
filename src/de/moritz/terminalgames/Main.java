package de.moritz.terminalgames;

import de.moritz.terminalgames.command.CommandManager;
import de.moritz.terminalgames.command.ExitCommand;
import de.moritz.terminalgames.command.PlayerCommand;
import de.moritz.terminalgames.game.GameManager;
import de.moritz.terminalgames.game.QuadConnect;
import de.moritz.terminalgames.player.PlayerManager;

public class Main {

    public static final String PREFIX = "[TerminalGames] ";

    private static CommandManager commandManager;
    private static GameManager gameManager;
    private static PlayerManager playerManager;

    public static void main(String[] args) {
        System.out.println(Main.PREFIX + "erfolgreich gestartet.");

        Main.commandManager = new CommandManager();
        Main.commandManager.registerCommand(new ExitCommand());
        Main.commandManager.registerCommand(new PlayerCommand());
        
        Main.gameManager = new GameManager();
        Main.gameManager.registerGame(new QuadConnect());

        Main.playerManager = new PlayerManager();

        Main.commandManager.read();
    }

    public static CommandManager getCommandManager() {
        return Main.commandManager;
    }

    public static GameManager getGameManager() {
        return Main.gameManager;
    }

    public static PlayerManager getPlayerManager() {
        return Main.playerManager;
    }
}
