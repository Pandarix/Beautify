package com.github.Pandarix.beautify.event;

import java.util.List;

import com.github.Pandarix.beautify.Beautify;
import com.github.Pandarix.beautify.core.init.ItemInit;
import com.github.Pandarix.beautify.core.init.ModVillagers;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Beautify.MODID)
public class ModEvents {
	@SubscribeEvent
	public static void addCustomTrades(VillagerTradesEvent event) {
		// BOTANIST
		// lvl1
		if (event.getType() == ModVillagers.BOTANIST.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(ItemInit.HANGING_POT_ITEM.get(), 1);
			int villagerLevel = 1;

			trades.get(villagerLevel)
					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2), stack, 16, 6, 0.02F));
		}

		if (event.getType() == ModVillagers.BOTANIST.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(Items.FLOWER_POT, 2);
			int villagerLevel = 1;

			trades.get(villagerLevel)
					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), stack, 12, 5, 0.02F));
		}

		if (event.getType() == ModVillagers.BOTANIST.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(Items.VINE, 3);
			int villagerLevel = 1;

			trades.get(villagerLevel)
					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2), stack, 16, 4, 0.02F));
		}

		// lvl2
		if (event.getType() == ModVillagers.BOTANIST.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(ItemInit.OAK_TRELLIS_ITEM.get(), 2);
			int villagerLevel = 2;

			trades.get(villagerLevel)
					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 16, 3, 0.02F));
		}

		if (event.getType() == ModVillagers.BOTANIST.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(ItemInit.SPRUCE_TRELLIS_ITEM.get(), 2);
			int villagerLevel = 2;

			trades.get(villagerLevel)
					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 16, 3, 0.02F));
		}

		if (event.getType() == ModVillagers.BOTANIST.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(ItemInit.BIRCH_TRELLIS_ITEM.get(), 2);
			int villagerLevel = 2;

			trades.get(villagerLevel)
					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 16, 3, 0.02F));
		}

		if (event.getType() == ModVillagers.BOTANIST.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(ItemInit.JUNGLE_TRELLIS_ITEM.get(), 2);
			int villagerLevel = 2;

			trades.get(villagerLevel)
					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 16, 3, 0.02F));
		}

		if (event.getType() == ModVillagers.BOTANIST.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(ItemInit.ACACIA_TRELLIS_ITEM.get(), 2);
			int villagerLevel = 2;

			trades.get(villagerLevel)
					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 16, 3, 0.02F));
		}

		if (event.getType() == ModVillagers.BOTANIST.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(ItemInit.DARK_OAK_TRELLIS_ITEM.get(), 2);
			int villagerLevel = 2;

			trades.get(villagerLevel)
					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 16, 3, 0.02F));
		}

		if (event.getType() == ModVillagers.BOTANIST.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(ItemInit.MANGROVE_TRELLIS_ITEM.get(), 2);
			int villagerLevel = 2;

			trades.get(villagerLevel)
					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 16, 3, 0.02F));
		}

		if (event.getType() == ModVillagers.BOTANIST.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(ItemInit.CRIMSON_TRELLIS_ITEM.get(), 2);
			int villagerLevel = 2;

			trades.get(villagerLevel)
					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 16, 3, 0.02F));
		}

		if (event.getType() == ModVillagers.BOTANIST.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(ItemInit.WARPED_TRELLIS_ITEM.get(), 2);
			int villagerLevel = 2;

			trades.get(villagerLevel)
					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 16, 3, 0.02F));
		}

		if (event.getType() == ModVillagers.BOTANIST.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(Items.BIG_DRIPLEAF, 3);
			int villagerLevel = 2;

			trades.get(villagerLevel)
					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), stack, 6, 9, 0.02F));
		}

		if (event.getType() == ModVillagers.BOTANIST.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(Items.SMALL_DRIPLEAF, 4);
			int villagerLevel = 2;

			trades.get(villagerLevel)
					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), stack, 6, 8, 0.02F));
		}

		// lvl3
		if (event.getType() == ModVillagers.BOTANIST.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(Items.LILY_PAD, 4);
			int villagerLevel = 3;

			trades.get(villagerLevel)
					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 8, 5, 0.02F));
		}

		if (event.getType() == ModVillagers.BOTANIST.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(Items.SPORE_BLOSSOM, 1);
			int villagerLevel = 3;

			trades.get(villagerLevel)
					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), stack, 12, 10, 0.02F));
		}

		// lvl 4
		if (event.getType() == ModVillagers.BOTANIST.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(Items.MOSS_BLOCK, 2);
			int villagerLevel = 4;

			trades.get(villagerLevel)
					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 48, 3, 0.02F));
		}

		if (event.getType() == ModVillagers.BOTANIST.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(Items.FLOWERING_AZALEA, 1);
			int villagerLevel = 4;

			trades.get(villagerLevel)
					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2), stack, 16, 7, 0.02F));
		}

		// lvl 5
		if (event.getType() == ModVillagers.BOTANIST.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(Items.ROOTED_DIRT, 4);
			int villagerLevel = 5;

			trades.get(villagerLevel)
					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 24, 3, 0.02F));
		}

		if (event.getType() == ModVillagers.BOTANIST.get()) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(Items.HANGING_ROOTS, 3);
			int villagerLevel = 5;

			trades.get(villagerLevel)
					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 10, 7, 0.02F));
		}
	}
}