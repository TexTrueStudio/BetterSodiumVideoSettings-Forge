package com.limeshulkerbox.bsvsb.mixin;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import java.util.List;
import java.util.Set;

import static com.limeshulkerbox.bsvsb.BRVSB.LOGGER;

@SuppressWarnings("unused")
public class DisableSodiumOptionsMixinPlugin implements IMixinConfigPlugin {
    private static final String MIXIN_SODIUM_OPTIONS_SCREEN = "me.jellysquid.mods.sodium.mixin.options.MixinOptionsScreen";

    @Override
    public void onLoad(String mixinPackage) {
        LOGGER.info("The sodium options screen has been successfully moved!");
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        LOGGER.info("Loading: " + mixinClassName);
        return !mixinClassName.equals(MIXIN_SODIUM_OPTIONS_SCREEN);
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }
}