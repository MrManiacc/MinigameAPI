package net.ghostrealms;

import net.ghostrealms.minigame.Minigame;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by James on 8/5/2015.
 */
public class MinigameAPI extends JavaPlugin {
    private static MinigameAPI instance;

    private HashMap<String, Minigame> registeredMinigames;

    /**
     * Creates the instance and the Minigame HashMap handler.
     */
    public void onEnable() {
        this.registeredMinigames = new HashMap<String, Minigame>();
        instance = this;
    }

    /**
     * Disables all of the minigames.
     */
    public void onDisable() {
        for(Minigame minigame : registeredMinigames.values()) minigame.setEnabled(false);
    }

    /**
     * Hooks into the MinigameAPI.
     * @return instance
     */
    public static final MinigameAPI getInstance() {
        return instance;
    }

    /**
     * Registers the minigame if it is not already registered.
     * @param minigame the minigame to be registered
     */
    public void registerMinigame(Minigame minigame) {
        if (!registeredMinigames.containsValue(minigame)){
            registeredMinigames.put(minigame.getName(), minigame);
            getLogger().log(Level.INFO, minigame.getName() + " v" + minigame.getVersion() + " has been loaded into the GhostRealmsMinigameAPI!");
        }
    }

    /**
     * Returns the minigame with the specific name.
     * @param name the name of the minigame to get
     * @return the minigame specified
     */
    public Minigame getMinigame(String name){
        return registeredMinigames.get(name);
    }
}
