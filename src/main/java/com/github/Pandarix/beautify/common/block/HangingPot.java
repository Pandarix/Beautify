package com.github.Pandarix.beautify.common.block;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.github.Pandarix.beautify.util.KeyBoardHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
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
	public static final IntegerProperty POTFLOWER = IntegerProperty.create("potflower", 0, 20);

	private static final List<Item> validFlowers = Arrays.asList(Items.AIR, Items.ROSE_BUSH, Items.LILAC,
			Items.BLUE_ORCHID, Items.VINE, Items.SUNFLOWER, Items.PEONY, Items.AZURE_BLUET, Items.RED_TULIP,
			Items.ORANGE_TULIP, Items.WHITE_TULIP, Items.PINK_TULIP, Items.ALLIUM, Items.DANDELION, Items.POPPY,
			Items.GLOW_LICHEN, Items.OXEYE_DAISY, Items.LILY_OF_THE_VALLEY, Items.CORNFLOWER, Items.WEEPING_VINES,
			Items.TWISTING_VINES);

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
			if (playerStack.getItem().equals(Items.BONE_MEAL)) {
				Random rand = new Random();
				int randomNum = rand.nextInt(3);

				if (randomNum == 0) {
					pLevel.playSound(null, pPos, SoundEvents.NETHER_SPROUTS_BREAK, SoundSource.BLOCKS, 1, 1);
					switch (pState.getValue(POTFLOWER)) {
					case 1:
						pPlayer.drop(new ItemStack(Items.ROSE_BUSH), false);
						playerStack.shrink(1);
						return InteractionResult.SUCCESS;
					case 2:
						pPlayer.drop(new ItemStack(Items.LILAC), false);
						playerStack.shrink(1);
						return InteractionResult.SUCCESS;
					case 3:
						pPlayer.drop(new ItemStack(Items.BLUE_ORCHID), false);
						playerStack.shrink(1);
						return InteractionResult.SUCCESS;
					case 4:
						pPlayer.drop(new ItemStack(Items.VINE), false);
						playerStack.shrink(1);
						return InteractionResult.SUCCESS;
					case 5:
						pPlayer.drop(new ItemStack(Items.SUNFLOWER), false);
						playerStack.shrink(1);
						return InteractionResult.SUCCESS;
					case 6:
						pPlayer.drop(new ItemStack(Items.PEONY), false);
						playerStack.shrink(1);
						return InteractionResult.SUCCESS;
					case 7:
						pPlayer.drop(new ItemStack(Items.AZURE_BLUET), false);
						playerStack.shrink(1);
						return InteractionResult.SUCCESS;
					case 8:
						pPlayer.drop(new ItemStack(Items.RED_TULIP), false);
						playerStack.shrink(1);
						return InteractionResult.SUCCESS;
					case 9:
						pPlayer.drop(new ItemStack(Items.ORANGE_TULIP), false);
						playerStack.shrink(1);
						return InteractionResult.SUCCESS;
					case 10:
						pPlayer.drop(new ItemStack(Items.WHITE_TULIP), false);
						playerStack.shrink(1);
						return InteractionResult.SUCCESS;
					case 11:
						pPlayer.drop(new ItemStack(Items.PINK_TULIP), false);
						playerStack.shrink(1);
						return InteractionResult.SUCCESS;
					case 12:
						pPlayer.drop(new ItemStack(Items.ALLIUM), false);
						playerStack.shrink(1);
						return InteractionResult.SUCCESS;
					case 13:
						pPlayer.drop(new ItemStack(Items.DANDELION), false);
						playerStack.shrink(1);
						return InteractionResult.SUCCESS;
					case 14:
						pPlayer.drop(new ItemStack(Items.POPPY), false);
						playerStack.shrink(1);
						return InteractionResult.SUCCESS;
					case 15:
						pPlayer.drop(new ItemStack(Items.GLOW_LICHEN), false);
						playerStack.shrink(1);
						return InteractionResult.SUCCESS;
					case 16:
						pPlayer.drop(new ItemStack(Items.OXEYE_DAISY), false);
						playerStack.shrink(1);
						return InteractionResult.SUCCESS;
					case 17:
						pPlayer.drop(new ItemStack(Items.LILY_OF_THE_VALLEY), false);
						playerStack.shrink(1);
						return InteractionResult.SUCCESS;
					case 18:
						pPlayer.drop(new ItemStack(Items.CORNFLOWER), false);
						playerStack.shrink(1);
						return InteractionResult.SUCCESS;
					case 19:
						pPlayer.drop(new ItemStack(Items.WEEPING_VINES), false);
						playerStack.shrink(1);
						return InteractionResult.SUCCESS;
					case 20:
						pPlayer.drop(new ItemStack(Items.TWISTING_VINES), false);
						playerStack.shrink(1);
						return InteractionResult.SUCCESS;
					default:
						return InteractionResult.SUCCESS;
					}
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
					switch (pState.getValue(POTFLOWER)) {
					case 1:
						pPlayer.setItemInHand(pHand, new ItemStack(Items.ROSE_BUSH));
						break;
					case 2:
						pPlayer.setItemInHand(pHand, new ItemStack(Items.LILAC));
						break;
					case 3:
						pPlayer.setItemInHand(pHand, new ItemStack(Items.BLUE_ORCHID));
						break;
					case 4:
						pPlayer.setItemInHand(pHand, new ItemStack(Items.VINE));
						break;
					case 5:
						pPlayer.setItemInHand(pHand, new ItemStack(Items.SUNFLOWER));
						break;
					case 6:
						pPlayer.setItemInHand(pHand, new ItemStack(Items.PEONY));
						break;
					case 7:
						pPlayer.setItemInHand(pHand, new ItemStack(Items.AZURE_BLUET));
						break;
					case 8:
						pPlayer.setItemInHand(pHand, new ItemStack(Items.RED_TULIP));
						break;
					case 9:
						pPlayer.setItemInHand(pHand, new ItemStack(Items.ORANGE_TULIP));
						break;
					case 10:
						pPlayer.setItemInHand(pHand, new ItemStack(Items.WHITE_TULIP));
						break;
					case 11:
						pPlayer.setItemInHand(pHand, new ItemStack(Items.PINK_TULIP));
						break;
					case 12:
						pPlayer.setItemInHand(pHand, new ItemStack(Items.ALLIUM));
						break;
					case 13:
						pPlayer.setItemInHand(pHand, new ItemStack(Items.DANDELION));
						break;
					case 14:
						pPlayer.setItemInHand(pHand, new ItemStack(Items.POPPY));
						break;
					case 15:
						pPlayer.setItemInHand(pHand, new ItemStack(Items.GLOW_LICHEN));
						break;
					case 16:
						pPlayer.setItemInHand(pHand, new ItemStack(Items.OXEYE_DAISY));
						break;
					case 17:
						pPlayer.setItemInHand(pHand, new ItemStack(Items.LILY_OF_THE_VALLEY));
						break;
					case 18:
						pPlayer.setItemInHand(pHand, new ItemStack(Items.CORNFLOWER));
						break;
					case 19:
						pPlayer.setItemInHand(pHand, new ItemStack(Items.WEEPING_VINES));
						break;
					case 20:
						pPlayer.setItemInHand(pHand, new ItemStack(Items.TWISTING_VINES));
						break;
					default:
						pPlayer.setItemInHand(pHand, new ItemStack(Items.AIR));
						break;
					}
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

	// Description
	@Override
	public void appendHoverText(ItemStack stack, BlockGetter getter, List<Component> tooltip, TooltipFlag flag) {
		if (!KeyBoardHelper.isHoldingShift() && !KeyBoardHelper.isHoldingControl()) {
			tooltip.add(
					new TextComponent("\u00A77Hold\u00A77 \u00A7e\u00A7oSHIFT\u00A7o\u00A7r \u00A77for more.\u00A77"));
			tooltip.add(new TextComponent(
					"\u00A77Hold\u00A77 \u00A7e\u00A7oCTRL\u00A7o\u00A7r \u00A77for a list of plants.\u00A77"));
		}

		if (KeyBoardHelper.isHoldingShift()) {
			tooltip.add(new TextComponent(
					"\u00A77Can be placed hanging on blocks and\u00A77 \u00A7oropes\u00A7o \u00A77or on ground as usual.\u00A77"));
			tooltip.add(new TextComponent("\u00A77Right click with plants to pot them.\u00A77"));
			tooltip.add(
					new TextComponent("\u00A77Right click with Bone Meal to duplicate plant with 1/3 chance.\u00A77"));
		}

		if (KeyBoardHelper.isHoldingControl()) {
			tooltip.add(new TextComponent("\u00A7nPottable plants:\u00A7n"));
			tooltip.add(new TextComponent(
					"\u00A77All normal flowers + Rose Bushes, Lilacs, Peonies, Sunflowers, Vines, Weeping Vines, Twisting Vines, Glow Lichen\u00A77"));
		}

		super.appendHoverText(stack, getter, tooltip, flag);
	}
}