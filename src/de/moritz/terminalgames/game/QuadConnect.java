package de.moritz.terminalgames.game;

public class QuadConnect extends Game {

    private int width;
    private int height;

    public QuadConnect() {
        super("QuadConnect");

        this.width = 20;
        this.height = 10;
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
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
