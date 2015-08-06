package net.ghostrealms.minigame.modules;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 8/5/2015.
 */
public abstract class Component {
    private boolean isEnabled;
    private String name;
    private Component parent;
    private List<Component> subComponents = new ArrayList<Component>();

    public Component(String name, boolean defaultEnable) {
        this.name = name;
        this.isEnabled = defaultEnable;
    }

    public Component(Component Parent, String name, boolean defaultEnable) {
        this(name, defaultEnable);
        this.parent = Parent;
    }

    /**
     * Returns the parent component
     */
    public Component getParent() {
        return parent;
    }

    /**
     * Sets status of the current component
     */
    public void setState(boolean enabled) {
        this.isEnabled = enabled;
    }

    /**
     * Adds a sub component to a the current component
     */
    public void addComponenet(Component component) {
        if (subComponents.contains(component)) return;
        subComponents.add(component);
    }

    /**
     * Removes sub component from current component
     */
    public void removeComponenet(Component component) {
        if (subComponents.contains(component)) return;
        subComponents.remove(component);
    }

    /**
     * Sets the sub component to enabled if the current component contains it
     */
    public void enableComponent(String name) {
        if (containsComponent(name)) getComponent(name).setState(true);
    }

    /**
     * Sets the sub component to disabled if the current component contains it
     */
    public void disableComponent(String name) {
        if (containsComponent(name)) getComponent(name).setState(false);
    }

    /**
     * Returns true if the current component contains the request component
     */
    public boolean containsComponent(String name) {
        for (Component c : subComponents) if (c.getName().equals(name)) return true;
        return false;
    }

    /**
     * Returns the sub component if it is contained within the current component
     */
    public Component getComponent(String name) {
        if (containsComponent(name))
            for (Component c : subComponents) if (c.getName().equals(name)) return c;
        return null;
    }

    /**
     * Returns the current components name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the current state of the component
     */
    public boolean isEnabled() {
        return isEnabled;
    }
}
