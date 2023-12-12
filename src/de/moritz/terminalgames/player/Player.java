package de.moritz.terminalgames.player;

import java.util.UUID;

public class Player {

    private final String name;
    private char icon;


    public Player(String name, char icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return this.name;
    }

    public char getIcon() {
        return this.icon;
    }

    public void setIcon(char icon) {
        this.icon = icon;
    }
}
