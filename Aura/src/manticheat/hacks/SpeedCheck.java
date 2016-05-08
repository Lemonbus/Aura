package manticheat.hacks;

import org.bukkit.event.Listener;

import manticheat.hacks.utils.HackCheck;
import manticheat.hacks.utils.HackType;

/**
	 * 
	 * Copyright GummyPvP. Created on May 6, 2016 by Jeremy Gooch.
	 * All Rights Reserved.
	 * 
	 */

public class SpeedCheck extends HackCheck implements Listener {

	@Override
	public HackType getHackType() {
		return HackType.SPEED;
	}
	
	
}
