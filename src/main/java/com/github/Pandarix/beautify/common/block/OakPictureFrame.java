package com.github.Pandarix.beautify.common.block;

import java.util.List;
import java.util.Random;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class OakPictureFrame extends HorizontalDirectionalBlock {
	private static final int modelcount = 13; // number of models the frame has
	public static final IntegerProperty FRAME_MOTIVE = IntegerProperty.create("frame_motive", 0, modelcount - 1);
	protected static final VoxelShape SHAPE = Block.box(5, 0, 5, 11, 8, 11);

	public OakPictureFrame(Properties p_49795_) {
		super(p_49795_);
		this.registerDefaultState(this.defaultBlockState().setValue(FRAME_MOTIVE, 0).setValue(FACING, Direction.NORTH));
	}

	// changing the model of the picture frame by shift-rightclicking
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
			BlockHitResult pResult) {
		if(pLevel.isClientSide()){
			return InteractionResult.SUCCESS;
		}
		if (pHand == InteractionHand.MAIN_HAND && pPlayer.getItemInHand(pHand).isEmpty()
				&& pPlayer.isShiftKeyDown()) {
			int currentModel = pState.getValue(FRAME_MOTIVE); // current index
			// reset if it surpasses the number of possible models
			if (currentModel + 1 > modelcount - 1) {
				pLevel.setBlock(pPos, pState.setValue(FRAME_MOTIVE, 0), 3);
				pLevel.playSound(null, pPos, SoundEvents.PAINTING_PLACE, SoundSource.BLOCKS, 1, 1);
				return InteractionResult.SUCCESS;
			} else { // increases index
				pLevel.setBlock(pPos, pState.setValue(FRAME_MOTIVE, currentModel + 1), 3);
				pLevel.playSound(null, pPos, SoundEvents.PAINTING_PLACE, SoundSource.BLOCKS, 1, 1);
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.SUCCESS;
	}

	public VoxelShape getShape(BlockState p_56331_, BlockGetter p_56332_, BlockPos p_56333_,
			CollisionContext p_56334_) {
		return SHAPE;
	}

	public PushReaction getPistonPushReaction(BlockState p_153494_) {
		return PushReaction.DESTROY;
	}

	public VoxelShape getOcclusionShape(BlockState p_56336_, BlockGetter p_56337_, BlockPos p_56338_) {
		return Shapes.empty();
	}

	public BlockState getStateForPlacement(BlockPlaceContext context) {
		final int min = 0;
		final int max = modelcount;
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min));

		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite())
				.setValue(FRAME_MOTIVE, randomNum);
	}

	// creates blockstate
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		super.createBlockStateDefinition(pBuilder);
		pBuilder.add(FRAME_MOTIVE, FACING);
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, BlockGetter getter, List<Component> component, TooltipFlag flag) {
		if (!Screen.hasShiftDown()) {
			component.add(Component.literal("Hold SHIFT for more info.").withStyle(ChatFormatting.YELLOW));
		}

		if (Screen.hasShiftDown()) {
			component.add(Component.literal("Places Frame with a random motive.")
					.withStyle(ChatFormatting.GRAY));
			component.add(Component.literal("Shift-Rightclick on Block to change model.")
					.withStyle(ChatFormatting.GRAY));
		}
		super.appendHoverText(stack, getter, component, flag);
	}
}
