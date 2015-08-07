package net.ghostrealms.minigame.modules.Components;

import net.ghostrealms.minigame.modules.Component;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by James on 8/6/2015.
 */
public class CommandComponent extends Component implements CommandExecutor {

    public CommandComponent(Component Parent, String name, boolean defaultEnable) {
        super(Parent, name, defaultEnable);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (isEnabled()) {
            
        }
        return false;
    }
}
