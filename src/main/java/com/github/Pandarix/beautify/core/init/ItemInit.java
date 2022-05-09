package com.github.Pandarix.beautify.core.init;

import com.github.Pandarix.beautify.Beautify;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ItemInit {
	private ItemInit() {
	}

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Beautify.MODID);

	// BLOCK ITEMS
	public static final RegistryObject<BlockItem> ROPE_ITEM = ITEMS.register("rope",
			() -> new BlockItem(BlockInit.ROPE.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));
	
	public static final RegistryObject<BlockItem> ROSE_POT_ITEM = ITEMS.register("rose_pot",
			() -> new BlockItem(BlockInit.ROSE_POT.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));
	
	public static final RegistryObject<BlockItem> ORCHID_POT_ITEM = ITEMS.register("orchid_pot",
			() -> new BlockItem(BlockInit.ORCHID_POT.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));
	
	public static final RegistryObject<BlockItem> HANGING_POT_ITEM = ITEMS.register("hanging_pot",
			() -> new BlockItem(BlockInit.HANGING_POT.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));
}
