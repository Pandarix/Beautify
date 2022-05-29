package com.github.Pandarix.beautify.common.block;

import java.util.List;

import com.github.Pandarix.beautify.util.KeyBoardHelper;

import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class Rope extends ChainBlock {
	public Rope(BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.valueOf(false))
				.setValue(AXIS, Direction.Axis.Y));
	}
	
	@Override
	public void appendHoverText(ItemStack stack, BlockGetter getter, List<Component> tooltip, TooltipFlag flag) {
		if (!KeyBoardHelper.isHoldingShift()) {
			tooltip.add(new TextComponent("Hold \u00A7eSHIFT\u00A7r for more."));
		}

		if (KeyBoardHelper.isHoldingShift()) {
			tooltip.add(new TextComponent("Acts like Chains. Nice addition to \u00A7ehanging pots\u00A7r"));
		}
		super.appendHoverText(stack, getter, tooltip, flag);
	}
}
