package com.github.Pandarix.beautify.common.block;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.github.Pandarix.beautify.core.init.BlockInit;

import com.google.common.collect.ImmutableMap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
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
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class OakTrellis extends HorizontalDirectionalBlock {
	private static final List<Item> VALID_FLOWERS = Arrays.asList(Items.AIR, Items.ROSE_BUSH, Items.SUNFLOWER,
			Items.PEONY, Items.LILAC, Items.VINE, Items.WEEPING_VINES, Items.TWISTING_VINES, Items.GLOW_LICHEN);

	// FLOWERS indicates which index of the flowers List below is active
	public static final IntegerProperty FLOWERS = IntegerProperty.create("flowers", 0, VALID_FLOWERS.size() - 1);

	public static final BooleanProperty CEILLING = BooleanProperty.create("ceilling");

	private static final Map<Direction, VoxelShape> SHAPES_FOR_MODEL = ImmutableMap.of(
			Direction.NORTH, Block.box(0, 0, 14, 16, 16, 16),
			Direction.SOUTH, Block.box(0, 0, 0, 16, 16, 2),
			Direction.WEST, Block.box(14, 0, 0, 16, 16, 16),
			Direction.EAST, Block.box(0, 0, 0, 2, 16, 16)
	);
	private static final VoxelShape SHAPE_CEILLING = Block.box(0, 14, 0, 16, 16, 16);

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

		return SHAPES_FOR_MODEL.get(state.getValue(FACING));
	}

	@Override
	public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return true;
	}

	@Override
	public boolean isLadder(BlockState state, LevelReader level, BlockPos pos, LivingEntity entity) {
		return state.is(this) || super.isLadder(state, level, pos, entity);
	}

	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
			BlockHitResult pResult) {
		if(pLevel.isClientSide()){
			return InteractionResult.SUCCESS;
		}
		if (pHand == InteractionHand.MAIN_HAND) {

			ItemStack playerStack = pPlayer.getItemInHand(pHand);

			// if there is a flower
			if (pState.getValue(FLOWERS) != 0) {

				// giving flower and clearing pot if hand empty or same stack
				if (playerStack.isEmpty()) {
					pPlayer.setItemInHand(pHand, new ItemStack(VALID_FLOWERS.get(pState.getValue(FLOWERS))));
					pLevel.setBlock(pPos, pState.setValue(FLOWERS, 0), 3);
					pLevel.playSound(null, pPos, SoundEvents.AZALEA_LEAVES_BREAK, SoundSource.BLOCKS, 1, 1);
					return InteractionResult.SUCCESS;
				} else if (playerStack.is(VALID_FLOWERS.get(pState.getValue(FLOWERS)))
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
				for (Item flower : VALID_FLOWERS) {
					if (playerStack.getItem().equals(flower)) {
						pLevel.setBlock(pPos, pState.setValue(FLOWERS, VALID_FLOWERS.indexOf(flower)), 3);
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

	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, BlockGetter getter, List<Component> component, TooltipFlag flag) {
		if (!Screen.hasShiftDown() && !Screen.hasControlDown()) {
			component.add(Component.translatable("tooltip.shift").withStyle(ChatFormatting.YELLOW));
			component.add(Component.translatable("tooltip.control").withStyle(ChatFormatting.YELLOW));
		}

		if (Screen.hasShiftDown()) {
			component.add(Component.translatable("trellis.description1").withStyle(ChatFormatting.GRAY));
			component.add(Component.translatable("trellis.description2").withStyle(ChatFormatting.GRAY));
		}

		if (Screen.hasControlDown()) {
			component.add(Component.translatable("trellis.list1").withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.GRAY));
			component.add(Component.translatable("trellis.list2").withStyle(ChatFormatting.GRAY));
		}
		super.appendHoverText(stack, getter, component, flag);
	}
}
