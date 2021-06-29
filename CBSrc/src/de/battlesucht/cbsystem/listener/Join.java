package de.battlesucht.cbsystem.listener;

import de.battlesucht.cbsystem.utils.ScoreboardManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        ScoreboardManager.setScoreboard(e.getPlayer());
    }

}
