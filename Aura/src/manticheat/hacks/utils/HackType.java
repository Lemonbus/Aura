package manticheat.hacks.utils;

	/**
	 * 
	 * Copyright GummyPvP. Created on May 4, 2016 by Jeremy Gooch.
	 * All Rights Reserved.
	 * 
	 */

public enum HackType {
	
	FLIGHT("Flight", PunishmentType.KICK), SPEED("Speed", PunishmentType.PERMBAN);
	
	private String ufType;
	private PunishmentType pType;
	
	HackType(String ufType, PunishmentType pType) {
		
		this.ufType = ufType;
		this.pType = pType;
		
	}
	
	public String getHackName() {
		
		return ufType;
		
	}
	
	public PunishmentType getPunishment() {
		
		return pType;
		
	}

}
