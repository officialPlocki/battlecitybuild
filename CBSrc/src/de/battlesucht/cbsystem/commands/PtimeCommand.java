package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.player.Language;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PtimeCommand extends Language implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (!player.hasPermission("system.ptime")) {
      player.sendMessage(noPermissions);
      return false;
    } 
    if (args.length == 1) {
      if (args[0].equalsIgnoreCase("day")) {
        player.setPlayerTime(6000L, true);
        player.sendMessage(prefix + "Zeit für dich wurde auf §aTag §7gesetzt!");
        return false;
      } 
      if (args[0].equalsIgnoreCase("night")) {
        player.setPlayerTime(12000L, true);
        player.sendMessage(prefix + "Zeit für dich wurde auf §cNacht §7gesetzt!");
        return false;
      } 
    } 
    player.sendMessage(prefix + "Bitte benutze: §e/ptime <day/night>");
    return false;
  }
}
