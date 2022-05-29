package com.github.Pandarix.beautify.common.block;

import java.util.Arrays;
import java.util.List;

import com.github.Pandarix.beautify.util.KeyBoardHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
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
	private ItemStack content;
	private static final List<String> flowers = Arrays.asList("block.minecraft.air", "block.minecraft.rose_bush",
			"block.minecraft.lilac", "block.minecraft.blue_orchid");

	public HangingPot(Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(POTFLOWER, 0));
		content = new ItemStack(Items.AIR);
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

	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
			BlockHitResult pResult) {

		if (!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {

			ItemStack stack = pPlayer.getItemInHand(pHand);

			if (pState.getValue(POTFLOWER) != 0) {
				if (stack.isEmpty()) {
					pPlayer.drop(content, false);
					pLevel.setBlock(pPos, pState.setValue(POTFLOWER, 0), 3);
					return InteractionResult.SUCCESS;
				}
			} else {
				String stackID = stack.getDescriptionId();
				for (String flower : flowers) {
					if (stackID.equals(flower)) {
						if (flower == "block.minecraft.rose_bush") {
							content = new ItemStack(Items.ROSE_BUSH);
						} else if (flower == "block.minecraft.lilac") {
							content = new ItemStack(Items.LILAC);
						} else if (flower == "block.minecraft.blue_orchid") {
							content = new ItemStack(Items.BLUE_ORCHID);
						}
						pLevel.setBlock(pPos, pState.setValue(POTFLOWER, flowers.indexOf(flower)), 3);
						stack.shrink(1);
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

	@Override
	public void appendHoverText(ItemStack stack, BlockGetter getter, List<Component> tooltip, TooltipFlag flag) {
		if (!KeyBoardHelper.isHoldingShift()) {
			tooltip.add(new TextComponent("Hold \u00A7eSHIFT\u00A7r for more."));
		}

		if (KeyBoardHelper.isHoldingShift()) {
			tooltip.add(new TextComponent("Can be placed hanging on blocks and \u00A7eropes\u00A7r or on ground as usual. Right click with plants to pot them."));
		}
		super.appendHoverText(stack, getter, tooltip, flag);
	}
}