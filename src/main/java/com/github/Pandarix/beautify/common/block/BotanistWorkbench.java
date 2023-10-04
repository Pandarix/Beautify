package com.github.Pandarix.beautify.common.block;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BotanistWorkbench extends HorizontalDirectionalBlock {

	private static final VoxelShape SHAPE_NORTH = Shapes.or(box(2, 0, 0, 16, 12, 14.25),
			box(9.5, 12, 8.5, 13.5, 16, 12.5));
	private static final VoxelShape SHAPE_SOUTH = Shapes.or(box(0, 0, 1.75, 14, 12, 16),
			box(2.5, 12, 3.5, 6.5, 16, 7.5));
	private static final VoxelShape SHAPE_EAST = Shapes.or(box(1.75, 0, 2, 16, 12, 16),
			box(3.5, 12, 9.5, 7.5, 16, 13.5));
	private static final VoxelShape SHAPE_WEST = Shapes.or(box(0, 0, 0, 14.25, 12, 14),
			box(8.5, 12, 2.5, 12.5, 16, 6.5));

	public BotanistWorkbench(Properties p_49795_) {
		super(p_49795_);
		this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
		case NORTH -> SHAPE_NORTH;
		case SOUTH -> SHAPE_SOUTH;
		case EAST -> SHAPE_EAST;
		case WEST -> SHAPE_WEST;
		default -> SHAPE_NORTH;
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		super.createBlockStateDefinition(pBuilder);
		pBuilder.add(FACING);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, BlockGetter getter, List<Component> component, TooltipFlag flag) {
		if (!Screen.hasShiftDown()) {
			component.add(Component.translatable("tooltip.shift").withStyle(ChatFormatting.YELLOW));
		} else {
			component.add(Component.translatable("botanist_workbench.description").withStyle(ChatFormatting.GRAY));
		}
		super.appendHoverText(stack, getter, component, flag);
	}
}
