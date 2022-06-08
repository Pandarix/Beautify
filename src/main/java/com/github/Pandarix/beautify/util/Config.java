package com.github.Pandarix.beautify.util;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class Config {
	
	public static ForgeConfigSpec.IntValue SEARCHRADIUS;
	public static ForgeConfigSpec.BooleanValue OPENS_FROM_ROOT;

	public static void register() {
		registerServerConfigs();
	}

	private static void registerServerConfigs() {
		ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();

		SERVER_BUILDER.comment("Settings for the Blinds").push("Blinds");

		SEARCHRADIUS = SERVER_BUILDER.comment(
				"Searches X-Blocks below and X/2 to the sides of the clicked blind for others and opens/closes them too")
				.defineInRange("searchRadius", 6, 0, 100);
		
		OPENS_FROM_ROOT = SERVER_BUILDER.comment(
				"Opens blinds from the topmost blind on if true").define("opensFromRoot", true);

		SERVER_BUILDER.pop();

		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_BUILDER.build());
	}
}
