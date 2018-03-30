package me.tokyojack.spigot.particlefly.particles;

import lombok.Getter;
import me.tokyojack.spigot.particlefly.utils.ParticleEffect;

@Getter
public class FlyParticle {

	private ParticleEffect particleEffect;
	private double belowY;

	public FlyParticle(ParticleEffect particleEffect) {
		this.belowY = 0;
		this.particleEffect = particleEffect;
	}

	public FlyParticle(ParticleEffect particleEffect, double belowY) {
		this.belowY = belowY;
		this.particleEffect = particleEffect;
	}

}
