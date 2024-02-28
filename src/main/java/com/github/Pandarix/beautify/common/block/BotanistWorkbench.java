package com.github.Pandarix.beautify.common.block;

import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;
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
	public static final MapCodec<BotanistWorkbench> WORKBENCH_MAP_CODEC = simpleCodec(BotanistWorkbench::new);
	//Map of hitboxes for direction the model can be facing
	private static final Map<Direction, VoxelShape> SHAPES_FOR_MODEL = ImmutableMap.of(
			Direction.NORTH, Shapes.or(box(2, 0, 0, 16, 12, 14.25),
					box(9.5, 12, 8.5, 13.5, 16, 12.5)),
			Direction.SOUTH, Shapes.or(box(0, 0, 1.75, 14, 12, 16),
					box(2.5, 12, 3.5, 6.5, 16, 7.5)),
			Direction.WEST, Shapes.or(box(0, 0, 0, 14.25, 12, 14),
					box(8.5, 12, 2.5, 12.5, 16, 6.5)),
			Direction.EAST, Shapes.or(box(1.75, 0, 2, 16, 12, 16),
					box(3.5, 12, 9.5, 7.5, 16, 13.5))
	);

	public BotanistWorkbench(Properties p_49795_) {
		super(p_49795_);
		this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
	}

	@Override
	protected MapCodec<? extends HorizontalDirectionalBlock> codec()
	{
		return WORKBENCH_MAP_CODEC;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return SHAPES_FOR_MODEL.get(blockState.getValue(FACING));
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
