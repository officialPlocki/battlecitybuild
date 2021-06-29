package de.battlesucht.cbsystem.commands;

import de.battlesucht.api.utils.player.Language;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Clearchat extends Language implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.hasPermission("system.chat.clear")) {
            for(Player p : Bukkit.getOnlinePlayers()) {
                if(!p.hasPermission("system.chat.clear.bypass")) {
                    for(int i=0; i<250; i++) {
                        p.sendMessage("");
                    }
                }
            }
            Bukkit.broadcastMessage(prefix+"Der Chat wurde von einem Teammitglied geleert.");
            return true;
        } else {
            commandSender.sendMessage(noPermissions);
            return false;
        }
    }
}
