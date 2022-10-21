package com.github.Pandarix.beautify.common.block;

import java.util.List;
import java.util.Random;

import com.github.Pandarix.beautify.particle.ParticleInit;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class LampJar extends LanternBlock {
	private static final int maxLevel = 15;
	public static final IntegerProperty FILL_LEVEL = IntegerProperty.create("fill_level", 0, maxLevel);

	public LampJar(Properties p_153465_) {
		super(p_153465_);
		this.registerDefaultState(this.defaultBlockState().setValue(FILL_LEVEL, 0));
	}

	// Fill
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
			BlockHitResult pResult) {
		if (!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {

			ItemStack playerStack = pPlayer.getItemInHand(pHand);

			final int increase = 5;
			final int currentLevel = pState.getValue(FILL_LEVEL);

			// decreasing
			if (playerStack.isEmpty() && currentLevel > 0) {
				pPlayer.setItemInHand(pHand, new ItemStack(Items.GLOWSTONE_DUST, currentLevel / increase));
				pLevel.setBlock(pPos, pState.setValue(FILL_LEVEL, 0), 3);
				pLevel.playSound((Player) null, pPos, SoundEvents.AMETHYST_CLUSTER_BREAK, SoundSource.BLOCKS, 0.5F,
						0.5f);
				return InteractionResult.SUCCESS;
			}

			// increasing
			if (playerStack.is(Items.GLOWSTONE_DUST) && currentLevel + increase <= maxLevel) {
				playerStack.shrink(1);
				pLevel.setBlock(pPos, pState.setValue(FILL_LEVEL, currentLevel + increase), 3);
				pLevel.playSound((Player) null, pPos, SoundEvents.AMETHYST_BLOCK_HIT, SoundSource.BLOCKS, 0.5F, 0.5f);
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		super.createBlockStateDefinition(pBuilder);
		pBuilder.add(FILL_LEVEL);
	}
	
	public void m_7100_(BlockState pState, Level pLevel, BlockPos pPos, Random rand) {
		double posX = (pPos.getX() + 0.35) + rand.nextDouble() / 3.5;
		double posY = (pPos.getY() + 0.1) + rand.nextDouble() / 3.5;
		double posZ = (pPos.getZ() + 0.35) + rand.nextDouble() / 3.5;

		if (pState.getValue(FILL_LEVEL) >= 5 && pState.getValue(FILL_LEVEL) < 10) {
			if (rand.nextBoolean()) {
				pLevel.addParticle(ParticleInit.GLOWESSENCE_PARTICLES.get(), posX, posY, posZ, randomDir(rand), 0.01,
						randomDir(rand));
			}
		} else if (pState.getValue(FILL_LEVEL) >= 10 && pState.getValue(FILL_LEVEL) < 15) {
			if (rand.nextBoolean()) {
				pLevel.addParticle(ParticleInit.GLOWESSENCE_PARTICLES.get(), posX, posY, posZ, randomDir(rand), 0.01,
						randomDir(rand));
			}
			posX = (pPos.getX() + 0.35) + rand.nextDouble() / 3.5;
			posY = (pPos.getY() + 0.1) + rand.nextDouble() / 3.5;
			posZ = (pPos.getZ() + 0.35) + rand.nextDouble() / 3.5;
			pLevel.addParticle(ParticleInit.GLOWESSENCE_PARTICLES.get(), posX, posY, posZ, randomDir(rand), 0.01,
					randomDir(rand));
		} else if (pState.getValue(FILL_LEVEL) == 15) {
			if (rand.nextBoolean()) {
				pLevel.addParticle(ParticleInit.GLOWESSENCE_PARTICLES.get(), posX, posY, posZ, randomDir(rand), 0.01,
						randomDir(rand));
			}

			posX = (pPos.getX() + 0.35) + rand.nextDouble() / 3.5;
			posY = (pPos.getY() + 0.1) + rand.nextDouble() / 3.5;
			posZ = (pPos.getZ() + 0.35) + rand.nextDouble() / 3.5;
			pLevel.addParticle(ParticleInit.GLOWESSENCE_PARTICLES.get(), posX, posY, posZ, randomDir(rand), 0.01,
					randomDir(rand));

			posX = (pPos.getX() + 0.35) + rand.nextDouble() / 3.5;
			posY = (pPos.getY() + 0.1) + rand.nextDouble() / 3.5;
			posZ = (pPos.getZ() + 0.35) + rand.nextDouble() / 3.5;
			pLevel.addParticle(ParticleInit.GLOWESSENCE_PARTICLES.get(), posX, posY, posZ, randomDir(rand), 0.01,
					randomDir(rand));
		}
	}

	private static double randomDir(Random rand) {
		return (rand.nextInt(2) - 1) * rand.nextFloat() / 34;
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, BlockGetter getter, List<Component> component, TooltipFlag flag) {
		if (!Screen.hasShiftDown()) {
			component.add(new TranslatableComponent("tooltip.beautify.tooltip.shift").withStyle(ChatFormatting.YELLOW));
		}

		if (Screen.hasShiftDown()) {
			component.add(new TranslatableComponent("tooltip.beautify.lamp_jar.info").withStyle(ChatFormatting.GRAY));
		}
		super.appendHoverText(stack, getter, component, flag);
	}
}
