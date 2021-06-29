package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.player.Language;
import de.battlesucht.cbsystem.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SkullCommand extends Language implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (!player.hasPermission("system.skull")) {
      player.sendMessage(noPermissions);
      return false;
    } 
    if (args.length == 1) {
      player.getInventory().addItem(new ItemStack[] { (new ItemBuilder(Material.PLAYER_HEAD, 1)).setSkullOwner(args[0]).build() });
      return false;
    } 
    player.sendMessage(prefix+"Bitte benutze: §e/skull <Spieler>");
    return false;
  }
}
