package net.ghostrealms.minigame.modules.Components;

import net.ghostrealms.minigame.modules.Component;

import org.bukkit.plugin.java.JavaPlugin;


/**
 * Created by James on 8/5/2015.
 */
public class TimerComponent extends Component {
    private Long wait;
    private JavaPlugin plugin;
    private int id = 0;

    public TimerComponent(Component parent, String name, long wait, boolean enabled, JavaPlugin plugin) {
        super(parent, name, enabled);
        this.wait = wait;
        this.plugin = plugin;
    }

    public void load() {
        super.load();
        id = plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            public void run() {
                if (!components.isEmpty())
                    for (Component c : components) c.update();
            }
        }, 0L, wait);
    }

    public void unload() {
        super.unload();
        if (id != 0) {
            plugin.getServer().getScheduler().cancelTask(id);
            id = 0;
        }
    }


}
