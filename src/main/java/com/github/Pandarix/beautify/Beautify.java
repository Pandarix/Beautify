package com.github.Pandarix.beautify;

import com.github.Pandarix.beautify.core.init.BlockInit;
import com.github.Pandarix.beautify.core.init.ItemInit;
import com.github.Pandarix.beautify.core.init.ModVillagers;
import com.github.Pandarix.beautify.core.init.SoundInit;
import com.github.Pandarix.beautify.util.Config;
import com.github.Pandarix.beautify.world.structure.ModStructuresMain;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Beautify.MODID)
public class Beautify {
	public static final String MODID = "beautify";

	public Beautify() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ItemInit.ITEMS.register(modEventBus);
		BlockInit.BLOCKS.register(modEventBus);
		
		ModVillagers.register(modEventBus);
		modEventBus.addListener(this::commonSetup);
		
		SoundInit.SOUND_EVENTS.register(modEventBus);
		
		// ParticleInit.PARTICLE_TYPES.register(bus);
		Config.register();
		
		ModStructuresMain.register(modEventBus);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void commonSetup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			ModVillagers.registerPOIs();
		});
	}

	// TAB
	public static final CreativeModeTab BEAUTIFY_TAB = new CreativeModeTab(MODID) { // itemGroup.beautify
		@Override
		public ItemStack makeIcon() {
			return ItemInit.HANGING_POT_ITEM.get().getDefaultInstance();
		}
	};
}