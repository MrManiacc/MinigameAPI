package net.ghostrealms.minigame.modules.Components;

import net.ghostrealms.minigame.modules.Component;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

/**
 * Created by James on 8/6/2015.
 */
public class ListenerComponent extends Component {
    private JavaPlugin plugin;

    public ListenerComponent(JavaPlugin plugin, Component Parent) {
        super(Parent, "Listenerhandler", false);
        this.plugin = plugin;
    }

    @Override
    public void load() {
        super.load();
        for (Component c : components) {
            if (c instanceof Listener) {
                if (c.isEnabled())
                    plugin.getServer().getPluginManager().registerEvents((Listener) c, plugin);

            }
        }
    }
}
