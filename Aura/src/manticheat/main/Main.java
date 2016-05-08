package manticheat.main;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import manticheat.hacks.FlyCheck;
import manticheat.listeners.PlayerJoin;
import manticheat.listeners.PlayerQuit;

/**
	 * 
	 * Copyright GummyPvP. Created on May 4, 2016 by Jeremy Gooch.
	 * All Rights Reserved.
	 * 
	 */

public class Main extends JavaPlugin {
	
	static Main instance;
	private boolean debug = true;
	
	public void onEnable() {
		
		instance = this;
		
		// debug = configmanager.getboolean(stuff);
		
		registerEvents(FlyCheck.getInstance(), new PlayerQuit(), new PlayerJoin());
		
	}
	
	private void registerEvents(Listener... listeners) {
		
		for (Listener l : listeners) {
			
			Bukkit.getPluginManager().registerEvents(l, this);
			
		}
		
	}
	
	public static Main getMain() {
		
		return instance;
		
	}
	
	public boolean debugEnabled() {
		
		return debug;
		
	}

}
