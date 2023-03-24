package com.limeshulkerbox.bsvsb;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Mod(BSVSBForge.MODID)
public class BSVSBForge {
    public static final String MODID = "bsvsb";
    public static Logger LOGGER = LoggerFactory.getLogger("BRVSB");

    public static boolean rubidiumLoaded;
    public static boolean TROLoaded;

    public BSVSBForge() {
        IEventBus MOD_BUS = FMLJavaModLoadingContext.get().getModEventBus();
        MOD_BUS.addListener(this::onInitializeClient);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void onInitializeClient(final FMLClientSetupEvent event) {
        TROLoaded = ModList.get().isLoaded("reeses_sodium_options");
        rubidiumLoaded = ModList.get().isLoaded("rubidium");
        if (rubidiumLoaded) {
            LOGGER.info("Rubidium is Loaded!");
            if (TROLoaded) {
                LOGGER.info("TexTrue's Rubidium Options is Loaded!");
            }
        }
    }
}
