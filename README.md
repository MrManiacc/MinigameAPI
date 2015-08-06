## MinigameAPI | v 0.0.2


MinigameAPI is a useful resource for Spigot/CraftBukkit developers to use. It aims to create a unified system for developers looking to make minigames.
The sole purpose is to make the development process of minigames, quick and easy (if possible).


# Developer(s)

* MrManiacc - Lead Developer


# Commands and Permissions
* /enablemg <Minigame name> - Allows for users with the correct permission ```MinigameAPI.enablemg``` to enable a minigame, this will ask to force currently enabled minigame to shutdown (if there are any).
* /disablemg - Forces the current minigame to shutdown, if there's one running and if the user has the correct permission ```MinigameAPI.disablemg```.
* /restartmg - Restarts the minigame in a bruteforce fasion, if the user sending the command has permission ```MinigameAPI.restartmg```.


# Planned features
* Easy database connection and sql queries.
* Saving and data easily to a custom yaml configurgiation, and or a xaml.
* Loading data from sql, yaml, and xaml easily and abstractly.
* Adding useful minigame funciality i.e. adding a way to create holograms, leaderboards etc.

# Current features
* Developers can easily hook into the api and create a minigame instance.
* Component system (see 'What is the Component System'
* Timer component, which allows you to easily create countdown components or anything that needs to be updated a certain amount of time per a tick
* Listener component, which allows to create sub listeners components that can be enabled or disabled. They can be registered from the Listener component it's self easily.

# What is the Component System?
The the idea behind the component system is to make it easy for developers to be able to use certain features of the plugin all together. What does that mean? That means you can easily find another component based on the name. So what? Well with being able to get any component from another component is pretty powerful, let me give you an example. There is a countdown-timer component and you need to access it in a event listener class, well yes of course you just pass it in the constructor, but it gets sloppy sometimes. The component system allows for disabling certain components, reloading them etc. Each component has children of sub-components, they can be accessed via their name. You can cast those components to what ever you need to and easily access it. 
