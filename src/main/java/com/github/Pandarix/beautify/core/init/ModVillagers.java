package com.github.Pandarix.beautify.core.init;

import java.lang.reflect.InvocationTargetException;

import com.github.Pandarix.beautify.Beautify;
import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
	public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES,
			Beautify.MODID);

	public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister
			.create(ForgeRegistries.VILLAGER_PROFESSIONS, Beautify.MODID);

	public static final RegistryObject<PoiType> BOTANIST_WORKBENCH_POI = POI_TYPES.register("botanist_workbench_poi",
			() -> new PoiType(
					ImmutableSet.copyOf(BlockInit.BOTANIST_WORKBENCH.get().getStateDefinition().getPossibleStates()), 1,
					1));

	public static final RegistryObject<VillagerProfession> BOTANIST = VILLAGER_PROFESSIONS.register("botanist",
			() -> new VillagerProfession("botanist", x -> x.get() == BOTANIST_WORKBENCH_POI.get(),
					x -> x.get() == BOTANIST_WORKBENCH_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
					SoundEvents.CAVE_VINES_PLACE));

	public static void registerPOIs() {
		try {
			ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null,
					BOTANIST_WORKBENCH_POI.get());
		} catch (InvocationTargetException | IllegalAccessException exception) {
			exception.printStackTrace();
		}
	}

	public static void register(IEventBus eventBus) {
		POI_TYPES.register(eventBus);
		VILLAGER_PROFESSIONS.register(eventBus);
	}
}
