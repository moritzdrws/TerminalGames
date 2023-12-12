package de.moritz.terminalgames.command;

import de.moritz.terminalgames.Main;

import java.util.*;

public class CommandManager {

    private final List<Command> commands;
    private final Map<String, Command> commandMap;

    private boolean reading;

    public CommandManager() {
        this.commands = new ArrayList<>();
        this.commandMap = new HashMap<>();
    }

    public void registerCommand(Command command) {
        this.commands.add(command);
        this.commandMap.put(command.getName(), command);

        System.out.println(Main.PREFIX + "Der Command '" + command.getName() + "' wurde registriert!");
    }

    public void read() {
        if (this.reading) return;

        this.reading = true;

        System.out.println(Main.PREFIX + "Nutze '!help' um alle Commands anzuzeigen.");
        while (this.reading) {
            System.out.print(">> ");

            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();

            if (message.startsWith("!")) {
                String[] strings = message.split(" ");
                String commandName = strings[0].replaceFirst("!", "");
                strings = Arrays.copyOfRange(strings, 1, strings.length);

                Command command = this.commandMap.getOrDefault(commandName, null);
                if (this.commandMap.get(commandName) != null) {
                    command.execute(strings);
                    continue;
                }
                System.out.println(Main.PREFIX + "Command wurde nicht gefunden. Benutze '!help' um alle Commands anzuzeigen.");
                continue;
            }

            Main.getGameManager().handle(message);
        }
    }

    public void setReading(boolean reading) {
        this.reading = reading;
    }
}
