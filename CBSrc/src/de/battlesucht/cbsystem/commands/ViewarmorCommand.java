package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.player.Language;
import de.battlesucht.cbsystem.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ViewarmorCommand extends Language implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (!player.hasPermission("system.invsee")) {
      player.sendMessage(noPermissions);
      return false;
    } 
    if (args.length == 1) {
      if (Bukkit.getPlayer(args[0]) != null) {
        Player target = Bukkit.getPlayer(args[0]);
        if (player == target) {
          player.sendMessage(prefix + "Du kannst das nicht bei dir selber machen!");
          return false;
        } 
        Inventory inventory = Bukkit.createInventory(null, 9, "§4:" + target.getName());
        for (int i = 0; i < inventory.getSize(); i++)
          inventory.setItem(i, (new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1)).setName(" ").build());
        inventory.setItem(1, target.getInventory().getHelmet());
        inventory.setItem(3, target.getInventory().getChestplate());
        inventory.setItem(5, target.getInventory().getLeggings());
        inventory.setItem(7, target.getInventory().getBoots());
        player.openInventory(inventory);
      } else {
        player.sendMessage(prefix+"Dieser Spieler ist nicht online.");
      } 
      return false;
    } 
    player.sendMessage(prefix+"Bitte benutze: §e/invsee <spieler>");
    return false;
  }
}
