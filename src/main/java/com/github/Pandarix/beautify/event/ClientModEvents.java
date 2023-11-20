package com.github.Pandarix.beautify.event;

import com.github.Pandarix.beautify.Beautify;
import com.github.Pandarix.beautify.particle.ParticleInit;
import com.github.Pandarix.beautify.particle.custom.GlowEssenceParticles;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Beautify.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    // minecraft is autoclosing
    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(ParticleInit.GLOWESSENCE_PARTICLES.get(),
                GlowEssenceParticles.Provider::new);
    }
}
