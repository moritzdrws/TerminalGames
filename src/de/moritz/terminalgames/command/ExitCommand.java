package de.moritz.terminalgames.command;

import de.moritz.terminalgames.Main;

import java.util.Arrays;

public class ExitCommand extends Command {

    public ExitCommand() {
        super("exit");
    }

    @Override
    public void execute(String[] strings) {
        System.out.println(Main.PREFIX + "Spiel wird geschlossen...");
        Main.getCommandManager().setReading(false);
    }
}
