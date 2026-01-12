package de.zweifelnder.zweifelentitys;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("entityspawn").setExecutor(new EntitySpawnCommand());
        System.out.println("ZWEIFELENTITYS" + " >> " + "Zweifelentitys aktiviert! Developed by Zweifelnder.");
    }

    @Override
    public void onDisable() {
        getLogger().info("ZweifelEntitys deaktiviert!");
    }
}
