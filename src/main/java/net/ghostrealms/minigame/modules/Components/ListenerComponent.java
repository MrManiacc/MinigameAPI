package net.ghostrealms.minigame.modules.Components;

/**
 * Created by James on 8/6/2015.
 */
public class ListenerComponent {
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
                if (c.isEnabled()) {
                    plugin.getServer().getPluginManager().registerEvents((Listener) c, plugin);
                } else {
                    if (isDebug())
                        plugin.getLogger().log(Level.WARNING, "'" + c.getName() + "' was not loaded as a listener because it is not enabled.");
                }
            } else {
                if (isDebug())
                    plugin.getLogger().log(Level.WARNING, "'" + c.getName() + "' was not loaded into '" + this.getName() + "' because it doesn't implement listener .");
            }
        }
    }
}
