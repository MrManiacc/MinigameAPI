package net.ghostrealms.minigame.modules.Components;

import net.ghostrealms.minigame.modules.Component;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by James on 8/5/2015.
 */
public class MainComponent extends Component {
    public MainComponent(JavaPlugin plugin) {
        super(plugin, "MainComponent", true);
    }

    public void load(){
        super.load();
    }

    public void unload(){
        super.unload();
    }
}
