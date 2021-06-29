package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.player.Language;
import de.battlesucht.cbsystem.utils.TpaManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpacceptCommand extends Language implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (args.length == 0) {
      if (TpaManager.getTpa2(player) != null) {
        TpaManager.getTpa2(player).accept();
      } else if (TpaManager.getTpahere2(player) != null) {
        TpaManager.getTpahere2(player).accept();
      } else {
        player.sendMessage(prefix + "Du hast keine Anfragen!");
      } 
      return false;
    } 
    player.sendMessage(prefix + "Bitte benutze: §e/tpaccept");
    return false;
  }
}
