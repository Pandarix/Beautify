package com.github.Pandarix.beautify.client.event;

import com.github.Pandarix.beautify.Beautify;
import com.github.Pandarix.beautify.core.init.BlockInit;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
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
		
		ItemBlockRenderTypes.setRenderLayer(BlockInit.OAK_PICTURE_FRAME.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.BIRCH_PICTURE_FRAME.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.SPRUCE_PICTURE_FRAME.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.DARK_OAK_PICTURE_FRAME.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.JUNGLE_PICTURE_FRAME.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.ACACIA_PICTURE_FRAME.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.WARPED_PICTURE_FRAME.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.CRIMSON_PICTURE_FRAME.get(), RenderType.cutout());
		
		ItemBlockRenderTypes.setRenderLayer(BlockInit.OAK_BLINDS.get(), RenderType.cutout());
	}
}
