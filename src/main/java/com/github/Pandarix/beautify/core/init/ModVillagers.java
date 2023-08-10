package com.github.Pandarix.beautify.core.init;

import com.github.Pandarix.beautify.Beautify;
import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ModVillagers {
	public static final DeferredRegister<PoiType> POI_TYPES =
			DeferredRegister.create(ForgeRegistries.POI_TYPES, Beautify.MODID);
	public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
			DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, Beautify.MODID);

	public static final RegistryObject<PoiType> BOTANIST_WORKBENCH_POI = POI_TYPES.register("botanist_workbench_poi",
			() -> new PoiType(
					ImmutableSet.copyOf(BlockInit.BOTANIST_WORKBENCH.get().getStateDefinition().getPossibleStates()), 1,
					1));

	public static final RegistryObject<VillagerProfession> BOTANIST = VILLAGER_PROFESSIONS.register("botanist",
			() -> new VillagerProfession("botanist", holder -> holder.value().equals(BOTANIST_WORKBENCH_POI.get()), holder -> holder.value().equals(BOTANIST_WORKBENCH_POI.get()), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.CAVE_VINES_PLACE));

	public static void register(IEventBus eventBus) {
		POI_TYPES.register(eventBus);
		VILLAGER_PROFESSIONS.register(eventBus);
	}
}
