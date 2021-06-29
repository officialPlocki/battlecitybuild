package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.player.Language;
import de.battlesucht.cbsystem.utils.HomeManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommand extends Language implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if(sender instanceof Player) {
      Player p = (Player) sender;
      if(args.length==0) {
        if(HomeManager.getLocation(p) != null) {
          p.teleport(HomeManager.getLocation(p));
          return true;
        } else {
          p.sendMessage(prefix+"Du hast keinen Home gesetzt. Benutze §e/home set §7um einen Home zu setzen.");
          return false;
        }
      } else if(args.length==1) {
        if(args[0].equalsIgnoreCase("set")) {
          p.sendMessage(prefix+"Dein Home wurde gesetzt.");
          return true;
        } else {
          p.sendMessage(prefix+"Bitte benutze: §e/home <set>");
          return false;
        }
      } else {
        p.sendMessage(prefix+"Bitte benutze: §e/home <set>");
        return false;
      }
    }
    return false;
  }
}
