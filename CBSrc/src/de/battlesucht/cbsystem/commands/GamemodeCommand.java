package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.player.Language;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand extends Language implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (!player.hasPermission("system.gamemode")) {
      player.sendMessage(noPermissions);
      return false;
    } 
    if (args.length == 1) {
      if (args[0].equalsIgnoreCase("0")) {
        player.setGameMode(GameMode.SURVIVAL);
        player.sendMessage(prefix + "Du bist nun im Spielmodus §a" + GameMode.SURVIVAL + "§7!");
        return false;
      } 
      if (args[0].equalsIgnoreCase("1")) {
        player.setGameMode(GameMode.CREATIVE);
        player.sendMessage(prefix + "Du bist nun im Spielmodus §a" + GameMode.CREATIVE + "§7!");
        return false;
      } 
      if (args[0].equalsIgnoreCase("2")) {
        player.setGameMode(GameMode.ADVENTURE);
        player.sendMessage(prefix + "Du bist nun im Spielmodus §a" + GameMode.ADVENTURE + "§7!");
        return false;
      } 
      if (args[0].equalsIgnoreCase("3")) {
        player.setGameMode(GameMode.SPECTATOR);
        player.sendMessage(prefix + "Du bist nun im Spielmodus §a" + GameMode.SPECTATOR + "§7!");
        return false;
      } 
    } 
    if (args.length == 2) {
      if (!player.hasPermission("system.gamemode.other")) {
        player.sendMessage(noPermissions);
        return false;
      } 
      if (Bukkit.getPlayer(args[1]) != null) {
        Player target = Bukkit.getPlayer(args[1]);
        if (player == target) {
          player.sendMessage(prefix + "Du kannst das nicht bei dir selber machen!");
          return false;
        } 
        if (args[0].equalsIgnoreCase("0")) {
          target.setGameMode(GameMode.SURVIVAL);
          target.sendMessage(prefix + "Du bist nun im Spielmodus §a" + GameMode.SURVIVAL + "§7!");
          player.sendMessage(prefix + "§a" + target.getName() + " §7ist nun im Spielmodus §a" + GameMode.SURVIVAL + "§7!");
        } else if (args[0].equalsIgnoreCase("1")) {
          target.setGameMode(GameMode.CREATIVE);
          target.sendMessage(prefix + "Du bist nun im Spielmodus §a" + GameMode.CREATIVE + "§7!");
          player.sendMessage(prefix + "§a" + target.getName() + " §7ist nun im Spielmodus §a" + GameMode.CREATIVE + "§7!");
        } else if (args[0].equalsIgnoreCase("2")) {
          target.setGameMode(GameMode.ADVENTURE);
          target.sendMessage(prefix + "Du bist nun im Spielmodus §a" + GameMode.ADVENTURE + "§7!");
          player.sendMessage(prefix + "§a" + target.getName() + " §7ist nun im Spielmodus §a" + GameMode.ADVENTURE + "§7!");
        } else if (args[0].equalsIgnoreCase("3")) {
          target.setGameMode(GameMode.SPECTATOR);
          target.sendMessage(prefix + "Du bist nun im Spielmodus §a" + GameMode.SPECTATOR + "§7!");
          player.sendMessage(prefix + "§a" + target.getName() + " §7ist nun im Spielmodus §a" + GameMode.SPECTATOR + "§7!");
        } 
      } else {
        player.sendMessage(prefix+"Dieser Spieler ist nicht online.");
      } 
      return false;
    }
    player.sendMessage(prefix+"Bitte benutze: §e/gamemode <0/1/2/3>");
    if (player.hasPermission("system.gamemode.other"))
      player.sendMessage(prefix+"Bitte benutze: §e/gamemode <0/1/2/3> <spieler>");
    return false;
  }
}
