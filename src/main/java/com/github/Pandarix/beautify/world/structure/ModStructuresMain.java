package com.github.Pandarix.beautify.world.structure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.Pandarix.beautify.Beautify;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ModStructuresMain {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = Beautify.MODID;

    public ModStructuresMain() {
        // For registration and init stuff.
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModStructures.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);
    }
    
    public static void register(IEventBus eventBus) {
    	ModStructures.DEFERRED_REGISTRY_STRUCTURE.register(eventBus);
    }
}