package me.EssexIO;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class PlayerJoin implements Listener {

	// This will make it easy for me to implement UUID authentication when need
	// be.

	File PlayerDB = new File(Main.getPlugin().getDataFolder() + "/players.yml");
	FileConfiguration customConfig = YamlConfiguration
			.loadConfiguration(PlayerDB);

	@EventHandler
	public void onPlayerJoin(PlayerLoginEvent event) {
		Player p = event.getPlayer();

		if (!customConfig
				.getBoolean(p.getName().toString() + ".Whitelist") == true) {
			event.disallow(
					Result.KICK_WHITELIST,
					"To better enhance each players' experience, Haxx is a whitelisted server. To apply, visit http://haxx.me!");
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
