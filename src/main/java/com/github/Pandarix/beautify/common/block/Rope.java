package com.github.Pandarix.beautify.common.block;

import java.util.List;

import com.github.Pandarix.beautify.core.init.BlockInit;
import com.github.Pandarix.beautify.util.KeyBoardHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;

public class Rope extends ChainBlock {
	public Rope(BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.valueOf(false))
				.setValue(AXIS, Direction.Axis.Y));
	}

	@Override
	public void appendHoverText(ItemStack stack, BlockGetter getter, List<Component> tooltip, TooltipFlag flag) {
		if (!KeyBoardHelper.isHoldingShift()) {
			tooltip.add(
					new TextComponent("\u00A77Hold\u00A77 \u00A7e\u00A7oSHIFT\u00A7o\u00A7r \u00A77for more.\u00A77"));
		}

		if (KeyBoardHelper.isHoldingShift()) {
			tooltip.add(new TextComponent(
					"\u00A77Placable like chains and climbable. Nice addition to\u00A77 \u00A7ohanging pots.\u00A7o"));
		}
		super.appendHoverText(stack, getter, tooltip, flag);
	}

	@Override
	public boolean isLadder(BlockState state, LevelReader level, BlockPos pos, LivingEntity entity) {
		if (state.is(BlockInit.ROPE.get())) {
			return true;
		}
		return super.isLadder(state, level, pos, entity);
	}

	public PushReaction getPistonPushReaction(BlockState p_153494_) {
		return PushReaction.DESTROY;
	}

	@Override
	public boolean makesOpenTrapdoorAboveClimbable(BlockState state, LevelReader level, BlockPos pos,
			BlockState trapdoorState) {
		if (state.is(BlockInit.ROPE.get())) {
			return true;
		} else {
			return super.makesOpenTrapdoorAboveClimbable(state, level, pos, trapdoorState);
		}
	}
}
