package de.battlesucht.cbsystem;

import de.battlesucht.api.utils.server.plugin.PermissionManager;
import de.battlesucht.cbsystem.listener.Join;
import de.battlesucht.cbsystem.utils.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import de.battlesucht.cbsystem.commands.*;

public class BattleCitybuild extends JavaPlugin {

    private static Plugin instance;

    @Override
    public void onEnable() {
        instance = this;
        ScoreboardManager.update();
        Bukkit.getPluginManager().registerEvents(new JobCommand(), this);
        Bukkit.getPluginManager().registerEvents(new Join(), this);
        getCommand("job").setExecutor(new JobCommand());
        getCommand("jobs").setExecutor(new JobCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("god").setExecutor(new GodCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("v").setExecutor(new VanishCommand());
        getCommand("tp").setExecutor(new TpCommand());
        getCommand("tphere").setExecutor(new TphereCommand());
        getCommand("tpa").setExecutor(new TpaCommand());
        getCommand("tpahere").setExecutor(new TpahereCommand());
        getCommand("craft").setExecutor(new CraftCommand());
        getCommand("enderchest").setExecutor(new EnderchestCommand());
        getCommand("ec").setExecutor(new EnderchestCommand());
        getCommand("invsee").setExecutor(new InvseeCommand());
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("gm").setExecutor(new GamemodeCommand());
        getCommand("reply").setExecutor(new ReplyCommand());
        getCommand("r").setExecutor(new ReplyCommand());
        getCommand("warp").setExecutor(new WarpCommand());
        getCommand("setwarp").setExecutor(new SetwarpCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("setspawn").setExecutor(new SetspawnCommand());
        getCommand("ptime").setExecutor(new PtimeCommand());
        getCommand("day").setExecutor(new DayCommand());
        getCommand("night").setExecutor(new NightCommand());
        getCommand("head").setExecutor(new HeadCommand());
        getCommand("skull").setExecutor(new SkullCommand());
        getCommand("kopf").setExecutor(new SkullCommand());
        getCommand("home").setExecutor(new HomeCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("tpaccept").setExecutor(new TpacceptCommand());
        getCommand("tpdeny").setExecutor(new TpdenyCommand());
        getCommand("sign").setExecutor(new SignCommand());
        getCommand("rename").setExecutor(new RenameCommand());
        getCommand("msg").setExecutor(new MsgCommand());
        getCommand("speed").setExecutor(new SpeedCommand());
        getCommand("clearlag").setExecutor(new ClearlagCommand());
        getCommand("viewarmor").setExecutor(new ViewarmorCommand());

        PermissionManager pm = new PermissionManager("BattleCitybuild");
        pm.addPermission("system.chat.clear");
        pm.addPermission("system.chat.clear.bypass");
        pm.addPermission("system.clearlag");
        pm.addPermission("system.time");
        pm.addPermission("system.ec");
        pm.addPermission("system.ec.other");
        pm.addPermission("system.fly");
        pm.addPermission("system.fly.other");
        pm.addPermission("system.gamemode");
        pm.addPermission("system.gamemode.other");
        pm.addPermission("system.god");
        pm.addPermission("system.god.other");
        pm.addPermission("system.heal");
        pm.addPermission("system.heal.other");
        pm.addPermission("system.invsee");
        pm.addPermission("minecraft.kill");
        pm.addPermission("system.time");
        pm.addPermission("system.msg.read");
        pm.addPermission("system.vanish");
        pm.addPermission("system.rename");
        pm.addPermission("system.admin");
        pm.addPermission("system.sign");
        pm.addPermission("system.skull");
        pm.addPermission("system.speed.other");
        pm.addPermission("system.speed");
        pm.addPermission("system.tp");
        pm.addPermission("system.vanish.other");
        pm.build();

    }

    @Override
    public void onDisable() {

    }

    public static Plugin getInstance() {
        return instance;
    }

}
