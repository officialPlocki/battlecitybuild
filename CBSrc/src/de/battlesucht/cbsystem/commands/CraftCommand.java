package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.player.Language;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CraftCommand extends Language implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (args.length == 0) {
      player.openWorkbench(null, true);
      return false;
    } 
    player.sendMessage(prefix+"Bitte benutze: §e/craft");
    return false;
  }
}
