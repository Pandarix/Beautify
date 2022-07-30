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

	/*
	 * IN DEV
	 * 
	 * // trellis public static final RegistryObject<BlockItem> OAK_TRELLIS_ITEM =
	 * ITEMS.register("oak_trellis", () -> new
	 * BlockItem(BlockInit.OAK_TRELLIS.get(), new
	 * Item.Properties().tab(Beautify.BEAUTIFY_TAB)) {
	 * 
	 * @Override public int getBurnTime(ItemStack itemStack, RecipeType<?>
	 * recipeType) { return 300; } });
	 */

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

	public static final RegistryObject<BlockItem> MANGROVE_BLINDS_ITEM = ITEMS.register("mangrove_blinds",
			() -> new BlockItem(BlockInit.MANGROVE_BLINDS.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)) {
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

	public static final RegistryObject<BlockItem> MANGROVE_PICTURE_FRAME_ITEM = ITEMS.register("mangrove_picture_frame",
			() -> new BlockItem(BlockInit.MANGROVE_PICTURE_FRAME.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> QUARTZ_PICTURE_FRAME_ITEM = ITEMS.register("quartz_picture_frame",
			() -> new BlockItem(BlockInit.QUARTZ_PICTURE_FRAME.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));

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

	public static final RegistryObject<BlockItem> LAMP_LIGHT_BULB_ITEM = ITEMS.register("lamp_light_bulb",
			() -> new BlockItem(BlockInit.LAMP_LIGHT_BULB.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));

	public static final RegistryObject<BlockItem> LAMP_BAMBOO_ITEM = ITEMS.register("lamp_bamboo",
			() -> new BlockItem(BlockInit.LAMP_BAMBOO.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));

	public static final RegistryObject<BlockItem> LAMP_JAR_ITEM = ITEMS.register("lamp_jar",
			() -> new BlockItem(BlockInit.LAMP_JAR.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));

	// candleabras
	public static final RegistryObject<BlockItem> LAMP_CANDLEABRA_ITEM = ITEMS.register("lamp_candleabra",
			() -> new BlockItem(BlockInit.LAMP_CANDLEABRA.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));

	public static final RegistryObject<BlockItem> LAMP_CANDLEABRA_LIGHT_BLUE_ITEM = ITEMS
			.register("lamp_candleabra_light_blue", () -> new BlockItem(BlockInit.LAMP_CANDLEABRA_LIGHT_BLUE.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));

	public static final RegistryObject<BlockItem> LAMP_CANDLEABRA_LIGHT_GRAY_ITEM = ITEMS
			.register("lamp_candleabra_light_gray", () -> new BlockItem(BlockInit.LAMP_CANDLEABRA_LIGHT_GRAY.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));

	public static final RegistryObject<BlockItem> LAMP_CANDLEABRA_BLACK_ITEM = ITEMS.register("lamp_candleabra_black",
			() -> new BlockItem(BlockInit.LAMP_CANDLEABRA_BLACK.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));

	public static final RegistryObject<BlockItem> LAMP_CANDLEABRA_BLUE_ITEM = ITEMS.register("lamp_candleabra_blue",
			() -> new BlockItem(BlockInit.LAMP_CANDLEABRA_BLUE.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));

	public static final RegistryObject<BlockItem> LAMP_CANDLEABRA_BROWN_ITEM = ITEMS.register("lamp_candleabra_brown",
			() -> new BlockItem(BlockInit.LAMP_CANDLEABRA_BROWN.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));

	public static final RegistryObject<BlockItem> LAMP_CANDLEABRA_CYAN_ITEM = ITEMS.register("lamp_candleabra_cyan",
			() -> new BlockItem(BlockInit.LAMP_CANDLEABRA_CYAN.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));

	public static final RegistryObject<BlockItem> LAMP_CANDLEABRA_GRAY_ITEM = ITEMS.register("lamp_candleabra_gray",
			() -> new BlockItem(BlockInit.LAMP_CANDLEABRA_GRAY.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));

	public static final RegistryObject<BlockItem> LAMP_CANDLEABRA_GREEN_ITEM = ITEMS.register("lamp_candleabra_green",
			() -> new BlockItem(BlockInit.LAMP_CANDLEABRA_GREEN.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));

	public static final RegistryObject<BlockItem> LAMP_CANDLEABRA_LIME_ITEM = ITEMS.register("lamp_candleabra_lime",
			() -> new BlockItem(BlockInit.LAMP_CANDLEABRA_LIME.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));

	public static final RegistryObject<BlockItem> LAMP_CANDLEABRA_MAGENTA_ITEM = ITEMS
			.register("lamp_candleabra_magenta", () -> new BlockItem(BlockInit.LAMP_CANDLEABRA_MAGENTA.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));

	public static final RegistryObject<BlockItem> LAMP_CANDLEABRA_ORANGE_ITEM = ITEMS.register("lamp_candleabra_orange",
			() -> new BlockItem(BlockInit.LAMP_CANDLEABRA_ORANGE.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));

	public static final RegistryObject<BlockItem> LAMP_CANDLEABRA_PINK_ITEM = ITEMS.register("lamp_candleabra_pink",
			() -> new BlockItem(BlockInit.LAMP_CANDLEABRA_PINK.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));

	public static final RegistryObject<BlockItem> LAMP_CANDLEABRA_PURPLE_ITEM = ITEMS.register("lamp_candleabra_purple",
			() -> new BlockItem(BlockInit.LAMP_CANDLEABRA_PURPLE.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));

	public static final RegistryObject<BlockItem> LAMP_CANDLEABRA_RED_ITEM = ITEMS.register("lamp_candleabra_red",
			() -> new BlockItem(BlockInit.LAMP_CANDLEABRA_RED.get(), new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));

	public static final RegistryObject<BlockItem> LAMP_CANDLEABRA_WHITE_ITEM = ITEMS.register("lamp_candleabra_white",
			() -> new BlockItem(BlockInit.LAMP_CANDLEABRA_WHITE.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));

	public static final RegistryObject<BlockItem> LAMP_CANDLEABRA_YELLOW_ITEM = ITEMS.register("lamp_candleabra_yellow",
			() -> new BlockItem(BlockInit.LAMP_CANDLEABRA_YELLOW.get(),
					new Item.Properties().tab(Beautify.BEAUTIFY_TAB)));
}
