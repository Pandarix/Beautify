package com.github.Pandarix.beautify.core.init;

import com.github.Pandarix.beautify.Beautify;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
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

	// trellis
	public static final RegistryObject<BlockItem> OAK_TRELLIS_ITEM = ITEMS.register("oak_trellis",
			() -> new BlockItem(BlockInit.OAK_TRELLIS.get(), new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> SPRUCE_TRELLIS_ITEM = ITEMS.register("spruce_trellis",
			() -> new BlockItem(BlockInit.SPRUCE_TRELLIS.get(), new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> BIRCH_TRELLIS_ITEM = ITEMS.register("birch_trellis",
			() -> new BlockItem(BlockInit.BIRCH_TRELLIS.get(), new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> JUNGLE_TRELLIS_ITEM = ITEMS.register("jungle_trellis",
			() -> new BlockItem(BlockInit.JUNGLE_TRELLIS.get(), new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> ACACIA_TRELLIS_ITEM = ITEMS.register("acacia_trellis",
			() -> new BlockItem(BlockInit.ACACIA_TRELLIS.get(), new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> DARK_OAK_TRELLIS_ITEM = ITEMS.register("dark_oak_trellis",
			() -> new BlockItem(BlockInit.DARK_OAK_TRELLIS.get(), new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> MANGROVE_TRELLIS_ITEM = ITEMS.register("mangrove_trellis",
			() -> new BlockItem(BlockInit.MANGROVE_TRELLIS.get(), new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> CRIMSON_TRELLIS_ITEM = ITEMS.register("crimson_trellis",
			() -> new BlockItem(BlockInit.CRIMSON_TRELLIS.get(), new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> WARPED_TRELLIS_ITEM = ITEMS.register("warped_trellis",
			() -> new BlockItem(BlockInit.WARPED_TRELLIS.get(), new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	// blinds
	public static final RegistryObject<BlockItem> OAK_BLINDS_ITEM = ITEMS.register("oak_blinds",
			() -> new BlockItem(BlockInit.OAK_BLINDS.get(), new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> SPRUCE_BLINDS_ITEM = ITEMS.register("spruce_blinds",
			() -> new BlockItem(BlockInit.SPRUCE_BLINDS.get(), new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> BIRCH_BLINDS_ITEM = ITEMS.register("birch_blinds",
			() -> new BlockItem(BlockInit.BIRCH_BLINDS.get(), new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> JUNGLE_BLINDS_ITEM = ITEMS.register("jungle_blinds",
			() -> new BlockItem(BlockInit.JUNGLE_BLINDS.get(), new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> ACACIA_BLINDS_ITEM = ITEMS.register("acacia_blinds",
			() -> new BlockItem(BlockInit.ACACIA_BLINDS.get(), new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> DARK_OAK_BLINDS_ITEM = ITEMS.register("dark_oak_blinds",
			() -> new BlockItem(BlockInit.DARK_OAK_BLINDS.get(), new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> CRIMSON_BLINDS_ITEM = ITEMS.register("crimson_blinds",
			() -> new BlockItem(BlockInit.CRIMSON_BLINDS.get(), new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> WARPED_BLINDS_ITEM = ITEMS.register("warped_blinds",
			() -> new BlockItem(BlockInit.WARPED_BLINDS.get(), new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> MANGROVE_BLINDS_ITEM = ITEMS.register("mangrove_blinds",
			() -> new BlockItem(BlockInit.MANGROVE_BLINDS.get(), new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> IRON_BLINDS_ITEM = ITEMS.register("iron_blinds",
			() -> new BlockItem(BlockInit.IRON_BLINDS.get(), new Item.Properties()));

	// picture frame
	public static final RegistryObject<BlockItem> OAK_PICTURE_FRAME_ITEM = ITEMS.register("oak_picture_frame",
			() -> new BlockItem(BlockInit.OAK_PICTURE_FRAME.get(), new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> SPRUCE_PICTURE_FRAME_ITEM = ITEMS.register("spruce_picture_frame",
			() -> new BlockItem(BlockInit.SPRUCE_PICTURE_FRAME.get(),
					new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> BIRCH_PICTURE_FRAME_ITEM = ITEMS.register("birch_picture_frame",
			() -> new BlockItem(BlockInit.BIRCH_PICTURE_FRAME.get(), new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> JUNGLE_PICTURE_FRAME_ITEM = ITEMS.register("jungle_picture_frame",
			() -> new BlockItem(BlockInit.JUNGLE_PICTURE_FRAME.get(),
					new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> ACACIA_PICTURE_FRAME_ITEM = ITEMS.register("acacia_picture_frame",
			() -> new BlockItem(BlockInit.ACACIA_PICTURE_FRAME.get(),
					new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> DARK_OAK_PICTURE_FRAME_ITEM = ITEMS.register("dark_oak_picture_frame",
			() -> new BlockItem(BlockInit.DARK_OAK_PICTURE_FRAME.get(),
					new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> CRIMSON_PICTURE_FRAME_ITEM = ITEMS.register("crimson_picture_frame",
			() -> new BlockItem(BlockInit.CRIMSON_PICTURE_FRAME.get(),
					new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> WARPED_PICTURE_FRAME_ITEM = ITEMS.register("warped_picture_frame",
			() -> new BlockItem(BlockInit.WARPED_PICTURE_FRAME.get(),
					new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> MANGROVE_PICTURE_FRAME_ITEM = ITEMS.register("mangrove_picture_frame",
			() -> new BlockItem(BlockInit.MANGROVE_PICTURE_FRAME.get(),
					new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 300;
				}
			});

	public static final RegistryObject<BlockItem> QUARTZ_PICTURE_FRAME_ITEM = ITEMS.register("quartz_picture_frame",
			() -> new BlockItem(BlockInit.QUARTZ_PICTURE_FRAME.get(),
					new Item.Properties()));

	public static final RegistryObject<BlockItem> ROPE_ITEM = ITEMS.register("rope",
			() -> new BlockItem(BlockInit.ROPE.get(), new Item.Properties()) {
				@Override
				public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
					return 100;
				}
			});

	public static final RegistryObject<BlockItem> HANGING_POT_ITEM = ITEMS.register("hanging_pot",
			() -> new BlockItem(BlockInit.HANGING_POT.get(), new Item.Properties()));

	public static final RegistryObject<BlockItem> BOOKSTACK_ITEM = ITEMS.register("bookstack",
			() -> new BlockItem(BlockInit.BOOKSTACK.get(), new Item.Properties()));

	public static final RegistryObject<BlockItem> LAMP_LIGHT_BULB_ITEM = ITEMS.register("lamp_light_bulb",
			() -> new BlockItem(BlockInit.LAMP_LIGHT_BULB.get(), new Item.Properties()));

	public static final RegistryObject<BlockItem> LAMP_BAMBOO_ITEM = ITEMS.register("lamp_bamboo",
			() -> new BlockItem(BlockInit.LAMP_BAMBOO.get(), new Item.Properties()));

	public static final RegistryObject<BlockItem> LAMP_JAR_ITEM = ITEMS.register("lamp_jar",
			() -> new BlockItem(BlockInit.LAMP_JAR.get(), new Item.Properties()));

	// candleabras
	public static final RegistryObject<BlockItem> LAMP_CANDELABRA_ITEM = ITEMS.register("lamp_candelabra",
			() -> new BlockItem(BlockInit.LAMP_CANDELABRA.get(), new Item.Properties()));

	public static final RegistryObject<BlockItem> LAMP_CANDELABRA_LIGHT_BLUE_ITEM = ITEMS
			.register("lamp_candelabra_light_blue", () -> new BlockItem(BlockInit.LAMP_CANDELABRA_LIGHT_BLUE.get(),
					new Item.Properties()));

	public static final RegistryObject<BlockItem> LAMP_CANDELABRA_LIGHT_GRAY_ITEM = ITEMS
			.register("lamp_candelabra_light_gray", () -> new BlockItem(BlockInit.LAMP_CANDELABRA_LIGHT_GRAY.get(),
					new Item.Properties()));

	public static final RegistryObject<BlockItem> LAMP_CANDELABRA_BLACK_ITEM = ITEMS.register("lamp_candelabra_black",
			() -> new BlockItem(BlockInit.LAMP_CANDELABRA_BLACK.get(),
					new Item.Properties()));

	public static final RegistryObject<BlockItem> LAMP_CANDELABRA_BLUE_ITEM = ITEMS.register("lamp_candelabra_blue",
			() -> new BlockItem(BlockInit.LAMP_CANDELABRA_BLUE.get(),
					new Item.Properties()));

	public static final RegistryObject<BlockItem> LAMP_CANDELABRA_BROWN_ITEM = ITEMS.register("lamp_candelabra_brown",
			() -> new BlockItem(BlockInit.LAMP_CANDELABRA_BROWN.get(),
					new Item.Properties()));

	public static final RegistryObject<BlockItem> LAMP_CANDELABRA_CYAN_ITEM = ITEMS.register("lamp_candelabra_cyan",
			() -> new BlockItem(BlockInit.LAMP_CANDELABRA_CYAN.get(),
					new Item.Properties()));

	public static final RegistryObject<BlockItem> LAMP_CANDELABRA_GRAY_ITEM = ITEMS.register("lamp_candelabra_gray",
			() -> new BlockItem(BlockInit.LAMP_CANDELABRA_GRAY.get(),
					new Item.Properties()));

	public static final RegistryObject<BlockItem> LAMP_CANDELABRA_GREEN_ITEM = ITEMS.register("lamp_candelabra_green",
			() -> new BlockItem(BlockInit.LAMP_CANDELABRA_GREEN.get(),
					new Item.Properties()));

	public static final RegistryObject<BlockItem> LAMP_CANDELABRA_LIME_ITEM = ITEMS.register("lamp_candelabra_lime",
			() -> new BlockItem(BlockInit.LAMP_CANDELABRA_LIME.get(),
					new Item.Properties()));

	public static final RegistryObject<BlockItem> LAMP_CANDELABRA_MAGENTA_ITEM = ITEMS
			.register("lamp_candelabra_magenta", () -> new BlockItem(BlockInit.LAMP_CANDELABRA_MAGENTA.get(),
					new Item.Properties()));

	public static final RegistryObject<BlockItem> LAMP_CANDELABRA_ORANGE_ITEM = ITEMS.register("lamp_candelabra_orange",
			() -> new BlockItem(BlockInit.LAMP_CANDELABRA_ORANGE.get(),
					new Item.Properties()));

	public static final RegistryObject<BlockItem> LAMP_CANDELABRA_PINK_ITEM = ITEMS.register("lamp_candelabra_pink",
			() -> new BlockItem(BlockInit.LAMP_CANDELABRA_PINK.get(),
					new Item.Properties()));

	public static final RegistryObject<BlockItem> LAMP_CANDELABRA_PURPLE_ITEM = ITEMS.register("lamp_candelabra_purple",
			() -> new BlockItem(BlockInit.LAMP_CANDELABRA_PURPLE.get(),
					new Item.Properties()));

	public static final RegistryObject<BlockItem> LAMP_CANDELABRA_RED_ITEM = ITEMS.register("lamp_candelabra_red",
			() -> new BlockItem(BlockInit.LAMP_CANDELABRA_RED.get(), new Item.Properties()));

	public static final RegistryObject<BlockItem> LAMP_CANDELABRA_WHITE_ITEM = ITEMS.register("lamp_candelabra_white",
			() -> new BlockItem(BlockInit.LAMP_CANDELABRA_WHITE.get(),
					new Item.Properties()));

	public static final RegistryObject<BlockItem> LAMP_CANDELABRA_YELLOW_ITEM = ITEMS.register("lamp_candelabra_yellow",
			() -> new BlockItem(BlockInit.LAMP_CANDELABRA_YELLOW.get(),
					new Item.Properties()));

	// workbench
	public static final RegistryObject<BlockItem> BOTANIST_WORKBENCH_ITEM = ITEMS.register("botanist_workbench",
			() -> new BlockItem(BlockInit.BOTANIST_WORKBENCH.get(), new Item.Properties()));
}
