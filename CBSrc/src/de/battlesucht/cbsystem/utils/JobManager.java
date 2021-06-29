package de.battlesucht.cbsystem.utils;

import java.io.File;
import java.io.IOException;

import de.battlesucht.api.utils.files.FileBuilder;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class JobManager {

    private static FileBuilder fb = new FileBuilder("jobs.data");
    private static YamlConfiguration yml = fb.getYaml();

    public static void setJob(Player p, String job) {

        yml.set(p.getUniqueId().toString()+".job", job);
        fb.save();
    }
    
    public static String getJob(Player p) {
        if(yml.isSet(p.getUniqueId().toString()+".job")) {
            return yml.getString(p.getUniqueId().toString()+".job");
        } else {
        	setJob(p, "none");
            return "none";
        }
    }
    
}
