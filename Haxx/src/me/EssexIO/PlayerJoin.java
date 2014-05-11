package me.EssexIO;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class PlayerJoin implements Listener {

	// This will make it easy for me to implement UUID authentication when need
	// be.

	File PlayerDB = new File(Main.getPlugin().getDataFolder() + "/players.yml");

	public void checkWhitelist(Player gp, PlayerLoginEvent ge) {
		Player p = gp;
		FileConfiguration customConfig = YamlConfiguration
				.loadConfiguration(PlayerDB);
		if (!customConfig.getBoolean(p.getName().toString() + ".Whitelist") == true) {
			ge.disallow(
					Result.KICK_WHITELIST,
					"To better enhance each players' experience, Haxx is a whitelisted server. To apply, visit http://haxx.me!");
		}
	}

	public void message(Player gp, String msg) {
		gp.sendMessage(msg);
	}

	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent event) {
		/**
		 * Decided against whitelisting for now.
		 */
		// checkWhitelist(event.getPlayer(), event);
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();

		if (!p.hasPlayedBefore() || p.getName().equalsIgnoreCase("EssexIO")) {
			event.setJoinMessage("§3§lWelcome to Haxx 1.7.9, §a"
					+ p.getDisplayName() + "§f!");
			message(p, "§6§l==== §3HAXX SERVER §6====");
			message(p, "§fWe are a §acustom §fserver with §3fun additions.");
			message(p,
					"§fWe have two simple rules. §cNo Griefing §fand §cNo Hacking§f.");
			message(p, "§fPlease abide by those rules, and have a great time!");
		} else {
			event.setJoinMessage("§3§lWelcome back to Haxx 1.7.9, §a"
					+ p.getDisplayName() + "§f!");
		}
	}

	public void saveCustomYml(FileConfiguration ymlConfig, File ymlFlle) {
		try {
			ymlConfig.save(PlayerDB);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
