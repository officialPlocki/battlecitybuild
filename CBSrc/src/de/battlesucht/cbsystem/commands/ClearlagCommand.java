package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.player.Language;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class ClearlagCommand extends Language implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (!player.hasPermission("system.clearlag")) {
      player.sendMessage(noPermissions);
      return false;
    } 
    if (args.length == 0) {
      for(Entity e : player.getWorld().getEntities()) {
        if(!e.getType().equals(EntityType.PLAYER)) {
          if(e.getCustomName() == null || e.getCustomName().equalsIgnoreCase("")) {
            e.remove();
          }
        }
      }
      Bukkit.broadcastMessage("§7 ");
      Bukkit.broadcastMessage("§7 ");
      Bukkit.broadcastMessage(prefix + "§7Alle Items und Mobs wurden gelöscht!");
      Bukkit.broadcastMessage("§7 ");
      Bukkit.broadcastMessage("§7 ");
      return false;
    } 
    player.sendMessage(prefix+"Bitte benutze: §e/clearlag");
    return false;
  }
}
