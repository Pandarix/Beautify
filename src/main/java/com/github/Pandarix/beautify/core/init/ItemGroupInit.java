package com.github.Pandarix.beautify.core.init;

import com.github.Pandarix.beautify.Beautify;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class ItemGroupInit {
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Beautify.MODID);

	public static final RegistryObject<CreativeModeTab> BEAUTIFY_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
			() -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemInit.HANGING_POT_ITEM.get()))
					.title(Component.translatable("creativetab.tutorial_tab"))
					.displayItems((pParameters, pOutput) -> {
						/*
						TODO: register items to tab like this
						pOutput.accept(ItemInit.SAPPHIRE.get());
						 */
					})
					.build());
}
