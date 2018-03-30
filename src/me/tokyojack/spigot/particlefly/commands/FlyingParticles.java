package me.tokyojack.spigot.particlefly.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.tokyojack.spigot.particlefly.particles.Particles;
import me.tokyojack.spigot.particlefly.utils.kommand.Kommand;

public class FlyingParticles extends Kommand {

	public FlyingParticles() {
		super("Inventory for particles", Arrays.asList("flycos", "flycosmetic"));
	}

	@Override
	public boolean execute(CommandSender commandSender, String label, String[] args) {
		if (!(commandSender instanceof Player)) {
			commandSender.sendMessage("Only player's can do this command!");
			return false;
		}

		Inventory inv = Bukkit.createInventory(null, 27,
				ChatColor.AQUA + ChatColor.BOLD.toString() + "Flying Particles");

		Arrays.asList(Particles.values()).forEach(particle -> inv.addItem(particle.getInventoryItem()));
		((Player) commandSender).openInventory(inv);
		
		return true;
	}

}
