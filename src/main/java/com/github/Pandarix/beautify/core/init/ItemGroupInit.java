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

	public static final RegistryObject<CreativeModeTab> BEAUTIFY_TAB = CREATIVE_MODE_TABS.register("beautify",
			() -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemInit.HANGING_POT_ITEM.get()))
					.title(Component.translatable("itemGroup.beautify"))
					.displayItems((pParameters, pOutput) -> {
						//misc
						pOutput.accept(ItemInit.ROPE_ITEM.get());
						pOutput.accept(ItemInit.HANGING_POT_ITEM.get());
						pOutput.accept(ItemInit.BOOKSTACK_ITEM.get());
						pOutput.accept(ItemInit.BOTANIST_WORKBENCH_ITEM.get());
						//blinds
						pOutput.accept(ItemInit.OAK_BLINDS_ITEM.get());
						pOutput.accept(ItemInit.SPRUCE_BLINDS_ITEM.get());
						pOutput.accept(ItemInit.DARK_OAK_BLINDS_ITEM.get());
						pOutput.accept(ItemInit.CRIMSON_BLINDS_ITEM.get());
						pOutput.accept(ItemInit.MANGROVE_BLINDS_ITEM.get());
						pOutput.accept(ItemInit.ACACIA_BLINDS_ITEM.get());
						pOutput.accept(ItemInit.JUNGLE_BLINDS_ITEM.get());
						pOutput.accept(ItemInit.BIRCH_BLINDS_ITEM.get());
						pOutput.accept(ItemInit.WARPED_BLINDS_ITEM.get());
						pOutput.accept(ItemInit.IRON_BLINDS_ITEM.get());
						//picture frame
						pOutput.accept(ItemInit.OAK_PICTURE_FRAME_ITEM.get());
						pOutput.accept(ItemInit.SPRUCE_PICTURE_FRAME_ITEM.get());
						pOutput.accept(ItemInit.DARK_OAK_PICTURE_FRAME_ITEM.get());
						pOutput.accept(ItemInit.CRIMSON_PICTURE_FRAME_ITEM.get());
						pOutput.accept(ItemInit.MANGROVE_PICTURE_FRAME_ITEM.get());
						pOutput.accept(ItemInit.ACACIA_PICTURE_FRAME_ITEM.get());
						pOutput.accept(ItemInit.JUNGLE_PICTURE_FRAME_ITEM.get());
						pOutput.accept(ItemInit.BIRCH_PICTURE_FRAME_ITEM.get());
						pOutput.accept(ItemInit.WARPED_PICTURE_FRAME_ITEM.get());
						pOutput.accept(ItemInit.QUARTZ_PICTURE_FRAME_ITEM.get());
						//picture frame
						pOutput.accept(ItemInit.OAK_TRELLIS_ITEM.get());
						pOutput.accept(ItemInit.SPRUCE_TRELLIS_ITEM.get());
						pOutput.accept(ItemInit.DARK_OAK_TRELLIS_ITEM.get());
						pOutput.accept(ItemInit.CRIMSON_TRELLIS_ITEM.get());
						pOutput.accept(ItemInit.MANGROVE_TRELLIS_ITEM.get());
						pOutput.accept(ItemInit.ACACIA_TRELLIS_ITEM.get());
						pOutput.accept(ItemInit.JUNGLE_TRELLIS_ITEM.get());
						pOutput.accept(ItemInit.BIRCH_TRELLIS_ITEM.get());
						pOutput.accept(ItemInit.WARPED_TRELLIS_ITEM.get());
						//lamps
						pOutput.accept(ItemInit.LAMP_BAMBOO_ITEM.get());
						pOutput.accept(ItemInit.LAMP_JAR_ITEM.get());
						pOutput.accept(ItemInit.LAMP_LIGHT_BULB_ITEM.get());
							//candelabras
						pOutput.accept(ItemInit.LAMP_CANDELABRA_ITEM.get());
						pOutput.accept(ItemInit.LAMP_CANDELABRA_RED_ITEM.get());
						pOutput.accept(ItemInit.LAMP_CANDELABRA_ORANGE_ITEM.get());
						pOutput.accept(ItemInit.LAMP_CANDELABRA_YELLOW_ITEM.get());
						pOutput.accept(ItemInit.LAMP_CANDELABRA_LIME_ITEM.get());
						pOutput.accept(ItemInit.LAMP_CANDELABRA_GREEN_ITEM.get());
						pOutput.accept(ItemInit.LAMP_CANDELABRA_CYAN_ITEM.get());
						pOutput.accept(ItemInit.LAMP_CANDELABRA_LIGHT_BLUE_ITEM.get());
						pOutput.accept(ItemInit.LAMP_CANDELABRA_BLUE_ITEM.get());
						pOutput.accept(ItemInit.LAMP_CANDELABRA_PURPLE_ITEM.get());
						pOutput.accept(ItemInit.LAMP_CANDELABRA_MAGENTA_ITEM.get());
						pOutput.accept(ItemInit.LAMP_CANDELABRA_PINK_ITEM.get());
						pOutput.accept(ItemInit.LAMP_CANDELABRA_BROWN_ITEM.get());
						pOutput.accept(ItemInit.LAMP_CANDELABRA_BLACK_ITEM.get());
						pOutput.accept(ItemInit.LAMP_CANDELABRA_GRAY_ITEM.get());
						pOutput.accept(ItemInit.LAMP_CANDELABRA_LIGHT_GRAY_ITEM.get());
						pOutput.accept(ItemInit.LAMP_CANDELABRA_WHITE_ITEM.get());
					})
					.build());
}
