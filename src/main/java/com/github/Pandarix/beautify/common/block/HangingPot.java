package com.github.Pandarix.beautify.common.block;

import java.util.Arrays;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import com.github.Pandarix.beautify.core.init.BlockInit;
import com.github.Pandarix.beautify.core.init.ItemInit;

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
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HangingPot extends LanternBlock {
	// POTFLOWER indicates which index of the flowers List below is active
	public static final IntegerProperty POTFLOWER = IntegerProperty.create("potflower", 0, 3);
	private static final List<String> flowers = Arrays.asList("block.minecraft.air", "block.minecraft.rose_bush",
			"block.minecraft.lilac", "block.minecraft.blue_orchid");

	// constructor
	public HangingPot(Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(POTFLOWER, 0));
	}

	// hitbox for the Hanging Pot
	private static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.D, 12.0D, 8.0D, 12.0D);

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	@Override
	public VoxelShape getOcclusionShape(BlockState p_53338_, BlockGetter p_53339_, BlockPos p_53340_) {
		return SHAPE;
	}

	// interaction for placing flowers into the flower-pot
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
			BlockHitResult pResult) {
		// if the player interacts with their main hand
		if (!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {
			// the stack of the hand item gets stored in "stack"
			ItemStack stack = pPlayer.getItemInHand(pHand);

			// if the flower pot is not empty (index greater than 0)
			// and the hand of the player is empty, the pot gets cleared (0)
			if (pState.getValue(POTFLOWER) != 0) {
				if (stack.isEmpty()) {
					pLevel.setBlock(pPos, pState.setValue(POTFLOWER, 0), 3);
					return InteractionResult.SUCCESS;
				}
				// if there is no flower inside of the pot
				// the id of the stack item gets stored in "stackID"
			} else {
				String stackID = stack.getDescriptionId();
				// then test if the stackID corresponds to any flower in the valid list
				for (String flower : flowers) {
					if (stackID.equals(flower)) {
						// if that is the case, the BlockState gets set to the index value of the flower
						// the flower gets removed from the inventory
			            //ItemStack dropStack = new ItemStack(Items.);
						pLevel.setBlock(pPos, pState.setValue(POTFLOWER, flowers.indexOf(flower)), 3);
						stack.shrink(1);
						//pPlayer.drop(dropStack, false);
						return InteractionResult.CONSUME;
					}
				}
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.SUCCESS;
	}

	// creating Blockstates
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		super.createBlockStateDefinition(pBuilder);
		pBuilder.add(POTFLOWER);
	}
}