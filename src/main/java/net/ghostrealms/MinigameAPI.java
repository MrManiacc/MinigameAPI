package net.ghostrealms;

import net.ghostrealms.minigame.Minigame;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by James on 8/5/2015.
 */
public class MinigameAPI extends JavaPlugin {
    private static MinigameAPI instance;

    private List<Minigame> registeredMinigames;

    @Override
    public void onEnable() {
        this.registeredMinigames = new ArrayList<Minigame>();
        instance = this;
    }

    @Override
    public void onDisable() {
        for(Minigame minigame : registeredMinigames) minigame.unload();
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
        if (!registeredMinigames.contains(minigame)){
            registeredMinigames.add(minigame);
            getLogger().log(Level.INFO, minigame.getName() + " v" + minigame.getVersion() + " has been loaded into the GhostRealmsMinigameAPI!");
        }
    }
}
