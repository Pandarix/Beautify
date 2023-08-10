package com.github.Pandarix.beautify.common.block;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
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
		if(pLevel.isClientSide()){
			return InteractionResult.SUCCESS;
		}
		if (pHand == InteractionHand.MAIN_HAND && pPlayer.getItemInHand(pHand).isEmpty()) {
			pLevel.setBlock(pPos, pState.setValue(ON, !pState.getValue(ON)), 3);
			float f = pState.getValue(ON) ? 0.5F : 0.6F;
			pLevel.playSound((Player) null, pPos, SoundEvents.LEVER_CLICK, SoundSource.BLOCKS, 0.25F, f);
		}

		return InteractionResult.SUCCESS;
	}

	public void animateTick(BlockState p_57494_, Level p_57495_, BlockPos p_57496_, RandomSource p_57497_) {
		double d0 = (double) p_57496_.getX() + 0.5D;
		double d1 = (double) p_57496_.getY() + 0.7D;
		double d2 = (double) p_57496_.getZ() + 0.5D;

		if (p_57497_.nextBoolean() && p_57494_.getValue(ON)) {
			if (p_57494_.getValue(HANGING)) {
				p_57495_.addParticle(ParticleTypes.SMOKE, d0, d1 - 0.3, d2, 0.0D, 0.0D, 0.0D);
			} else {
				p_57495_.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
			}
		}
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
			component.add(Component.translatable("tooltip.shift").withStyle(ChatFormatting.YELLOW));
		} else {
			component.add(Component.translatable(this.getName().getString().replaceAll(" ", "_").toLowerCase() + ".description1").withStyle(ChatFormatting.GRAY));
			component.add(Component.translatable(this.getName().getString().replaceAll(" ", "_").toLowerCase() + ".description2").withStyle(ChatFormatting.GRAY));
		}
		super.appendHoverText(stack, getter, component, flag);
	}
}
