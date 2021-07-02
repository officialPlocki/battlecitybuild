package de.battlesucht.cbsystem.commands;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import de.battlesucht.api.utils.player.Language;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SignCommand extends Language implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (!player.hasPermission("system.sign")) {
      player.sendMessage(noPermissions);
      return false;
    } 
    if (args.length >= 1) {
      String text = "";
      for (int i = 0; i < args.length; i++)
        text = text + args[i] + " "; 
      if (player.getInventory().getItemInMainHand().getType() != null && player.getInventory().getItemInMainHand().getType() != Material.AIR) {
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();
        meta.setLore(Arrays.asList(new String[] { "§c" + text
                .replaceAll("&", "§"), " ", "§7§m------------------------------", "§8➥ §7Von: §b" + player
                
                .getName(), "§8➥ §7Am: §b" + (new SimpleDateFormat("dd.MM.yyyy"))
                .format(new Date()), "§8➥ §7Um: §b" + (new SimpleDateFormat("HH:mm"))
                .format(new Date()) }));
        item.setItemMeta(meta);
        player.getInventory().setItemInMainHand(item);
        player.updateInventory();
        player.sendMessage(prefix + "Item wurde signiert!");
      } else {
        player.sendMessage(prefix + "Du musst ein Item in der Hand haben!");
      } 
      return false;
    } 
    player.sendMessage(prefix + "Bitte benutze: §e/sign <Text>");
    return false;
  }
}
