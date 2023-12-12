package de.moritz.terminalgames.command;

public abstract class Command {

    private final String name;

    public Command(String name) {
        this.name = name.toLowerCase();
    }

    public abstract void execute(String[] strings);

    public String getName() {
        return this.name;
    }
}
