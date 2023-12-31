package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.player.Language;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand extends Language implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (!player.hasPermission("system.fly")) {
      player.sendMessage(noPermissions);
      return false;
    } 
    if (args.length == 0) {
      if (player.getAllowFlight()) {
        player.setAllowFlight(false);
        player.sendMessage(prefix + "Du kannst nun §cnicht mehr fliegen§7.");
      } else {
        player.setAllowFlight(true);
        player.sendMessage(prefix + "Du kannst nun §afliegen§7.");
      } 
      return false;
    } 
    if (args.length == 1) {
      if (!player.hasPermission("system.fly.other")) {
        player.sendMessage(noPermissions);
        return false;
      } 
      if (Bukkit.getPlayer(args[0]) != null) {
        Player target = Bukkit.getPlayer(args[0]);
        if (player == target) {
          player.sendMessage(prefix + "Du kannst das nicht bei dir selber machen!");
          return false;
        } 
        if (target.getAllowFlight()) {
          target.setAllowFlight(false);
          target.sendMessage(prefix + "Du kannst nun §cnicht mehr fliegen§7.");
          player.sendMessage(prefix + "§e" + target.getName() + " §7kann nun §cnicht mehr fliegen§7.");
        } else {
          target.setAllowFlight(true);
          target.sendMessage(prefix + "Du kannst nun §afliegen§7.");
          player.sendMessage(prefix + "§e" + target.getName() + " §7kann nun §afliegen§7.");
        } 
      } else {
        player.sendMessage(prefix+"Dieser Spieler ist nicht online.");
      } 
      return false;
    } 
    player.sendMessage(prefix+"Bitte benutze: §e/fly");
    if (!player.hasPermission("system.fly.other"))
      player.sendMessage(prefix+"Bitte benutze: §e/fly <spieler>");
    return false;
  }
}
