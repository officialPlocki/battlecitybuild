package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.player.Language;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HeadCommand extends Language implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (!player.hasPermission("system.head")) {
      player.sendMessage(noPermissions);
      return false;
    } 
    if (args.length == 0) {
      if (player.getInventory().getItemInMainHand().getType() != null && player.getInventory().getItemInMainHand().getType() != Material.AIR) {
        player.getInventory().setHelmet(player.getInventory().getItemInMainHand());
        player.setItemInHand(null);
        player.sendMessage(prefix + "Item wurde auf deinen Kopf gesetzt!");
      } else {
        player.sendMessage(prefix + "Du musst ein Item in der Hand haben!");
      } 
      return false;
    } 
    player.sendMessage(prefix+"Bitte benutze: §e/head");
    return false;
  }
}
