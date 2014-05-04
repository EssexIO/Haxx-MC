package me.EssexIO;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class KillReward implements Listener {
	// Haven't slept in 24 hours, sorry for that derp.

	@EventHandler
	public void onPlayerKillEntity(EntityDeathEvent event) {
		if (event.getEntity().getKiller().getType() == EntityType.PLAYER) {
			Player p = event.getEntity().getKiller();

			if (event.getEntityType() == EntityType.SPIDER) {
				ItemStack reward = new ItemStack(Material.GOLD_NUGGET, 6, (short)1);
				p.getInventory().addItem(reward);
			}
		}
	}
}
