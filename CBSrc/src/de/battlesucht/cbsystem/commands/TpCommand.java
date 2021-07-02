package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.player.Language;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class TpCommand extends Language implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (!player.hasPermission("system.tp")) {
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
        player.teleport((Entity)target);
        player.sendMessage(prefix + "Du wurdest zu §a" + target.getName() + " §7teleportiert!");
      } else {
        player.hasPermission(prefix+"Dieser Spieler ist nicht online.");
      } 
      return false;
    } 
    if (args.length == 2) {
      if (Bukkit.getPlayer(args[0]) != null && Bukkit.getPlayer(args[1]) != null) {
        Player who = Bukkit.getPlayer(args[0]);
        Player target = Bukkit.getPlayer(args[1]);
        who.teleport((Entity)target);
        player.sendMessage(prefix + "§a" + who.getName() + " §7wurde zu §a" + target.getName() + " §7teleportiert!");
      } else {
        player.hasPermission(prefix+"Dieser Spieler ist nicht online.");
      } 
      return false;
    } 
    player.sendMessage(prefix + "Bitte benutze: §e/tp <spieler>");
    player.sendMessage(prefix + "Bitte benutze: §e/tp <spieler> <spieler>");
    return false;
  }
}
