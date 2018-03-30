package me.tokyojack.spigot.particlefly.particles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.tokyojack.spigot.particlefly.utils.ItemBuilder;
import me.tokyojack.spigot.particlefly.utils.ParticleEffect;

public enum Particles {
	BASIC(new ItemBuilder(Material.WOOL).setName("Basic").toItemStack(), new FlyParticle(ParticleEffect.CLOUD), new FlyParticle(ParticleEffect.SNOW_SHOVEL)),
	FIRE(new ItemBuilder(Material.WOOL).setName("Fire").toItemStack(),new FlyParticle(ParticleEffect.SMOKE_LARGE), new FlyParticle(ParticleEffect.FLAME)),
	MAGIC(new ItemBuilder(Material.WOOL).setName("Magic").toItemStack(),new FlyParticle(ParticleEffect.ENCHANTMENT_TABLE), new FlyParticle(ParticleEffect.CRIT_MAGIC)),
	REDSTONEWATER(new ItemBuilder(Material.WOOL).setName("Redstone Water").toItemStack(),new FlyParticle(ParticleEffect.WATER_DROP), new FlyParticle(ParticleEffect.REDSTONE)),
	WATER(new ItemBuilder(Material.WOOL).setName("Water").toItemStack(),new FlyParticle(ParticleEffect.WATER_WAKE), new FlyParticle(ParticleEffect.WATER_SPLASH)),
	BALL(new ItemBuilder(Material.WOOL).setName("Ball").toItemStack(),new FlyParticle(ParticleEffect.SLIME), new FlyParticle(ParticleEffect.SNOWBALL));

	private ItemStack inventoryItem;
	private List<FlyParticle> effects = new ArrayList<FlyParticle>();

	private Particles(ItemStack inventoryItem, FlyParticle... effects) {
		this.inventoryItem = inventoryItem;
		this.effects = Arrays.asList(effects);
	}

	public ItemStack getInventoryItem(){
		return this.inventoryItem;
	}
	
	public List<FlyParticle> getFlyParticles() {
		return this.effects;
	}

	public void display(Player player) {
		this.effects.forEach(fp -> fp.getParticleEffect().display(0, 0, 0, 0, 1,
				player.getLocation().add(0.0, fp.getBelowY(), 0.0), 100));
	}

}
