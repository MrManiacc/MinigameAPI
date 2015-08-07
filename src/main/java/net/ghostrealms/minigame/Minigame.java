package net.ghostrealms.minigame;

import net.ghostrealms.minigame.modules.Component;
import net.ghostrealms.minigame.modules.Components.MainComponent;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by James on 8/5/2015.
 */
public abstract class Minigame {
    private Component mainComponent;
    private Database database;
    private String name;
    private String version;
    private boolean enabled;
    private JavaPlugin plugin;
    private boolean isDebug;

    public Minigame(String databaseName, JavaPlugin plugin, boolean isDebug) {
        this.name = plugin.getDescription().getName();
        this.version = plugin.getDescription().getVersion();
        this.plugin = plugin;
        this.isDebug = isDebug;
        this.database = new Database(databaseName, plugin);
        mainComponent = new MainComponent(plugin);
    }

    /**
     * Returns the plugin instance.
     * @return plugin
     */
    public JavaPlugin getPlugin() {
        return plugin;
    }

    /**
     * Returns the main component for children classes to use.
     * @return mainComponent
     */
    protected Component getMainComponent() {
        return mainComponent;
    }

    /**
     * Enables and disables the minigame.
     * @param b sets the status of the plugin
     */
    public void setEnabled(boolean b) {
        this.enabled = b;
        if (b == true) {
            mainComponent.toggleDebug(isDebug);
            load();
        } else unload();
    }

    /**
     * Returns the status of the minigame.
     * @return enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Returns the name of the minigame.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the version of the minigame.
     * @return version
     */
    public String getVersion() {
        return version;
    }

    /**
     * Forces creation of the load method.
     */
    protected abstract void load();

    /**
     * Forces creation of the unload method.
     */
    protected abstract void unload();

    /**
     * Returns the database class asigned to the plugin.
     * @return database
     */
    public Database getDatabase() {
        return database;
    }
}
