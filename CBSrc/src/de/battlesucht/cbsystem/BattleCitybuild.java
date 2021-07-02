package de.battlesucht.cbsystem;

import de.battlesucht.api.utils.server.plugin.PermissionManager;
import de.battlesucht.cbsystem.commands.*;
import de.battlesucht.cbsystem.listener.Join;
import de.battlesucht.cbsystem.utils.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class BattleCitybuild extends JavaPlugin {

    private static Plugin instance;

    public static Plugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        ScoreboardManager.update();
        Bukkit.getPluginManager().registerEvents(new JobCommand(), this);
        Bukkit.getPluginManager().registerEvents(new Join(), this);
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
        this.getCommand("job").setExecutor(new JobCommand());
        this.getCommand("jobs").setExecutor(new JobCommand());
        this.getCommand("fly").setExecutor(new FlyCommand());
        this.getCommand("god").setExecutor(new GodCommand());
        this.getCommand("vanish").setExecutor(new VanishCommand());
        this.getCommand("v").setExecutor(new VanishCommand());
        this.getCommand("tp").setExecutor(new TpCommand());
        this.getCommand("tphere").setExecutor(new TphereCommand());
        this.getCommand("tpa").setExecutor(new TpaCommand());
        this.getCommand("tpahere").setExecutor(new TpahereCommand());
        this.getCommand("craft").setExecutor(new CraftCommand());
        this.getCommand("enderchest").setExecutor(new EnderchestCommand());
        this.getCommand("ec").setExecutor(new EnderchestCommand());
        this.getCommand("invsee").setExecutor(new InvseeCommand());
        this.getCommand("gamemode").setExecutor(new GamemodeCommand());
        this.getCommand("gm").setExecutor(new GamemodeCommand());
        this.getCommand("reply").setExecutor(new ReplyCommand());
        this.getCommand("r").setExecutor(new ReplyCommand());
        this.getCommand("warp").setExecutor(new WarpCommand());
        this.getCommand("setwarp").setExecutor(new SetwarpCommand());
        this.getCommand("spawn").setExecutor(new SpawnCommand());
        this.getCommand("setspawn").setExecutor(new SetspawnCommand());
        this.getCommand("ptime").setExecutor(new PtimeCommand());
        this.getCommand("day").setExecutor(new DayCommand());
        this.getCommand("night").setExecutor(new NightCommand());
        this.getCommand("head").setExecutor(new HeadCommand());
        this.getCommand("skull").setExecutor(new SkullCommand());
        this.getCommand("kopf").setExecutor(new SkullCommand());
        this.getCommand("home").setExecutor(new HomeCommand());
        this.getCommand("heal").setExecutor(new HealCommand());
        this.getCommand("tpaccept").setExecutor(new TpacceptCommand());
        this.getCommand("tpdeny").setExecutor(new TpdenyCommand());
        this.getCommand("sign").setExecutor(new SignCommand());
        this.getCommand("rename").setExecutor(new RenameCommand());
        this.getCommand("msg").setExecutor(new MsgCommand());
        this.getCommand("speed").setExecutor(new SpeedCommand());
        this.getCommand("clearlag").setExecutor(new ClearlagCommand());
        this.getCommand("viewarmor").setExecutor(new ViewarmorCommand());
    }

    @Override
    public void onDisable() {

    }

}
