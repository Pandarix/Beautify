package com.github.Pandarix.beautify.event;

import java.util.List;

import com.github.Pandarix.beautify.Beautify;
import com.github.Pandarix.beautify.core.init.ItemInit;
import com.github.Pandarix.beautify.core.init.ModVillagers;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Beautify.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
	@SubscribeEvent
	public static void onFMLCommonSetup(FMLCommonSetupEvent event){
		Int2ObjectMap<VillagerTrades.ItemListing[]> trades = new Int2ObjectOpenHashMap<>();

		List<VillagerTrades.ItemListing> level1 = List.of(
				new VillagerTrades.ItemsForEmeralds(new ItemStack(ItemInit.HANGING_POT_ITEM.get()),2,1,16,6,0.02f),
				new VillagerTrades.ItemsForEmeralds(new ItemStack(Items.FLOWER_POT),3,2,12,5,0.02f),
				new VillagerTrades.ItemsForEmeralds(new ItemStack(Items.VINE),2,3,16,4,0.02f)
		);
		List<VillagerTrades.ItemListing> level2 = List.of(
				new VillagerTrades.ItemsForEmeralds(new ItemStack(ItemInit.OAK_TRELLIS_ITEM.get()),1,2,16,3,0.02f),
				new VillagerTrades.ItemsForEmeralds(new ItemStack(ItemInit.SPRUCE_TRELLIS_ITEM.get()),1,2,16,3,0.02f),
				new VillagerTrades.ItemsForEmeralds(new ItemStack(ItemInit.BIRCH_TRELLIS_ITEM.get()),1,2,16,3,0.02f),
				new VillagerTrades.ItemsForEmeralds(new ItemStack(ItemInit.JUNGLE_TRELLIS_ITEM.get()),1,2,16,3,0.02f),
				new VillagerTrades.ItemsForEmeralds(new ItemStack(ItemInit.ACACIA_TRELLIS_ITEM.get()),1,2,16,3,0.02f),
				new VillagerTrades.ItemsForEmeralds(new ItemStack(ItemInit.DARK_OAK_TRELLIS_ITEM.get()),1,2,16,3,0.02f),
				new VillagerTrades.ItemsForEmeralds(new ItemStack(ItemInit.CRIMSON_TRELLIS_ITEM.get()),1,2,16,3,0.02f),
				new VillagerTrades.ItemsForEmeralds(new ItemStack(ItemInit.WARPED_TRELLIS_ITEM.get()),1,2,16,3,0.02f),
				new VillagerTrades.ItemsForEmeralds(new ItemStack(Items.BIG_DRIPLEAF),4,3,6,9,0.02f),
				new VillagerTrades.ItemsForEmeralds(new ItemStack(Items.SMALL_DRIPLEAF),3,4,6,8,0.02f)
		);
		List<VillagerTrades.ItemListing> level3 = List.of(
				new VillagerTrades.ItemsForEmeralds(new ItemStack(Items.LILY_PAD),1,4,8,5,0.02f),
				new VillagerTrades.ItemsForEmeralds(new ItemStack(Items.SPORE_BLOSSOM),3,1,12,10,0.02f)
		);

		List<VillagerTrades.ItemListing> level4 = List.of(
				new VillagerTrades.ItemsForEmeralds(new ItemStack(Items.MOSS_BLOCK),1,2,48,3,0.02f),
				new VillagerTrades.ItemsForEmeralds(new ItemStack(Items.FLOWERING_AZALEA),2,1,16,7,0.02f)
		);
		List<VillagerTrades.ItemListing> level5 = List.of(
				new VillagerTrades.ItemsForEmeralds(new ItemStack(Items.ROOTED_DIRT),1,4,24,3,0.02f),
				new VillagerTrades.ItemsForEmeralds(new ItemStack(Items.HANGING_ROOTS),1,3,10,7,0.02f)
		);


		trades.put(1, level1.toArray(new VillagerTrades.ItemListing[3]));
		trades.put(2, level2.toArray(new VillagerTrades.ItemListing[10]));
		trades.put(3, level3.toArray(new VillagerTrades.ItemListing[2]));
		trades.put(4, level4.toArray(new VillagerTrades.ItemListing[2]));
		trades.put(5, level5.toArray(new VillagerTrades.ItemListing[2]));
		VillagerTrades.TRADES.put(ModVillagers.BOTANIST.get(),trades);

	}

