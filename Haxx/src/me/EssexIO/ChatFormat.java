package me.EssexIO;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ChatFormat implements Listener {
	@EventHandler
	public void formatChat(AsyncPlayerChatEvent event) {
		event.setFormat(PermissionsEx.getUser(event.getPlayer()).getPrefix()
				.replaceAll("&", "§")
				+ "§3"
				+ event.getPlayer().getName()
				+ "§f: "
				+ event.getMessage());

		if (event.getPlayer().hasPermission("haxx.color")) {
			event.getMessage().replaceAll("&", "§");
		}

		if (event.getMessage().contains("staff")) {
			if (!event.getPlayer().hasPermission("haxx.staffword")) {
				event.setCancelled(true);
				event.getPlayer().sendMessage(
						"§cDo NOT ask about a staff position on the server.");
			} else {

			}
		}
	}
}
