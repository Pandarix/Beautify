package com.github.Pandarix.beautify.core.init;

import com.github.Pandarix.beautify.Beautify;
import com.github.Pandarix.beautify.common.block.AcaciaBlinds;
import com.github.Pandarix.beautify.common.block.AcaciaPictureFrame;
import com.github.Pandarix.beautify.common.block.AcaciaTrellis;
import com.github.Pandarix.beautify.common.block.BirchBlinds;
import com.github.Pandarix.beautify.common.block.BirchPictureFrame;
import com.github.Pandarix.beautify.common.block.BirchTrellis;
import com.github.Pandarix.beautify.common.block.BookStack;
import com.github.Pandarix.beautify.common.block.BotanistWorkbench;
import com.github.Pandarix.beautify.common.block.CrimsonBlinds;
import com.github.Pandarix.beautify.common.block.CrimsonPictureFrame;
import com.github.Pandarix.beautify.common.block.CrimsonTrellis;
import com.github.Pandarix.beautify.common.block.DarkOakBlinds;
import com.github.Pandarix.beautify.common.block.DarkOakPictureFrame;
import com.github.Pandarix.beautify.common.block.DarkOakTrellis;
import com.github.Pandarix.beautify.common.block.HangingPot;
import com.github.Pandarix.beautify.common.block.IronBlinds;
import com.github.Pandarix.beautify.common.block.JungleBlinds;
import com.github.Pandarix.beautify.common.block.JunglePictureFrame;
import com.github.Pandarix.beautify.common.block.JungleTrellis;
import com.github.Pandarix.beautify.common.block.LampBamboo;
import com.github.Pandarix.beautify.common.block.LampCandleabra;
import com.github.Pandarix.beautify.common.block.LampCandleabraBlack;
import com.github.Pandarix.beautify.common.block.LampCandleabraBlue;
import com.github.Pandarix.beautify.common.block.LampCandleabraBrown;
import com.github.Pandarix.beautify.common.block.LampCandleabraCyan;
import com.github.Pandarix.beautify.common.block.LampCandleabraGray;
import com.github.Pandarix.beautify.common.block.LampCandleabraGreen;
import com.github.Pandarix.beautify.common.block.LampCandleabraLightBlue;
import com.github.Pandarix.beautify.common.block.LampCandleabraLightGray;
import com.github.Pandarix.beautify.common.block.LampCandleabraLime;
import com.github.Pandarix.beautify.common.block.LampCandleabraMagenta;
import com.github.Pandarix.beautify.common.block.LampCandleabraOrange;
import com.github.Pandarix.beautify.common.block.LampCandleabraPink;
import com.github.Pandarix.beautify.common.block.LampCandleabraPurple;
import com.github.Pandarix.beautify.common.block.LampCandleabraRed;
import com.github.Pandarix.beautify.common.block.LampCandleabraWhite;
import com.github.Pandarix.beautify.common.block.LampCandleabraYellow;
import com.github.Pandarix.beautify.common.block.LampJar;
import com.github.Pandarix.beautify.common.block.LampLightBulb;
import com.github.Pandarix.beautify.common.block.MangroveBlinds;
import com.github.Pandarix.beautify.common.block.MangrovePictureFrame;
import com.github.Pandarix.beautify.common.block.MangroveTrellis;
import com.github.Pandarix.beautify.common.block.OakBlinds;
import com.github.Pandarix.beautify.common.block.OakPictureFrame;
import com.github.Pandarix.beautify.common.block.OakTrellis;
import com.github.Pandarix.beautify.common.block.Rope;
import com.github.Pandarix.beautify.common.block.SpruceBlinds;
import com.github.Pandarix.beautify.common.block.SprucePictureFrame;
import com.github.Pandarix.beautify.common.block.SpruceTrellis;
import com.github.Pandarix.beautify.common.block.WarpedBlinds;
import com.github.Pandarix.beautify.common.block.WarpedPictureFrame;
import com.github.Pandarix.beautify.common.block.WarpedTrellis;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
					.noOcclusion().strength(0.1f, 0.1f).sound(SoundType.STONE).lightLevel((state) -> {
						if (state.getValue(HangingPot.POTFLOWER) == 15) {
							return 7;
						} else if (state.getValue(HangingPot.POTFLOWER) == 22) {
							return 14;
						} else {
							return 0;
						}
					})));

	// trellis
	public static final RegistryObject<OakTrellis> OAK_TRELLIS = BLOCKS.register("oak_trellis",
			() -> new OakTrellis(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.3F, 0.3F)
					.sound(SoundType.BAMBOO).noOcclusion()));

	public static final RegistryObject<SpruceTrellis> SPRUCE_TRELLIS = BLOCKS.register("spruce_trellis",
			() -> new SpruceTrellis(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.3F, 0.3F)
					.sound(SoundType.BAMBOO).noOcclusion()));

	public static final RegistryObject<BirchTrellis> BIRCH_TRELLIS = BLOCKS.register("birch_trellis",
			() -> new BirchTrellis(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.3F, 0.3F)
					.sound(SoundType.BAMBOO).noOcclusion()));

	public static final RegistryObject<JungleTrellis> JUNGLE_TRELLIS = BLOCKS.register("jungle_trellis",
			() -> new JungleTrellis(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.3F, 0.3F)
					.sound(SoundType.BAMBOO).noOcclusion()));

	public static final RegistryObject<AcaciaTrellis> ACACIA_TRELLIS = BLOCKS.register("acacia_trellis",
			() -> new AcaciaTrellis(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.3F, 0.3F)
					.sound(SoundType.BAMBOO).noOcclusion()));

	public static final RegistryObject<DarkOakTrellis> DARK_OAK_TRELLIS = BLOCKS.register("dark_oak_trellis",
			() -> new DarkOakTrellis(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD)
					.strength(0.3F, 0.3F).sound(SoundType.BAMBOO).noOcclusion()));

	public static final RegistryObject<MangroveTrellis> MANGROVE_TRELLIS = BLOCKS.register("mangrove_trellis",
			() -> new MangroveTrellis(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD)
					.strength(0.3F, 0.3F).sound(SoundType.BAMBOO).noOcclusion()));

	public static final RegistryObject<CrimsonTrellis> CRIMSON_TRELLIS = BLOCKS.register("crimson_trellis",
			() -> new CrimsonTrellis(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD)
					.strength(0.3F, 0.3F).sound(SoundType.BAMBOO).noOcclusion()));

	public static final RegistryObject<WarpedTrellis> WARPED_TRELLIS = BLOCKS.register("warped_trellis",
			() -> new WarpedTrellis(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.3F, 0.3F)
					.sound(SoundType.BAMBOO).noOcclusion()));

	// lamps
	public static final RegistryObject<LampLightBulb> LAMP_LIGHT_BULB = BLOCKS.register("lamp_light_bulb",
			() -> new LampLightBulb(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).noOcclusion()
					.strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
						if (state.getValue(LampLightBulb.ON)) {
							return 14;
						} else {
							return 0;
						}
					})));

	public static final RegistryObject<LampBamboo> LAMP_BAMBOO = BLOCKS.register("lamp_bamboo",
			() -> new LampBamboo(BlockBehaviour.Properties.of(Material.BAMBOO, MaterialColor.WOOD).noOcclusion()
					.strength(0.1f, 0.1f).sound(SoundType.SCAFFOLDING).lightLevel((state) -> {
						if (state.getValue(LampBamboo.ON)) {
							return 14;
						} else {
							return 0;
						}
					})));

	public static final RegistryObject<LampJar> LAMP_JAR = BLOCKS.register("lamp_jar",
			() -> new LampJar(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.NONE).noOcclusion()
					.strength(0.05f, 0.05f).sound(SoundType.GLASS).lightLevel((state) -> {
						final int fill = state.getValue(LampJar.FILL_LEVEL);
						switch (fill) {
						case 0:
							return 0;
						case 5:
							return 8;
						case 10:
							return 11;
						case 15:
							return 14;
						default:
							return 0;
						}
					})));

	// candleabras
	public static final RegistryObject<LampCandleabra> LAMP_CANDLEABRA = BLOCKS.register("lamp_candleabra",
			() -> new LampCandleabra(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).noOcclusion()
					.strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
						if (state.getValue(LampCandleabra.ON)) {
							return 14;
						} else {
							return 0;
						}
					})));

	public static final RegistryObject<LampCandleabraLightBlue> LAMP_CANDLEABRA_LIGHT_BLUE = BLOCKS.register(
			"lamp_candleabra_light_blue",
			() -> new LampCandleabraLightBlue(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
					.noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
						if (state.getValue(LampCandleabraLightBlue.ON)) {
							return 14;
						} else {
							return 0;
						}
					})));

	public static final RegistryObject<LampCandleabraLightGray> LAMP_CANDLEABRA_LIGHT_GRAY = BLOCKS.register(
			"lamp_candleabra_light_gray",
			() -> new LampCandleabraLightGray(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
					.noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
						if (state.getValue(LampCandleabraLightGray.ON)) {
							return 14;
						} else {
							return 0;
						}
					})));

	public static final RegistryObject<LampCandleabraBlack> LAMP_CANDLEABRA_BLACK = BLOCKS.register(
			"lamp_candleabra_black",
			() -> new LampCandleabraBlack(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
					.noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
						if (state.getValue(LampCandleabraBlack.ON)) {
							return 14;
						} else {
							return 0;
						}
					})));

	public static final RegistryObject<LampCandleabraBlue> LAMP_CANDLEABRA_BLUE = BLOCKS.register(
			"lamp_candleabra_blue",
			() -> new LampCandleabraBlue(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).noOcclusion()
					.strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
						if (state.getValue(LampCandleabraBlue.ON)) {
							return 14;
						} else {
							return 0;
						}
					})));

	public static final RegistryObject<LampCandleabraBrown> LAMP_CANDLEABRA_BROWN = BLOCKS.register(
			"lamp_candleabra_brown",
			() -> new LampCandleabraBrown(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
					.noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
						if (state.getValue(LampCandleabraBrown.ON)) {
							return 14;
						} else {
							return 0;
						}
					})));

	public static final RegistryObject<LampCandleabraCyan> LAMP_CANDLEABRA_CYAN = BLOCKS.register(
			"lamp_candleabra_cyan",
			() -> new LampCandleabraCyan(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).noOcclusion()
					.strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
						if (state.getValue(LampCandleabraCyan.ON)) {
							return 14;
						} else {
							return 0;
						}
					})));

	public static final RegistryObject<LampCandleabraGray> LAMP_CANDLEABRA_GRAY = BLOCKS.register(
			"lamp_candleabra_gray",
			() -> new LampCandleabraGray(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).noOcclusion()
					.strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
						if (state.getValue(LampCandleabraGray.ON)) {
							return 14;
						} else {
							return 0;
						}
					})));

	public static final RegistryObject<LampCandleabraGreen> LAMP_CANDLEABRA_GREEN = BLOCKS.register(
			"lamp_candleabra_green",
			() -> new LampCandleabraGreen(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
					.noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
						if (state.getValue(LampCandleabraGreen.ON)) {
							return 14;
						} else {
							return 0;
						}
					})));

	public static final RegistryObject<LampCandleabraLime> LAMP_CANDLEABRA_LIME = BLOCKS.register(
			"lamp_candleabra_lime",
			() -> new LampCandleabraLime(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).noOcclusion()
					.strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
						if (state.getValue(LampCandleabraLime.ON)) {
							return 14;
						} else {
							return 0;
						}
					})));

	public static final RegistryObject<LampCandleabraMagenta> LAMP_CANDLEABRA_MAGENTA = BLOCKS.register(
			"lamp_candleabra_magenta",
			() -> new LampCandleabraMagenta(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
					.noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
						if (state.getValue(LampCandleabraMagenta.ON)) {
							return 14;
						} else {
							return 0;
						}
					})));

	public static final RegistryObject<LampCandleabraOrange> LAMP_CANDLEABRA_ORANGE = BLOCKS.register(
			"lamp_candleabra_orange",
			() -> new LampCandleabraOrange(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
					.noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
						if (state.getValue(LampCandleabraOrange.ON)) {
							return 14;
						} else {
							return 0;
						}
					})));

	public static final RegistryObject<LampCandleabraPink> LAMP_CANDLEABRA_PINK = BLOCKS.register(
			"lamp_candleabra_pink",
			() -> new LampCandleabraPink(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).noOcclusion()
					.strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
						if (state.getValue(LampCandleabraPink.ON)) {
							return 14;
						} else {
							return 0;
						}
					})));

	public static final RegistryObject<LampCandleabraPurple> LAMP_CANDLEABRA_PURPLE = BLOCKS.register(
			"lamp_candleabra_purple",
			() -> new LampCandleabraPurple(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
					.noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
						if (state.getValue(LampCandleabraPurple.ON)) {
							return 14;
						} else {
							return 0;
						}
					})));

	public static final RegistryObject<LampCandleabraRed> LAMP_CANDLEABRA_RED = BLOCKS.register("lamp_candleabra_red",
			() -> new LampCandleabraRed(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).noOcclusion()
					.strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
						if (state.getValue(LampCandleabraRed.ON)) {
							return 14;
						} else {
							return 0;
						}
					})));

	public static final RegistryObject<LampCandleabraWhite> LAMP_CANDLEABRA_WHITE = BLOCKS.register(
			"lamp_candleabra_white",
			() -> new LampCandleabraWhite(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
					.noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
						if (state.getValue(LampCandleabraWhite.ON)) {
							return 14;
						} else {
							return 0;
						}
					})));

	public static final RegistryObject<LampCandleabraYellow> LAMP_CANDLEABRA_YELLOW = BLOCKS.register(
			"lamp_candleabra_yellow",
			() -> new LampCandleabraYellow(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
					.noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
						if (state.getValue(LampCandleabraYellow.ON)) {
							return 14;
						} else {
							return 0;
						}
					})));

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

	public static final RegistryObject<MangroveBlinds> MANGROVE_BLINDS = BLOCKS.register("mangrove_blinds",
			() -> new MangroveBlinds(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).noOcclusion()
					.strength(0.4f, 0.4f).sound(SoundType.WOOD)));

	public static final RegistryObject<IronBlinds> IRON_BLINDS = BLOCKS.register("iron_blinds",
			() -> new IronBlinds(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).noOcclusion()
					.strength(0.4f, 0.4f).sound(SoundType.CHAIN).requiresCorrectToolForDrops()));

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

	public static final RegistryObject<MangrovePictureFrame> MANGROVE_PICTURE_FRAME = BLOCKS.register(
			"mangrove_picture_frame",
			() -> new MangrovePictureFrame(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).noOcclusion()
					.strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

	public static final RegistryObject<WarpedPictureFrame> QUARTZ_PICTURE_FRAME = BLOCKS.register(
			"quartz_picture_frame",
			() -> new WarpedPictureFrame(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.QUARTZ)
					.noOcclusion().strength(0.1f, 0.1f).sound(SoundType.STONE).noOcclusion()));

	// workbench
	public static final RegistryObject<BotanistWorkbench> BOTANIST_WORKBENCH = BLOCKS.register("botanist_workbench",
			() -> new BotanistWorkbench(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE)));
}
