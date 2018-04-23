package me.tokyojack.spigot.particlefly;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;
import me.tokyojack.spigot.particlefly.commands.FlyingParticles;
import me.tokyojack.spigot.particlefly.listeners.InventoryClick;
import me.tokyojack.spigot.particlefly.particles.Particles;
import me.tokyojack.spigot.particlefly.utils.kommand.KommandManager;

@Getter
public class Core extends JavaPlugin {

	@Getter
	private static Core plugin;

	private Map<UUID, Particles> flyingParticles = new HashMap<UUID, Particles>();

	public void onEnable() {
		plugin = this;
		
		new KommandManager().addCommand(new FlyingParticles()).build();

		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new InventoryClick(this), this);
		
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			@Override
			public void run() {
				for (Player player : Bukkit.getOnlinePlayers()) {
					if (!player.isFlying())
						continue;

					if (!flyingParticles.containsKey(player.getUniqueId())) {
						Particles.BASIC.display(player);
						continue;
					}

					flyingParticles.get(player.getUniqueId()).display(player);
				}
			}
		}, 0, 1);
	}

}