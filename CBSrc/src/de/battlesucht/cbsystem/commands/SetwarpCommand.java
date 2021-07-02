package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.files.FileBuilder;
import de.battlesucht.api.utils.player.Language;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SetwarpCommand extends Language implements CommandExecutor {

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
    if (args.length == 1) {
      if (args[0].equalsIgnoreCase("farmwelt")) {
        yml.set("Warp.Farmwelt.World", player.getLocation().getWorld().getName());
        yml.set("Warp.Farmwelt.X", Double.valueOf(player.getLocation().getBlockX() + 0.5D));
        yml.set("Warp.Farmwelt.Y", Integer.valueOf(player.getLocation().getBlockY()));
        yml.set("Warp.Farmwelt.Z", Double.valueOf(player.getLocation().getBlockZ() + 0.5D));
        yml.set("Warp.Farmwelt.Yaw", Integer.valueOf(Math.round(player.getLocation().getYaw() / 45.0F) * 45));
        yml.set("Warp.Farmwelt.Pitch", Integer.valueOf(Math.round(player.getLocation().getPitch() / 45.0F) * 45));
        fb.save();
        player.sendMessage(prefix + "Du hast §aerfolgreich §eFarmwelt §7gesetzt!");
        return false;
      } 
      if (args[0].equalsIgnoreCase("nether")) {
        yml.set("Warp.Nether.World", player.getLocation().getWorld().getName());
        yml.set("Warp.Nether.X", Double.valueOf(player.getLocation().getBlockX() + 0.5D));
        yml.set("Warp.Nether.Y", Integer.valueOf(player.getLocation().getBlockY()));
        yml.set("Warp.Nether.Z", Double.valueOf(player.getLocation().getBlockZ() + 0.5D));
        yml.set("Warp.Nether.Yaw", Integer.valueOf(Math.round(player.getLocation().getYaw() / 45.0F) * 45));
        yml.set("Warp.Nether.Pitch", Integer.valueOf(Math.round(player.getLocation().getPitch() / 45.0F) * 45));
        fb.save();
        player.sendMessage(prefix + "Du hast §aerfolgreich §eNether §7gesetzt!");
        return false;
      } 
    } 
    player.sendMessage(prefix + "Bitte benutze: §e/setwarp <farmwelt, nether>");
    return false;
  }
}
