package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.player.Language;
import de.battlesucht.cbsystem.utils.Hashmaps;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand extends Language implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (!player.hasPermission("system.vanish")) {
      player.sendMessage(noPermissions);
      return false;
    } 
    if (args.length == 0) {
      if (Hashmaps.vanish.contains(player)) {
        Hashmaps.vanish.remove(player);
        Hashmaps.reloadVanish();
        player.sendMessage(prefix + "Du bist nun §cnicht mehr §7im §cVanish§7.");
      } else {
        Hashmaps.vanish.add(player);
        Hashmaps.reloadVanish();
        player.sendMessage(prefix + "Du bist nun im §aVanish§7.");
      } 
      return false;
    } 
    if (args.length == 1) {
      if (!player.hasPermission("system.vanish.other")) {
        player.sendMessage(noPermissions);
        return false;
      } 
      if (Bukkit.getPlayer(args[0]) != null) {
        Player target = Bukkit.getPlayer(args[0]);
        if (player == target) {
          player.sendMessage(prefix + "Du kannst das nicht bei dir selber machen!");
          return false;
        } 
        if (Hashmaps.vanish.contains(target)) {
          Hashmaps.vanish.remove(target);
          Hashmaps.reloadVanish();
          target.sendMessage(prefix + "Du bist nun §cnicht mehr §7im §cVanish§7.");
          player.sendMessage(prefix + "§e" + target.getName() + " §7ist nun §cnicht mehr §7im §cVanish§7.");
        } else {
          Hashmaps.vanish.add(target);
          Hashmaps.reloadVanish();
          target.sendMessage(prefix + "Du bist nun im §aVanish§7.");
          player.sendMessage(prefix + "§e" + target.getName() + " §7ist nun im §aVanish§7.");
        } 
      } else {
        player.sendMessage(prefix+"Dieser Spieler ist nicht online.");
      } 
      return false;
    } 
    player.sendMessage(prefix+"Bitte benutze: §e/vanish");
    if (!player.hasPermission("system.vanish.other"))
      player.sendMessage(prefix+"Bitte benutze: §e/vanish <spieler>");
    return false;
  }
}
