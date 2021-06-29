package de.battlesucht.cbsystem.utils;

import de.battlesucht.api.utils.files.FileBuilder;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class HomeManager {

    private static FileBuilder fb = new FileBuilder("locations.data");
    private static YamlConfiguration yml = fb.getYaml();

    public static Location getLocation(Player p) {
        if(yml.isSet("loc."+p.getUniqueId().toString())) {
            return yml.getLocation("loc."+p.getUniqueId().toString());
        } else {
            return null;
        }
    }

    public static void setLocation(Player p, Location loc) {
        yml.set("loc."+p.getUniqueId().toString(), loc);
        fb.save();
    }

}
