package com.github.Pandarix.beautify.common.block;

import java.util.Random;

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
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BookStack extends HorizontalDirectionalBlock {
	private static final int modelcount = 2; // number of models the bookstack has
	public static final IntegerProperty BOOKSTACK_MODEL = IntegerProperty.create("bookstack_model", 0, modelcount - 1);
	private static final VoxelShape SHAPE = Block.box(0, 0, 2, 16, 5, 14); // bounding box

	public BookStack(Properties p_49795_) {
		super(p_49795_);
		this.registerDefaultState(
				this.defaultBlockState().setValue(BOOKSTACK_MODEL, 0).setValue(FACING, Direction.NORTH));
	}

	// setting the bounding box
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	@Override
	public VoxelShape getOcclusionShape(BlockState p_53338_, BlockGetter p_53339_, BlockPos p_53340_) {
		return SHAPE;
	}

	// changing the model of the bookstack by shift-rightclicking
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
			BlockHitResult pResult) {
		if (!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND && pPlayer.getItemInHand(pHand).isEmpty()
				&& pPlayer.isShiftKeyDown()) {
			int currentModel = pState.getValue(BOOKSTACK_MODEL); // current index
			// reset if it surpasses the number of possible models
			if (currentModel + 1 > modelcount - 1) {
				pLevel.setBlock(pPos, pState.setValue(BOOKSTACK_MODEL, 0), 3);
				return InteractionResult.SUCCESS;
			} else { // increases index
				pLevel.setBlock(pPos, pState.setValue(BOOKSTACK_MODEL, currentModel + 1), 3);
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.SUCCESS;
	}

	public BlockState getStateForPlacement(BlockPlaceContext context) {
		final int min=0;
		final int max=modelcount;
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min));
		
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(BOOKSTACK_MODEL, randomNum);
	}

	// creates blockstate
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		super.createBlockStateDefinition(pBuilder);
		pBuilder.add(BOOKSTACK_MODEL, FACING);
	}
}
