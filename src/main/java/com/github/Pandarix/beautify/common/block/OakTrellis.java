package com.github.Pandarix.beautify.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class OakTrellis extends HorizontalDirectionalBlock {
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

	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
			BlockHitResult pResult) {
		return InteractionResult.SUCCESS;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_57561_) {
		p_57561_.add(FACING, CEILLING);
	}
}
