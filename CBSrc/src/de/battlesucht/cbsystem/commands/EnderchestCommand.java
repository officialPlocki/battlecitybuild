package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.player.Language;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class EnderchestCommand extends Language implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (!player.hasPermission("system.ec")) {
      player.sendMessage(noPermissions);
      return false;
    } 
    if (args.length == 0) {
      player.openInventory(player.getEnderChest());
      return false;
    } 
    if (args.length == 1) {
      if (!player.hasPermission("system.ec.other")) {
        player.sendMessage(noPermissions);
        return false;
      } 
      if (Bukkit.getPlayer(args[0]) != null) {
        Player target = Bukkit.getPlayer(args[0]);
        if (player == target) {
          player.sendMessage(prefix + "Du kannst das nicht bei dir selber machen!");
          return false;
        } 
        Inventory inventory = Bukkit.createInventory(null, target.getEnderChest().getSize(), "§4:" + target.getName());
        inventory.setContents(target.getEnderChest().getContents());
        player.openInventory(inventory);
      } else {
        player.sendMessage(prefix+"Der Spieler ist nicht online.");
      } 
      return false;
    } 
    player.sendMessage(prefix+"Bitte benutze: §e/enderchest");
    if (!player.hasPermission("system.ec.other"))
      player.sendMessage(prefix + "Bitte benutze: §e/enderchest <spieler>");
    return false;
  }
}
