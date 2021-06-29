package de.battlesucht.cbsystem.utils;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class MsgManager {

    private static HashMap<Player, Player> last = new HashMap<>();

    public static void setLast(Player from, Player target) {
        last.put(from, target);
    }

    public static Player getLast(Player p) {
        if(last.containsKey(p)) {
            if(last.get(p).isOnline()) {
                return last.get(p);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

}
