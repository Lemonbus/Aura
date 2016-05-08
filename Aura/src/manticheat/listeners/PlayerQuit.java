package manticheat.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import manticheat.hacks.FlyCheck;

/**
	 * 
	 * Copyright GummyPvP. Created on May 5, 2016 by Jeremy Gooch.
	 * All Rights Reserved.
	 * 
	 */

public class PlayerQuit implements Listener {
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		
		FlyCheck.getInstance().removeEntry(e.getPlayer());
		
	}

}
