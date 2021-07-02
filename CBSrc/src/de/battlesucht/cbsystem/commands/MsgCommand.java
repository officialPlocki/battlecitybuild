package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.player.Language;
import de.battlesucht.cbsystem.utils.Hashmaps;
import de.battlesucht.cbsystem.utils.MsgManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MsgCommand extends Language implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (args.length >= 1) {
      if (Bukkit.getPlayer(args[0]) != null) {
        Player target = Bukkit.getPlayer(args[0]);
        if (player == target) {
          player.sendMessage(prefix + "Du kannst das nicht bei dir selber machen!");
          return false;
        }
        MsgManager.setLast(player, target);
        MsgManager.setLast(target, player);
        if(Hashmaps.vanish.contains(target)) {
          if(!player.hasPermission("system.vanish")) {
            player.sendMessage("§8[§cMSG§8] §cDieser Spieler ist nicht online.");
            return false;
          }
        }
        if(!target.isOnline()) {
          player.sendMessage("§8[§cMSG§8] §cDieser Spieler ist nicht online.");
          return false;
        }
        String message = "";
        for (int i = 1; i < args.length; i++)
          message = message + args[i] + " "; 
        target.sendMessage("§8[§cMSG§8] §7" + player.getDisplayName() + " §8➜ §7MIR §8» §7" + message);
        player.sendMessage("§8[§cMSG§8] §7ICH §8➜ §7" + target.getDisplayName() + " §8» §7" + message);
        for (Player all : Bukkit.getOnlinePlayers()) {
          if (all == player || all == target)
            continue; 
          if (all.hasPermission("system.msg.read"))
            all.sendMessage("§8[§cMSG§8] §7" + player.getDisplayName() + " §8➜ §7" + target.getDisplayName() + " §8» §7" + message); 
        }
      } else {
        player.sendMessage(prefix+"Dieser Spieler ist nicht online.");
      } 
      return false;
    } 
    player.sendMessage(prefix+ "Bitte benutze: §e/msg <spieler> <nachricht>");
    return false;
  }
}
