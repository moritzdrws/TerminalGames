package de.moritz.terminalgames.game;

public interface Game {

    String getName();

    void start();

    void stop();

    void render();

    default String getGamePrefix() {
        return "[" + this.getName() + "] ";
    }
}
