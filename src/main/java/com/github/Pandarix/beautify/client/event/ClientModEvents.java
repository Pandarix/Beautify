package com.github.Pandarix.beautify.client.event;

import com.github.Pandarix.beautify.Beautify;
import com.github.Pandarix.beautify.core.init.BlockInit;
import com.github.Pandarix.beautify.particle.ParticleInit;
import com.github.Pandarix.beautify.particle.custom.GlowEssenceParticles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Beautify.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
	private ClientModEvents() {
	}

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {

		ItemBlockRenderTypes.setRenderLayer(BlockInit.ROPE.get(), RenderType.cutout());

		ItemBlockRenderTypes.setRenderLayer(BlockInit.HANGING_POT.get(), RenderType.cutout());

		ItemBlockRenderTypes.setRenderLayer(BlockInit.BOOKSTACK.get(), RenderType.cutout());

		// TRELLIS
		ItemBlockRenderTypes.setRenderLayer(BlockInit.OAK_TRELLIS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.SPRUCE_TRELLIS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.BIRCH_TRELLIS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.JUNGLE_TRELLIS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.ACACIA_TRELLIS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.DARK_OAK_TRELLIS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.CRIMSON_TRELLIS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.WARPED_TRELLIS.get(), RenderType.cutout());

		// LAMPS
		ItemBlockRenderTypes.setRenderLayer(BlockInit.LAMP_LIGHT_BULB.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.LAMP_BAMBOO.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.LAMP_JAR.get(), RenderType.cutout());

		// FRAMES
		ItemBlockRenderTypes.setRenderLayer(BlockInit.OAK_PICTURE_FRAME.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.BIRCH_PICTURE_FRAME.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.SPRUCE_PICTURE_FRAME.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.DARK_OAK_PICTURE_FRAME.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.JUNGLE_PICTURE_FRAME.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.ACACIA_PICTURE_FRAME.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.WARPED_PICTURE_FRAME.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.CRIMSON_PICTURE_FRAME.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.QUARTZ_PICTURE_FRAME.get(), RenderType.cutout());

		// BLINDS
		ItemBlockRenderTypes.setRenderLayer(BlockInit.OAK_BLINDS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.SPRUCE_BLINDS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.BIRCH_BLINDS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.DARK_OAK_BLINDS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.JUNGLE_BLINDS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.ACACIA_BLINDS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.IRON_BLINDS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.CRIMSON_BLINDS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.WARPED_BLINDS.get(), RenderType.cutout());
	}

	@SuppressWarnings("resource") // minecraft is autoclosing
	@SubscribeEvent
	public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particleEngine.register(ParticleInit.GLOWESSENCE_PARTICLES.get(),
				GlowEssenceParticles.Provider::new);
	}
}
