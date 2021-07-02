package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.player.Language;
import de.battlesucht.cbsystem.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class WarpCommand extends Language implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (args.length == 0) {
      Inventory inventory = Bukkit.createInventory(null, 27, "§6Warps");
      for (int i = 0; i < inventory.getSize(); i++)
        inventory.setItem(i, (new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE,  1)).setName(" ").build());
      inventory.setItem(11, (new ItemBuilder(Material.GRASS,  1)).setName("§6Farmwelt").build());
      inventory.setItem(13, (new ItemBuilder(Material.MAGMA_CREAM,  1)).setName("§6Spawn").build());
      inventory.setItem(15, (new ItemBuilder(Material.NETHERRACK,  1)).setName("§6Nether").build());
      player.openInventory(inventory);
      player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 5.0F, 5.0F);
      return false;
    } 
    player.sendMessage(prefix+"Bitte benutze: §e/warp");
    return false;
  }
}
