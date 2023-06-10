package com.hinaouo.noleavesdecay;

import com.hinaouo.noleavesdecay.events.NoLeavesDecayEvents;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class NoLeavesDecay extends JavaPlugin {
    //private FileConfiguration config;


    @Override
    public void onEnable() {

        //save default config if it doesn't exist
        this.saveDefaultConfig();

        FileConfiguration config = getConfig();
        //config.addDefault("enable", true);
        //config.addDefault("proximity-range", 10);

        //save default values of the config
        config.options().copyDefaults(true);
        saveConfig();

        //instantiate the obj for load the event class
        NoLeavesDecayEvents noLeavesDecayEvents = new NoLeavesDecayEvents();

        //set values got from the config
        noLeavesDecayEvents.setProximityRange(config.getInt("proximity-range"));
        noLeavesDecayEvents.setIsNotDecay(config.getBoolean("enable"));

        //load the event in the main class
        getServer().getPluginManager().registerEvents(noLeavesDecayEvents, this);

        //console log the correct load of the plugin
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[NO LEAVES DECAY]: Plugin Loaded Correctly");
    }

    @Override
    public void onDisable() {

        //console log the correct unload of the plugin
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[NO LEAVES DECAY]: Plugin Unloaded Correctly");

    }

}
