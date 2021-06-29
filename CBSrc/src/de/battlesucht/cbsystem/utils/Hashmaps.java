package de.battlesucht.cbsystem.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hashmaps {

    public static HashMap<Player, Boolean> chatBold = new HashMap<>();
    public static List<Player> vanish = new ArrayList<>();
    public static List<Player> god = new ArrayList<>();

    public static void reloadVanish() {
        for (Player all : Bukkit.getOnlinePlayers()) {
            for (Player all2 : Bukkit.getOnlinePlayers()) {
                all.showPlayer(all2);
                all2.showPlayer(all);
            }
        }
        for (Player all : Bukkit.getOnlinePlayers()) {
            if (!all.hasPermission("system.vanish"))
                for (Player vanished : vanish)
                    all.hidePlayer(vanished);
        }
    }

}
