package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.files.FileBuilder;
import de.battlesucht.api.utils.player.Language;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SetspawnCommand extends Language implements CommandExecutor {

  private FileBuilder fb = new FileBuilder("locations.data");
  private YamlConfiguration yml = fb.getYaml();
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (!player.hasPermission("system.admin")) {
      player.sendMessage(noPermissions);
      return false;
    } 
    if (args.length == 0) {
      yml.set("Spawn.World", player.getLocation().getWorld().getName());
      yml.set("Spawn.X", Double.valueOf(player.getLocation().getBlockX() + 0.5D));
      yml.set("Spawn.Y", Integer.valueOf(player.getLocation().getBlockY()));
      yml.set("Spawn.Z", Double.valueOf(player.getLocation().getBlockZ() + 0.5D));
      yml.set("Spawn.Yaw", Integer.valueOf(Math.round(player.getLocation().getYaw() / 45.0F) * 45));
      yml.set("Spawn.Pitch", Integer.valueOf(Math.round(player.getLocation().getPitch() / 45.0F) * 45));
      fb.save();
      player.sendMessage(prefix + "Du hast §aerfolgreich §eSpawn §7gesetzt!");
      return false;
    } 
    player.sendMessage(prefix + "Bitte benutze: §e/setspawn");
    return false;
  }
}
