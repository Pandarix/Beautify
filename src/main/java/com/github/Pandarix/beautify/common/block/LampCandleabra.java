package com.github.Pandarix.beautify.common.block;

import com.github.Pandarix.beautify.util.KeyBoardHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
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

public class LampCandleabra extends LanternBlock {
	public static final BooleanProperty ON = BooleanProperty.create("on");
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	private static final VoxelShape SHAPE_HANGING = Shapes.join(Block.box(0, 2, 6.5, 16, 16, 9.5), Block.box(6.5, 2, 0, 9.5, 16, 16), BooleanOp.OR);
	private static final VoxelShape SHAPE_STANDING = Block.box(4, 0, 4, 12, 13, 12);

	public LampCandleabra(Properties p_153465_) {
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
		if (!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {
			// Ignite/Extinguish
			if (pState.getValue(ON) && !KeyBoardHelper.isHoldingShift() && pPlayer.getItemInHand(pHand).isEmpty()) {
				pLevel.setBlock(pPos, pState.setValue(ON, !pState.getValue(ON)), 3);
				pLevel.playSound((Player) null, pPos, SoundEvents.CANDLE_EXTINGUISH, SoundSource.BLOCKS, 0.25F, 0.5f);
				return InteractionResult.SUCCESS;
			} else if (!pState.getValue(ON) && pPlayer.getItemInHand(pHand).is(Items.FLINT_AND_STEEL)) {
				pLevel.setBlock(pPos, pState.setValue(ON, !pState.getValue(ON)), 3);
				pLevel.playSound((Player) null, pPos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 0.25F, 1f);
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.SUCCESS;
	}

	public void animateTick(BlockState p_57494_, Level p_57495_, BlockPos p_57496_, RandomSource p_57497_) {
		double d0 = (double) p_57496_.getX() + 0.5D;
		double d1 = (double) p_57496_.getY() + 1D;
		double d2 = (double) p_57496_.getZ() + 0.5D;

		if (p_57494_.getValue(ON)) {
			if (p_57494_.getValue(HANGING)) {
				p_57495_.addParticle(ParticleTypes.SMALL_FLAME, d0 + 0.4, d1 - 0.15, d2, 0.0D, 0.0D, 0.0D);
				p_57495_.addParticle(ParticleTypes.SMALL_FLAME, d0 - 0.4, d1 - 0.15, d2, 0.0D, 0.0D, 0.0D);
				p_57495_.addParticle(ParticleTypes.SMALL_FLAME, d0, d1 - 0.15, d2 + 0.4, 0.0D, 0.0D, 0.0D);
				p_57495_.addParticle(ParticleTypes.SMALL_FLAME, d0, d1 - 0.15, d2 - 0.4, 0.0D, 0.0D, 0.0D);
			} else {
				if (p_57494_.getValue(FACING) == Direction.EAST || p_57494_.getValue(FACING) == Direction.WEST) {
					p_57495_.addParticle(ParticleTypes.SMALL_FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);
					p_57495_.addParticle(ParticleTypes.SMALL_FLAME, d0, d1 + 0.05, d2 + 0.35, 0.0D, 0.0D, 0.0D);
					p_57495_.addParticle(ParticleTypes.SMALL_FLAME, d0, d1 + 0.05, d2 - 0.35, 0.0D, 0.0D, 0.0D);
				} else {
					p_57495_.addParticle(ParticleTypes.SMALL_FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);
					p_57495_.addParticle(ParticleTypes.SMALL_FLAME, d0 + 0.35, d1 + 0.05, d2, 0.0D, 0.0D, 0.0D);
					p_57495_.addParticle(ParticleTypes.SMALL_FLAME, d0 - 0.35, d1 + 0.05, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		super.createBlockStateDefinition(pBuilder);
		pBuilder.add(FACING, ON);
	}

	/*
	 * @Override public void appendHoverText(ItemStack stack, BlockGetter getter,
	 * List<Component> tooltip, TooltipFlag flag) { if
	 * (!KeyBoardHelper.isHoldingShift()) { tooltip.add( new
	 * TextComponent("\u00A77Hold\u00A77 \u00A7e\u00A7oSHIFT\u00A7o\u00A7r \u00A77for more.\u00A77"
	 * )); }
	 * 
	 * if (KeyBoardHelper.isHoldingShift()) { tooltip.add(new
	 * TextComponent("\u00A77Rightclick to turn on/off.\u00A77")); }
	 * super.appendHoverText(stack, getter, tooltip, flag); }
	 */
}
