package com.github.Pandarix.beautify.common.block;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

import com.github.Pandarix.beautify.core.init.BlockInit;
import com.github.Pandarix.beautify.core.init.SoundInit;
import com.github.Pandarix.beautify.util.KeyBoardHelper;
import com.google.common.collect.ImmutableMap;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BookStack extends HorizontalDirectionalBlock {
	private static final int modelcount = 4; // number of models the bookstack has
	public static final IntegerProperty BOOKSTACK_MODEL = IntegerProperty.create("bookstack_model", 0, modelcount - 1);
	private static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 4, 15); // bounding box

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
			// currently broken
			pLevel.playSound(pPlayer, pPos, SoundInit.BOOKSTACK_NEXT.get(), SoundSource.BLOCKS, 1f, 1f);
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

	@Override
	public float getEnchantPowerBonus(BlockState state, LevelReader level, BlockPos pos) {
		if (state.is(BlockInit.BOOKSTACK.get())) {
			return 1;
		} else {
			return super.getEnchantPowerBonus(state, level, pos);
		}
	}

	public BlockState getStateForPlacement(BlockPlaceContext context) {
		final int min = 0;
		final int max = modelcount;
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min));

		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite())
				.setValue(BOOKSTACK_MODEL, randomNum);
	}

	// creates blockstate
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		super.createBlockStateDefinition(pBuilder);
		pBuilder.add(BOOKSTACK_MODEL, FACING);
	}

	@Override
	public void appendHoverText(ItemStack stack, BlockGetter getter, List<Component> tooltip, TooltipFlag flag) {
		if (!KeyBoardHelper.isHoldingShift()) {
			tooltip.add(
					new TextComponent("\u00A77Hold\u00A77 \u00A7e\u00A7oSHIFT\u00A7o\u00A7r \u00A77for more.\u00A77"));
		}

		if (KeyBoardHelper.isHoldingShift()) {
			tooltip.add(new TextComponent(
					"\u00A77Increases Enchantment Table Power like Shelves.\u00A77"));
			tooltip.add(new TextComponent(
					"\u00A77Places random Bookstack. Shift-Rightclick on Block to change model.\u00A77"));
		}
		super.appendHoverText(stack, getter, tooltip, flag);
	}
}
