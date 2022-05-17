package com.github.Pandarix.beautify.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HangingPot extends LanternBlock {
	public static final EnumProperty<PotFlower> POTFLOWER = EnumProperty.create("pot_flower", PotFlower.class);

	public HangingPot(Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(POTFLOWER, PotFlower.dirt));
	}

	private static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.D, 12.0D, 8.0D, 12.0D);

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	@Override
	public VoxelShape getOcclusionShape(BlockState p_53338_, BlockGetter p_53339_, BlockPos p_53340_) {
		return SHAPE;
	}

	// Method for playing flowers inside of the pot
	// 0=empty, 1=rose_bush, 2=lilac
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
			BlockHitResult pResult) {
		if (!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {
			ItemStack stack = pPlayer.getItemInHand(pHand);

			if (pState.getValue(POTFLOWER) != PotFlower.dirt) {
				if (stack.isEmpty()) {
					pLevel.setBlock(pPos, pState.setValue(POTFLOWER, PotFlower.dirt), 3);
				}
				return InteractionResult.SUCCESS;
			} else if (stack.is(Items.ROSE_BUSH)) {
				pLevel.setBlock(pPos, pState.setValue(POTFLOWER, PotFlower.rose), 3);
				stack.shrink(1);
				return InteractionResult.CONSUME;
			}
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		super.createBlockStateDefinition(pBuilder);
		pBuilder.add(POTFLOWER);
	}
}