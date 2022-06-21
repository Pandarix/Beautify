package com.github.Pandarix.beautify.particle.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GlowEssenceParticles extends TextureSheetParticle {

	protected GlowEssenceParticles(ClientLevel level, double xCoord, double yCoord, double zCoord, SpriteSet spriteSet,
			double xd, double yd, double zd) {
		super(level, xCoord, yCoord, zCoord, xd, yd, zd);

		this.friction = 0.8F;
		this.xd = xd;
		this.yd = yd;
		this.zd = zd;
		this.quadSize *= 0.4F;
		this.lifetime = 60;
		this.setSpriteFromAge(spriteSet);

		this.rCol = 1f;
		this.gCol = 1f;
		this.bCol = 1f;
	}

	private void fadeOut() {
		this.alpha = (-(1 / (float) lifetime) * age + 1);
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
	}
	
    @Override
    public void tick() {
        super.tick();
        fadeOut();
    }

	@OnlyIn(Dist.CLIENT)
	public static class Provider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet sprites;

		public Provider(SpriteSet spriteSet) {
			this.sprites = spriteSet;
		}

		public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z,
				double dx, double dy, double dz) {
			return new GlowEssenceParticles(level, x, y, z, this.sprites, dx, dy, dz);
		}
	}

}
