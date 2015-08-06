package net.ghostrealms.minigame;

import net.ghostrealms.minigame.modules.Component;
import net.ghostrealms.minigame.modules.Components.MainComponent;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by James on 8/5/2015.
 */
public abstract class Minigame {
    private Component mainComponent;
    private String name;
    private String version;
    private boolean enabled;
    private JavaPlugin plugin;

    public Minigame(JavaPlugin plugin) {
        this.name = plugin.getDescription().getName();
        this.version = plugin.getDescription().getVersion();
        this.plugin = plugin;
        mainComponent = new MainComponent();
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    protected Component getMainComponent() {
        return mainComponent;
    }

    public void setEnabled(boolean b) {
        this.enabled = b;
        if(b == true) load();
        else unload();
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    protected abstract void load();

    protected abstract void unload();


}
