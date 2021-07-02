package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.player.Language;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RenameCommand extends Language implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (!player.hasPermission("system.rename")) {
      player.sendMessage(noPermissions);
      return false;
    } 
    if (args.length >= 1) {
      String name = "";
      for (int i = 0; i < args.length; i++)
        name = name + args[i] + " "; 
      if (player.getInventory().getItemInMainHand().getType() != null && player.getInventory().getItemInMainHand().getType() != Material.AIR) {
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§c§l" + name.replaceAll("&", "§"));
        item.setItemMeta(meta);
        player.getInventory().setItemInMainHand(item);
        player.updateInventory();
        player.sendMessage(prefix + "Item Name wurde geändert!");
      } else {
        player.sendMessage(prefix + "Du musst ein Item in der Hand haben!");
      } 
      return false;
    } 
    player.sendMessage(prefix + "Bitte benutze: §e/rename <Text>");
    return false;
  }
}
