package net.ghostrealms;

import net.ghostrealms.minigame.Minigame;

import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

/**
 * Created by James on 8/5/2015.
 */
public class MinigameAPI extends JavaPlugin {
    private static MinigameAPI instance;

    private HashMap<String, Minigame> registeredMinigames;

    @Override
    public void onEnable() {
        this.registeredMinigames = new HashMap<String, Minigame>();
        instance = this;
        try {
            Metrics metrics = new Metrics(this);
            metrics.start();
        } catch (IOException e) {
            getLogger().log(Level.INFO, "Failed to report stats to MCStat's Plugin Metrics");
        }
    }

    @Override
    public void onDisable() {
        for(Minigame minigame : registeredMinigames.values()) minigame.setEnabled(false);
    }

    /**
     * Allows to hook into the minigameAPI
     */
    public static final MinigameAPI getInstance() {
        return instance;
    }

    /**
     * Allows for a the registration of a minigame
     */
    public void registerMinigame(Minigame minigame) {
        if (!registeredMinigames.containsValue(minigame)){
            registeredMinigames.put(minigame.getName(), minigame);
            getLogger().log(Level.INFO, minigame.getName() + " v" + minigame.getVersion() + " has been loaded into the GhostRealmsMinigameAPI!");
        }
    }
    public Minigame getMinigame(String name){
        return registeredMinigames.get(name);
    }
}
