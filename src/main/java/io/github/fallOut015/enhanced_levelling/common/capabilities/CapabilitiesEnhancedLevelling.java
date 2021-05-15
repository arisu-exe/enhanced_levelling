package io.github.fallOut015.enhanced_levelling.common.capabilities;

import io.github.fallOut015.enhanced_levelling.MainEnhancedLevelling;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CapabilitiesEnhancedLevelling {
    @CapabilityInject(IPlayerUpgrades.class)
    public static final Capability<IPlayerUpgrades> PLAYER_UPGRADES = null;

    public static void setup(final FMLCommonSetupEvent event) {
        CapabilityManager.INSTANCE.register(IPlayerUpgrades.class, new PlayerUpgradesStorage(), new PlayerUpgradesCallable());
    }

    public static void onAttachCapabilities(final AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof PlayerEntity) {
            event.addCapability(new ResourceLocation(MainEnhancedLevelling.MODID, event.getObject().getUUID().toString()), new PlayerUpgradesProvider(new PlayerUpgrades()));
        }
    }
}