//	@SubscribeEvent
//	public static void addCustomTrades(VillagerTradesEvent event) {
//		// BOTANIST
//		// lvl1
//		if (event.getType() == ModVillagers.BOTANIST.get()) {
//			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//			ItemStack stack = new ItemStack(ItemInit.HANGING_POT_ITEM.get(), 1);
//			int villagerLevel = 1;
//
//			trades.get(villagerLevel)
//					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2), stack, 16, 6, 0.02F));
//		}
//
//		if (event.getType() == ModVillagers.BOTANIST.get()) {
//			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//			ItemStack stack = new ItemStack(Items.FLOWER_POT, 2);
//			int villagerLevel = 1;
//
//			trades.get(villagerLevel)
//					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), stack, 12, 5, 0.02F));
//		}
//
//		if (event.getType() == ModVillagers.BOTANIST.get()) {
//			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//			ItemStack stack = new ItemStack(Items.VINE, 3);
//			int villagerLevel = 1;
//
//			trades.get(villagerLevel)
//					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2), stack, 16, 4, 0.02F));
//		}
//
//		// lvl2
//		if (event.getType() == ModVillagers.BOTANIST.get()) {
//			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//			ItemStack stack = new ItemStack(ItemInit.OAK_TRELLIS_ITEM.get(), 2);
//			int villagerLevel = 2;
//
//			trades.get(villagerLevel)
//					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 16, 3, 0.02F));
//		}
//
//		if (event.getType() == ModVillagers.BOTANIST.get()) {
//			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//			ItemStack stack = new ItemStack(ItemInit.SPRUCE_TRELLIS_ITEM.get(), 2);
//			int villagerLevel = 2;
//
//			trades.get(villagerLevel)
//					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 16, 3, 0.02F));
//		}
//
//		if (event.getType() == ModVillagers.BOTANIST.get()) {
//			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//			ItemStack stack = new ItemStack(ItemInit.BIRCH_TRELLIS_ITEM.get(), 2);
//			int villagerLevel = 2;
//
//			trades.get(villagerLevel)
//					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 16, 3, 0.02F));
//		}
//
//		if (event.getType() == ModVillagers.BOTANIST.get()) {
//			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//			ItemStack stack = new ItemStack(ItemInit.JUNGLE_TRELLIS_ITEM.get(), 2);
//			int villagerLevel = 2;
//
//			trades.get(villagerLevel)
//					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 16, 3, 0.02F));
//		}
//
//		if (event.getType() == ModVillagers.BOTANIST.get()) {
//			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//			ItemStack stack = new ItemStack(ItemInit.ACACIA_TRELLIS_ITEM.get(), 2);
//			int villagerLevel = 2;
//
//			trades.get(villagerLevel)
//					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 16, 3, 0.02F));
//		}
//
//		if (event.getType() == ModVillagers.BOTANIST.get()) {
//			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//			ItemStack stack = new ItemStack(ItemInit.DARK_OAK_TRELLIS_ITEM.get(), 2);
//			int villagerLevel = 2;
//
//			trades.get(villagerLevel)
//					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 16, 3, 0.02F));
//		}
//
//		if (event.getType() == ModVillagers.BOTANIST.get()) {
//			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//			ItemStack stack = new ItemStack(ItemInit.MANGROVE_TRELLIS_ITEM.get(), 2);
//			int villagerLevel = 2;
//
//			trades.get(villagerLevel)
//					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 16, 3, 0.02F));
//		}
//
//		if (event.getType() == ModVillagers.BOTANIST.get()) {
//			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//			ItemStack stack = new ItemStack(ItemInit.CRIMSON_TRELLIS_ITEM.get(), 2);
//			int villagerLevel = 2;
//
//			trades.get(villagerLevel)
//					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 16, 3, 0.02F));
//		}
//
//		if (event.getType() == ModVillagers.BOTANIST.get()) {
//			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//			ItemStack stack = new ItemStack(ItemInit.WARPED_TRELLIS_ITEM.get(), 2);
//			int villagerLevel = 2;
//
//			trades.get(villagerLevel)
//					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 16, 3, 0.02F));
//		}
//
//		if (event.getType() == ModVillagers.BOTANIST.get()) {
//			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//			ItemStack stack = new ItemStack(Items.BIG_DRIPLEAF, 3);
//			int villagerLevel = 2;
//
//			trades.get(villagerLevel)
//					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 4), stack, 6, 9, 0.02F));
//		}
//
//		if (event.getType() == ModVillagers.BOTANIST.get()) {
//			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//			ItemStack stack = new ItemStack(Items.SMALL_DRIPLEAF, 4);
//			int villagerLevel = 2;
//
//			trades.get(villagerLevel)
//					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), stack, 6, 8, 0.02F));
//		}
//
//		// lvl3
//		if (event.getType() == ModVillagers.BOTANIST.get()) {
//			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//			ItemStack stack = new ItemStack(Items.LILY_PAD, 4);
//			int villagerLevel = 3;
//
//			trades.get(villagerLevel)
//					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 8, 5, 0.02F));
//		}
//
//		if (event.getType() == ModVillagers.BOTANIST.get()) {
//			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//			ItemStack stack = new ItemStack(Items.SPORE_BLOSSOM, 1);
//			int villagerLevel = 3;
//
//			trades.get(villagerLevel)
//					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), stack, 12, 10, 0.02F));
//		}
//
//		// lvl 4
//		if (event.getType() == ModVillagers.BOTANIST.get()) {
//			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//			ItemStack stack = new ItemStack(Items.MOSS_BLOCK, 2);
//			int villagerLevel = 4;
//
//			trades.get(villagerLevel)
//					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 48, 3, 0.02F));
//		}
//
//		if (event.getType() == ModVillagers.BOTANIST.get()) {
//			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//			ItemStack stack = new ItemStack(Items.FLOWERING_AZALEA, 1);
//			int villagerLevel = 4;
//
//			trades.get(villagerLevel)
//					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2), stack, 16, 7, 0.02F));
//		}
//
//		// lvl 5
//		if (event.getType() == ModVillagers.BOTANIST.get()) {
//			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//			ItemStack stack = new ItemStack(Items.ROOTED_DIRT, 4);
//			int villagerLevel = 5;
//
//			trades.get(villagerLevel)
//					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 24, 3, 0.02F));
//		}
//
//		if (event.getType() == ModVillagers.BOTANIST.get()) {
//			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
//			ItemStack stack = new ItemStack(Items.HANGING_ROOTS, 3);
//			int villagerLevel = 5;
//
//			trades.get(villagerLevel)
//					.add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), stack, 10, 7, 0.02F));
//		}
//	}
}