package de.moritz.terminalgames.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerManager {

    private final List<Player> players;
    private final Map<String, Player> playerMap;

    public PlayerManager() {
        this.players = new ArrayList<>();
        this.playerMap = new HashMap<>();
    }

    public Player addPlayer(String name, char icon) {
        Player player = new Player(name, icon);

        this.players.add(player);
        this.playerMap.put(name, player);

        return player;
    }

    public Player getPlayerExact(String name) {
        return this.playerMap.get(name);
    }

    public Player getPlayer(String name) {
        if (name == null)
            return null;
        Player found = this.getPlayerExact(name);
        if (found != null) {
            return found;
        }
        String lowerName = name.toLowerCase();
        int delta = 2147483647;
        for (Player player : this.players) {
            if (player.getName().toLowerCase().startsWith(lowerName)) {
                int curDelta = Math.abs(player.getName().length() - lowerName.length());
                if (curDelta < delta) {
                    found = player;
                    delta = curDelta;
                }
                if (curDelta == 0) {
                    break;
                }
            }
        }
        return found;
    }
}
