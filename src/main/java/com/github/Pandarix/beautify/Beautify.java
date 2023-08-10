package com.github.Pandarix.beautify;

import com.github.Pandarix.beautify.core.init.*;
import com.github.Pandarix.beautify.util.Config;
import com.github.Pandarix.beautify.world.structure.ModStructuresMain;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.ArrayList;
import java.util.List;

@Mod(Beautify.MODID)
public class Beautify {
	public static final String MODID = "beautify";

	public Beautify() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ItemInit.ITEMS.register(modEventBus);
		BlockInit.BLOCKS.register(modEventBus);
		ItemGroupInit.CREATIVE_MODE_TABS.register(modEventBus);
		SoundInit.SOUND_EVENTS.register(modEventBus);

		modEventBus.addListener(this::commonSetup);
		ModVillagers.register(modEventBus);

		Config.register();

		ModStructuresMain.register(modEventBus);
		MinecraftForge.EVENT_BUS.addListener(this::addNewVillageBuilding);
		MinecraftForge.EVENT_BUS.register(this);
	}

	private void commonSetup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			ModVillagers.registerPOIs();
		});
	}

	private static final ResourceKey<StructureProcessorList> EMPTY_PROCESSOR_LIST_KEY = ResourceKey
			.create(Registries.PROCESSOR_LIST, new ResourceLocation("minecraft", "empty"));

	/**
	 * Adds the building to the targeted pool. We will call this in
	 * addNewVillageBuilding method further down to add to every village.
	 *
	 * Note: This is an additive operation which means multiple mods can do this and
	 * they stack with each other safely.
	 */
	private static void addBuildingToPool(Registry<StructureTemplatePool> templatePoolRegistry,
			Registry<StructureProcessorList> processorListRegistry, ResourceLocation poolRL, String nbtPieceRL,
			int weight) {

		// Grabs the processor list we want to use along with our piece.
		// This is a requirement as using the ProcessorLists.EMPTY field will cause the
		// game to throw errors.
		// The reason why is the empty processor list in the world's registry is not the
		// same instance as in that field once the world is started up.
		Holder<StructureProcessorList> emptyProcessorList = processorListRegistry
				.getHolderOrThrow(EMPTY_PROCESSOR_LIST_KEY);

		// Grab the pool we want to add to
		StructureTemplatePool pool = templatePoolRegistry.get(poolRL);
		if (pool == null) {
			return;
		}

		// Grabs the nbt piece and creates a SinglePoolElement of it that we can add to
		// a structure's pool.
		// Use .legacy( for villages/outposts and .single( for everything else
		SinglePoolElement piece = SinglePoolElement.legacy(nbtPieceRL, emptyProcessorList)
				.apply(StructureTemplatePool.Projection.RIGID);

		// Use AccessTransformer or Accessor Mixin to make StructureTemplatePool's
		// templates field public for us to see.
		// Weight is handled by how many times the entry appears in this list.
		// We do not need to worry about immutability as this field is created using
		// Lists.newArrayList(); which makes a mutable list.
		for (int i = 0; i < weight; i++) {
			pool.templates.add(piece);
		}

		// Use AccessTransformer or Accessor Mixin to make StructureTemplatePool's
		// rawTemplates field public for us to see.
		// This list of pairs of pieces and weights is not used by vanilla by default
		// but another mod may need it for efficiency.
		// So lets add to this list for completeness. We need to make a copy of the
		// array as it can be an immutable list.
		List<Pair<StructurePoolElement, Integer>> listOfPieceEntries = new ArrayList<>(pool.rawTemplates);
		listOfPieceEntries.add(new Pair<>(piece, weight));
		pool.rawTemplates = listOfPieceEntries;
	}

	/**
	 * We use FMLServerAboutToStartEvent as the dynamic registry exists now and all
	 * JSON worldgen files were parsed. Mod compat is best done here.
	 */
	public void addNewVillageBuilding(final ServerAboutToStartEvent event) {
		Registry<StructureTemplatePool> templatePoolRegistry = event.getServer().registryAccess()
				.registry(Registries.TEMPLATE_POOL).orElseThrow();
		Registry<StructureProcessorList> processorListRegistry = event.getServer().registryAccess()
				.registry(Registries.PROCESSOR_LIST).orElseThrow();
		
		int weight = Config.BOTANIST_SPAWN_WEIGHT.get();

		// Adds our piece to all village houses pool
		// Note, the resourcelocation is getting the pool files from the data folder.
		// Not assets folder.
		addBuildingToPool(templatePoolRegistry, processorListRegistry,
				new ResourceLocation("minecraft:village/plains/streets"), "beautify:botanist_house_plains", weight);

		addBuildingToPool(templatePoolRegistry, processorListRegistry,
				new ResourceLocation("minecraft:village/snowy/streets"), "beautify:botanist_house_snowy", weight);

		addBuildingToPool(templatePoolRegistry, processorListRegistry,
				new ResourceLocation("minecraft:village/savanna/streets"), "beautify:botanist_house_savanna", weight);

		addBuildingToPool(templatePoolRegistry, processorListRegistry,
				new ResourceLocation("minecraft:village/taiga/streets"), "beautify:botanist_house_taiga", weight);

		addBuildingToPool(templatePoolRegistry, processorListRegistry,
				new ResourceLocation("minecraft:village/desert/streets"), "beautify:botanist_house_desert", weight);
	}
}