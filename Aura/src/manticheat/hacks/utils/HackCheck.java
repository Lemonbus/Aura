package manticheat.hacks.utils;

import org.bukkit.entity.Player;

/**
	 * 
	 * Copyright GummyPvP. Created on May 4, 2016 by Jeremy Gooch.
	 * All Rights Reserved.
	 * 
	 */

public abstract class HackCheck {
	
	public abstract HackType getHackType();
	
	public void deliverPunishment(Player p) {
		
		switch (getHackType().getPunishment()) {
		case KICK:
			
			p.kickPlayer("Anticheat kicked you for " + getHackType().getHackName());
			
			break;
		case TEMPBAN:
			
			p.kickPlayer("Anticheat tempbanned you for " + getHackType().getHackName());
			
			break;
			
		case PERMBAN:
			
			p.kickPlayer("Anticheat banned you for " + getHackType().getHackName());
			
			break;

		default: 
			
			p.kickPlayer("Anticheat kicked you for some illegal modification");
			
			break;
		}
		
	}

}
