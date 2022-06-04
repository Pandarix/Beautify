package com.github.Pandarix.beautify.common.block;

import java.util.List;

import com.github.Pandarix.beautify.util.Config;
import com.github.Pandarix.beautify.util.KeyBoardHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
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
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class OakBlinds extends HorizontalDirectionalBlock {
	private static final VoxelShape SHAPE_NORTH = Block.box(0, 13, 13, 16, 16, 16);
	private static final VoxelShape SHAPE_SOUTH = Block.box(0, 13, 0, 16, 16, 3);
	private static final VoxelShape SHAPE_WEST = Block.box(13, 13, 0, 16, 16, 16);
	private static final VoxelShape SHAPE_EAST = Block.box(0, 13, 0, 3, 16, 16);

	public static final BooleanProperty OPEN = BooleanProperty.create("open");

	public OakBlinds(Properties p_54120_) {
		super(p_54120_);
		this.registerDefaultState(this.defaultBlockState().setValue(OPEN, false).setValue(FACING, Direction.NORTH));
	}

	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(OPEN,
				false);
	}

	// changing the model of the blinds by shift-rightclicking
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
			BlockHitResult pResult) {
		if (!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND && pPlayer.getItemInHand(pHand).isEmpty()) {
			final boolean currentState = pState.getValue(OPEN); // current index

			{
				// changes clicked blinds
				pLevel.setBlock(pPos, pState.setValue(OPEN, !currentState), 3);
				// checks for blinds below clicked blind
				if (Config.SEARCHRADIUS.get() > 0) {

					for (int offsetDown = 1; offsetDown <= Config.SEARCHRADIUS.get(); ++offsetDown) {
						if (pLevel.getBlockState(pPos.below(offsetDown)).getBlock().getClass() == this.getClass()) {
							pLevel.setBlock(pPos.below(offsetDown), pState.setValue(OPEN, !currentState), 3);
						} else {
							break;
						}
					}
				}

				if (Config.SEARCHRADIUS.get() > 0) {
					// NORTH-SOUTH axis
					if (pState.getValue(FACING) == Direction.NORTH || pState.getValue(FACING) == Direction.SOUTH) {

						// checks blinds east of clicked blind
						for (int offsetEast = 1; offsetEast <= (int) Config.SEARCHRADIUS.get() / 2; ++offsetEast) {
							if (pLevel.getBlockState(pPos.east(offsetEast)).getBlock().getClass() == this.getClass()) {
								// changes east blinds
								pLevel.setBlock(pPos.east(offsetEast), pState.setValue(OPEN, !currentState), 3);
								// checks for blinds below east blinds
								for (int offsetDown = 1; offsetDown <= Config.SEARCHRADIUS.get(); ++offsetDown) {
									if (pLevel.getBlockState(pPos.below(offsetDown).east(offsetEast))
											.getBlock().getClass() == this.getClass()) {
										pLevel.setBlock(pPos.below(offsetDown).east(offsetEast),
												pState.setValue(OPEN, !currentState), 3);
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
							if (pLevel.getBlockState(pPos.west(offsetWest)).getBlock().getClass() == this.getClass()) {
								// changes west blinds
								pLevel.setBlock(pPos.west(offsetWest), pState.setValue(OPEN, !currentState), 3);
								// checks for blinds below west blinds
								for (int offsetDown = 1; offsetDown <= Config.SEARCHRADIUS.get(); ++offsetDown) {
									if (pLevel.getBlockState(pPos.below(offsetDown).west(offsetWest))
											.getBlock().getClass() == this.getClass()) {
										pLevel.setBlock(pPos.below(offsetDown).west(offsetWest),
												pState.setValue(OPEN, !currentState), 3);
									} else {
										break;
									}
								}
							} else {
								break;
							}
						}
					}

					// EAST-WEST axis
					if (pState.getValue(FACING) == Direction.EAST || pState.getValue(FACING) == Direction.WEST) {

						// checks blinds north of clicked blind
						for (int offsetNorth = 1; offsetNorth <= Config.SEARCHRADIUS.get() / 2; ++offsetNorth) {
							if (pLevel.getBlockState(pPos.north(offsetNorth)).getBlock().getClass() == this.getClass()) {
								// changes north blinds
								pLevel.setBlock(pPos.north(offsetNorth), pState.setValue(OPEN, !currentState), 3);
								// checks for blinds below north blinds
								for (int offsetDown = 1; offsetDown <= Config.SEARCHRADIUS.get(); ++offsetDown) {
									if (pLevel.getBlockState(pPos.below(offsetDown).north(offsetNorth))
											.getBlock().getClass() == this.getClass()) {
										pLevel.setBlock(pPos.below(offsetDown).north(offsetNorth),
												pState.setValue(OPEN, !currentState), 3);
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
							if (pLevel.getBlockState(pPos.south(offsetSouth)).getBlock().getClass() == this.getClass()) {
								// changes south blinds
								pLevel.setBlock(pPos.south(offsetSouth), pState.setValue(OPEN, !currentState), 3);
								// checks for blinds below south blinds
								for (int offsetDown = 1; offsetDown <= Config.SEARCHRADIUS.get(); ++offsetDown) {
									if (pLevel.getBlockState(pPos.below(offsetDown).south(offsetSouth))
											.getBlock().getClass() == this.getClass()) {
										pLevel.setBlock(pPos.below(offsetDown).south(offsetSouth),
												pState.setValue(OPEN, !currentState), 3);
									} else {
										break;
									}
								}
							} else {
								break;
							}
						}
					}
				    pLevel.levelEvent((Player)null, currentState ? 1007 : 1013, pPos, 0);
					return InteractionResult.SUCCESS;

				}
			}
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
		case NORTH -> SHAPE_NORTH;
		case SOUTH -> SHAPE_SOUTH;
		case WEST -> SHAPE_WEST;
		case EAST -> SHAPE_EAST;
		default -> SHAPE_NORTH;
		};
	}

	@Override
	public void appendHoverText(ItemStack stack, BlockGetter getter, List<Component> tooltip, TooltipFlag flag) {
		if (!KeyBoardHelper.isHoldingShift()) {
			tooltip.add(
					new TextComponent("\u00A77Hold\u00A77 \u00A7e\u00A7oSHIFT\u00A7o\u00A7r \u00A77for more.\u00A77"));
		}

		if (KeyBoardHelper.isHoldingShift()) {
			tooltip.add(new TextComponent("\u00A77Rightclick on Block to open or close.\u00A77"));
		}
		super.appendHoverText(stack, getter, tooltip, flag);
	}

	// creates blockstate
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		super.createBlockStateDefinition(pBuilder);
		pBuilder.add(OPEN, FACING);
	}
}
