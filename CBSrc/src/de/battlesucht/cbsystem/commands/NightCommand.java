package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.player.Language;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NightCommand extends Language implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (!player.hasPermission("system.time")) {
      player.sendMessage(noPermissions);
      return false;
    } 
    if (args.length == 0) {
      for (World world : Bukkit.getWorlds())
        world.setTime(12000L); 
      for (Player all : Bukkit.getOnlinePlayers())
        all.setPlayerTime(12000L, true); 
      player.sendMessage(prefix + "Zeit wurde auf §cNacht §7gesetzt!");
      return false;
    } 
    player.sendMessage(prefix + "Bitte benutze: §e/night");
    return false;
  }
}
