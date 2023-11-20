package com.github.Pandarix.beautify.common.block;

import com.github.Pandarix.beautify.core.init.BlockInit;
import com.github.Pandarix.beautify.core.init.SoundInit;
import com.google.common.collect.ImmutableMap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class BookStack extends HorizontalDirectionalBlock {
	private static final int MODELCOUNT = 7; // number of models the bookstack has
	public static final IntegerProperty BOOKSTACK_MODEL = IntegerProperty.create("bookstack_model", 0, MODELCOUNT - 1);

	//Map of hitboxes for every model the model can be
	private static final Map<Integer, VoxelShape> SHAPES_FOR_MODEL = ImmutableMap.of(
			0, Shapes.or(Block.box(1, 0, 1, 15, 4, 15)),
			1, Shapes.or(Block.box(1, 0, 1, 15, 4, 15)),
			2, Shapes.or(Block.box(0, 0, 0, 16, 1.5, 16)),
			3, Shapes.or(Block.box(0, 0, 0, 16, 9.5, 16)),
			4, Shapes.or(Block.box(1, 0, 1, 15, 5, 15)),
			5, Shapes.or(Block.box(0.5, 0, 0.5, 15.5, 7.25, 15.5)),
			6, Shapes.or(Block.box(1, 0, 1, 15, 12, 15))
	);

	public BookStack(Properties p_49795_) {
		super(p_49795_);
		this.registerDefaultState(
				this.defaultBlockState().setValue(BOOKSTACK_MODEL, 0).setValue(FACING, Direction.NORTH));
	}

	@Override
	public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return SHAPES_FOR_MODEL.get(blockState.getValue(BOOKSTACK_MODEL));
	}

	@Override
	public BlockState updateShape(BlockState p_60541_, Direction p_60542_, BlockState p_60543_, LevelAccessor p_60544_,
			BlockPos p_60545_, BlockPos p_60546_) {
		if (!p_60541_.canSurvive(p_60544_, p_60545_)) {
			p_60544_.scheduleTick(p_60545_, this, 1);
		}
		return super.updateShape(p_60541_, p_60542_, p_60543_, p_60544_, p_60545_, p_60546_);
	}

	@Override
	public boolean canSurvive(BlockState p_49395_, LevelReader p_49396_, BlockPos p_49397_) {
		return canSupportRigidBlock(p_49396_, p_49397_.below());
	}

	public void tick(BlockState p_48896_, ServerLevel p_48897_, BlockPos p_48898_, Random p_48899_) {
		if (!p_48896_.canSurvive(p_48897_, p_48898_)) {
			p_48897_.destroyBlock(p_48898_, true);
		}
	}

	// changing the model of the bookstack by shift-rightclicking
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
			BlockHitResult pResult) {
		if(pLevel.isClientSide()){
			return InteractionResult.SUCCESS;
		}
		if (pHand == InteractionHand.MAIN_HAND && pPlayer.getItemInHand(pHand).isEmpty()
				&& pPlayer.isShiftKeyDown()) {
			int currentModel = pState.getValue(BOOKSTACK_MODEL); // current index
			pLevel.playSound(null, pPos, SoundInit.BOOKSTACK_NEXT.get(), SoundSource.BLOCKS, 1, 1);
			// reset if it surpasses the number of possible models
			if (currentModel + 1 > MODELCOUNT - 1) {
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

	@Override
	public void fallOn(Level p_152426_, BlockState p_152427_, BlockPos p_152428_, Entity p_152429_, float p_152430_) {
		p_152426_.playSound(null, p_152428_, SoundInit.BOOKSTACK_FALL.get(), SoundSource.BLOCKS, 1, 1);
		super.fallOn(p_152426_, p_152427_, p_152428_, p_152429_, p_152430_);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Random rand = new Random();
		int randomNum = rand.nextInt((MODELCOUNT));

		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite())
				.setValue(BOOKSTACK_MODEL, randomNum);
	}

	// creates blockstate
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		super.createBlockStateDefinition(pBuilder);
		pBuilder.add(BOOKSTACK_MODEL, FACING);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, BlockGetter getter, List<Component> component, TooltipFlag flag) {
		if (!Screen.hasShiftDown()) {
			component.add(Component.translatable("tooltip.shift").withStyle(ChatFormatting.YELLOW));
		} else {
			component.add(Component.translatable("bookstack.description1").withStyle(ChatFormatting.GRAY));
			component.add(Component.translatable("bookstack.description2").withStyle(ChatFormatting.GRAY));
		}
		super.appendHoverText(stack, getter, component, flag);
	}
}
