package com.github.Pandarix.beautify.core.init;

import com.github.Pandarix.beautify.Beautify;
import com.github.Pandarix.beautify.common.block.AcaciaBlinds;
import com.github.Pandarix.beautify.common.block.AcaciaPictureFrame;
import com.github.Pandarix.beautify.common.block.BirchBlinds;
import com.github.Pandarix.beautify.common.block.BirchPictureFrame;
import com.github.Pandarix.beautify.common.block.BookStack;
import com.github.Pandarix.beautify.common.block.CrimsonBlinds;
import com.github.Pandarix.beautify.common.block.CrimsonPictureFrame;
import com.github.Pandarix.beautify.common.block.DarkOakBlinds;
import com.github.Pandarix.beautify.common.block.DarkOakPictureFrame;
import com.github.Pandarix.beautify.common.block.HangingPot;
import com.github.Pandarix.beautify.common.block.IronBlinds;
import com.github.Pandarix.beautify.common.block.JungleBlinds;
import com.github.Pandarix.beautify.common.block.JunglePictureFrame;
import com.github.Pandarix.beautify.common.block.OakBlinds;
import com.github.Pandarix.beautify.common.block.OakPictureFrame;
import com.github.Pandarix.beautify.common.block.Rope;
import com.github.Pandarix.beautify.common.block.SpruceBlinds;
import com.github.Pandarix.beautify.common.block.SprucePictureFrame;
import com.github.Pandarix.beautify.common.block.WarpedBlinds;
import com.github.Pandarix.beautify.common.block.WarpedPictureFrame;

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

	// blinds
	public static final RegistryObject<OakBlinds> SPRUCE_BLINDS = BLOCKS.register("spruce_blinds",
			() -> new SpruceBlinds(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).noOcclusion()
					.strength(0.4f, 0.4f).sound(SoundType.WOOD)));

	public static final RegistryObject<DarkOakBlinds> DARK_OAK_BLINDS = BLOCKS.register("dark_oak_blinds",
			() -> new DarkOakBlinds(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).noOcclusion()
					.strength(0.4f, 0.4f).sound(SoundType.WOOD)));

	public static final RegistryObject<CrimsonBlinds> CRIMSON_BLINDS = BLOCKS.register("crimson_blinds",
			() -> new CrimsonBlinds(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).noOcclusion()
					.strength(0.4f, 0.4f).sound(SoundType.WOOD)));

	public static final RegistryObject<AcaciaBlinds> ACACIA_BLINDS = BLOCKS.register("acacia_blinds",
			() -> new AcaciaBlinds(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).noOcclusion()
					.strength(0.4f, 0.4f).sound(SoundType.WOOD)));

	public static final RegistryObject<JungleBlinds> JUNGLE_BLINDS = BLOCKS.register("jungle_blinds",
			() -> new JungleBlinds(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).noOcclusion()
					.strength(0.4f, 0.4f).sound(SoundType.WOOD)));

	public static final RegistryObject<OakBlinds> OAK_BLINDS = BLOCKS.register("oak_blinds",
			() -> new OakBlinds(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).noOcclusion()
					.strength(0.4f, 0.4f).sound(SoundType.WOOD)));

	public static final RegistryObject<BirchBlinds> BIRCH_BLINDS = BLOCKS.register("birch_blinds",
			() -> new BirchBlinds(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).noOcclusion()
					.strength(0.4f, 0.4f).sound(SoundType.WOOD)));

	public static final RegistryObject<WarpedBlinds> WARPED_BLINDS = BLOCKS.register("warped_blinds",
			() -> new WarpedBlinds(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).noOcclusion()
					.strength(0.4f, 0.4f).sound(SoundType.WOOD)));

	public static final RegistryObject<IronBlinds> IRON_BLINDS = BLOCKS.register("iron_blinds",
			() -> new IronBlinds(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
					.noOcclusion().strength(0.4f, 0.4f).sound(SoundType.CHAIN).requiresCorrectToolForDrops()));

	// picture frames
	public static final RegistryObject<SprucePictureFrame> SPRUCE_PICTURE_FRAME = BLOCKS.register(
			"spruce_picture_frame",
			() -> new SprucePictureFrame(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).noOcclusion()
					.strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

	public static final RegistryObject<DarkOakPictureFrame> DARK_OAK_PICTURE_FRAME = BLOCKS.register(
			"dark_oak_picture_frame",
			() -> new DarkOakPictureFrame(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).noOcclusion()
					.strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

	public static final RegistryObject<CrimsonPictureFrame> CRIMSON_PICTURE_FRAME = BLOCKS.register(
			"crimson_picture_frame",
			() -> new CrimsonPictureFrame(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).noOcclusion()
					.strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

	public static final RegistryObject<AcaciaPictureFrame> ACACIA_PICTURE_FRAME = BLOCKS.register(
			"acacia_picture_frame",
			() -> new AcaciaPictureFrame(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).noOcclusion()
					.strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

	public static final RegistryObject<JunglePictureFrame> JUNGLE_PICTURE_FRAME = BLOCKS.register(
			"jungle_picture_frame",
			() -> new JunglePictureFrame(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).noOcclusion()
					.strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

	public static final RegistryObject<OakPictureFrame> OAK_PICTURE_FRAME = BLOCKS.register("oak_picture_frame",
			() -> new OakPictureFrame(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).noOcclusion()
					.strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

	public static final RegistryObject<BirchPictureFrame> BIRCH_PICTURE_FRAME = BLOCKS.register("birch_picture_frame",
			() -> new BirchPictureFrame(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).noOcclusion()
					.strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

	public static final RegistryObject<WarpedPictureFrame> WARPED_PICTURE_FRAME = BLOCKS.register(
			"warped_picture_frame",
			() -> new WarpedPictureFrame(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).noOcclusion()
					.strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));
}
