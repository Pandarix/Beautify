package com.github.Pandarix.beautify.common.block;

import com.github.Pandarix.beautify.core.init.SoundInit;
import com.github.Pandarix.beautify.util.Config;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class OakBlinds extends HorizontalDirectionalBlock {
	// Voxelshapes; Hidden = Blind not visible
	private static final VoxelShape OPEN_NORTH = Block.box(0, 13, 13, 16, 16, 16);
	private static final VoxelShape OPEN_SOUTH = Block.box(0, 13, 0, 16, 16, 3);
	private static final VoxelShape OPEN_WEST = Block.box(13, 13, 0, 16, 16, 16);
	private static final VoxelShape OPEN_EAST = Block.box(0, 13, 0, 3, 16, 16);
	private static final VoxelShape CLOSED_SOUTH = Block.box(0, 0, 0, 16, 16, 2);
	private static final VoxelShape CLOSED_NORTH = Block.box(0, 0, 13, 16, 16, 16);
	private static final VoxelShape CLOSED_EAST = Block.box(0, 0, 0, 3, 16, 16);
	private static final VoxelShape CLOSED_WEST = Block.box(13, 0, 0, 16, 16, 16);
	private static final VoxelShape SHAPE_HIDDEN = Block.box(0, 0, 0, 0, 0, 0);
	// Open = true if blinds are down; Hidden = true if blinds are closed and there
	// is a blind above
	public static final BooleanProperty OPEN = BooleanProperty.create("open");
	public static final BooleanProperty HIDDEN = BooleanProperty.create("hidden");

	// constructor
	public OakBlinds(Properties p_54120_) {
		super(p_54120_);
		this.registerDefaultState(this.defaultBlockState().setValue(OPEN, false).setValue(FACING, Direction.NORTH)
				.setValue(HIDDEN, false));
	}

	// check for facing placement, hidden is false per default
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite())
				.setValue(OPEN, false).setValue(HIDDEN, false);
	}

	// creating blockstates
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		super.createBlockStateDefinition(pBuilder);
		pBuilder.add(OPEN, FACING, HIDDEN);
	}

	// INTERACTION
	// changes blockstates:
	// OPEN: open <-> closed
	// HIDDEN: false <-> true if below root
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
			BlockHitResult pResult) {
		if (!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND && pPlayer.getItemInHand(pHand).isEmpty()) {
			// stores last value of blind
			final boolean currentlyOpen = pState.getValue(OPEN);
			
			// if the blinds open from the root
			// search for the position of the topmost blind and set the pPos
			if (Config.OPENS_FROM_ROOT.get()) {
				int step = 1;
				while (sameBlindType(pLevel, pPos.above(step), pState)) {
					++step;
				}
				pPos = pPos.above(step-1);
			}

			{
				// changes clicked blind: open <-> closed
				pLevel.setBlock(pPos, pState.setValue(OPEN, !currentlyOpen), 3);

				// CODE BELOW IS DISABLED IF SEARCHRADIUS = 0
				// checks for blinds below clicked blind: open <-> closed, hidden=true
				if (Config.SEARCHRADIUS.get() > 0) {
					for (int offsetDown = 1; offsetDown <= Config.SEARCHRADIUS.get(); ++offsetDown) {
						if (sameBlindType(pLevel, pPos.below(offsetDown), pState)) {
							switchOpenUpdateHidden(pLevel, pPos.below(offsetDown), pState, false);
						} else {
							break;
						}
					}
				}

				if (Config.SEARCHRADIUS.get() > 0) {
					// FOR BLINDS ON NORTH-SOUTH AXIS
					if (pState.getValue(FACING) == Direction.NORTH || pState.getValue(FACING) == Direction.SOUTH) {

						// checks blinds east of clicked blind
						for (int offsetEast = 1; offsetEast <= (int) Config.SEARCHRADIUS.get() / 2; ++offsetEast) {
							if (sameBlindType(pLevel, pPos.east(offsetEast), pState)) {
								// changes east blinds: open <-> closed
								pLevel.setBlock(pPos.east(offsetEast), pState.setValue(OPEN, !currentlyOpen), 3);
								// checks for blinds below east blinds: open <-> closed, hidden=true
								for (int offsetDown = 1; offsetDown <= Config.SEARCHRADIUS.get(); ++offsetDown) {
									if (sameBlindType(pLevel, pPos.below(offsetDown).east(offsetEast), pState)) {
										switchOpenUpdateHidden(pLevel, pPos.below(offsetDown).east(offsetEast), pState,
												false);
									} else {
										break;
									}
								}
							} else {
								break;
							}
						}

						// checks blinds west of clicked blind
						for (int offsetWest = 1; offsetWest <= Config.SEARCHRADIUS.get() / 2; ++offsetWest) {
							if (sameBlindType(pLevel, pPos.west(offsetWest), pState)) {
								// changes west blinds: open <-> closed
								pLevel.setBlock(pPos.west(offsetWest), pState.setValue(OPEN, !currentlyOpen), 3);
								// checks for blinds below west blinds: open <-> closed, hidden=true
								for (int offsetDown = 1; offsetDown <= Config.SEARCHRADIUS.get(); ++offsetDown) {
									if (sameBlindType(pLevel, pPos.below(offsetDown).west(offsetWest), pState)) {
										switchOpenUpdateHidden(pLevel, pPos.below(offsetDown).west(offsetWest), pState,
												false);
									} else {
										break;
									}
								}
							} else {
								break;
							}
						}
					}

					// FOR BLINDS ON EAST-WEST AXIS
					if (pState.getValue(FACING) == Direction.EAST || pState.getValue(FACING) == Direction.WEST) {

						// checks blinds north of clicked blind
						for (int offsetNorth = 1; offsetNorth <= Config.SEARCHRADIUS.get() / 2; ++offsetNorth) {
							if (sameBlindType(pLevel, pPos.north(offsetNorth), pState)) {
								// changes north blinds: open <-> closed
								pLevel.setBlock(pPos.north(offsetNorth), pState.setValue(OPEN, !currentlyOpen), 3);
								// checks for blinds below north blinds: open <-> closed, hidden=true
								for (int offsetDown = 1; offsetDown <= Config.SEARCHRADIUS.get(); ++offsetDown) {
									if (sameBlindType(pLevel, pPos.below(offsetDown).north(offsetNorth), pState)) {
										switchOpenUpdateHidden(pLevel, pPos.below(offsetDown).north(offsetNorth),
												pState, false);
									} else {
										break;
									}
								}
							} else {
								break;
							}
						}

						// checks blinds south of clicked blind
						for (int offsetSouth = 1; offsetSouth <= Config.SEARCHRADIUS.get() / 2; ++offsetSouth) {
							if (sameBlindType(pLevel, pPos.south(offsetSouth), pState)) {
								// changes south blinds: open <-> closed
								pLevel.setBlock(pPos.south(offsetSouth), pState.setValue(OPEN, !currentlyOpen), 3);
								// checks for blinds below south blinds: open <-> closed, hidden=true
								for (int offsetDown = 1; offsetDown <= Config.SEARCHRADIUS.get(); ++offsetDown) {
									if (sameBlindType(pLevel, pPos.below(offsetDown).south(offsetSouth), pState)) {
										switchOpenUpdateHidden(pLevel, pPos.below(offsetDown).south(offsetSouth),
												pState, false);
									} else {
										break;
									}
								}
							} else {
								break;
							}
						}
					}
					pLevel.playSound(null, pPos,
							currentlyOpen ? SoundInit.BLINDS_CLOSE.get() : SoundInit.BLINDS_OPEN.get(),
							SoundSource.BLOCKS, 1, 1);
					return InteractionResult.SUCCESS;
				}
			}
		}
		return InteractionResult.SUCCESS;
	}

	// returns: true/false if
	// block in pLevel at pPos is the same kind of blind
	// and facing is the same as pState
	private final boolean sameBlindType(Level pLevel, BlockPos pPos, BlockState pState) {
		return pLevel.getBlockState(pPos).getBlock().getClass() == this.getClass()
				&& pLevel.getBlockState(pPos).getValue(FACING) == pState.getValue(FACING);
	}

	// method for changing the blockstates of blinds
	// if updateOnly is true, only HIDDEN is changed
	// if updateOnly is false, the blind will also open or close
	private final void switchOpenUpdateHidden(Level pLevel, BlockPos pPos, BlockState pState, boolean updateOnly) {
		if (updateOnly) {
			pLevel.setBlock(pPos, pState.setValue(HIDDEN, false), 3);
			return;
		}

		if (!pState.getValue(OPEN)) {
			pLevel.setBlock(pPos, pState.setValue(OPEN, true).setValue(HIDDEN, false), 3);
		} else {
			pLevel.setBlock(pPos, pState.setValue(OPEN, false).setValue(HIDDEN, true), 3);
		}
	}

	// method to prevent hidden blinds from being unaccessible
	// after root block is destroyed.
	// updates blind below the destroyed block.
	@Override
	public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest,
			FluidState fluid) {
		if (sameBlindType(level, pos.below(), state)) {
			switchOpenUpdateHidden(level, pos.below(), state, true);
		}
		return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
	}

	// Shape switch
	// hidden = invisible model
	// OPEN_X = models of blinds that are down
	// CLOSED_X= models of blinds that are up
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
		if (state.getValue(HIDDEN)) {
			return SHAPE_HIDDEN;
		}

		if (!state.getValue(OPEN)) {
			return switch (state.getValue(FACING)) {
			case NORTH -> OPEN_NORTH;
			case SOUTH -> OPEN_SOUTH;
			case WEST -> OPEN_WEST;
			case EAST -> OPEN_EAST;
			default -> OPEN_NORTH;
			};
		}

		return switch (state.getValue(FACING)) {
		case NORTH -> CLOSED_NORTH;
		case SOUTH -> CLOSED_SOUTH;
		case WEST -> CLOSED_WEST;
		case EAST -> CLOSED_EAST;
		default -> CLOSED_NORTH;
		};
	}

	/*
	// Tooltips
	@Override
	public void appendHoverText(ItemStack stack, BlockGetter getter, List<Component> tooltip, TooltipFlag flag) {
		if (!KeyBoardHelper.isHoldingShift()) {
			tooltip.add(
					new TextComponent("\u00A77Hold\u00A77 \u00A7e\u00A7oSHIFT\u00A7o\u00A7r \u00A77for more.\u00A77"));
		}

		if (KeyBoardHelper.isHoldingShift()) {
			tooltip.add(
					new TextComponent("\u00A77Rightclick on Block to open or close blind and adjacent ones.\u00A77"));
			tooltip.add(new TextComponent(
					"\u00A7oNote:\u00A7o \u00A77After closing 1st time, blinds below topmost blind become invisible when open.\u00A77"));
		}
		super.appendHoverText(stack, getter, tooltip, flag);
	}
	*/
}
