package com.github.Pandarix.beautify.common.block;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class LampBamboo extends LanternBlock {
	public static final BooleanProperty ON = BooleanProperty.create("on");

	private static final VoxelShape SHAPE_HANGING = Block.box(2, 1, 2, 14, 12, 14);
	private static final VoxelShape SHAPE_STANDING = Block.box(4, 0, 4, 12, 13, 12);

	public LampBamboo(Properties p_153465_) {
		super(p_153465_);
		this.registerDefaultState(this.defaultBlockState().setValue(ON, true));
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
		if (!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND && pPlayer.getItemInHand(pHand).isEmpty()) {
			pLevel.setBlock(pPos, pState.setValue(ON, !pState.getValue(ON)), 3);
			float f = pState.getValue(ON) ? 0.5F : 0.6F;
			pLevel.playSound((Player) null, pPos, SoundEvents.LEVER_CLICK, SoundSource.BLOCKS, 0.25F, f);
		}

		return InteractionResult.SUCCESS;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		super.createBlockStateDefinition(pBuilder);
		pBuilder.add(ON);
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
			component.add(Component.literal("Rightclick to turn on/off.")
					.withStyle(ChatFormatting.GRAY));
		}
		super.appendHoverText(stack, getter, component, flag);
	}
}
