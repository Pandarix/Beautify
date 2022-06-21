package com.github.Pandarix.beautify.particle;

import com.github.Pandarix.beautify.Beautify;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ParticleInit {
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister
			.create(ForgeRegistries.PARTICLE_TYPES, Beautify.MODID);

	public static void register(IEventBus eventBus) {
		PARTICLE_TYPES.register(eventBus);
	}

	public static final RegistryObject<SimpleParticleType> GLOWESSENCE_PARTICLES = PARTICLE_TYPES
			.register("glowessence_particles", () -> new SimpleParticleType(true));
}
