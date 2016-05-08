package manticheat.hacks;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

import manticheat.hacks.utils.HackCheck;
import manticheat.hacks.utils.HackType;
import manticheat.main.Main;
import mgeneral.utils.mPlayer;
import mpermissions.utils.permissions.Rank;

/**
 * 
 * Copyright GummyPvP. Created on May 4, 2016 by Jeremy Gooch. All Rights
 * Reserved.
 * 
 */

public class FlyCheck extends HackCheck implements Listener {

	private FlyCheck() { }

	private static FlyCheck instance = new FlyCheck();

	public static FlyCheck getInstance() {

		return instance;

	}

	static final long CHECKTIME = 2;
	static final double MAX_VELOCITY = 1.5;

	private static Map<Player, Integer> flyCheck = new HashMap<Player, Integer>();
	private static Map<Player, Location> flyLocation = new HashMap<Player, Location>();

	@Override
	public HackType getHackType() {
		return HackType.FLIGHT;
	}

	@EventHandler
	public void onMove(PlayerMoveEvent e) {

		startCheck(e.getPlayer());

	}

	public void startCheck(Player p) {
		
		if (flyCheck.containsKey(p)) return;
		
		flyCheck.put(p, Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getMain(), new Runnable() {

			@Override
			public void run() {
				
				if (flyLocation.containsKey(p)) {
					
					if (flyLocation.get(p).getBlockX() == p.getLocation().getBlockX() && flyLocation.get(p).getBlockY() == p.getLocation().getBlockY() && flyLocation.get(p).getBlockZ() == p.getLocation().getBlockZ()) {
						
						removeEntry(p);
						
						return;
					}
					
				}

				flyLocation.put(p, p.getLocation());
				
				if (p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR)
					return;

				if (p.hasPotionEffect(PotionEffectType.JUMP))
					return;

				if (p.isInsideVehicle())
					return;

				if (p.isFlying())
					return;

				mPlayer user = mPlayer.getInstance(p);

				if (user.getGroup().getRank().hasRequiredRank(Rank.HARIBO)) {

					Bukkit.getScheduler().cancelTask(flyCheck.get(p));
					return;

				}

				debug ("Checking math");
				
				if (Math.abs(p.getVelocity().getY()) < MAX_VELOCITY)
					return;

				deliverPunishment(p);

			}

		}, 0L, 20L * CHECKTIME));

	}

	public void removeEntry(Player p) {

		if (flyCheck.get(p) != null) {

			Bukkit.getScheduler().cancelTask(flyCheck.get(p));

		}

		flyCheck.remove(p);

	}

	public static long getCheckTime() {
		return CHECKTIME;
	}

	private static void debug(String s) {

		if (Main.getMain().debugEnabled()) {
			
			Bukkit.broadcastMessage(s);
			
		}

	}

}
