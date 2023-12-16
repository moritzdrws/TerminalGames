package de.moritz.terminalgames.game;

public interface Game {

    boolean running();

    String getName();

    void start();

    void stop();

    void render();

    void handle(String message);

    default String getGamePrefix() {
        return "[" + this.getName() + "] ";
    }
}
