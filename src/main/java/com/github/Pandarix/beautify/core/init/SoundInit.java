package com.github.Pandarix.beautify.core.init;

import com.github.Pandarix.beautify.Beautify;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundInit {
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister
			.create(ForgeRegistries.SOUND_EVENTS, Beautify.MODID);

	public static final RegistryObject<SoundEvent> BOOKSTACK_NEXT = registerSoundEvent("bookstack_next");

	public static RegistryObject<SoundEvent> BOOKSTACK_BREAK = registerSoundEvent("bookstack_break");
	public static RegistryObject<SoundEvent> BOOKSTACK_STEP = registerSoundEvent("bookstack_step");
	public static RegistryObject<SoundEvent> BOOKSTACK_PLACE = registerSoundEvent("bookstack_place");
	public static RegistryObject<SoundEvent> BOOKSTACK_HIT = registerSoundEvent("bookstack_hit");
	public static RegistryObject<SoundEvent> BOOKSTACK_FALL = registerSoundEvent("bookstack_fall");

	public static final ForgeSoundType BOOKSTACK_SOUNDS = new ForgeSoundType(1f, 1f, SoundInit.BOOKSTACK_BREAK,
			SoundInit.BOOKSTACK_STEP, SoundInit.BOOKSTACK_PLACE, SoundInit.BOOKSTACK_HIT, SoundInit.BOOKSTACK_FALL);

	private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
		return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(Beautify.MODID, name)));
	}

	public static void register(IEventBus eventBus) {
		SOUND_EVENTS.register(eventBus);
	}
}