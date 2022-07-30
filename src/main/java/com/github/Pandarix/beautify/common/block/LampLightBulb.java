package com.github.Pandarix.beautify.common.block;

import java.util.List;
import java.util.Random;

import com.github.Pandarix.beautify.util.KeyBoardHelper;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
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

public class LampLightBulb extends LanternBlock {
	public static final BooleanProperty ON = BooleanProperty.create("on");

	private static final VoxelShape SHAPE_HANGING = Block.box(5, 3, 5, 11, 16, 11);
	private static final VoxelShape SHAPE_STANDING = Block.box(4, 0, 4, 12, 13, 12);

	public LampLightBulb(Properties p_153465_) {
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

	public void m_7100_(BlockState state, Level level, BlockPos pos, Random random) {
		double d0 = (double) pos.getX() + 0.5D;
		double d1 = (double) pos.getY() + 0.7D;
		double d2 = (double) pos.getZ() + 0.5D;

		if (random.nextBoolean() && state.getValue(ON)) {
			if (state.getValue(HANGING)) {
				level.addParticle(ParticleTypes.SMOKE, d0, d1 - 0.3, d2, 0.0D, 0.0D, 0.0D);
			} else {
				level.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		super.createBlockStateDefinition(pBuilder);
		pBuilder.add(ON);
	}

	@Override
	public void appendHoverText(ItemStack stack, BlockGetter getter, List<Component> component, TooltipFlag flag) {
		if (!KeyBoardHelper.isHoldingShift()) {
			component.add(new TranslatableComponent("tooltip.beautify.tooltip.shift").withStyle(ChatFormatting.YELLOW));
		}

		if (KeyBoardHelper.isHoldingShift()) {
			component.add(new TranslatableComponent("tooltip.beautify.lamp.info").withStyle(ChatFormatting.GRAY));
		}
		super.appendHoverText(stack, getter, component, flag);
	}
}
