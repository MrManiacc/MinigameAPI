## MinigameAPI | v 0.0.2


MinigameAPI is a useful resource for Spigot/Bukkit developers to use. It aims to create a unified system for developers looking to make minigames.
The sole purpose is to make the development process of minigames, quick and easy (if possible).


# Developer(s)

* MrManiacc - Lead Developer
* AlphaTech - Contributor


# Commands and Permissions
* /enablemg <Minigame name> - Allows for users with the correct permission ```MinigameAPI.enablemg``` to enable a minigame, this will ask to force currently enabled minigame to shutdown (if there are any).
* /disablemg - Forces the current minigame to shutdown, if there's one running and if the user has the correct permission ```MinigameAPI.disablemg```.
* /restartmg - Restarts the minigame in a brute-force fashion, if the user sending the command has permission ```MinigameAPI.restartmg```.


# Planned features
* Easy database connection and SQL queries.
* Saving and data easily to a custom yaml configuration, and or a xaml.
* Loading data from SQL, yaml, and xaml easily and abstractly.
* Adding useful minigame functionality i.e. adding a way to create holograms, leaderboards etc.
* Command component system i.e. having a base command and then separate components for arguments for easy command system.
* Added a ci build system, along with a maven repo.
* Youtube tutorial on how to use the minigameAPI, and or a full Youtube series on creating a minigame with the API. 
* Add javadocs.

# Current features
* Developers can easily hook into the API and create a minigame instance.
* Component system (see 'What is the Component System'
* Timer component, which allows you to easily create countdown components or anything that needs to be updated a certain amount of time per a tick
* Listener component, which allows to create sub listeners components that can be enabled or disabled. They can be registered from the Listener component it's self easily.

# What is the Component System?
The the idea behind the component system is to make it easy for developers to be able to use certain features of the plugin all together. What does that mean? That means you can easily find another component based on the name. So what? Well with being able to get any component from another component is pretty powerful, let me give you an example. There is a countdown-timer component and you need to access it in a event listener class, well yes of course you just pass it in the constructor, but it gets sloppy sometimes. The component system allows for disabling certain components, reloading them etc. Each component has children of sub-components, they can be accessed via their name. You can cast those components to what ever you need to and easily access it. 

# How to use?
1. Download the lastes build from the jars folder.
2. Make a spigot/bukkit plugin, for either intellij or eclispe.
3. Add the 'Minigame(CurrentVersion).jar' to your build path.
4. Create a new class that extends 'Minigame'
5. Add the following to your 'onEnable' method:
  MinigameAPI.getInstance().registerMinigame(new GetToTheZoneMinigame(this));
  MinigameAPI.getInstance().getMinigame(this.getDescription().getName()).setEnabled(true);
6. When compiling your plugin don't forget to have the 'Minigame(CurrentVersion).jar' inside your plugin server!
