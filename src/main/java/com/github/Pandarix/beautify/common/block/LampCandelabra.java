package com.github.Pandarix.beautify.common.block;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class LampCandelabra extends LanternBlock {
	public static final BooleanProperty ON = BooleanProperty.create("on");
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	private static final VoxelShape SHAPE_HANGING = Shapes.join(Block.box(0, 2, 6.5, 16, 16, 9.5), Block.box(6.5, 2, 0, 9.5, 16, 16), BooleanOp.OR);
	private static final VoxelShape SHAPE_STANDING = Block.box(4, 0, 4, 12, 13, 12);

	public LampCandelabra(Properties p_153465_) {
		super(p_153465_);
		this.registerDefaultState(this.defaultBlockState().setValue(ON, false).setValue(FACING, Direction.NORTH));
	}

	public BlockState getStateForPlacement(BlockPlaceContext context) {
		FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());

		for (Direction direction : context.getNearestLookingDirections()) {
			if (direction.getAxis() == Direction.Axis.Y) {
				BlockState blockstate = this.defaultBlockState().setValue(HANGING,
						Boolean.valueOf(direction == Direction.UP));
				if (blockstate.canSurvive(context.getLevel(), context.getClickedPos())) {
					return blockstate.setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER))
							.setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(ON, false);
				}
			}
		}
		return null;
	}

	@Override
	public VoxelShape getShape(BlockState p_153474_, BlockGetter p_153475_, BlockPos p_153476_,
			CollisionContext p_153477_) {
		if (p_153474_.getValue(HANGING)) {
			return SHAPE_HANGING;
		}
		return SHAPE_STANDING;
	}

	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
			BlockHitResult pResult) {
		if(pLevel.isClientSide()){
			return InteractionResult.SUCCESS;
		}
		if (pHand == InteractionHand.MAIN_HAND) {
			// Ignite/Extinguish
			if (pState.getValue(ON) && !pPlayer.isShiftKeyDown() && pPlayer.getItemInHand(pHand).isEmpty()) {
				pLevel.setBlock(pPos, pState.setValue(ON, !pState.getValue(ON)), 3);
				pLevel.playSound((Player) null, pPos, SoundEvents.CANDLE_EXTINGUISH, SoundSource.BLOCKS, 0.5F, 0.5f);
				return InteractionResult.SUCCESS;
			} else if (!pState.getValue(ON) && pPlayer.getItemInHand(pHand).is(Items.FLINT_AND_STEEL)) {
				pLevel.setBlock(pPos, pState.setValue(ON, !pState.getValue(ON)), 3);
				pLevel.playSound((Player) null, pPos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 0.5F, 1f);
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.SUCCESS;
	}

	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
		double d0 = (double) pos.getX() + 0.5D;
		double d1 = (double) pos.getY() + 1D;
		double d2 = (double) pos.getZ() + 0.5D;

		if (state.getValue(ON)) {
			if (state.getValue(HANGING)) {
				level.addParticle(ParticleTypes.SMALL_FLAME, d0 + 0.4, d1 - 0.15, d2, 0.0D, 0.0D, 0.0D);
				level.addParticle(ParticleTypes.SMALL_FLAME, d0 - 0.4, d1 - 0.15, d2, 0.0D, 0.0D, 0.0D);
				level.addParticle(ParticleTypes.SMALL_FLAME, d0, d1 - 0.15, d2 + 0.4, 0.0D, 0.0D, 0.0D);
				level.addParticle(ParticleTypes.SMALL_FLAME, d0, d1 - 0.15, d2 - 0.4, 0.0D, 0.0D, 0.0D);
			} else {
				if (state.getValue(FACING) == Direction.EAST || state.getValue(FACING) == Direction.WEST) {
					level.addParticle(ParticleTypes.SMALL_FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);
					level.addParticle(ParticleTypes.SMALL_FLAME, d0, d1 + 0.05, d2 + 0.35, 0.0D, 0.0D, 0.0D);
					level.addParticle(ParticleTypes.SMALL_FLAME, d0, d1 + 0.05, d2 - 0.35, 0.0D, 0.0D, 0.0D);
				} else {
					level.addParticle(ParticleTypes.SMALL_FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);
					level.addParticle(ParticleTypes.SMALL_FLAME, d0 + 0.35, d1 + 0.05, d2, 0.0D, 0.0D, 0.0D);
					level.addParticle(ParticleTypes.SMALL_FLAME, d0 - 0.35, d1 + 0.05, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		super.createBlockStateDefinition(pBuilder);
		pBuilder.add(FACING, ON);
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, BlockGetter getter, List<Component> component, TooltipFlag flag) {
		if (!Screen.hasShiftDown()) {
			component.add(Component.literal("Hold SHIFT for more info.").withStyle(ChatFormatting.YELLOW));
		}

		if (Screen.hasShiftDown()) {
			component.add(Component.literal("Can be placed hanging and standing like Lanterns.")
					.withStyle(ChatFormatting.GRAY));
			component.add(Component.literal("Rightclick with hand to turn off.")
					.withStyle(ChatFormatting.GRAY));
			component.add(Component.literal("Rightclick with Flint and Steel to turn on.")
					.withStyle(ChatFormatting.GRAY));
		}
		super.appendHoverText(stack, getter, component, flag);
	}
}
