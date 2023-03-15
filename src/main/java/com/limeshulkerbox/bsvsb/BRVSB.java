package com.limeshulkerbox.bsvsb;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(BRVSB.MODID)
public class BRVSB {
    public static Logger LOGGER = LogManager.getLogger("Better Rubidium Video Settings Button");
    public static final String MODID = "bsvsb";
    public static boolean rubidiumLoaded;
    public static boolean TROLoaded;

    public BRVSB() {
        IEventBus MOD_BUS = FMLJavaModLoadingContext.get().getModEventBus();
        MOD_BUS.addListener(this::onInitializeClient);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void onInitializeClient(final FMLClientSetupEvent event) {
        TROLoaded = ModList.get().isLoaded("reeses_sodium_options");
        rubidiumLoaded = ModList.get().isLoaded("rubidium");
    }
}
