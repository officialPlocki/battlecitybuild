package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.files.FileBuilder;
import de.battlesucht.api.utils.player.Language;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SpawnCommand extends Language implements CommandExecutor {

  private FileBuilder fb = new FileBuilder("locations.data");
  private YamlConfiguration yml = fb.getYaml();

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (args.length == 0) {
      player.teleport(new Location(Bukkit.getWorld(yml.getString("Spawn.World")), yml.getDouble("Spawn.X"), yml.getDouble("Spawn.Y"), yml.getDouble("Spawn.Z"), (float)yml.getDouble("Spawn.Yaw"), (float)yml.getDouble("Spawn.Pitch")));
      return false;
    } 
    player.sendMessage(prefix+ "Bitte benutze: §e/spawn");
    return false;
  }
}
