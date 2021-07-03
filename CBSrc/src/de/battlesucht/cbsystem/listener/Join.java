package de.battlesucht.cbsystem.listener;

import de.battlesucht.api.utils.files.FileBuilder;
import de.battlesucht.cbsystem.BattleCitybuild;
import de.battlesucht.cbsystem.utils.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    private FileBuilder fb = new FileBuilder("locations.data");
    private YamlConfiguration yml = fb.getYaml();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        ScoreboardManager.setScoreboard(e.getPlayer());
        e.getPlayer().teleport(new Location(Bukkit.getWorld(yml.getString("Spawn.World")), yml.getDouble("Spawn.X"), yml.getDouble("Spawn.Y"), yml.getDouble("Spawn.Z"), (float)yml.getDouble("Spawn.Yaw"), (float)yml.getDouble("Spawn.Pitch")));
        Bukkit.getScheduler().runTaskLater(BattleCitybuild.getInstance(), () -> {
            if(e.getPlayer().getLocation().getWorld().getName().equalsIgnoreCase("world")) {
                e.getPlayer().teleport(new Location(Bukkit.getWorld(yml.getString("Spawn.World")), yml.getDouble("Spawn.X"), yml.getDouble("Spawn.Y"), yml.getDouble("Spawn.Z"), (float)yml.getDouble("Spawn.Yaw"), (float)yml.getDouble("Spawn.Pitch")));
            }
        }, 240);
    }

}
