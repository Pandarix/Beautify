package com.github.Pandarix.beautify.common.item;

import com.github.Pandarix.beautify.core.init.BlockInit;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class LampShadeItem extends Item {
	private static final Block LampShadeBlock = BlockInit.BOOKSTACK.get();

	public LampShadeItem(Properties p_41383_) {
		super(p_41383_);
	}

	@Override
	public InteractionResult useOn(UseOnContext pContext) {
		if (pContext.getClickedPos() == null) {
			return super.useOn(pContext);
		}
		if (!pContext.getLevel().isClientSide() && pContext.getHand() == InteractionHand.MAIN_HAND
				&& isLantern(pContext)) {
			pContext.getLevel().setBlock(pContext.getClickedPos(), LampShadeBlock.defaultBlockState(), 3);
		}
		return super.useOn(pContext);
	}

	private boolean isLantern(UseOnContext pContext) {
		return pContext.getLevel().getBlockState(pContext.getClickedPos()).getBlock().equals(Blocks.LANTERN)
				|| pContext.getLevel().getBlockState(pContext.getClickedPos()).getBlock().equals(Blocks.SOUL_LANTERN);
	}
}
