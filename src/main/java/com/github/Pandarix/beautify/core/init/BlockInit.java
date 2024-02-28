package com.github.Pandarix.beautify.core.init;

import com.github.Pandarix.beautify.Beautify;
import com.github.Pandarix.beautify.common.block.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
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
            () -> new BookStack(BlockBehaviour.Properties.of().strength(0.2F, 0.2F).sound(SoundInit.BOOKSTACK_SOUNDS).noOcclusion()));

    public static final RegistryObject<Rope> ROPE = BLOCKS.register("rope",
            () -> new Rope(BlockBehaviour.Properties.of().strength(0.2F, 0.2F).sound(SoundType.WOOL).noOcclusion()));

    public static final RegistryObject<HangingPot> HANGING_POT = BLOCKS.register("hanging_pot",
            () -> new HangingPot(BlockBehaviour.Properties.of()
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
    public static final RegistryObject<Trellis> OAK_TRELLIS = BLOCKS.register("oak_trellis",
            () -> new Trellis(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(0.3F, 0.3F)
                    .sound(SoundType.BAMBOO).noOcclusion()));

    public static final RegistryObject<Trellis> SPRUCE_TRELLIS = BLOCKS.register("spruce_trellis",
            () -> new Trellis(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).strength(0.3F, 0.3F)
                    .sound(SoundType.BAMBOO).noOcclusion()));

    public static final RegistryObject<Trellis> BIRCH_TRELLIS = BLOCKS.register("birch_trellis",
            () -> new Trellis(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).strength(0.3F, 0.3F)
                    .sound(SoundType.BAMBOO).noOcclusion()));

    public static final RegistryObject<Trellis> JUNGLE_TRELLIS = BLOCKS.register("jungle_trellis",
            () -> new Trellis(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).strength(0.3F, 0.3F)
                    .sound(SoundType.BAMBOO).noOcclusion()));

    public static final RegistryObject<Trellis> ACACIA_TRELLIS = BLOCKS.register("acacia_trellis",
            () -> new Trellis(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).strength(0.3F, 0.3F)
                    .sound(SoundType.BAMBOO).noOcclusion()));

    public static final RegistryObject<Trellis> DARK_OAK_TRELLIS = BLOCKS.register("dark_oak_trellis",
            () -> new Trellis(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
                    .strength(0.3F, 0.3F).sound(SoundType.BAMBOO).noOcclusion()));

    public static final RegistryObject<Trellis> MANGROVE_TRELLIS = BLOCKS.register("mangrove_trellis",
            () -> new Trellis(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
                    .strength(0.3F, 0.3F).sound(SoundType.BAMBOO).noOcclusion()));

    public static final RegistryObject<Trellis> CRIMSON_TRELLIS = BLOCKS.register("crimson_trellis",
            () -> new Trellis(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
                    .strength(0.3F, 0.3F).sound(SoundType.BAMBOO).noOcclusion()));

    public static final RegistryObject<Trellis> WARPED_TRELLIS = BLOCKS.register("warped_trellis",
            () -> new Trellis(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).strength(0.3F, 0.3F)
                    .sound(SoundType.BAMBOO).noOcclusion()));

    // lamps
    public static final RegistryObject<LampLightBulb> LAMP_LIGHT_BULB = BLOCKS.register("lamp_light_bulb",
            () -> new LampLightBulb(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN)
                    .lightLevel((state) -> {
                        if (state.getValue(LampLightBulb.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampBamboo> LAMP_BAMBOO = BLOCKS.register("lamp_bamboo",
            () -> new LampBamboo(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()
                    .strength(0.1f, 0.1f).sound(SoundType.SCAFFOLDING).lightLevel((state) -> {
                        if (state.getValue(LampBamboo.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampJar> LAMP_JAR = BLOCKS.register("lamp_jar",
            () -> new LampJar(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()
                    .strength(0.05f, 0.05f).sound(SoundType.GLASS).lightLevel((state) -> {
                        final int fill = state.getValue(LampJar.FILL_LEVEL);
                        return switch (fill) {
                            case 0 -> 0;
                            case 5 -> 8;
                            case 10 -> 11;
                            case 15 -> 14;
                            default -> 0;
                        };
                    })));

    // candelabras
    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA = BLOCKS.register("lamp_candelabra",
            () -> new LampCandelabra(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).noOcclusion()
                    .strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_LIGHT_BLUE = BLOCKS.register(
            "lamp_candelabra_light_blue",
            () -> new LampCandelabra(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_LIGHT_GRAY = BLOCKS.register(
            "lamp_candelabra_light_gray",
            () -> new LampCandelabra(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_BLACK = BLOCKS.register(
            "lamp_candelabra_black",
            () -> new LampCandelabra(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_BLUE = BLOCKS.register(
            "lamp_candelabra_blue",
            () -> new LampCandelabra(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).noOcclusion()
                    .strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_BROWN = BLOCKS.register(
            "lamp_candelabra_brown",
            () -> new LampCandelabra(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_CYAN = BLOCKS.register(
            "lamp_candelabra_cyan",
            () -> new LampCandelabra(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).noOcclusion()
                    .strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_GRAY = BLOCKS.register(
            "lamp_candelabra_gray",
            () -> new LampCandelabra(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).noOcclusion()
                    .strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_GREEN = BLOCKS.register(
            "lamp_candelabra_green",
            () -> new LampCandelabra(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_LIME = BLOCKS.register(
            "lamp_candelabra_lime",
            () -> new LampCandelabra(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).noOcclusion()
                    .strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_MAGENTA = BLOCKS.register(
            "lamp_candelabra_magenta",
            () -> new LampCandelabra(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_ORANGE = BLOCKS.register(
            "lamp_candelabra_orange",
            () -> new LampCandelabra(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_PINK = BLOCKS.register(
            "lamp_candelabra_pink",
            () -> new LampCandelabra(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).noOcclusion()
                    .strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_PURPLE = BLOCKS.register(
            "lamp_candelabra_purple",
            () -> new LampCandelabra(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_RED = BLOCKS.register("lamp_candelabra_red",
            () -> new LampCandelabra(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).noOcclusion()
                    .strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_WHITE = BLOCKS.register(
            "lamp_candelabra_white",
            () -> new LampCandelabra(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_YELLOW = BLOCKS.register(
            "lamp_candelabra_yellow",
            () -> new LampCandelabra(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    // blinds
    public static final RegistryObject<Blinds> SPRUCE_BLINDS = BLOCKS.register("spruce_blinds",
            () -> new Blinds(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion()
                    .strength(0.4f, 0.4f).sound(SoundType.WOOD)));

    public static final RegistryObject<Blinds> DARK_OAK_BLINDS = BLOCKS.register("dark_oak_blinds",
            () -> new Blinds(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion()
                    .strength(0.4f, 0.4f).sound(SoundType.WOOD)));

    public static final RegistryObject<Blinds> CRIMSON_BLINDS = BLOCKS.register("crimson_blinds",
            () -> new Blinds(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()
                    .strength(0.4f, 0.4f).sound(SoundType.WOOD)));

    public static final RegistryObject<Blinds> ACACIA_BLINDS = BLOCKS.register("acacia_blinds",
            () -> new Blinds(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion()
                    .strength(0.4f, 0.4f).sound(SoundType.WOOD)));

    public static final RegistryObject<Blinds> JUNGLE_BLINDS = BLOCKS.register("jungle_blinds",
            () -> new Blinds(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion()
                    .strength(0.4f, 0.4f).sound(SoundType.WOOD)));

    public static final RegistryObject<Blinds> OAK_BLINDS = BLOCKS.register("oak_blinds",
            () -> new Blinds(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()
                    .strength(0.4f, 0.4f).sound(SoundType.WOOD)));

    public static final RegistryObject<Blinds> BIRCH_BLINDS = BLOCKS.register("birch_blinds",
            () -> new Blinds(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion()
                    .strength(0.4f, 0.4f).sound(SoundType.WOOD)));

    public static final RegistryObject<Blinds> WARPED_BLINDS = BLOCKS.register("warped_blinds",
            () -> new Blinds(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion()
                    .strength(0.4f, 0.4f).sound(SoundType.WOOD)));

    public static final RegistryObject<Blinds> MANGROVE_BLINDS = BLOCKS.register("mangrove_blinds",
            () -> new Blinds(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()
                    .strength(0.4f, 0.4f).sound(SoundType.WOOD)));

    public static final RegistryObject<Blinds> IRON_BLINDS = BLOCKS.register("iron_blinds",
            () -> new Blinds(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).noOcclusion()
                    .strength(0.4f, 0.4f).sound(SoundType.CHAIN).requiresCorrectToolForDrops()));

    // picture frames
    public static final RegistryObject<PictureFrame> SPRUCE_PICTURE_FRAME = BLOCKS.register(
            "spruce_picture_frame",
            () -> new PictureFrame(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion()
                    .strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<PictureFrame> DARK_OAK_PICTURE_FRAME = BLOCKS.register(
            "dark_oak_picture_frame",
            () -> new PictureFrame(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion()
                    .strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<PictureFrame> CRIMSON_PICTURE_FRAME = BLOCKS.register(
            "crimson_picture_frame",
            () -> new PictureFrame(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()
                    .strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<PictureFrame> ACACIA_PICTURE_FRAME = BLOCKS.register(
            "acacia_picture_frame",
            () -> new PictureFrame(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion()
                    .strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<PictureFrame> JUNGLE_PICTURE_FRAME = BLOCKS.register(
            "jungle_picture_frame",
            () -> new PictureFrame(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion()
                    .strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<PictureFrame> OAK_PICTURE_FRAME = BLOCKS.register("oak_picture_frame",
            () -> new PictureFrame(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()
                    .strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<PictureFrame> BIRCH_PICTURE_FRAME = BLOCKS.register("birch_picture_frame",
            () -> new PictureFrame(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion()
                    .strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<PictureFrame> WARPED_PICTURE_FRAME = BLOCKS.register(
            "warped_picture_frame",
            () -> new PictureFrame(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion()
                    .strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<PictureFrame> MANGROVE_PICTURE_FRAME = BLOCKS.register(
            "mangrove_picture_frame",
            () -> new PictureFrame(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()
                    .strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<PictureFrame> QUARTZ_PICTURE_FRAME = BLOCKS.register(
            "quartz_picture_frame",
            () -> new PictureFrame(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)
                    .noOcclusion().strength(0.1f, 0.1f).sound(SoundType.STONE).noOcclusion()));

    // workbench
    public static final RegistryObject<BotanistWorkbench> BOTANIST_WORKBENCH = BLOCKS.register("botanist_workbench",
            () -> new BotanistWorkbench(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
}
