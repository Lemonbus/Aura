package manticheat.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import manticheat.hacks.FlyCheck;

/**
	 * 
	 * Copyright GummyPvP. Created on May 6, 2016 by Jeremy Gooch.
	 * All Rights Reserved.
	 * 
	 */

public class PlayerJoin implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		FlyCheck.getInstance().startCheck(p);
		
		p.teleport(new Location(p.getWorld(), p.getLocation().getBlockX(), p.getWorld().getHighestBlockYAt(p.getLocation()), p.getLocation().getBlockY()));
		
	}

}
