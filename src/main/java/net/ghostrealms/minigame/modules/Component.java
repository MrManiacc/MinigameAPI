package net.ghostrealms.minigame.modules;

import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by James on 8/5/2015.
 */
public abstract class Component {
    private boolean isEnabled;
    private String name;
    private Component parent;
    protected List<Component> components = new ArrayList<Component>();
    private Thread upateThread;
    private boolean isDebug = false;
    private JavaPlugin plugin;

    public Component(JavaPlugin plugin, String name, boolean defaultEnable) {
        this.plugin = plugin;
        this.name = name;
        this.isEnabled = defaultEnable;
        setState(defaultEnable);
    }

    public Component(Component Parent, String name, boolean defaultEnable) {
        this.parent = Parent;
        this.plugin = parent.getPlugin();
        this.name = name;
        this.isEnabled = defaultEnable;
        setState(defaultEnable);
    }

    /**
     * Toggles debug mode.
     * @param debug if minigame should print out logs or not
     */
    public void toggleDebug(boolean debug) {
        isDebug = debug;
    }

    /**
     * Where all of the loading code etc. should be put.
     */
    public void load() {
        for (Component c : components) c.load();
        if (parent != null)
            plugin.getLogger().log(Level.INFO, "'" + getName() + "' has been added as a sub-component to '" + parent.getName() + "'.");
        else
            plugin.getLogger().log(Level.INFO, getName() + ", has been added.");
    }

    /**
     * Where all of the saving code etc. should be put.
     */
    public void unload() {
        for (Component c : components) c.unload();
        if (isDebug) {
            if (parent != null)
                plugin.getLogger().log(Level.INFO, "'" + getName() + "' has been removed as a sub-component to '" + parent.getName() + "'.");
            else
                plugin.getLogger().log(Level.INFO, getName() + ", has been unloaded.");
        }
        if (this instanceof Listener) {
            for (HandlerList l : HandlerList.getHandlerLists()) l.unregister(plugin);
            plugin.getLogger().log(Level.INFO, "'" + this.getName() + "' unregistered all events.");
        }
        this.isEnabled = false;
    }

    /**
     * Reloads a component.
     */
    public void reload() {
        unload();
        load();
    }

    /**
     * Method gets updated if component is in the timer list.
     */
    public void update() {
    }

    /**
     * Returns the parent component.
     * @return parent
     */
    public Component getParent() {
        return parent;
    }

    /**
     * Sets status of the current component.
     * @param enabled if the plugin should be enabled or not
     */
    public void setState(boolean enabled) {
        this.isEnabled = enabled;
    }

    /**
     * Adds a sub component to a the current component list.
     * @param component the component to be added
     */
    public void addComponenet(Component component) {
        if (components.contains(component)) return;
        component.toggleDebug(this.isDebug);
        components.add(component);
    }

    /**
     * Removes sub component from current component list.
     * @param component the component to be removed
     */
    public void removeComponenet(Component component) {
        if (components.contains(component)) return;
        components.remove(component);
    }

    /**
     * Sets the sub component to enabled if the current component contains it.
     * @param name the name of the component to enable
     */
    public void enableComponent(String name) {
        if (containsComponent(name)) getComponent(name).setState(true);
    }

    /**
     * Sets the sub component to disabled if the current component contains it.
     * @param name the name of the component to disable
     */
    public void disableComponent(String name) {
        if (containsComponent(name)) getComponent(name).setState(false);
    }

    /**
     * Returns true if the current component contains the request component.
     * @param name the name that is checked if is sub component or not
     * @return containment of component
     */
    public boolean containsComponent(String name) {
        for (Component c : components) if (c.getName().equals(name)) return true;
        return false;
    }

    /**
     * Returns the sub component if it is contained within the current component.
     * @param name the name of the component trying to be accessed
     * @return component
     */
    public Component getComponent(String name) {
        if (containsComponent(name))
            for (Component c : components) if (c.getName().equals(name)) return c;
        return null;
    }

    /**
     * Returns the current components name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the current state of the component.
     * @return isEnabled
     */
    public boolean isEnabled() {
        return isEnabled;
    }

    /**
     * Returns the debug status.
     * @return isDebug
     */
    public boolean isDebug() {
        return isDebug;
    }

    /**
     * Returns the JavaPlugin.
     * @return plugin
     */
    public JavaPlugin getPlugin() {
        return plugin;
    }
}
