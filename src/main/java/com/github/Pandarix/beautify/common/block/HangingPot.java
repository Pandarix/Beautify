package com.github.Pandarix.beautify.common.block;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.github.Pandarix.beautify.util.KeyBoardHelper;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
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
	public static final IntegerProperty POTFLOWER = IntegerProperty.create("potflower", 0, 23);

	private static final List<Item> validFlowers = Arrays.asList(Items.AIR, Items.ROSE_BUSH, Items.LILAC,
			Items.BLUE_ORCHID, Items.VINE, Items.SUNFLOWER, Items.PEONY, Items.AZURE_BLUET, Items.RED_TULIP,
			Items.ORANGE_TULIP, Items.WHITE_TULIP, Items.PINK_TULIP, Items.ALLIUM, Items.DANDELION, Items.POPPY,
			Items.GLOW_LICHEN, Items.OXEYE_DAISY, Items.LILY_OF_THE_VALLEY, Items.CORNFLOWER, Items.WEEPING_VINES,
			Items.TWISTING_VINES, Items.WITHER_ROSE, Items.GLOW_BERRIES, Items.SWEET_BERRIES);

	public HangingPot(Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(POTFLOWER, 0));
	}

	// hitbox for the HangingPot
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

			ItemStack playerStack = pPlayer.getItemInHand(pHand);
			if (playerStack.getItem().equals(Items.BONE_MEAL) && pState.getValue(POTFLOWER)!=0) {
				Random rand = new Random();
				int randomNum = rand.nextInt(3);

				if (randomNum == 0) {
					pLevel.playSound(null, pPos, SoundEvents.NETHER_SPROUTS_BREAK, SoundSource.BLOCKS, 1, 1);
					pPlayer.drop(new ItemStack(validFlowers.get(pState.getValue(POTFLOWER))), false);
					playerStack.shrink(1);
					return InteractionResult.SUCCESS;
				} else {
					pLevel.playSound(null, pPos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1, 1);
					playerStack.shrink(1);
					return InteractionResult.SUCCESS;
				}
			}

			// if there is a flower
			if (pState.getValue(POTFLOWER) != 0) {

				// giving flower and clearing pot if hand empty
				if (playerStack.isEmpty()) {
					pPlayer.setItemInHand(pHand, new ItemStack(validFlowers.get(pState.getValue(POTFLOWER))));
					pLevel.setBlock(pPos, pState.setValue(POTFLOWER, 0), 3);
					pLevel.playSound(null, pPos, SoundEvents.COMPOSTER_READY, SoundSource.BLOCKS, 1, 1);
					return InteractionResult.SUCCESS;
				}

				// else just return
				return InteractionResult.PASS;
			} else { // if there is no flower

				// checks if the flower in hand matches the available types
				for (Item flower : validFlowers) {
					if (playerStack.getItem().equals(flower)) {
						pLevel.setBlock(pPos, pState.setValue(POTFLOWER, validFlowers.indexOf(flower)), 3);
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

	// creating Blockstates
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		super.createBlockStateDefinition(pBuilder);
		pBuilder.add(POTFLOWER);
	}
	
	@Override
	public void appendHoverText(ItemStack stack, BlockGetter getter, List<Component> component, TooltipFlag flag) {
		if (!KeyBoardHelper.isHoldingShift() && !KeyBoardHelper.isHoldingControl()) {
			component.add(new TranslatableComponent("tooltip.beautify.tooltip.shift").withStyle(ChatFormatting.YELLOW));
			component.add(new TranslatableComponent("tooltip.beautify.hanging_pot.tooltip.control").withStyle(ChatFormatting.YELLOW));
		}

		if (KeyBoardHelper.isHoldingShift()) {
			component.add(new TranslatableComponent("tooltip.beautify.hanging_pot.tooltip.info").withStyle(ChatFormatting.GRAY));
		}
		
		if (KeyBoardHelper.isHoldingControl()) {
			component.add(new TranslatableComponent("tooltip.beautify.hanging_pot.tooltip.plant_header").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.BOLD));
			component.add(new TranslatableComponent("tooltip.beautify.hanging_pot.tooltip.plants").withStyle(ChatFormatting.GRAY));
		}
		super.appendHoverText(stack, getter, component, flag);
	}
}