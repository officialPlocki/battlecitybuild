package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.player.Language;
import de.battlesucht.cbsystem.utils.Tpahere;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpahereCommand extends Language implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (args.length == 1) {
      if (Bukkit.getPlayer(args[0]) != null) {
        Player target = Bukkit.getPlayer(args[0]);
        if (player == target) {
          player.sendMessage(prefix + "Du kannst das nicht bei dir selber machen!");
          return false;
        } 
        new Tpahere(player, target);
      } else {
        player.sendMessage(prefix+"Dieser Spieler ist nicht online.");
      } 
      return false;
    } 
    player.sendMessage(prefix + "Bitte benutze: §e/tpahere <spieler>");
    return false;
  }
}
