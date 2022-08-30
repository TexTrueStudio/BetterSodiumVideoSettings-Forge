package com.limeshulkerbox.bsvsb.client;

import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.FMLNetworkConstants;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(BSVSBClientMod.MODID)
public class BSVSBClientMod {

    public static Logger LOGGER = LogManager.getLogger("Better Sodium Video Settings Button");

    private static String MOD_VERSION;

    public static final String MODID = "bsvsb";

    public static boolean rubidiumLoaded;
    public static boolean RSOLoaded;
    public static boolean TROLoaded = RSOLoaded;



    public BSVSBClientMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onInitializeClient);

        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST, () -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true));

    }

    public void onInitializeClient(final FMLClientSetupEvent event) {

        TROLoaded = ModList.get().isLoaded("reeses_sodium_options");
        rubidiumLoaded = ModList.get().isLoaded("rubidium");

    }

    public static Logger logger() {
        if (LOGGER == null) {
            LOGGER = LogManager.getLogger("BSVSB");
        }

        return LOGGER;
    }

    public static String getVersion() {
        if (MOD_VERSION == null) {
            throw new NullPointerException("Mod version hasn't been populated yet");
        }

        return MOD_VERSION;
    }
}