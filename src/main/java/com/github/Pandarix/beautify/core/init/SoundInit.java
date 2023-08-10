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

	//BOOKSTACK
	public static final RegistryObject<SoundEvent> BOOKSTACK_NEXT = registerSoundEvent("block.bookstack_next");
	public static final RegistryObject<SoundEvent> BOOKSTACK_BREAK = registerSoundEvent("block.bookstack_break");
	public static final RegistryObject<SoundEvent> BOOKSTACK_STEP = registerSoundEvent("block.bookstack_step");
	public static final RegistryObject<SoundEvent> BOOKSTACK_PLACE = registerSoundEvent("block.bookstack_place");
	public static final RegistryObject<SoundEvent> BOOKSTACK_HIT = registerSoundEvent("block.bookstack_hit");
	public static final RegistryObject<SoundEvent> BOOKSTACK_FALL = registerSoundEvent("block.bookstack_fall");
	public static final ForgeSoundType BOOKSTACK_SOUNDS = new ForgeSoundType(1f, 1f, SoundInit.BOOKSTACK_BREAK,
			SoundInit.BOOKSTACK_STEP, SoundInit.BOOKSTACK_PLACE, SoundInit.BOOKSTACK_HIT, SoundInit.BOOKSTACK_FALL);

	//BLINDS
	public static final RegistryObject<SoundEvent> BLINDS_OPEN = registerSoundEvent("block.blinds_open");
	public static final RegistryObject<SoundEvent> BLINDS_CLOSE = registerSoundEvent("block.blinds_close");
	
	private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
		ResourceLocation id = new ResourceLocation(Beautify.MODID, name);
		return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
	}
}