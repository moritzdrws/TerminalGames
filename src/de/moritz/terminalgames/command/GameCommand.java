package de.moritz.terminalgames.command;

import de.moritz.terminalgames.Main;
import de.moritz.terminalgames.game.Game;

public class GameCommand extends Command {


    // !game start <name>
    // !game stop
    // !game list

    public GameCommand() {
        super("game");
    }

    @Override
    public void execute(String[] strings) {
        if (strings.length == 2 && strings[0].equalsIgnoreCase("start")) {
            if (Main.getGameManager().getCurrentGame() != null && Main.getGameManager().getCurrentGame().running()) {
                System.out.println(Main.PREFIX + "Aktuell läuf schon ein Spiel (" + Main.getGameManager().getCurrentGame().getName() + ").");
                return;
            }
            Game game = Main.getGameManager().getGame(strings[1]);
            if (game == null) {
                System.out.println(Main.PREFIX + "Das Spiel '" + strings[1] + "' wurde nicht gefunden.");
                return;
            }
            game.start();
            System.out.println(game.getGamePrefix() + "Spiel '" + game.getName() + "' wurde gestartet.");
            return;
        }
        if (strings.length == 1) {
            if (strings[0].equalsIgnoreCase("stop")) {
                if (Main.getGameManager().getCurrentGame() == null || (Main.getGameManager().getCurrentGame() != null && !Main.getGameManager().getCurrentGame().running())) {
                    System.out.println(Main.PREFIX + "Aktuell läuft kein Spiel.");
                    return;
                }
                Game currentGame = Main.getGameManager().getCurrentGame();
                currentGame.stop();
                System.out.println(currentGame.getGamePrefix() + "Das Spiel '" + currentGame.getName() + "' wurde gestoppt.");
                return;
            }
            if (strings[0].equalsIgnoreCase("list")) {
                if (Main.getGameManager().getGames().isEmpty()) {
                    System.out.println(Main.PREFIX + "Aktuell sind keine Spiele verfügbar.");
                    return;
                }
                System.out.println(Main.PREFIX + "Aktuell verfügbare Spiele:");
                for (Game game : Main.getGameManager().getGames()) {
                    System.out.println("-> " + game.getName());
                }
                return;
            }
        }

        System.out.println(Main.PREFIX + "Benutze bitte:");
        System.out.println("-> !game start <Name>");
        System.out.println("-> !game stop <Name>");
        System.out.println("-> !game list");
    }
}
