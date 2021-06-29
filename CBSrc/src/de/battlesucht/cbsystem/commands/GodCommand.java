package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.player.Language;
import de.battlesucht.cbsystem.utils.Hashmaps;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand extends Language implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (!player.hasPermission("system.god")) {
      player.sendMessage(noPermissions);
      return false;
    } 
    if (args.length == 0) {
      if (Hashmaps.god.contains(player)) {
        Hashmaps.god.remove(player);
        player.sendMessage(prefix + "Du bist nun §cnicht mehr §7im §cGod Modus§7.");
      } else {
        Hashmaps.god.add(player);
        player.sendMessage(prefix + "Du bist nun im §aGod Modus§7.");
      } 
      return false;
    } 
    if (args.length == 1) {
      if (!player.hasPermission("system.god.other")) {
        player.sendMessage(noPermissions);
        return false;
      } 
      if (Bukkit.getPlayer(args[0]) != null) {
        Player target = Bukkit.getPlayer(args[0]);
        if (player == target) {
          player.sendMessage(prefix + "Du kannst das nicht bei dir selber machen!");
          return false;
        } 
        if (Hashmaps.god.contains(target)) {
          Hashmaps.god.remove(target);
          target.sendMessage(prefix + "Du bist nun §cnicht mehr §7im §cGod Modus§7.");
          player.sendMessage(prefix + "§e" + target.getName() + " §7ist nun §cnicht mehr §7im §cGod Modus§7.");
        } else {
          Hashmaps.god.add(target);
          target.sendMessage(prefix + "Du bist nun im §aGod Modus§7.");
          player.sendMessage(prefix + "§e" + target.getName() + " §7ist nun im §aGod Modu§7.");
        } 
      } else {
        player.sendMessage(prefix+"Dieser Spieler ist nicht online.");
      } 
      return false;
    } 
    player.sendMessage(prefix+"Bitte benutze: §e/god");
    if (!player.hasPermission("system.god.other"))
      player.sendMessage(prefix+"Bitte benutze: §e/god <spieler>");
    return false;
  }
}
