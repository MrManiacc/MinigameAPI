## MinigameAPI | v0.0.3
![logo](https://cloud.githubusercontent.com/assets/4280960/9127886/134dad6c-3c8f-11e5-88b7-f36e3818e6ca.jpg)

[![Build Status](https://travis-ci.org/MrManiacc/MinigameAPI.svg?branch=master)](https://travis-ci.org/MrManiacc/MinigameAPI)

MinigameAPI is a useful resource for Spigot/Bukkit developers to use. It aims to create a unified system for developers looking to make minigames.
The sole purpose of the MinigameAPI is to make the development process of minigames, quick and easy (if possible).

# Developers

* [MrManiacc](https://github.com/MrManiacc) - Lead Developer
* [AlphaTech](https://github.com/AlphaT3ch) - Contributor
* [CoderPluto](https://github.com/CoderPluto) - Developer

# Back on track
Recently this project was on hold. I [MrManiacc](https://github.com/MrManiacc) have decided to take it off of hold. This means that I will start work on this project again. I hope to get a big release soon (hopefully some kind of beta). Thank you!

# Commands and Permissions
* /enablemg <Minigame name> - Allows for users with the correct permission ```MinigameAPI.enablemg``` to enable a minigame, this will ask to force currently enabled minigame to shutdown (if there are any).
* /disablemg - Forces the current minigame to shutdown, if there's one running and if the user has the correct permission ```MinigameAPI.disablemg```.
* /restartmg - Restarts the minigame in a brute-force fashion, if the user sending the command has permission ```MinigameAPI.restartmg```.


# Planned features
* Easy database connection and using SQL queries.
* Save and retrieve data quickly and easily to and from a custom yaml or xaml configuration.
* Adding useful minigame functionality i.e. adding a way to create holograms, leaderboards etc.
* Command component system i.e. having a base command and then separate components for arguments for easy command system.
* Add with a maven repo.
* YouTube tutorial on how to use the MinigameAPI, and/or a full YouTube series on creating a minigame using the API. 

# Current features
* Developers can easily hook into the API and create a minigame instance.
* Component system (see '[What is the Component System](#what-is-the-component-system)').
* Timer component, which allows you to easily create a countdown component or anything that needs to be updated a certain amount of time per a tick.
* Listener component, which allows to create sub listeners components that can be enabled or disabled. They can be registered from the Listener component it's self easily.
* Added a Travis-CI build system.
* Added Javadocs.
* [MCStats](http://mcstats.org/plugin/RealmsMinigameAPI) support.

# What is the Component System?
The idea behind the component system is to make it easy for developers to be able to use certain features of the plugin all together. What does that mean? That means you can easily find another component based on the name. So what? Well with being able to get any component from another component is pretty powerful, let me give you an example. There is a countdown-timer component and you need to access it in a event listener class, well yes of course you just pass it in the constructor, but it gets sloppy sometimes. The component system allows for disabling certain components, reloading them etc. Each component has children of sub-components, they can be accessed via their name. You can cast those components to what ever you need to and easily access it. 

# Usage
1. Download the lastest build from the jars folder.
2. Make a spigot/bukkit plugin, for either intellij or eclispe.
3. Add the 'Minigame(CurrentVersion).jar' to your build path.
4. Create a new class that extends 'Minigame'
5. Add the following to your 'onEnable' method:
  1. MinigameAPI.getInstance().registerMinigame(new GetToTheZoneMinigame(this));
  2. MinigameAPI.getInstance().getMinigame(this.getDescription().getName()).setEnabled(true);
6. When compiling your plugin, don't forget to have the 'Minigame(CurrentVersion).jar' plugin running on your server instance!

# MCStats
All plugin details and statistics can be viewed on our [MCStats Plugin Page](http://mcstats.org/plugin/RealmsMinigameAPI).


