package me.EssexIO;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class NoPL implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("pl") || cmd.getName().equalsIgnoreCase("plugins") || cmd.getName().equalsIgnoreCase("?")) {
			sender.sendMessage("§7For security reasons, we choose not to share our plugins. If you have a question about one, please ask a member of staff.");
			return true;
		}
		return false;
	}
}
