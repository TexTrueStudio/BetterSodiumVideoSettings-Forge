package com.limeshulkerbox.bettersodiumvideosettingsbutton.client;

//import net.fabricmc.api.ClientModInitializer;
//import net.fabricmc.api.EnvType;
//import net.fabricmc.api.Environment;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

//@OnlyIn(Dist.CLIENT)
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

        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (a, b) -> true));

    }

    public void onInitializeClient(final FMLClientSetupEvent event) {

        TROLoaded = ModList.get().isLoaded("reeses_sodium_options");
        rubidiumLoaded = ModList.get().isLoaded("rubidium");

    }

    public static Logger logger() {
        if (LOGGER == null) {
            LOGGER = LogManager.getLogger("Reese's Sodium Options");
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