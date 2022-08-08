package com.github.Pandarix.beautify.common.block;

import java.util.Arrays;
import java.util.List;

import com.github.Pandarix.beautify.core.init.BlockInit;
import com.github.Pandarix.beautify.util.KeyBoardHelper;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class OakTrellis extends HorizontalDirectionalBlock {
	private static final List<Item> validFlowers = Arrays.asList(Items.AIR, Items.ROSE_BUSH, Items.SUNFLOWER,
			Items.PEONY, Items.LILAC, Items.VINE, Items.WEEPING_VINES, Items.TWISTING_VINES, Items.GLOW_LICHEN);

	// FLOWERS indicates which index of the flowers List below is active
	public static final IntegerProperty FLOWERS = IntegerProperty.create("flowers", 0, validFlowers.size() - 1);

	public static final BooleanProperty CEILLING = BooleanProperty.create("ceilling");
	private static final VoxelShape SHAPE_CEILLING = Block.box(0, 14, 0, 16, 16, 16);
	private static final VoxelShape SHAPE_SOUTH = Block.box(0, 0, 0, 16, 16, 2);
	private static final VoxelShape SHAPE_NORTH = Block.box(0, 0, 14, 16, 16, 16);
	private static final VoxelShape SHAPE_WEST = Block.box(14, 0, 0, 16, 16, 16);
	private static final VoxelShape SHAPE_EAST = Block.box(0, 0, 0, 2, 16, 16);

	public OakTrellis(Properties p_49795_) {
		super(p_49795_);
		this.registerDefaultState(this.defaultBlockState().setValue(CEILLING, false).setValue(FACING, Direction.NORTH));
	}

	public BlockState getStateForPlacement(BlockPlaceContext context) {
		// if the trellis placed on underside of block -> hanging from the ceilling
		if (context.getClickedFace() == Direction.DOWN) {
			return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite())
					.setValue(CEILLING, true);
		}
		// otherwise on a wall
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite())
				.setValue(CEILLING, false);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
		if (state.getValue(CEILLING)) {
			return SHAPE_CEILLING;
		}

		return switch (state.getValue(FACING)) {
		case NORTH -> SHAPE_NORTH;
		case SOUTH -> SHAPE_SOUTH;
		case EAST -> SHAPE_EAST;
		case WEST -> SHAPE_WEST;
		default -> SHAPE_NORTH;
		};
	}

	@Override
	public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return true;
	}

	@Override
	public boolean isLadder(BlockState state, LevelReader level, BlockPos pos, LivingEntity entity) {
		if (state.is(BlockInit.OAK_TRELLIS.get()) || state.is(BlockInit.BIRCH_TRELLIS.get())
				|| state.is(BlockInit.JUNGLE_TRELLIS.get()) || state.is(BlockInit.SPRUCE_TRELLIS.get())
				|| state.is(BlockInit.ACACIA_TRELLIS.get()) || state.is(BlockInit.DARK_OAK_TRELLIS.get())
				|| state.is(BlockInit.MANGROVE_TRELLIS.get()) || state.is(BlockInit.CRIMSON_TRELLIS.get())
				|| state.is(BlockInit.WARPED_TRELLIS.get())) {
			return true;
		}
		return super.isLadder(state, level, pos, entity);
	}

	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
			BlockHitResult pResult) {

		if (!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {

			ItemStack playerStack = pPlayer.getItemInHand(pHand);

			// if there is a flower
			if (pState.getValue(FLOWERS) != 0) {

				// giving flower and clearing pot if hand empty or same stack
				if (playerStack.isEmpty()) {
					pPlayer.setItemInHand(pHand, new ItemStack(validFlowers.get(pState.getValue(FLOWERS))));
					pLevel.setBlock(pPos, pState.setValue(FLOWERS, 0), 3);
					pLevel.playSound(null, pPos, SoundEvents.AZALEA_LEAVES_BREAK, SoundSource.BLOCKS, 1, 1);
					return InteractionResult.SUCCESS;
				} else if (playerStack.is(validFlowers.get(pState.getValue(FLOWERS)))
						&& playerStack.getCount() < playerStack.getMaxStackSize()) {
					playerStack.grow(1);
					pLevel.setBlock(pPos, pState.setValue(FLOWERS, 0), 3);
					pLevel.playSound(null, pPos, SoundEvents.AZALEA_LEAVES_BREAK, SoundSource.BLOCKS, 1, 1);
					return InteractionResult.SUCCESS;
				}

				// else just return
				return InteractionResult.PASS;
			} else { // if there is no flower

				// checks if the flower in hand matches the available types
				for (Item flower : validFlowers) {
					if (playerStack.getItem().equals(flower)) {
						pLevel.setBlock(pPos, pState.setValue(FLOWERS, validFlowers.indexOf(flower)), 3);
						if (!flower.equals(Items.AIR)) {
							pLevel.playSound(null, pPos, SoundEvents.AZALEA_PLACE, SoundSource.BLOCKS, 1, 1);
						}
						playerStack.shrink(1);
						return InteractionResult.CONSUME_PARTIAL;
					}
				}
				// if the flower is not a valid one
				return InteractionResult.PASS;
			}
		}
		// end of statement
		return InteractionResult.PASS;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_57561_) {
		p_57561_.add(FACING, CEILLING, FLOWERS);
	}

	@Override
	public void appendHoverText(ItemStack stack, BlockGetter getter, List<Component> component, TooltipFlag flag) {
		if (!KeyBoardHelper.isHoldingShift() && !KeyBoardHelper.isHoldingControl()) {
			component.add(Component.literal("Hold SHIFT for more info.").withStyle(ChatFormatting.YELLOW));
			component.add(Component.literal("Hold CTRL for a list of plants.").withStyle(ChatFormatting.YELLOW));
		}

		if (KeyBoardHelper.isHoldingShift()) {
			component.add(Component.literal("Can be placed on or like walls and on the ceilling. Climbable.")
					.withStyle(ChatFormatting.GRAY));
			component.add(Component.literal("Right click with plants to insert.").withStyle(ChatFormatting.GRAY));
		}

		if (KeyBoardHelper.isHoldingControl()) {
			component.add(Component.literal("Pottable plants:").withStyle(ChatFormatting.UNDERLINE)
					.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.GRAY));
			component.add(Component.literal(
					"Rose Bushes, Sunflowers, Peonies, Lilacs, Vines, Weeping Vines, Twisting Vines, Glow Lichen")
					.withStyle(ChatFormatting.GRAY));
		}
		super.appendHoverText(stack, getter, component, flag);
	}
}
