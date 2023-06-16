package me.jsinco.colorswitch;

import org.bukkit.plugin.java.JavaPlugin;

public final class ColorSwitch extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new GUI(), this);
        getCommand("colorswitch").setExecutor(new OpenGUI());
        new Placeholder().register();
    }
}
