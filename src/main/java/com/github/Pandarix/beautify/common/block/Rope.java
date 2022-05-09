package com.github.Pandarix.beautify.common.block;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class Rope extends ChainBlock {
	public Rope(BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.valueOf(false))
				.setValue(AXIS, Direction.Axis.Y));
	}
}
