package me.EssexIO;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class WhitelistCommand implements CommandExecutor {

	File PlayerDB = new File(Main.getPlugin().getDataFolder() + "/players.yml");
	FileConfiguration customConfig = YamlConfiguration
			.loadConfiguration(PlayerDB);

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("whitelist")) {
			if(sender.hasPermission("haxx.whitelist")) {
			if (args.length < 2 || args.length > 2) {
				sender.sendMessage("§6Proper Use: §f/whitelist <add/remove> playername");
				return false;
			} else {
				if (args[0].equalsIgnoreCase("add")) {
					if (!customConfig.getBoolean(args[1] + ".Whitelist") == true) {
						customConfig.set(args[1] + ".Whitelist", true);
						saveCustomYml(customConfig, PlayerDB);
						sender.sendMessage("§b" + args[1]
								+ " §fadded to whitelist.");
						return true;
					} else {
						sender.sendMessage("§b" + args[1]
								+ " §fis already on the whitelist!");
						return false;
					}
				}

				if (args[0].equalsIgnoreCase("remove")) {
					if (!customConfig.getBoolean(args[1] + ".Whitelist") == false) {
						customConfig.set(args[1] + ".Whitelist", false);
						saveCustomYml(customConfig, PlayerDB);
						sender.sendMessage("§b" + args[1]
								+ " §fremoved from whitelist.");
						return true;
					} else {
						sender.sendMessage("§b" + args[1]
								+ " §fisn't on the whitelist!");
					}
				}
			}
		} else {
			sender.sendMessage("§7You do not have the required permission to use this command.");
		}
		}
		return false;
	}

	public void saveCustomYml(FileConfiguration ymlConfig, File ymlFlle) {
		try {
			ymlConfig.save(PlayerDB);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
