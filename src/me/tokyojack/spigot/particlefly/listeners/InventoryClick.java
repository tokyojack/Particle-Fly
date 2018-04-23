package me.tokyojack.spigot.particlefly.listeners;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import me.tokyojack.spigot.particlefly.Core;
import me.tokyojack.spigot.particlefly.particles.Particles;

public class InventoryClick implements Listener {
	
	@EventHandler(ignoreCancelled = true)
	public void onInventoryClick(InventoryClickEvent event) {
		ItemStack clickedItem = event.getCurrentItem();

		if (clickedItem == null || clickedItem.getType() == Material.AIR)
			return;

		Player player = (Player) event.getWhoClicked();

		if (!(player instanceof Player))
			return;

		if (event.getInventory().getName().equals(ChatColor.AQUA + ChatColor.BOLD.toString() + "Flying Particles")) {

			event.setCancelled(true);

			for (Particles particle : Arrays.asList(Particles.values())) {
				if (particle.getInventoryItem().getItemMeta().getDisplayName()
						.equals(clickedItem.getItemMeta().getDisplayName())) {

					Map<UUID, Particles> flyingParticles = Core.getPlugin().getFlyingParticles();

					if (particle == Particles.BASIC) {
						flyingParticles.remove(player.getUniqueId());
					} else {
						flyingParticles.put(player.getUniqueId(), particle);
					}

					break;
				}
			}
		}
	}

}
