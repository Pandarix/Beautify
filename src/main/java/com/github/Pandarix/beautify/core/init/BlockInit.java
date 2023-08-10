package com.github.Pandarix.beautify.core.init;

import com.github.Pandarix.beautify.Beautify;
import com.github.Pandarix.beautify.common.block.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
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
    public static final RegistryObject<OakTrellis> OAK_TRELLIS = BLOCKS.register("oak_trellis",
            () -> new OakTrellis(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(0.3F, 0.3F)
                    .sound(SoundType.BAMBOO).noOcclusion()));

    public static final RegistryObject<OakTrellis> SPRUCE_TRELLIS = BLOCKS.register("spruce_trellis",
            () -> new OakTrellis(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).strength(0.3F, 0.3F)
                    .sound(SoundType.BAMBOO).noOcclusion()));

    public static final RegistryObject<OakTrellis> BIRCH_TRELLIS = BLOCKS.register("birch_trellis",
            () -> new OakTrellis(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).strength(0.3F, 0.3F)
                    .sound(SoundType.BAMBOO).noOcclusion()));

    public static final RegistryObject<OakTrellis> JUNGLE_TRELLIS = BLOCKS.register("jungle_trellis",
            () -> new OakTrellis(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).strength(0.3F, 0.3F)
                    .sound(SoundType.BAMBOO).noOcclusion()));

    public static final RegistryObject<OakTrellis> ACACIA_TRELLIS = BLOCKS.register("acacia_trellis",
            () -> new OakTrellis(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).strength(0.3F, 0.3F)
                    .sound(SoundType.BAMBOO).noOcclusion()));

    public static final RegistryObject<OakTrellis> DARK_OAK_TRELLIS = BLOCKS.register("dark_oak_trellis",
            () -> new OakTrellis(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)
                    .strength(0.3F, 0.3F).sound(SoundType.BAMBOO).noOcclusion()));

    public static final RegistryObject<OakTrellis> MANGROVE_TRELLIS = BLOCKS.register("mangrove_trellis",
            () -> new OakTrellis(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)
                    .strength(0.3F, 0.3F).sound(SoundType.BAMBOO).noOcclusion()));

    public static final RegistryObject<OakTrellis> CRIMSON_TRELLIS = BLOCKS.register("crimson_trellis",
            () -> new OakTrellis(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)
                    .strength(0.3F, 0.3F).sound(SoundType.BAMBOO).noOcclusion()));

    public static final RegistryObject<OakTrellis> WARPED_TRELLIS = BLOCKS.register("warped_trellis",
            () -> new OakTrellis(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).strength(0.3F, 0.3F)
                    .sound(SoundType.BAMBOO).noOcclusion()));

    // lamps
    public static final RegistryObject<LampLightBulb> LAMP_LIGHT_BULB = BLOCKS.register("lamp_light_bulb",
            () -> new LampLightBulb(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampLightBulb.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampBamboo> LAMP_BAMBOO = BLOCKS.register("lamp_bamboo",
            () -> new LampBamboo(BlockBehaviour.Properties.copy(Blocks.BAMBOO).noOcclusion()
                    .strength(0.1f, 0.1f).sound(SoundType.SCAFFOLDING).lightLevel((state) -> {
                        if (state.getValue(LampBamboo.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampJar> LAMP_JAR = BLOCKS.register("lamp_jar",
            () -> new LampJar(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()
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

    // candleabras
    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA = BLOCKS.register("lamp_candleabra",
            () -> new LampCandelabra(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_LIGHT_BLUE = BLOCKS.register(
            "lamp_candleabra_light_blue",
            () -> new LampCandelabra(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_LIGHT_GRAY = BLOCKS.register(
            "lamp_candleabra_light_gray",
            () -> new LampCandelabra(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_BLACK = BLOCKS.register(
            "lamp_candleabra_black",
            () -> new LampCandelabra(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_BLUE = BLOCKS.register(
            "lamp_candleabra_blue",
            () -> new LampCandelabra(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_BROWN = BLOCKS.register(
            "lamp_candleabra_brown",
            () -> new LampCandelabra(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_CYAN = BLOCKS.register(
            "lamp_candleabra_cyan",
            () -> new LampCandelabra(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_GRAY = BLOCKS.register(
            "lamp_candleabra_gray",
            () -> new LampCandelabra(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_GREEN = BLOCKS.register(
            "lamp_candleabra_green",
            () -> new LampCandelabra(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_LIME = BLOCKS.register(
            "lamp_candleabra_lime",
            () -> new LampCandelabra(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_MAGENTA = BLOCKS.register(
            "lamp_candleabra_magenta",
            () -> new LampCandelabra(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_ORANGE = BLOCKS.register(
            "lamp_candleabra_orange",
            () -> new LampCandelabra(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_PINK = BLOCKS.register(
            "lamp_candleabra_pink",
            () -> new LampCandelabra(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_PURPLE = BLOCKS.register(
            "lamp_candleabra_purple",
            () -> new LampCandelabra(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_RED = BLOCKS.register("lamp_candleabra_red",
            () -> new LampCandelabra(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_WHITE = BLOCKS.register(
            "lamp_candleabra_white",
            () -> new LampCandelabra(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    public static final RegistryObject<LampCandelabra> LAMP_CANDELABRA_YELLOW = BLOCKS.register(
            "lamp_candleabra_yellow",
            () -> new LampCandelabra(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .noOcclusion().strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampCandelabra.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    })));

    // blinds
    public static final RegistryObject<OakBlinds> SPRUCE_BLINDS = BLOCKS.register("spruce_blinds",
            () -> new OakBlinds(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()
                    .strength(0.4f, 0.4f).sound(SoundType.WOOD)));

    public static final RegistryObject<OakBlinds> DARK_OAK_BLINDS = BLOCKS.register("dark_oak_blinds",
            () -> new OakBlinds(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()
                    .strength(0.4f, 0.4f).sound(SoundType.WOOD)));

    public static final RegistryObject<OakBlinds> CRIMSON_BLINDS = BLOCKS.register("crimson_blinds",
            () -> new OakBlinds(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()
                    .strength(0.4f, 0.4f).sound(SoundType.WOOD)));

    public static final RegistryObject<OakBlinds> ACACIA_BLINDS = BLOCKS.register("acacia_blinds",
            () -> new OakBlinds(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()
                    .strength(0.4f, 0.4f).sound(SoundType.WOOD)));

    public static final RegistryObject<OakBlinds> JUNGLE_BLINDS = BLOCKS.register("jungle_blinds",
            () -> new OakBlinds(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()
                    .strength(0.4f, 0.4f).sound(SoundType.WOOD)));

    public static final RegistryObject<OakBlinds> OAK_BLINDS = BLOCKS.register("oak_blinds",
            () -> new OakBlinds(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()
                    .strength(0.4f, 0.4f).sound(SoundType.WOOD)));

    public static final RegistryObject<OakBlinds> BIRCH_BLINDS = BLOCKS.register("birch_blinds",
            () -> new OakBlinds(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()
                    .strength(0.4f, 0.4f).sound(SoundType.WOOD)));

    public static final RegistryObject<OakBlinds> WARPED_BLINDS = BLOCKS.register("warped_blinds",
            () -> new OakBlinds(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()
                    .strength(0.4f, 0.4f).sound(SoundType.WOOD)));

    public static final RegistryObject<OakBlinds> MANGROVE_BLINDS = BLOCKS.register("mangrove_blinds",
            () -> new OakBlinds(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()
                    .strength(0.4f, 0.4f).sound(SoundType.WOOD)));

    public static final RegistryObject<OakBlinds> IRON_BLINDS = BLOCKS.register("iron_blinds",
            () -> new OakBlinds(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .strength(0.4f, 0.4f).sound(SoundType.CHAIN).requiresCorrectToolForDrops()));

    // picture frames
    public static final RegistryObject<OakPictureFrame> SPRUCE_PICTURE_FRAME = BLOCKS.register(
            "spruce_picture_frame",
            () -> new OakPictureFrame(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()
                    .strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<OakPictureFrame> DARK_OAK_PICTURE_FRAME = BLOCKS.register(
            "dark_oak_picture_frame",
            () -> new OakPictureFrame(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()
                    .strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<OakPictureFrame> CRIMSON_PICTURE_FRAME = BLOCKS.register(
            "crimson_picture_frame",
            () -> new OakPictureFrame(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()
                    .strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<OakPictureFrame> ACACIA_PICTURE_FRAME = BLOCKS.register(
            "acacia_picture_frame",
            () -> new OakPictureFrame(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()
                    .strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<OakPictureFrame> JUNGLE_PICTURE_FRAME = BLOCKS.register(
            "jungle_picture_frame",
            () -> new OakPictureFrame(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()
                    .strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<OakPictureFrame> OAK_PICTURE_FRAME = BLOCKS.register("oak_picture_frame",
            () -> new OakPictureFrame(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()
                    .strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<OakPictureFrame> BIRCH_PICTURE_FRAME = BLOCKS.register("birch_picture_frame",
            () -> new OakPictureFrame(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()
                    .strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<OakPictureFrame> WARPED_PICTURE_FRAME = BLOCKS.register(
            "warped_picture_frame",
            () -> new OakPictureFrame(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()
                    .strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<OakPictureFrame> MANGROVE_PICTURE_FRAME = BLOCKS.register(
            "mangrove_picture_frame",
            () -> new OakPictureFrame(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()
                    .strength(0.1f, 0.1f).sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<OakPictureFrame> QUARTZ_PICTURE_FRAME = BLOCKS.register(
            "quartz_picture_frame",
            () -> new OakPictureFrame(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK)
                    .noOcclusion().strength(0.1f, 0.1f).sound(SoundType.STONE).noOcclusion()));

    // workbench
    public static final RegistryObject<BotanistWorkbench> BOTANIST_WORKBENCH = BLOCKS.register("botanist_workbench",
            () -> new BotanistWorkbench(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE)));
}
