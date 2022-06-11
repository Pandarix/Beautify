package com.github.Pandarix.beautify.core.init;

import com.github.Pandarix.beautify.Beautify;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ItemInit {
	private ItemInit() {
	}

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Beautify.MODID);

	// blinds
	public static final RegistryObject<BlockItem> OAK_BLINDS_ITEM = ITEMS.register("oak_blinds",
			() -> new BlockItem(BlockInit.OAK_BLINDS.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> SPRUCE_BLINDS_ITEM = ITEMS.register("spruce_blinds",
			() -> new BlockItem(BlockInit.SPRUCE_BLINDS.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> BIRCH_BLINDS_ITEM = ITEMS.register("birch_blinds",
			() -> new BlockItem(BlockInit.BIRCH_BLINDS.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> JUNGLE_BLINDS_ITEM = ITEMS.register("jungle_blinds",
			() -> new BlockItem(BlockInit.JUNGLE_BLINDS.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});
	
	public static final RegistryObject<BlockItem> ACACIA_BLINDS_ITEM = ITEMS.register("acacia_blinds",
			() -> new BlockItem(BlockInit.ACACIA_BLINDS.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> DARK_OAK_BLINDS_ITEM = ITEMS.register("dark_oak_blinds",
			() -> new BlockItem(BlockInit.DARK_OAK_BLINDS.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> CRIMSON_BLINDS_ITEM = ITEMS.register("crimson_blinds",
			() -> new BlockItem(BlockInit.CRIMSON_BLINDS.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> WARPED_BLINDS_ITEM = ITEMS.register("warped_blinds",
			() -> new BlockItem(BlockInit.WARPED_BLINDS.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> IRON_BLINDS_ITEM = ITEMS.register("iron_blinds",
			() -> new BlockItem(BlockInit.IRON_BLINDS.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));

	// picture frame
	public static final RegistryObject<BlockItem> OAK_PICTURE_FRAME_ITEM = ITEMS.register("oak_picture_frame",
			() -> new BlockItem(BlockInit.OAK_PICTURE_FRAME.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});
	
	public static final RegistryObject<BlockItem> SPRUCE_PICTURE_FRAME_ITEM = ITEMS.register("spruce_picture_frame",
			() -> new BlockItem(BlockInit.SPRUCE_PICTURE_FRAME.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});
	
	public static final RegistryObject<BlockItem> BIRCH_PICTURE_FRAME_ITEM = ITEMS.register("birch_picture_frame",
			() -> new BlockItem(BlockInit.BIRCH_PICTURE_FRAME.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});
	
	public static final RegistryObject<BlockItem> JUNGLE_PICTURE_FRAME_ITEM = ITEMS.register("jungle_picture_frame",
			() -> new BlockItem(BlockInit.JUNGLE_PICTURE_FRAME.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> ACACIA_PICTURE_FRAME_ITEM = ITEMS.register("acacia_picture_frame",
			() -> new BlockItem(BlockInit.ACACIA_PICTURE_FRAME.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> DARK_OAK_PICTURE_FRAME_ITEM = ITEMS.register("dark_oak_picture_frame",
			() -> new BlockItem(BlockInit.DARK_OAK_PICTURE_FRAME.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> CRIMSON_PICTURE_FRAME_ITEM = ITEMS.register("crimson_picture_frame",
			() -> new BlockItem(BlockInit.CRIMSON_PICTURE_FRAME.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> WARPED_PICTURE_FRAME_ITEM = ITEMS.register("warped_picture_frame",
			() -> new BlockItem(BlockInit.WARPED_PICTURE_FRAME.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});
	
	public static final RegistryObject<BlockItem> QUARTZ_PICTURE_FRAME_ITEM = ITEMS.register("quartz_picture_frame",
			() -> new BlockItem(BlockInit.QUARTZ_PICTURE_FRAME.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));

	// BLOCK ITEMS
	public static final RegistryObject<BlockItem> ROPE_ITEM = ITEMS.register("rope",
			() -> new BlockItem(BlockInit.ROPE.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 100;
				}
			});

	public static final RegistryObject<BlockItem> HANGING_POT_ITEM = ITEMS.register("hanging_pot",
			() -> new BlockItem(BlockInit.HANGING_POT.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));

	public static final RegistryObject<BlockItem> BOOKSTACK_ITEM = ITEMS.register("bookstack",
			() -> new BlockItem(BlockInit.BOOKSTACK.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));
}
