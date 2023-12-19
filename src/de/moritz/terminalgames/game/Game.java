package de.moritz.terminalgames.game;

public abstract class Game {

    private final String name;
    private boolean running;


    public Game(String name) {
        this.name = name;
        this.running = false;
    }

    abstract void render();

    public String getName() {
        return this.name;
    }

    public boolean running() {
        return this.running;
    }

    public void start() {
        this.running = true;
    }

    public void stop() {
        this.running = false;
    }

    abstract void handle(String message);

    public final String getGamePrefix() {
        return "[" + this.getName() + "] ";
    }
}
