package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.player.Language;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand extends Language implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (!player.hasPermission("system.heal")) {
      player.sendMessage(noPermissions);
      return false;
    } 
    if (args.length == 0) {
      player.setHealth(player.getMaxHealth());
      player.setFoodLevel(20);
      player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5.0F, 5.0F);
      player.sendMessage(prefix + "Du wurdest §ageheilt§7!");
      return false;
    } 
    if (args.length == 1) {
      if (Bukkit.getPlayer(args[0]) != null) {
        Player target = Bukkit.getPlayer(args[0]);
        if (player == target) {
          player.sendMessage(prefix + "Du kannst das nicht bei dir selber machen!");
          return false;
        } 
        target.setHealth(player.getMaxHealth());
        target.setFoodLevel(20);
        target.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5.0F, 5.0F);
        target.sendMessage(prefix + "Du wurdest §ageheilt§7!");
        player.sendMessage(prefix + "§e" + target.getName() + " §7wurde §ageheilt§7!");
      } else {
        player.sendMessage(prefix+"Dieser Spieler ist nicht online.");
      } 
      return false;
    } 
    player.sendMessage(prefix+"Bitte benutze: §e/heal");
    player.sendMessage(prefix+"Bitte benutze: §e/heal <Spieler>");
    return false;
  }
}
