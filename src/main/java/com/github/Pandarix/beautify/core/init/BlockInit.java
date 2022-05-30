package com.github.Pandarix.beautify.core.init;

import com.github.Pandarix.beautify.Beautify;
import com.github.Pandarix.beautify.common.block.BookStack;
import com.github.Pandarix.beautify.common.block.HangingPot;
import com.github.Pandarix.beautify.common.block.Rope;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class BlockInit {

	private BlockInit() {
	}

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Beautify.MODID);

	// BLOCKS
	public static final RegistryObject<BookStack> BOOKSTACK = BLOCKS.register("bookstack",
			() -> new BookStack(BlockBehaviour.Properties.of(Material.CLOTH_DECORATION, MaterialColor.NONE)
					.strength(0.2F, 0.2F).sound(SoundInit.BOOKSTACK_SOUNDS).noOcclusion()));

	public static final RegistryObject<Rope> ROPE = BLOCKS.register("rope",
			() -> new Rope(BlockBehaviour.Properties.of(Material.CLOTH_DECORATION, MaterialColor.NONE)
					.strength(0.2F, 0.2F).sound(SoundType.WOOL).noOcclusion()));

	public static final RegistryObject<HangingPot> HANGING_POT = BLOCKS.register("hanging_pot",
			() -> new HangingPot(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.TERRACOTTA_BROWN)
					.noOcclusion().strength(0.1f, 0.1f).sound(SoundType.STONE)));
}
