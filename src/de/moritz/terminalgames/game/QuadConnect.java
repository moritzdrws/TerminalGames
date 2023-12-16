package de.moritz.terminalgames.game;

public class QuadConnect implements Game {

    private final String name;
    private boolean running;
    private int width;
    private int height;

    public QuadConnect() {
        this.name = "QuadConnect";

        this.width = 20;
        this.height = 10;
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean running() {
        return this.running;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void start() {
        this.running = true;
    }

    @Override
    public void stop() {
        this.running = false;
    }

    @Override
    public void render() {
        for (int i = 0; i < this.height; i++) {
            System.out.println("#".repeat(Math.max(0, this.width)));
        }
    }

    @Override
    public void handle(String message) {

    }
}
