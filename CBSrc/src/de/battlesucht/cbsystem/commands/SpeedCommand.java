package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.player.Language;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedCommand extends Language implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (!player.hasPermission("system.speed")) {
      player.sendMessage(noPermissions);
      return false;
    } 
    if (args.length == 1) {
      if (args[0].equalsIgnoreCase("1")) {
        player.setWalkSpeed(0.2F);
        player.setFlySpeed(0.1F);
        player.sendMessage(prefix + "Du hast nun den Speed §e" + args[0] + "§7!");
        return false;
      } 
      if (args[0].equalsIgnoreCase("2")) {
        player.setWalkSpeed(0.4F);
        player.setFlySpeed(0.2F);
        player.sendMessage(prefix + "Du hast nun den Speed §e" + args[0] + "§7!");
        return false;
      } 
      if (args[0].equalsIgnoreCase("3")) {
        player.setWalkSpeed(0.6F);
        player.setFlySpeed(0.3F);
        player.sendMessage(prefix + "Du hast nun den Speed §e" + args[0] + "§7!");
        return false;
      } 
      if (args[0].equalsIgnoreCase("4")) {
        player.setWalkSpeed(0.8F);
        player.setFlySpeed(0.4F);
        player.sendMessage(prefix + "Du hast nun den Speed §e" + args[0] + "§7!");
        return false;
      } 
      if (args[0].equalsIgnoreCase("5")) {
        player.setWalkSpeed(1.0F);
        player.setFlySpeed(0.5F);
        player.sendMessage(prefix + "Du hast nun den Speed §e" + args[0] + "§7!");
        return false;
      } 
    } 
    if (args.length == 2) {
      if (!player.hasPermission("system.speed.other")) {
        player.sendMessage(noPermissions);
        return false;
      } 
      if (Bukkit.getPlayer(args[0]) != null) {
        Player target = Bukkit.getPlayer(args[0]);
        if (player == target) {
          player.sendMessage(prefix + "Du kannst das nicht bei dir selber machen!");
          return false;
        } 
        if (args[0].equalsIgnoreCase("1")) {
          target.setWalkSpeed(0.2F);
          target.setFlySpeed(0.1F);
          target.sendMessage(prefix + "Du hast nun den Speed §e" + args[0] + "§7!");
          return false;
        } 
        if (args[0].equalsIgnoreCase("2")) {
          target.setWalkSpeed(0.4F);
          target.setFlySpeed(0.2F);
          target.sendMessage(prefix + "Du hast nun den Speed §e" + args[0] + "§7!");
          player.sendMessage(prefix + "§e" + target.getName() + " hat nun den Speed §e" + args[0] + "§7!");
          return false;
        } 
        if (args[0].equalsIgnoreCase("3")) {
          target.setWalkSpeed(0.6F);
          target.setFlySpeed(0.3F);
          target.sendMessage(prefix + "Du hast nun den Speed §e" + args[0] + "§7!");
          player.sendMessage(prefix + "§e" + target.getName() + " hat nun den Speed §e" + args[0] + "§7!");
          return false;
        } 
        if (args[0].equalsIgnoreCase("4")) {
          target.setWalkSpeed(0.8F);
          target.setFlySpeed(0.4F);
          target.sendMessage(prefix + "Du hast nun den Speed §e" + args[0] + "§7!");
          player.sendMessage(prefix + "§e" + target.getName() + " hat nun den Speed §e" + args[0] + "§7!");
          return false;
        } 
        if (args[0].equalsIgnoreCase("5")) {
          target.setWalkSpeed(1.0F);
          target.setFlySpeed(0.5F);
          target.sendMessage(prefix + "Du hast nun den Speed §e" + args[0] + "§7!");
          player.sendMessage(prefix + "§e" + target.getName() + " hat nun den Speed §e" + args[0] + "§7!");
          return false;
        } 
      } else {
        player.sendMessage(prefix+"Dieser Spieler ist nicht online.");
      } 
      return false;
    } 
    player.sendMessage(prefix + "Bitte benutze: §e/speed <1/2/3/4/5>");
    if (player.hasPermission("system.speed.other"))
      player.sendMessage(prefix + "Bitte benutze: §e/speed <1/2/3/4/5> <spieler>");
    return false;
  }
}
