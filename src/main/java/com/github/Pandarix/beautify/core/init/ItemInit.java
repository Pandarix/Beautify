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
	
	public static final RegistryObject<BlockItem> BOOKSTACK_ITEM = ITEMS.register("bookstack",
			() -> new BlockItem(BlockInit.BOOKSTACK.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));
	
	public static final RegistryObject<BlockItem> HANGING_POT_ITEM = ITEMS.register("hanging_pot",
			() -> new BlockItem(BlockInit.HANGING_POT.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));
	
		//blinds
	public static final RegistryObject<BlockItem> OAK_BLINDS_ITEM = ITEMS.register("oak_blinds",
			() -> new BlockItem(BlockInit.OAK_BLINDS.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));
	
		//picture frame
	public static final RegistryObject<BlockItem> OAK_PICTURE_FRAME_ITEM = ITEMS.register("oak_picture_frame",
			() -> new BlockItem(BlockInit.OAK_PICTURE_FRAME.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));
	
	public static final RegistryObject<BlockItem> BIRCH_PICTURE_FRAME_ITEM = ITEMS.register("birch_picture_frame",
			() -> new BlockItem(BlockInit.BIRCH_PICTURE_FRAME.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));
	
	public static final RegistryObject<BlockItem> SPRUCE_PICTURE_FRAME_ITEM = ITEMS.register("spruce_picture_frame",
			() -> new BlockItem(BlockInit.SPRUCE_PICTURE_FRAME.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));
	
	public static final RegistryObject<BlockItem> DARK_OAK_PICTURE_FRAME_ITEM = ITEMS.register("dark_oak_picture_frame",
			() -> new BlockItem(BlockInit.DARK_OAK_PICTURE_FRAME.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));
	
	public static final RegistryObject<BlockItem> JUNGLE_PICTURE_FRAME_ITEM = ITEMS.register("jungle_picture_frame",
			() -> new BlockItem(BlockInit.JUNGLE_PICTURE_FRAME.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));
	
	public static final RegistryObject<BlockItem> ACACIA_PICTURE_FRAME_ITEM = ITEMS.register("acacia_picture_frame",
			() -> new BlockItem(BlockInit.ACACIA_PICTURE_FRAME.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));
	
	public static final RegistryObject<BlockItem> WARPED_PICTURE_FRAME_ITEM = ITEMS.register("warped_picture_frame",
			() -> new BlockItem(BlockInit.WARPED_PICTURE_FRAME.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));
	
	public static final RegistryObject<BlockItem> CRIMSON_PICTURE_FRAME_ITEM = ITEMS.register("crimson_picture_frame",
			() -> new BlockItem(BlockInit.CRIMSON_PICTURE_FRAME.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));
}
