package de.moritz.terminalgames.command;

import de.moritz.terminalgames.Main;
import de.moritz.terminalgames.player.Player;

public class PlayerCommand extends Command {

    public PlayerCommand() {
        super("player");

        // !player add <Name> <Icon>
        // !player remove <Name>
        // !player list
    }

    @Override
    public void execute(String[] strings) {
        if (strings.length == 3 && strings[0].equalsIgnoreCase("add")) {
            String name = strings[1];
            char icon = strings[2].toCharArray()[0];

            if (Main.getPlayerManager().existsPlayer(name)) {
                System.out.println(Main.PREFIX + "Der Spieler '" + Main.getPlayerManager().getPlayer(name).getName() + "' existiert bereits.");
                return;
            }

            if (Main.getPlayerManager().existsIcon(icon)) {
                System.out.println(Main.PREFIX + "Das Icon '" + icon + "' wird bereits verwendet.");
                return;
            }

            if (name.length() < 3) {
                System.out.println(Main.PREFIX + "Der Name muss mindestens 3 Buchstaben haben.");
                return;
            }

            Main.getPlayerManager().addPlayer(name, icon);
            System.out.println(Main.PREFIX + "Der Spieler '" + name + " (" + icon + ")' wurde erstellt.");
            return;
        }
        if (strings.length == 2 && strings[0].equalsIgnoreCase("remove")) {
            String name = strings[1];

            if (!Main.getPlayerManager().existsPlayer(name)) {
                System.out.println(Main.PREFIX + "Der Spieler '" + name + "' existiert nicht.");
                return;
            }

            Player player = Main.getPlayerManager().removePlayer(name);
            System.out.println(Main.PREFIX + "Der Spieler '" + player.getName() + "' wurde entfernt.");
            return;
        }
        if (strings.length == 1 && strings[0].equalsIgnoreCase("list")) {
            if (Main.getPlayerManager().getPlayers().isEmpty()) {
                System.out.println(Main.PREFIX + "Aktuell sind keine Spieler erstellt.");
                return;
            }
            System.out.println(Main.PREFIX + "Aktuell angelegte Spieler:");
            for (Player player : Main.getPlayerManager().getPlayers()) {
                System.out.println("-> " + player.getName() + " (" + player.getIcon() + ")");
            }
            return;
        }

        System.out.println(Main.PREFIX + "Benutze bitte:");
        System.out.println("-> !player add <Name> <Icon>");
        System.out.println("-> !player remove <Name>");
        System.out.println("-> !player list");
    }
}
