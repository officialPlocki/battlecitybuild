package de.battlesucht.cbsystem.commands;

import de.battlesucht.cbsystem.utils.MsgManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReplyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(MsgManager.getLast((Player) commandSender) != null) {
            Player p = (Player) commandSender;
        	String s1 = "";
        	for(String s2 : strings) {
        		if(s1 == "") {
        			s1 = s2;
        		} else {
        			s1 = s1+" "+s2;
        		}
        	}
            Bukkit.getServer().dispatchCommand(p, "msg " + MsgManager.getLast(p).getName() + " "+s1);
            return true;
        } else {
            commandSender.sendMessage("§8[§cMSG§8] §cDu hast aktuell keine Unterhaltung am laufen.");
            return false;
        }
    }

}
